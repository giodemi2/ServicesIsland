<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:choose>
	<c:when test="${not empty requestScope.result}">
		
			<table id="servicesReportTable">
				<tr>
					<th><strong>Nome servizio</strong></th>
					<th><strong>Descrizione servizio</strong></th>
				</tr>
				<c:forEach items="${requestScope.result}" var="i">
				<tr>
					<td>
						<a href="ServicesHandler?op=findService&serviceId=${i.codice}">
							<p>${i.nome}</p>
						</a>
					</td>
					<td>
						<p>${i.descrizione}</p>	
					</td>
				</tr>
				</c:forEach>
			</table>
	</c:when>

	<c:otherwise>
		<article>
			<h1>La ricerca non ha prodotto risultati</h1>
		</article>
	</c:otherwise>
</c:choose>
