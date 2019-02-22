<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="get" action="UserHandler" id="logoutForm">
	<input type="hidden" value="logout" name="op">
	<input type="submit" style="cursor: pointer;" class="btn btn-danger btn-block" value="Logout" >
	
</form>

<script>
	$( '#logoutForm' ).submit(function( event ) {
		var confirm = confirm("Sei sicuro di voler effettuare il logout?");
		if(!confirm){
			e.preventDefault();
		}

	});
</script>