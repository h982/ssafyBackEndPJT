<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Happy House</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/clean-blog.min.css" rel="stylesheet">

<!-- 구글 맵 -->
<script defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCz3QVtVvXhroXoNau5LoNUz2-fybgByws&callback=initMap&libraries=&v=weekly"></script>

<script type="text/javascript">
function search() {
    console.log(sel1 + ", " + sel2 + ", " + sel3);
	if (sel3 == "") {
	    console.log(sel3);
		alert("지역을 잘못 선택하셨습니다.");
		return;
	}
	document.getElementById("searchform").action = "${root}/main.do";
	document.getElementById("searchform").submit();	
}
	 
function moveJoin() {
	document.location.href = "${root}/main.do?act=mvregister";
}

window.onload = function(){
   $("#sel1").on('change', function(){
       document.location.href = "${root}/main.do?act=citychange&city="+this.value;
   });
   $("#sel2").on('change', function(){
       document.location.href = "${root}/main.do?act=gugunchange&gu="+this.value;
   }) 
};
</script>	
</head>
<c:if test="${dong == null}">
	<c:redirect url="/main.do?act=loadpage">
	</c:redirect>
</c:if>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.html"> Happy House </a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="about.jsp">소개</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="notice.jsp">공지사항</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">오늘의 뉴스</a></li>
					<li class="nav-item">
						<c:if test="${userinfo == null}">
							<h3>${msg}</h3>
							<%@ include file="/user/login.jsp"%>
						</c:if> 
						<c:if test="${userinfo != null}">
							<a href="${root}/main.do?act=checklogin">회원정보보기</a>
                            <a href="${root}/main.do?act=mvmodifyuserinfo">회원정보수정</a>
                            <a href="${root}/main.do?act=logout">로그아웃</a>
						</c:if>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('img/mainbg1.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>HAPPY HOUSE</h1>
						<span class="subheading">행복한 우리 집</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div class="container border-bottom border-top p-5">
		<form class="form" id="searchform" action="" method="get">
		<input type="hidden" name="act" id="act" value="search">
			<div class="row">
				<div class="col-sm-4 text-center">
					<span class="font-weight-bold addr-select">시/도</span> 
					<select class="form-control bg-secondary text-light" id="sel1" name="city">
						<option value="">-</option>
						<c:forEach items="${sido }" var="city">
							<c:if test="${city.dongCode eq selectedcity }">
								<option value="${city.dongCode }" selected="selected">${city.name }</option>
							</c:if>
							<c:if test="${city.dongCode ne selectedcity }">
								<option value="${city.dongCode }">${city.name }</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="col-sm-4 text-center">
					<span class="font-weight-bold addr-select">군/구</span> <select
						class="form-control bg-secondary text-light" id="sel2" name="gu">
						<option>-</option>
						<c:if test="${gulist ne null }">
							<c:forEach items="${gulist }" var="gu">
								<c:if test="${gu.dongCode eq selectedgu }">
									<option value="${gu.dongCode }" selected="selected">${gu.name }</option>
								</c:if>
								<c:if test="${gu.dongCode ne selectedgu }">
									<option value="${gu.dongCode }">${gu.name }</option>
								</c:if>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="col-sm-4 text-center">
					<span class="font-weight-bold addr-select">읍/면/리/동</span> <select
						class="form-control bg-secondary text-light" id="sel3" name="dong">
						<option>-</option>
						<c:if test="${donglist ne null }">
							<c:forEach items="${donglist }" var="dong">
								<option value="${dong.name}" >${dong.name }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<button type="button"
						class="d-flex mx-auto btn btn-outline-info move-search-page rounded"  onclick="javascript:search();">조회하기</button>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</form>
	</div>

	<!-- Main Content -->
	<div class="container main-section">
		<div id="map"></div>
		<div class="row info-section">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="post-preview"></div>
				<hr>
				<div class="post-preview">
					<h2 class="post-title">안녕하세요. Happy House 입니다!!</h2>

					<p class="post-meta">
						Posted by <a href="#">JSP</a> on March 13, 2021
					</p>
					<!-- Pager -->
					<div class="clearfix">
						<a class="btn btn-primary float-right" href="about.jsp">소개
							바로가기 &rarr;</a>
					</div>
				</div>
				<hr>

			</div>
		</div>
		<div class="look-up-section" style="display: none;">
			<div id="map"></div>
		</div>
	</div>

	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<ul class="list-inline text-center">
						<li class="list-inline-item"><a href="javascript:void(0)"
							data-toggle="popover" data-placement="top" title="위치"
							data-content="(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fas fa-phone-alt fa-stack-1x fa-inverse"
									style="color: white;"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="javascript:void(0)"
							data-toggle="popover" data-placement="top" title="전화번호"
							data-content="000-0000-0000"> <span class="fa-stack fa-lg">
									<i class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fas fa-map-marker-alt fa-stack-1x fa-inverse"
									style="color: white;"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="javascript:void(0)"
							data-toggle="popover" data-placement="top" title="이메일"
							data-content="email@email.com"> <span class="fa-stack fa-lg">
									<i class="fas fa-circle fa-stack-2x"></i> <i
									class="fab far fa-envelope fa-stack-1x" style="color: white;"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright 1조. All rights
						reserved</p>
				</div>
			</div>
		</div>
	</footer>


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/clean-blog.min.js"></script>

	<!-- 자바스크립트 -->

	<script src="./js/main.js"></script>

</body>

</html>
