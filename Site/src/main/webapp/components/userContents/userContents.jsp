<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




<c:choose>

	<c:when test="${not empty sessionScope.professionist }">
	
	
		<input type="hidden" value="${sessionScope.id}" name="txtCodiceUtente" id="txtCodiceUtente" >
		<canvas id="bar-chart" width="800" height="450"></canvas>
		
		<script>
			
		$(document).ready(function(){
			$.ajax({
				url: "ServicesHandler",
				type: "post",
				async: true,
				data: {
					"op" : "getStatistics",
					"utente" : $('#txtCodiceUtente').val()
				},
				error : function(request, state, error){
					console.log("Errore nelle notifiche" + request + state + error);
				},
				success : function(result){
					var nums = result.split(',');
					drawChart([nums[0],nums[1],nums[2]]);
				}
			});
		
		});	
		
		drawChart = function(chartData) {
				//alert(chartData);
		
			new Chart($("#bar-chart"), {
			    type: 'pie',
			    data: {
			      labels: ["Servizi Oferti", "Prenotazioni", "Guadagno"],
			      datasets: [
			        {
			          label: "Numero",     
			          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f"],
			          data: chartData
			        }
			      ]
			    },
			    options: {
			      legend: { display: false },
			      title: {
			        display: true,
			        text: 'Indice apprezzamento'
			      }
			    }
			});
		}
		</script>
	
	
	</c:when>
	
	<c:otherwise>
		<h1>Benvenuto in ServicesIsland</h1>
	</c:otherwise>

</c:choose>


