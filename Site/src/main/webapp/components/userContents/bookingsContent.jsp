<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<article>
    <input type="hidden" value="${sessionScope.id}" name="txtCodiceUtente" id="txtCodiceUtente" >
	<h1>Le tue prenotazioni:</h1>
	<div id="bookingContainer" style="text-align: center; margin-top: 20px;">
	</div>
	
	<c:if test="${not empty sessionScope.professionist }">
		<h1>Prenotazioni sui tuoi servizi:</h1>
		<div id="bookingContainerProfessionist" style="text-align: center; margin-top: 20px;">
		</div>
	
	</c:if>
	
</article>

<script>
	$(document).ready(function(){
		setInterval(function(){ 
			// to view user prenotations
			$.ajax({
				url: "ServicesHandler",
				type: "post",
				async: true,
				data: {
					"op" : "getPrenotations",
					"utente" : $('#txtCodiceUtente').val()
				},
				error : function(request, state, error){
					console.log("Errore nelle notifiche" + request + state + error);
				},
				success : function(result){
					if(result != ""){
						$('#bookingContainer').empty();
						$('#bookingContainer').append(result);
					}
					else{
						$('#bookingContainer').empty();
						$('#bookingContainer').append("<p> NON ci sono prenotazioni effettuate</p>");
					}
				}
			});
		}, 1000);
	
	});
</script>


<c:if test="${not empty sessionScope.professionist }">
	<script>
		$(document).ready(function(){
			setInterval(function(){ 
				// to viev prenotations of service offered by professionist
				$.ajax({
					url: "ServicesHandler",
					type: "post",
					async: true,
					data: {
						"op" : "getPrenotationsOfProfessionist",
						"utente" : $('#txtCodiceUtente').val()
					},
					error : function(request, state, error){
						console.log("Errore nelle notifiche" + request + state + error);
					},
					success : function(result){
						if(result != ""){
							$('#bookingContainerProfessionist').empty();
							$('#bookingContainerProfessionist').append(result);
						}
						else{
							$('#bookingContainerProfessionist').empty();
							$('#bookingContainerProfessionist').append("<p> NON ci sono prenotazioni effettuate sui tuoi servizi</p>");
						}
					}
				});
			}, 1000);
		
		});
	</script>
</c:if>

		

