// 이채은 - 현재가 조회 리스트

var socket; // 소켓

// 웹소켓 연결
function connectWS() {
	if(socket != undefined){
		socket.close();
	}

	socket = new WebSocket("wss://api.upbit.com/websocket/v1");
	socket.binaryType = 'arraybuffer';

	socket.onopen 	= function(e){

		filterRequest('[{"ticket":"UNIQUE_TICKET"},{"type":"ticker","codes":["KRW-BTC","KRW-ETH","KRW-XRP","KRW-SOL","KRW-DOGE","KRW-WEMIX", "KRW-REP", "KRW-REP", "KRW-STRK", "KRW-SAND", "KRW-RFR", "KRW-WAVES", "KRW-TRX", "KRW-STX", "KRW-META", "KRW-ADA"]},{"type":"trade","codes":["KRW-BTC"]}]');

	}

	socket.onclose 	= function(e){
		socket = undefined;
	}

	socket.onmessage= function(e){

		var enc = new TextDecoder("utf-8");
		var arr = new Uint8Array(e.data);
		var str_d = enc.decode(arr);

		var coinData = JSON.parse(str_d);

		if(coinData.type == "ticker") { // 현재가 데이터

//			console.log(coinData.code);

			if ( coinData.code == "KRW-BTC" ){

				document.getElementById("KRW-BTC").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-BTC").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-BTC").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-BTC").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}

			else if ( coinData.code == "KRW-ETH" ){
				document.getElementById("KRW-ETH").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-ETH").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-ETH").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-ETH").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}

			else if ( coinData.code == "KRW-XRP" ){
				document.getElementById("KRW-XRP").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-XRP").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-XRP").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-XRP").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-SOL" ){
				document.getElementById("KRW-SOL").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-SOL").getElementsByTagName('td')[2].innerHTML =(coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-SOL").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-SOL").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-DOGE" ){
				document.getElementById("KRW-DOGE").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-DOGE").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-DOGE").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-DOGE").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-WEMIX" ){
				document.getElementById("KRW-WEMIX").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-WEMIX").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-WEMIX").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-WEMIX").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-REP" ){
				document.getElementById("KRW-REP").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-REP").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-REP").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-REP").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-STRK" ){
				document.getElementById("KRW-STRK").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-STRK").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-STRK").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-STRK").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-SAND" ){
				document.getElementById("KRW-SAND").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-SAND").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-SAND").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-SAND").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-RFR" ){
				document.getElementById("KRW-RFR").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-RFR").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-RFR").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-RFR").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-WAVES" ){
				document.getElementById("KRW-WAVES").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-WAVES").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-WAVES").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-WAVES").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-TRX" ){
				document.getElementById("KRW-TRX").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-TRX").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-TRX").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-TRX").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-STX" ){
				document.getElementById("KRW-STX").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-STX").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-STX").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-STX").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-META" ){
				document.getElementById("KRW-META").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-META").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-META").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-META").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}
			else if ( coinData.code == "KRW-ADA" ){
				document.getElementById("KRW-ADA").getElementsByTagName('td')[1].innerHTML = coinData.trade_price;
				document.getElementById("KRW-ADA").getElementsByTagName('td')[2].innerHTML = (coinData.signed_change_rate  * 100).toPrecision(2) + "%";
				document.getElementById("KRW-ADA").getElementsByTagName('td')[3].innerHTML = coinData.signed_change_price;
				document.getElementById("KRW-ADA").getElementsByTagName('td')[4].innerHTML = Math.round(coinData.acc_trade_price_24h);
			}

		}

		if(coinData.type == "orderbook") { // 호가 데이터
		// TODO
		}
		if(coinData.type == "trade") { // 체결 데이터

//			var table = document.getElementById('tradeTable');
//			var tr = document.createElement("tr");
//			var td1 = document.createElement("td");
//			td1.appendChild(document.createTextNode(coinData.trade_date + " " + coinData.trade_time));
//
//			var td2 = document.createElement("td");
//			td2.appendChild(document.createTextNode(coinData.trade_price));
//
//			var td3 = document.createElement("td");
//			td3.appendChild(document.createTextNode(coinData.trade_volume));
//
//			tr.appendChild(td1);
//	      	tr.appendChild(td2);
//	      	tr.appendChild(td3);
//
//			table.prepend(tr);

		}
	}
}
// 웹소켓 연결 해제
function closeWS() {
	if(socket != undefined){
		socket.close();
		socket = undefined;
	}
}

// 웹소켓 요청
function filterRequest(filter) {
	if(socket == undefined){
		alert('no connect exists');
		return;
	}
	socket.send(filter);
}

connectWS();