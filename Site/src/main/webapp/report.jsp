<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<!-- Tipical initial page template -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    
    

	<meta http-equiv="refresh" content="2;url=/Site" />

    

    <title>
        Services Island - Pagina di report
    </title>

	<link rel="shortcut icon" href="assets/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="//cloud.typography.com/746852/739588/css/fonts.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/report.css" />
	    
  </head>


<body>
	<c:if test="${empty requestScope.reportMessage}">
		<c:redirect url="../Site"></c:redirect>
	</c:if>
	<div class="log-container">
		<h1>${requestScope.reportMessage}</h1>
	</div>
<%-- 
	<%@ include file="components/footer.jsp" %> --%>


  </body>
</html>
