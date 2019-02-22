<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="post" action="UserHandler?op=registerProfessonist" id="professionistRegistrationForm">


		<div class="form-group">
			<p>Nome</p>
			<input maxlength="40" class="form-control" type="text" name="txtNome" id="txtNome">
		</div>
		
		<div class="form-group">
			<p>Cognome</p>
			<input maxlength="40" class="form-control" type="text" name="txtCognome" id="txtCognome">
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
			<input maxlength="10" class="form-control" type="number" name="txtNumeroTelefonico" id="txtNumeroTelefonico">
		</div>
		
		<div class="form-group">
			<p>Email</p>
			<input maxlength="254" class="form-control" type="email" name="txtEmail" id="txtEmail">
		</div>
		
		<div class="form-group">
			<p>Password</p>
			<input maxlength="64" class="form-control" type="password" name="txtPassword" id="txtPassword">
		</div>
		
		<div class="form-group">
			<p>Conferma password</p>
			<input maxlength="64" class="form-control" type="password" name="txtConfermaPassword" id="txtConfermaPassword">
		</div>
		
		<div class="form-group">
			<p>Codice Fiscale</p>
			<input maxlength="16" class="form-control" type="text" name="txtCodiceF" id="txtCodiceF">
		</div>
		
		<div class="form-group">
			<p>Partira IVA</p>
			<input maxlength="16" class="form-control" type="text" name="txtPartitaIVA" id="txtPartitaIVA">
		</div>
		
		<div class="form-group">
			<p>Professione</p>
			<input maxlength="40" class="form-control" type="text" name="txtProfessione" id="txtProfessione">
		</div>
		
		<div class="form-group">
			<p>Settore</p>
			<input maxlength="40" class="form-control" type="text" name="txtSettore" id="txtSettore">
		</div>
		
		<div class="form-group">
			<p>Sede fiscale</p>
			<input maxlength="50" class="form-control" type="text" name="txtSedeFiscale" id="txtSedeFiscale">
		</div>
		
		<div class="form-group">
			<p>Sede legale</p>
			<input maxlength="50" class="form-control" type="text" name="txtSedeLegale" id="txtSedeLegale">
		</div>
		
		<div class="form-group">
			<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Registrati" id="btnSubmit">
		</div>

		<fb:login-button scope="public_profile,email" onlogin="compilaCampi();">
			Compila con facebook
		</fb:login-button>

</form>


<script>

	professionistRegistration = function(){
		var emptyField = false;
		
		// passwords will be equals
		if($("#txtPassword").val() != $("#txtConfermaPassword").val()){
			alert("Le password non corrispondono");
			return false;
		}
		else{
			// all field MUST be not empty
			$("input").each(function(){
				if($(this).val() == "" ){
					alert("Campo/i mancante, impossibile continuare");
					emptyField = true;
					return false;
					
				}
			});
			if(emptyField){
				return false;
			}
			
		}
		return true;
	}
	
	$( "#professionistRegistrationForm" ).submit(function( event ) {
		if(professionistRegistration()){
			alert("Registrazione andata a buon fine.\nDa ora inizierà il tuo periodo di prova GRATUITO di un mese");
		}
		else{
			event.preventDefault();
		}
	});
	
</script>



	<!-- Facebook API scripts -->
	<script>
  // This is called with the results from from FB.getLoginStatus().
/*   function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    
    // Se siamo connessi
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      compilaCampi();
/* 	  alert(response.);
      testAPI(); */
/*     } else {
      // The person is not logged into your app or we are unable to tell.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    }
  } */ 

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
/*   function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  } */

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '407714560033631',
      cookie     : true,  // enable cookies to allow the server to access 
                          // the session
      xfbml      : true,  // parse social plugins on this page
      version    : 'v2.8' // The Graph API version to use for the call
    });

    // Now that we've initialized the JavaScript SDK, we call 
    // FB.getLoginStatus().  This function gets the state of the
    // person visiting this page and can return one of three states to
    // the callback you provide.  They can be:
    //
    // 1. Logged into your app ('connected')
    // 2. Logged into Facebook, but not your app ('not_authorized')
    // 3. Not logged into Facebook and can't tell if they are logged into
    //    your app or not.
    //
    // These three cases are handled in the callback function.

/*     FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    }); */

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // compila i campi tramite l'accesso a facebook
  function compilaCampi(){
	  FB.api(
			  '/me',
			  'GET',
			  {"fields":"id,name,address,email,birthday"},
			  function(response) {
				  var fullName = response.name.split(/ /);
			      $('#txtNome').val(fullName[0]);
			      $('#txtCognome').val(fullName[1]);	
			      $('#txtEmail').val(response.email);
			      
			  }
			);
  }
  
/*   // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  } */
</script>

