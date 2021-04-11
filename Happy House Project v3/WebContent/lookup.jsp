<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <link href="css/lookup.css" rel="stylesheet">
  
  <!-- 구글 맵 -->
  <script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCz3QVtVvXhroXoNau5LoNUz2-fybgByws&callback=initMap&libraries=&v=weekly"></script>

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
          <div class="post-heading">
            <h1>HAPPY HOUSE</h1>
            <span class="subheading">행복한 우리 집</span>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Post Content -->
  <article>
    <div class="container main-section" style="display: none;">
	    <div class="row">
		    <div class="col-sm-3 aside">
		    	<h2 class="deal-info border-bottom pb-2">거래 정보</h2>
		    	
                    <c:forEach var="hd" items="${houseDeal}">
                        <h5>${hd.getAptName() }</h5>
                        <h5>거래 금액 : ${hd.getDealAmount() }</h5>
                        <h5>전용 면적 : ${hd.getArea() } </h5>
                        <h5>${hd.getDealYear() }. ${hd.getDealMonth() }. ${hd.getDealDay() }</h5>
                    </c:forEach>
                
		    </div>
		    <div class="col-sm-9">
		    	<div id="map"></div>
		    </div>
	    </div>
    </div>
  </article>

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

   <!-- JQuery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/clean-blog.min.js"></script>
  
  <!-- 자바스크립트 -->
  <script src="./js/api.js"></script>
  <script src="./js/lookup.js"></script>
  <script src="./js/popover.js"></script>

</body>

</html>
