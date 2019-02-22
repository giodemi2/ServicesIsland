<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../forms/prenotationForm.jsp"></jsp:include>

<article>
	<h1>
		${requestScope.result.nome}
	</h1>
	
	<p>
		<strong>Descrizione: </strong> ${requestScope.result.descrizione}
	</p>
	
	<p>
		<strong>Prezzo: </strong> ${requestScope.result.prezzo}
	</p>
	
	<p>
		<strong>Data inizio: </strong> ${requestScope.result.data_inizio}
	</p>
	
	<p>
		<strong>Data fine: </strong> ${requestScope.result.data_fine}
	</p>
	
	<p>
		<strong>Orario inizio: </strong> ${requestScope.result.orario_inizio}
	</p>
	
	<p>
		<strong>Orario fine: </strong> ${requestScope.result.orario_fine}
	</p>
	
	<p>
		<strong>Durata media: </strong> ${requestScope.result.tempo_medio}
	</p>
	
	<p>
		<strong>Altri dettagli: </strong> ${requestScope.result.altri_dettagli}
	</p>
	
	<button data-toggle="modal" data-target="#prenotationModal" style="cursor: pointer;" class="btn btn-primary btn-block">Prenota</button>
	<a style="cursor: pointer;" class="btn btn-danger btn-block" href="user.jsp">Indietro</a>
	
</article>
