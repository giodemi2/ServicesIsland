<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h1>I tuoi dati (seleziona i campi da modificare): </h1>

		
<c:choose>
	<c:when test="${not empty sessionScope.professionist }">
		<form method="post" action="UserHandler?op=editProfessonist" id="professionistRegistrationForm">
			<div class="form-group">
				<p>Nome</p>
				<input value="${sessionScope.nome }" maxlength="40" class="form-control" type="text" name="txtNome" id="txtNome">
			</div>
			
			<div class="form-group">
				<p>Cognome</p>
				<input value="${sessionScope.cognome }" maxlength="40" class="form-control" type="text" name="txtCognome" id="txtCognome">
			</div>
			
			<div class="form-group">
				<p>Sesso</p>
				<select class="form-control" name="sltSesso"  id="sltSesso">
						<option value="M">Maschio</option>
						<option value="F">Femmina</option>
				</select>
			</div>
			
			<div class="form-group">
				<p>Numero telefonico</p>
				<input value="${sessionScope.numero }" maxlength="10" class="form-control" type="number" name="txtNumeroTelefonico" id="txtNumeroTelefonico">
			</div>
		
			<div class="form-group">
				<p>Codice Fiscale</p>
				<input value="${sessionScope.codice_fiscale }" maxlength="16" class="form-control" type="text" name="txtCodiceF" id="txtCodiceF">
			</div>
			
			<div class="form-group">
				<p>Partira IVA</p>
				<input value="${sessionScope.partita_iva }" maxlength="16" class="form-control" type="text" name="txtPartitaIVA" id="txtPartitaIVA">
			</div>
			
			<div class="form-group">
				<p>Professione</p>
				<input value="${sessionScope.professione }" maxlength="40" class="form-control" type="text" name="txtProfessione" id="txtProfessione">
			</div>
			
			<div class="form-group">
				<p>Settore</p>
				<input value="${sessionScope.settore }" maxlength="40" class="form-control" type="text" name="txtSettore" id="txtSettore">
			</div>
			
			<div class="form-group">
				<p>Sede fiscale</p>
				<input value="${sessionScope.sede_fiscale }" maxlength="50" class="form-control" type="text" name="txtSedeFiscale" id="txtSedeFiscale">
			</div>
			
			<div class="form-group">
				<p>Sede legale</p>
				<input value="${sessionScope.sede_legale }" maxlength="50" class="form-control" type="text" name="txtSedeLegale" id="txtSedeLegale">
			</div>
			
		
			<div class="form-group">
				<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Modifica" id="btnSubmit">
			</div>
		</form>
	</c:when>
	
	
	<c:otherwise>
		<form method="post" action="UserHandler?op=editUser" id="professionistRegistrationForm">
			<div class="form-group">
				<p>Nome</p>
				<input value="${sessionScope.nome }" maxlength="40" class="form-control" type="text" name="txtNome" id="txtNome">
			</div>
			
			<div class="form-group">
				<p>Cognome</p>
				<input value="${sessionScope.cognome }" maxlength="40" class="form-control" type="text" name="txtCognome" id="txtCognome">
			</div>
			
			<div class="form-group">
				<p>Sesso</p>
				<select class="form-control" name="sltSesso"  id="sltSesso">
						<option value="M">Maschio</option>
						<option value="F">Femmina</option>
				</select>
			</div>
			
			<div class="form-group">
				<p>Numero telefonico</p>
				<input value="${sessionScope.numero }" maxlength="10" class="form-control" type="number" name="txtNumeroTelefonico" id="txtNumeroTelefonico">
			</div>
			
			<div class="form-group">
				<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Modifica" id="btnSubmit">
			</div>
		</form>
	
	</c:otherwise>
</c:choose>
		
