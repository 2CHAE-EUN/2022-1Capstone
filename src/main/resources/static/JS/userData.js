function passwordTest(){
    var p1 = document.getElementById("newPassword1").value;
    var p2 = document.getElementById("newPassword2").value;

    var checkIndex = false;

    if( p1 != p2 ){
        document.getElementById("printPass").innerHTML = "새로운 비밀번호가 일치하지 않습니다."
        document.getElementById("printPass").style.color = "red";
        checkIndex = false;
    }
    else{
        document.getElementById("printPass").innerHTML = "새로운 비밀번호가 일치합니다."
        document.getElementById("printPass").style.color = "blue";
        checkIndex = true;
    }

    var mypw = document.getElementById("password").value;

    if( checkIndex == true ){
        $.ajax({
            type : 'POST',
            url : "/passwordCheck",
            data: { userPassword : mypw,
                    newPassword : p1 },
            async: false,
            charset: "utf-8",
            success: function(cnt){
                if( cnt == true ){
                        alert("비밀번호 변경 성공");
                        document.getElementById("newPassword1").value="";
                        document.getElementById("newPassword2").value ="";
                        document.getElementById("printPass").innerHTML = "";
                        document.getElementById("password").value = "";
                }
                else{
                    alert("현재 비밀번호를 다시 확인해주세요")
                }
            },
        })

    }


}