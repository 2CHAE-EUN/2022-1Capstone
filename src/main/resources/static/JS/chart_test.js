/********************** Configuration contants **********************/
const UPDATE_DELAY=1000;
const REQ_PARAM_COUNT=200;    //요청 가능한 최대 개수는 200입니다.
const chartGroupName="coinchart";
const staticChartOptions = {
  xaxis: {
    type: 'datetime',
    labels: {
      datetimeUTC: false,
      minWidth: 100,    //동기화할 차트들은 같은 그룹에 속해야 함
    },
    //1시간 간격을 보여줌
    max: new Date().getTime(),
    range: 3600000,
  },

  yaxis: {
  },

  dataLabels: {
    enabled: false
  },

  plotOptions: {
    candlestick: {
      colors: {
        upward: '#DF7D46',
        downward: '#3C90EB',
      },
    },
  },

  theme: {
    mode: 'dark',
    palette: 'palette1',
    monochrome: {
        enabled: false,
        color: '#255aee',
        shadeTo: 'light',
        shadeIntensity: 0.65
    },
  },

  legend: {
    show: false
  },

  noData: {
    text: 'Loading...'
  },
};
const staticCandleChartOptions = {
  series: [
    {
      name: 'candle',
      type: 'candlestick',
      data: [],
    }
  ],

  chart: {
    id: 'candle',
    group: chartGroupName,        //동기화할 차트들은 같은 그룹에 속해야 함
    type: 'candlestick',
    height: 350,
    zoom: {
      autoScaleYaxis: true
    },
  },

  title: {
    text: 'CandleStick chart',
    align: 'left',
  },

  yaxis: {
    tooltip: {
      enabled: true,
    }
  },
};
const staticVolumeChartOptions = {
  series: [
    {
      name: 'volume',
      type: 'bar',
      data: [],
    }
  ],

  chart: {
    id: 'volume',
    group: chartGroupName,        //동기화할 차트들은 같은 그룹에 속해야 함
    type: 'bar',
    height: 200,
    zoom: {
      autoScaleYaxis: true
    },
  },

  title: {
    text: 'Volume chart',
    align: 'left',
  },

  yaxis: {
    tooltip: {
      enabled: false,
    }
  },
};


/********************** Variables ***********************************/
var synchronized_clock

var candleChart;                  //Apexchart 객체 변수
var minuatelyCandleDataSeries = [];   //캔들차트의 데이터 형식: [timestamp, 시가, 고가, 저가, 종가]
var candleChartOptions = Object.assign({}, staticCandleChartOptions, staticChartOptions);

var volumeChart
var minuatelyVolumeDataSeries = [];
var volumeChartOptions = Object.assign({}, staticVolumeChartOptions, staticChartOptions);

/* tickerApiUrl
 * 쿼리 파라미터
 *   market={KRW-BTC, BTC-ETH, ..., 등의 마켓코드 형식의 문자열}
 */
var tickerApiUrl = "https://api.upbit.com/v1/ticker?markets=KRW-BTC";
/* minuateCandleApiUrl
 * 쿼리 파라미터
 *   market=string, 마켓코드, (ex. KRW-BTC, BTC-ETH)
 *   to=string, 마지막 캔들 시각, 형식: yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss. 비워서 요청시 가장 최근 캔들
 *   count=int, 캔들 개수(최대 200)
 */
var minuateCandleApiUrl = "https://api.upbit.com/v1/candles/minutes/1?market=KRW-BTC&";



/********************** Function definitions ************************/

/* request(url, callback) -> void
 *   ::=  주어진 url로 GET 메시지를 보내어 데이터를 비 동기적으로 응답받습니다.
 *        만약 요청에 대해 성공적으로 데이터를 응답받는 경우, 명시한 callback 함수의 파라미터로 응답이 주어집니다.
 */
function request(url, callback){
    var httpRequest = new XMLHttpRequest();

    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === 4) { // request is done
            if (httpRequest.status === 200) { // successfully
                callback(httpRequest.response); // we're calling our method
            }
        }
    };

    httpRequest.open('GET', url);
    httpRequest.send();
}

/* tickerUpdate(response) -> void
 *   ::=  request(url, callback) 함수에 주어지는 콜백함수입니다.
 *        응답받은 데이터를 기반으로 종목요약정보를 표시하는 DOM객체를 갱신합니다.
 */
function tickerUpdate (result){
  var json = JSON.parse(result)[0];

  var color = "black"
  if(json.change == "FALL")
    color = "blue";
  else if(json.change == "RISE")
    color = "red";

  document.getElementById("market").innerText = '마켓: ' + json.market;
  document.getElementById("tradePrice").innerText = '현재가: ' + json.trade_price;
  document.getElementById("changePrice").innerText = '전일대비변동금액: ' + json.signed_change_price;
  document.getElementById("changePrice").style.color = color;
  document.getElementById("changeRate").innerText = '전일대비금액변동률: ' + parseFloat(json.signed_change_rate) * 100 + "%";
  document.getElementById("changeRate").style.color = color
  document.getElementById("accTradePrice").innerText = '당일누적거래금액: ' + json.acc_trade_price;
}

/* renderCandleChart(response) -> void
 *   ::=  request(url, callback) 함수에 주어지는 콜백함수입니다.
 *          1) 응답받은 캔들 데이터를 바탕으로 데이터 시리즈를 초기화
 *          2) 캔들차트의 옵션을 설정하고 옵션에 데이터 시리즈를 주입
 *          3) 스타일과 옵션을 명시 후 apexchart 객체 생성
 *          4) 차트 렌더링
 */
function renderCandleChart (result) {
   var json = JSON.parse(result);

  for(i=0; i<REQ_PARAM_COUNT; i++){
    minuatelyCandleDataSeries.push([
      new Date(json[i].candle_date_time_kst).getTime(),
      json[i].opening_price, json[i].high_price, json[i].low_price, json[i].trade_price
    ])
  }

  console.log(""+ json[REQ_PARAM_COUNT-1].candle_date_time_kst + " ~ " + json[0].candle_date_time_kst);

  Object.assign(candleChartOptions,
    {series: [{
      name: 'candle',
      type: 'candlestick',
      data: minuatelyCandleDataSeries,
    }]}
  );

  //초기 차트 그리기
  candleChart = new ApexCharts(document.querySelector("#chart1"), candleChartOptions);
  candleChart.render();
}

/* renderVolumeChart(response) -> void
 *   ::=  request(url, callback) 함수에 주어지는 콜백함수입니다.
 *          1) 응답받은 볼륨 데이터를 바탕으로 데이터 시리즈를 초기화
 *          2) 볼륨차트의 옵션을 설정하고 옵션에 데이터 시리즈를 주입
 *          3) 스타일과 옵션을 명시 후 apexchart 객체 생성
 *          4) 차트 렌더링
 */
function renderVolumeChart (result) {
  var json = JSON.parse(result);

  for(i=0; i<REQ_PARAM_COUNT; i++){
    minuatelyVolumeDataSeries.push([
      new Date(json[i].candle_date_time_kst).getTime(),
      json[i].candle_acc_trade_volume
    ])
  }

  Object.assign(volumeChartOptions,
    {series: [{
      name: 'volume',
      type: 'bar',
      data: minuatelyVolumeDataSeries,
    }]}
  );

  //초기 차트 그리기
  volumeChart = new ApexCharts(document.querySelector("#chart2"), volumeChartOptions);
  volumeChart.render();
}

/* updateData() -> void
 *   ::=  주기적으로 호출되어 종목 현황을 갱신합니다.
 *
 */ function update(){
    var d = new Date();
    var s = d.getSeconds();

    //매 분
    if(s == 0){
        console.log("Minuate candle has been updated!");
    }

    //매 초
    request(tickerApiUrl, tickerUpdate);
}



/********************** Logic definition *****************************/

//타이머 설정
setInterval(update, UPDATE_DELAY);

//캔들 차트 출력
request( (minuateCandleApiUrl + "count=" + REQ_PARAM_COUNT), renderCandleChart);

//볼륨 차트 출력
request( (minuateCandleApiUrl + "count=" + REQ_PARAM_COUNT), renderVolumeChart);