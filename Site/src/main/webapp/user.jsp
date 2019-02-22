<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html lang="en">
  <head>
  
  <!-- This pages is accessible ONLY FOR LOGGED USER -->
  <c:if test="${empty sessionScope.email}">
  	<c:redirect url="../Site"></c:redirect>
  </c:if>
  
  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <title>
      Services Island - Pagina utente
    </title>

	<link rel="shortcut icon" href="assets/favicon.ico" />
    <link href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic" rel="stylesheet">
    
    <!-- Light Ui theme stylesheets -->
    <link href="assets/style/statisticsTemplate/toolkit-light.css" rel="stylesheet">
    <link href="assets/style/statisticsTemplate/application.css" rel="stylesheet">

    <style>
      /* note: this is a hack for ios iframe for bootstrap themes shopify page */
      /* this chunk of css is not part of the toolkit :) */
      body {
        width: 1px;
        min-width: 100%;
        *width: 100%;
      }
    </style>
    
    <script src="assets/script/jquery.min.js"></script>
    <script src="assets/script/tether.min.js"></script>
    <script src="assets/script/chart.js"></script>
    <script src="assets/script/tablesorter.min.js"></script>
    <script src="assets/script/toolkit.js"></script>

    <script src="assets/script/applicationStatistics.js"></script>
    
  </head>


<body>

	<div class="container">
		<div class="row">
			<div class="col-md-3 sidebar">
				<jsp:include page="components/userMenu.jsp"></jsp:include>
			</div>
			  
			<div class="col-md-9 content">			        
				<jsp:include page="components/userHeader.jsp"></jsp:include>
		
				<!-- Choose the contents -->
				<c:choose>
					<c:when test="${param.page eq 'services'}">
						<c:choose>
							<c:when test="${not empty sessionScope.professionist}">
								<jsp:include page="components/userContents/servicesContents.jsp"></jsp:include>
							</c:when>
							<c:otherwise>
								<jsp:include page="components/userContents/userContents.jsp"></jsp:include>
							</c:otherwise>
						</c:choose>
					</c:when>
					
					<c:when test="${param.page eq 'payments'}">
						<c:choose>
							<c:when test="${not empty sessionScope.professionist}">
								<jsp:include page="components/userContents/paymentsContents.jsp"></jsp:include>
							</c:when>
							<c:otherwise>
								<jsp:include page="components/userContents/userContents.jsp"></jsp:include>
							</c:otherwise>
						</c:choose>
					</c:when>
					
					<c:when test="${param.page eq 'settings'}">
						<jsp:include page="components/userContents/settingsContents.jsp"></jsp:include>
					</c:when>
					
					<c:when test="${param.page eq 'search'}">
						<jsp:include page="components/userContents/searchContents.jsp"></jsp:include>
					</c:when>
					
					<c:when test="${param.page eq 'serviceInfo'}">
						<jsp:include page="components/userContents/serviceInfoContents.jsp"></jsp:include>
					</c:when>
					
					<c:when test="${param.page eq 'addService'}">
						<c:choose>
							<c:when test="${not empty sessionScope.professionist}">
								<jsp:include page="components/forms/serviceRegistrationForm.jsp"></jsp:include>
							</c:when>
							<c:otherwise>
								<jsp:include page="components/userContents/userContents.jsp"></jsp:include>
							</c:otherwise>
						</c:choose>
					</c:when>
					
					<c:when test="${param.page eq 'books'}">
						<jsp:include page="components/userContents/bookingsContent.jsp"></jsp:include>
					</c:when>
					
					<c:when test="${param.page eq 'editAccount'}">
						<jsp:include page="components/forms/editAccountForm.jsp"></jsp:include>
					</c:when>
					
				<c:otherwise>
						<jsp:include page="components/userContents/userContents.jsp"></jsp:include>
					</c:otherwise>
				</c:choose>
							
			</div>
		</div>
	</div>


    <script>
      // execute/clear BS loaders for docs
      $(function(){while(window.BS&&window.BS.loader&&window.BS.loader.length){(window.BS.loader.pop())()}})
    </script>
  </body>
</html>
