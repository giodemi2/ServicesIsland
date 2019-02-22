<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form method="post" action="ServicesHandler?op=addService">

	<div class="form-group">
		<p>Nome servizio</p>
		<input maxlength="40" class="form-control" type="text" name="txtNomeServizio" id="txtNomeServizio">
	</div>

	<div class="form-group">
		<p>Prezzo</p>
		<input class="form-control" type="number" name="txtPrezzo" id="txtPrezzo">
	</div>

	<div class="form-group">
		<p>Durata media servizio - HH:MM:SS</p>
		<input class="form-control" type="text" name="txtTempoMedio" id="txtTempoMedio"  pattern="([0-1]{1}[0-9]{1}|20|21|22|23):([0-5]{1}[0-9]{1}):([0-5]{1}[0-9]{1})">
	</div>

	<div class="form-group">
		<p>Data inizio - YYYY-MM-DD</p>
		<input class="form-control" type="text" name="txtDataInizio" id="txtDataInizio" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
	</div>
	
	<div class="form-group">
		<p>Data fine - YYYY-MM-DD</p>
		<input class="form-control" type="text" name="txtDataFine" id="txtDataFine" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
	</div>

	<div class="form-group">
		<p>Orario inizio - HH:MM:SS</p>
		<input class="form-control" type="text" name="txtOrarioInizio" id="txtOrarioInizio" pattern="([0-1]{1}[0-9]{1}|20|21|22|23):([0-5]{1}[0-9]{1}):([0-5]{1}[0-9]{1})">
	</div>
	
	<div class="form-group">
		<p>Orario fine - HH:MM:SS</p>
		<input class="form-control" type="text" name="txtOrarioFine" id="txtOrarioFine"  pattern="([0-1]{1}[0-9]{1}|20|21|22|23):([0-5]{1}[0-9]{1}):([0-5]{1}[0-9]{1})">
	</div>

	<div class="form-group">
		<p>Descrizione</p>
		<input maxlength="500" class="form-control" type="text" name="txtDescrizione" id="txtDescrizione">
	</div>

	<div class="form-group">
		<p>Dettagli aggiuntivi</p>
		<input maxlength="100" class="form-control" type="text" name="txtAltriDettagli" id="txtAltriDettagli">
	</div>
	
<!-- 	<div class="form-group">
		<p>Foto</p>
		<input class="form-control" type="file" name="txtContenutiMultimediali" id="txtContenutiMultimediali">
	</div> -->
	

	<div class="form-group">
		<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Registra il servizio">
	</div>
</form>