<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Happy House</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">Happy House</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="about.jsp">소개</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="notice.jsp">공지사항</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">오늘의 뉴스</a>
          </li>
          <li class="nav-item">
           <a class="nav-link" id="member" href="member.jsp">로그인</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/mainbg1.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>HAPPY HOUSE</h1>
            <span class="subheading">행복한 우리 집</span>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto" >
      <div class="text-center">
   		 <button type="button" class="btn btn-dark" id="btn-signin" data-toggle="modal" data-target="#signModal">signin</button>      
 		<button type="button" class="btn btn-dark btn-showInfo" style="display:none;" data-toggle="modal" data-target="">정보조회</button> 
     	 <button type="button" class="btn btn-dark" id="btn-loginshow"data-toggle="modal" data-target="#logModal">login</button>
       	<button type="button" class="btn btn-dark" id="btn-logout" style="display:none;">logout</button> 	
        <button type="button" class="btn btn-dark" id="btn-findPassword" data-toggle="modal" data-target="#findModal">find Password</button>         
      </div>
 
      <!-- 회원가입 Modal -->
		<div class="modal" id="signModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">회원가입</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <div class="form-group">
				  <label for="usr">아이디:</label>
				  <input type="text" class="form-control" id="userid" name="userid">
				</div>
				<div class="form-group">
				  <label for="pwd">비밀번호:</label>
				  <input type="password" class="form-control" id="userpwd" name="userpwd">
				</div>
		        <div class="form-group">
				  <label for="name">이름:</label>
				  <input type="text" class="form-control" id="username" name="username">
				</div>
		        <div class="form-group">
				  <label for="address">이메일:</label>
				  <input type="text" class="form-control" id="email" name="email">
				</div>
		        <div class="form-group">
				  <label for="phone">주소:</label>
				  <input type="text" class="form-control" id="address" name="address">
				</div>									
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		         <button id ="btn-register" type="button" class="btn btn-danger" data-dismiss="modal">등록</button>	     
		      </div>
		      
		
		    </div>
		  </div>
		</div>
		
     <!-- 회원정보 Modal -->
      
		<div class="modal" id="editModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">정보조회</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <div class="form-group">
				  <label for="usr">아이디:</label>
				  <input type="text" class="form-control" id="idShow">
				</div>
				<div class="form-group">
				  <label for="pwd">비밀번호:</label>
				  <input type="password" class="form-control" id="pwdShow">
				</div>
		        <div class="form-group">
				  <label for="name">이름:</label>
				  <input type="text" class="form-control" id="nameShow">
				</div>
		        <div class="form-group">
				  <label for="address">주소:</label>
				  <input type="text" class="form-control" id="adrShow">
				</div>
		        <div class="form-group">
				  <label for="phone">전화번호:</label>
				  <input type="text" class="form-control" id="phoneShow">
				</div>									
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		         <button id ="btn-edit" type="button" class="btn btn-danger" >수정</button>
		      </div>	
		      <div class="modal-footer">
		         <button id ="btn-withdraw" type="button" class="btn btn-danger" >회원탈퇴</button>
		      </div>		      	      		
		    </div>
		  </div>
		</div>		
		
       <!-- 로그인 Modal -->

		<div class="modal" id="logModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">로그인</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <div class="form-group">
				  <label for="usr">아이디:</label>
				  <input type="text" class="form-control" id="idLogin">
				</div>
				<div class="form-group">
				  <label for="pwd">비밀번호:</label>
				  <input type="password" class="form-control" id="pwdLogin">
				</div>
		    	</div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button id ="btn-login" type="button" class="btn btn-danger" data-dismiss="modal">로그인</button>
		      </div>
		
		   	 </div>
		    </div>
		  </div>
		<!-- 비밀번호 Modal -->  

		<div class="modal" id="findModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">비밀번호 찾기</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <div class="form-group">
				  <label for="idFind">아이디:</label>
				  <input type="text" class="form-control" id="idFind">
				</div>
				<div class="form-group">
				  <label for="nameFind">이름:</label>
				  <input type="text" class="form-control" id="nameFind">
				</div>
		        <div class="form-group">
				  <label for="phoneFind">전화번호:</label>
				  <input type="text" class="form-control" id="phoneFind">
				</div>				
		    	</div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button id ="btn-find" type="button" class="btn btn-danger" data-dismiss="modal">찾기</button>
		      </div>
		
		   	 </div>
		    </div>
		  </div>		  
		</div>
		
		
        
        
      </div>
    </div>
  
  <hr>

  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <ul class="list-inline text-center">
            <li class="list-inline-item">
              <a href="javascript:void(0)" data-toggle="popover" data-placement="top" title="위치" data-content="(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fas fa-phone-alt fa-stack-1x fa-inverse" style="color: white;"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="javascript:void(0)" data-toggle="popover" data-placement="top" title="전화번호" data-content="000-0000-0000">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fas fa-map-marker-alt fa-stack-1x fa-inverse" style="color: white;"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="javascript:void(0)" data-toggle="popover" data-placement="top" title="이메일" data-content="email@email.com">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab far fa-envelope fa-stack-1x" style="color: white;"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted">Copyright 1조. All rights reserved</p>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Contact Form JavaScript -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/clean-blog.min.js"></script>
  
  <!-- 자바스크립트 -->
  <script src="./js/popover.js"></script>
  <script src="./js/storage2.js"></script>

</body>

</html>
