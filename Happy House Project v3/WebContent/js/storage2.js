$(document).ready(function(){
	var isLogin = false;
	var regitArr = [];
	var loginUser =[];
	
	var regits = localStorage.getItem("regitArr");
	if(regits){
		console.log(regitArr);

		regitArr = JSON.parse(regits);
	}
	
	
	$("#btn-register").on("click",function(){
		if(isLogin){
	alert("이미 로그인 됨");
	return;
	}
		//로그아웃상태이면 회원가입시키기
	
		regitArr.push({'id': $("#idSign").val() ,'password' : $("#pwdSign").val(),  'name' :$("#nameSign").val() , 
						 'address' : $("#adrSign").val() ,  'phone' : $("#phoneSign").val()} );
		localStorage.setItem( 'regitArr', JSON.stringify(regitArr));
			
		alert("회원가입 완료");
		location.reload();
	});	
	
	$("#btn-login").on("click",function(){
		if(isLogin){
			alert("이미 로그인 됨");
			return;
		}
		
		$.each(regitArr, function(index, item) {
			if( item.id == $('#idLogin').val() && item.password == $('#pwdLogin').val() ){
					isLogin = true;
					loginUser=item;
					return false;  
				}
				
		});	
		if(isLogin){
			status = true;
			$(".btn-showInfo").attr('data-target',"#editModal");
			$("#btn-logout").css("display","");
			$(".btn-showInfo").css("display","");
			$("#btn-loginshow").css("display","none");
			$("#btn-signin").css("display","none");
			$("#btn-findPassword").css("display","none");
			alert("로그인 완료");
			
		}else{
			alert("로그인 실패");
		}	


	});
	
	$("#btn-logout").on("click",function(){	
		if(isLogin){
			status = false;
			location.reload();
			alert("로그아웃 완료");
			
		}else{
			alert("로그인하세요");
		}
	});
	

	
	$('.btn-showInfo').on("click",function(){
		if(!isLogin){
			alert("로그인 안됨");
			return;
		} 
		//로그인상태이면 회원정보확인
		else{
				$("#idShow").val(loginUser.id);
				$("#pwdShow").val(loginUser.password);  
				$("#nameShow").val(loginUser.name);     
				$("#adrShow").val(loginUser.address);   
				$("#phoneShow").val(loginUser.phone);   
		}
		
		
	});
	
	$('#btn-edit').on("click",function(){
			$.each(regitArr, function(index, item) {
			if( item.id == loginUser.id  ){
				regitArr[index].id = $("#idShow").val();
				regitArr[index].password = $("#pwdShow").val();
				regitArr[index].name = $("#nameShow").val();
				regitArr[index].address = $("#adrShow").val();
				regitArr[index].phone = $("#phoneShow").val();
				localStorage.setItem( 'regitArr', JSON.stringify(regitArr));
			
				return false;	
			}
			alert("갱신 완료");
		});	

	});
	
	$('#btn-withdraw').on("click",function(){
		var flag =false;
		$.each(regitArr, function(index, item) {
			if( item.id == loginUser.id  ){
				regitArr.splice(index, 1);
				console.log(regitArr);
				localStorage.setItem( 'regitArr', JSON.stringify(regitArr));
				flag = true;
				return false;	
			}
			
		});	
		if(flag){
			status = false;
			alert("탈퇴 완료");
			location.reload();
		}

	});
	
	$('#btn-find').on("click",function(){
		var flag = false;
		
		$.each(regitArr, function(index, item) {
		if( item.id == $("#idFind").val() && item.name == $("#nameFind").val() && item.phone == $("#phoneFind").val() ){
			flag = true;
			alert("비밀번호는 "+ String(item.password)+" 입니다.");
			return false;	
		}
			
		});	
		if(!flag){
			alert("해당정보가 없습니다.");
		}
		
		location.reload();
	});

		
});

		