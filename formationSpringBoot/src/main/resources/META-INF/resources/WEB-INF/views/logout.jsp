<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<form method="post" action="${ctx}/logout" class="d-inline-block">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}"> <span>Bonjour ${pageContext.request.userPrincipal.name}</span>
	<button type="submit" class="btn btn-link">deconnexion</button>
</form>