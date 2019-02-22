<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<br>
<div class="rounded-circle block app-price-plans" id="registration">
  <div class="container text-center">

    <div class="row mb-5">
      <div class="col-md-8 offset-md-2 col-lg-6 offset-lg-3">
        <h6 class="text-muted text-uppercase mb-2" id="startContent" >Registrazione</h6>
        		<c:choose>
					<c:when test="${param.userType eq 'p'}">
						<jsp:include page="../forms/professionistRegistrationForm.jsp"></jsp:include>
					</c:when>
					<c:when test="${param.userType eq 'u'}">
						<jsp:include page="../forms/userRegistrationForm.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="../forms/userRegistrationForm.jsp"></jsp:include>
					</c:otherwise>
				</c:choose>
      </div>
    </div>


  </div>
</div>

<br>


