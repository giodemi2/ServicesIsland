<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<article class="rounded">
	<h1>Pagina di conferma</h1>
	<hr class="visible-xs mt-3">
	<p>
		${ param.message }
	</p>
</article>
