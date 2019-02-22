<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-md-3 offset-md-3 float-right" style="margin-top: 50px;">

	<form id="loginForm" class="px-4 py-3" method="POST" action="UserHandler?op=login">
		<div class="form-group">
			<label for="exampleDropdownFormEmail1">Email</label> <input
				name="txtEmail" type="email" class="form-control"
				id="exampleDropdownFormEmail1" placeholder="email@esempio.com"
				style="min-width: 150px;" name="txtEmail">
		</div>
		<div class="form-group">
			<label for="exampleDropdownFormPassword1">Password</label> <input
				name="txtPassword" type="password" class="form-control"
				id="exampleDropdownFormPassword1" placeholder="Password"
				style="min-width: 150px;" id="txtPassword">
		</div>

		<table style="margin: 0px; padding: 0px; width: 100%;">
			<tr>
				<td style="padding: 2px; width: 50%">
					<a style="cursor: pointer; width: 100%;" href="/Site#registration" class="btn btn-primary float-right">Registrati</a>
				</td>
				<td style="padding: 2px; width: 50%">
					<button style="cursor: pointer; width: 100%;" type="submit" class="btn btn-primary float-right">Accedi</button>
				</td>
			</tr>
		</table>
	</form>
</div>


<!-- 	<script>
	
	$( "#loginForm" ).submit(function( event ) {
		// not typed an email
		if($("#txtEmail").val() != undefined && $("#txtPassword").val() != undefined){
			return true;
		}
		else {
			alert("Inserisci password ed email per continuare");
			return false;
		}
	});
	
	</script> -->