<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




<input type="hidden" value="${requestScope.result.nome}">

<!-- Modal of prenotation form -->
<div class="modal fade" id="prenotationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Prenota il servizio - <strong>${requestScope.result.nome}</strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        	<input type="hidden" value="${requestScope.result.codice}" name="txtCodiceServizio" id="txtCodiceServizio" >
        	<input type="hidden" value="${sessionScope.id}" name="txtCodiceUtente" id="txtCodiceUtente" >
        	
	        <div class="form-group">
				<p>Data prenotazione - YYYY-MM-DD</p>
				<input class="form-control" type="text" name="txtDataPrenotazione" id="txtDataPrenotazione" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
			</div>
	
			<div class="form-group">
				<p>Orario prenotazione - HH:MM:SS</p>
				<input class="form-control" type="text" name="txtOrarioPrenotazione" id="txtOrarioPrenotazione" pattern="([0-1]{1}[0-9]{1}|20|21|22|23):([0-5]{1}[0-9]{1}):([0-5]{1}[0-9]{1})">
			</div>
        	
      </div>
      <div class="modal-footer">
        <button style="cursor: pointer;" type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
        <button style="cursor: pointer;" type="button" class="btn btn-primary" onclick="makePrenotation()">Conferma</button>
      </div>
    </div>
  </div>
</div>


<script>

makePrenotation = function(){

	if($('#txtDataPrenotazione').val()!="" && $('#txtOrarioPrenotazione').val()!=""){
		$.ajax({
			url: "ServicesHandler",
			type: "post",
			async: true,
			data: {
				"op" : "prenotation",
				"servizio" : $('#txtCodiceServizio').val(),
				"utente" : $('#txtCodiceUtente').val(),
				"giorno" : $('#txtDataPrenotazione').val(),
				"orario" : $('#txtOrarioPrenotazione').val()
			},
			error : function(request, state, error){
				console.log("Errore nelle notifiche" + request + state + error);
			},
			success : function(result){
 				if(result=="success"){
					alert("Prenotazione avvenuta con successo");
					window.location.replace("/Site");

				}
				else{
					alert("Errore nella prenotazione");
				} 
			}
		});
	}
	else{
		alert("Inserisci tutti i campi");
	}

}
</script>