<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!-- Modal of prenotation form -->
<div class="modal fade" id="accountDeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Rimuovi account</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      		<p>Sei sicuro di voler rimuovere il tuo account?<br><strong>una volta eliminato NON potrai più ripristinarlo</strong></p>	
      </div>
      <div class="modal-footer">
        <button style="cursor: pointer;" type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
        <button style="cursor: pointer;" type="button" class="btn btn-danger" onclick="removeAccount()">Conferma</button>
      </div>
    </div>
  </div>
</div>


<script>

removeAccount = function(){
	$.ajax({
		url: "UserHandler",
		type: "post",
		async: true,
		data: {
			"op" : "accountDelete",
		},
		error : function(request, state, error){
			console.log("Errore nelle notifiche" + request + state + error);
		},
		success : function(result){
 			if(result=="success"){
				alert("Account rimosso con successo");
				window.location.replace("/Site");
			}
			else{
				alert("Errore nella rimozione dell'account");
			} 
		}
	});
}
</script>