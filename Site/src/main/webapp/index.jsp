<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<!-- Tipical initial page template -->
<html lang="en">
  <head>
  
	<!-- This pages is inaccessible FOR LOGGED USER -->
	<c:if test="${not empty sessionScope.email}">
		<c:redirect url="user.jsp"></c:redirect>
	</c:if>

  
  
  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">

    <title>
        Services Island - Homepage
    </title>

	<link rel="shortcut icon" href="assets/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lora:400,400italic|Work+Sans:300,400,500,600' rel='stylesheet' type='text/css'>

	<!-- Startup theme stylesheets -->
	<link href="assets/style/homeTemplate/toolkit-startup.css" rel="stylesheet">
	<link href="assets/style/homeTemplate/application-startup.css" rel="stylesheet">
	<link href="assets/style/homeTemplate/iosIframeHack.css" rel="stylesheet">
    
    <script src="assets/script/jquery.min.js"></script>
    <script src="assets/script/tether.min.js"></script>
    <script src="assets/script/toolkit.js"></script>
    <script src="assets/script/application.js"></script>
    
  </head>


<body>

	<%@ include file="components/navbar.jsp" %>


	<!-- Choose the contents -->
	<c:choose>
		<c:when test="${param.page eq 'about'}">
			<jsp:include page="components/contents/aboutContents.jsp"></jsp:include>
		</c:when>
		<c:when test="${param.page eq 'legalIssues'}">
			<jsp:include page="components/contents/legalIssuesContents.jsp"></jsp:include>		
		</c:when>
		<c:when test="${param.page eq 'license'}">
			<jsp:include page="components/contents/licenseContents.jsp"></jsp:include>		
		</c:when>
		<c:when test="${param.page eq 'terms'}">
			<jsp:include page="components/contents/termsContents.jsp"></jsp:include>		
		</c:when>
		<c:when test="${param.page eq 'registration'}">
			<jsp:include page="components/contents/registrationContents.jsp"></jsp:include>		
		</c:when>
		<c:otherwise>
			<jsp:include page="components/contents/homeContents.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	
		

	<%@ include file="components/footer.jsp" %>


  </body>
</html>
