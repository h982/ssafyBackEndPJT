<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ssafy.dto.MemberDto"  %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${userinfo == null}">
	<c:redirect url="/main.do"/>
</c:if>
<c:if test="${userinfo != null}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<%
        MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
    %>
	<br>
	<br>
	<b><font size="6" color="gray">회원정보 수정</font></b>
	<br>
	<br>
	<br>

	<form method="post"
		action="./main.do"
		name="userInfo" onsubmit="return checkValue()">
		<input type="hidden" name="act" id="act" value="modifyuserinfo">		
		<table>
			<tr>
				<td id="title">아이디</td>
				<td id="title"><h5><%=memberDto.getUserId() %></h5>
				<input type="hidden" name="userid" value="<%=memberDto.getUserId() %>"></td>
			</tr>
			<tr>
				<td id="title">비밀번호</td>
				<td><input type="password" name="userpwd" maxlength="50" id="userpwd" value="<%=memberDto.getUserPwd() %>"></td>
				</td>
			</tr>
		</table>
		<br>
		<br>
		<table>

			<tr>
				<td id="title">이름</td>
				<td><input id="username" name="username" type="text" value="<%=memberDto.getUserName() %>"></td>
				
			</tr>

			
			<tr>
				<td id="title">이메일</td>
				<td><input id="email" name="email" type="text" value="<%=memberDto.getEmail() %>"></td>
				
			</tr>

			<tr>
				<td id="title">주소</td>
				<td><input id="address" name="address" type="text" value="<%=memberDto.getAddress() %>"></td>
		
			</tr>
		</table>
		<br>
		<br> 
		<input type="submit" name="act" id="act" value="modifyuserinfo" />
	</form>


</body>
</html>
</c:if>