function emailTest(){
    var email = document.getElementById("userEmail").value;
    console.log(email);
    console.log(typeof(email));

    $.ajax({
        type : 'POST',
        url : "/SignUpView",
        data: { userEmail : email },
        charset: "utf-8",
        success: function(cnt){
            if( cnt == 0 ){
                document.getElementById("duplicate").innerHTML = "사용 가능한 이메일 입니다.";
                document.getElementById("duplicate").style.color = "blue";
                return true;
            }
            else{
                document.getElementById("duplicate").innerHTML = "이미 사용 중인 이메일 입니다.";
                document.getElementById("duplicate").style.color = "red";
                return false;
            }
        }
    })

}