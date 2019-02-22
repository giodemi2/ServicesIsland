<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<article>

<jsp:include page="../forms/accountDeleteForm.jsp"></jsp:include>
	
	<h1>Impostazioni account</h1>
	<br>
	<a class="btn btn-primary btn-lg btn-block" href="user.jsp?page=editAccount">Modifica dati</a>
	<button class="btn btn-danger btn-lg btn-block" data-toggle="modal" data-target="#accountDeleteModal" style="cursor: pointer;" class="btn btn-primary btn-block">Elimina profilo</button>
</article>