<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<div class="nav-item dropdown">
	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
		role="button" data-toggle="dropdown" aria-haspopup="true"
		aria-expanded="false"> <i class="fas fa-bell"></i>
	</a>
	<div class="dropdown-menu" aria-labelledby="navbarDropdown"   id="notificationDiv">
		<p></p>
	</div>
</div>

<script>
	$(document).ready(function(){
		setInterval(function(){ 
			$.ajax({
				url: "ServicesHandler",
				type: "post",
				async: true,
				data: {
					"op" : "notifications"
				},
				error : function(request, state, error){
					console.log("Errore nelle notifiche" + request + state + error);
				},
				success : function(result){
					$('#notificationDiv').empty();
					$('#notificationDiv').append(result);
				}
			});
		}, 1000);

	});
</script>


