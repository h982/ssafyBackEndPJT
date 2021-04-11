<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${userinfo == null}">
	<c:redirect url="/main.do"/>
</c:if>
<c:if test="${userinfo != null}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보보기</title>
<style type="text/css">
        table{
            margin-left:auto; 
            margin-right:auto;
            border:3px solid black;
        }
        
        td{
            border:1px solid black
        }
        
</style>


</head>
<body>

<br><br>
        <b><font size="6" color="gray">내 정보</font></b>
        <br><br><br>
                   
        <table>
            <tr>
                <td id="title">아이디</td>
                <td>${userinfo.userId }</td>
            </tr>
 
            <tr>
                <td id="title">비밀번호</td>
                <td>${userinfo.userPwd }</td>
            </tr>
                    
            <tr>
                <td id="title">이름</td>
                <td>${userinfo.userName }</td>
            </tr>
                    
                    
            <tr>
                <td id="title">이메일</td>
                <td>
                    ${userinfo.email }</td>
            </tr>
                    
            
            <tr>
                <td id="title">주소</td>
                <td>
                    ${userinfo.address }
                </td>
            </tr>

        </table>





<input type="button" value="삭제" onclick="">
</body>
</html>
</c:if>