function passwordTest(){

	var p1 = document.getElementById("userPassword").value;
	var p2 = document.getElementById("CheckUserPassword").value;

	if( p1.length == 0 || p2.length == 0 ){
	    document.getElementById("printPass").innerHTML = "비밀번호를 입력해주세요."
	    document.getElementById("printPass").style.color = "red";
        return false;
	}

	 if(  p1 != p2 ){
		 document.getElementById("printPass").innerHTML = "비밀번호가 일치하지 않습니다."
		 document.getElementById("printPass").style.color = "red";
		 return false;
	 }
	 else{
		 document.getElementById("printPass").innerHTML = "비밀번호가 일치합니다."
		 document.getElementById("printPass").style.color = "blue";
		 return true;
	 }
 }

function doAction(){
	var id = document.getElementById("userEmail").value;
	var name = document.getElementById("userName").value;
	var year = document.getElementById("yy").value;
	var month = document.getElementById("mm").value;
	var day = document.getElementById("dd").value;
	var gender = document.getElementById("userGender").value;


	if( id.length == 0 || name.length == 0 || year.length == 0 || month.length == 0 || day.length == 0 || gender.length == 0 ){
    		alert("모든 항목 기입 필수입니다.")
    		return false;
    }

	if( passwordTest() == true ){
            return true;
	}
	else if( passwordTest() == false ){
		alert("비밀번호를 확인해주세요.")
		return false;
	}

}