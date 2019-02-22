<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<article>
	<input type="hidden" value="${sessionScope.id}" name="txtCodiceUtente" id="txtCodiceUtente" >

	<h1>Area Gestione servizi</h1>
	<br>
	<a class="btn btn-primary btn-lg btn-block" href="user.jsp?page=addService">Aggiungi servizio</a>
<!-- 	<a class="btn btn-primary btn-lg btn-block" href="user.jsp?page=editService">Modifica servizio</a> -->
<!-- 	<a class="btn btn-danger btn-lg btn-block" href="user.jsp?page=editService">Elimina servizio</a> -->
	<br>
	<br>
	<h1>I tuoi servizi:</h1>
	<div id="servicesContainer" style="text-align: center; margin-top: 20px;">
	</div>
	
</article>


<script>
	$(document).ready(function(){
		setInterval(function(){ 
			$.ajax({
				url: "ServicesHandler",
				type: "post",
				async: true,
				data: {
					"op" : "getServices",
					"utente" : $('#txtCodiceUtente').val()
				},
				error : function(request, state, error){
					console.log("Errore nelle notifiche" + request + state + error);
				},
				success : function(result){
					if(result != ""){
						$('#servicesContainer').empty();
						$('#servicesContainer').append(result);
					}
					else{
						$('#servicesContainer').empty();
						$('#servicesContainer').append("<p> NON ci sono servizi</p>");
					}
				}
			});
		}, 1000);
	
	});
</script>