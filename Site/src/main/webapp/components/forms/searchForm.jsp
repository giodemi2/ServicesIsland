<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form class="sidebar-form" id="searchForm" method="get" action="ServicesHandler">
	<input class="form-control" type="text" placeholder="Search..." name="txtSearch">
	<input type="hidden" name="op" value="search">
	<button type="submit" class="btn-link" style="cursor: pointer;">
		<span class="fas fa-search"></span>
	</button>
</form>