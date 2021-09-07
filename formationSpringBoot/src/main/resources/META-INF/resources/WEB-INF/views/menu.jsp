<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="${ctx}">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="${ctx}">Home
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${ctx}/hello">hello</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="${ctx}/secure">secure</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="${ctx}/admin">admin</a>
			</li>
			</li>
			<li class="nav-item"><a class="nav-link" href="${ctx}/login">connexion</a>
			</li>
			<li class="nav-item"><jsp:include page="./logout.jsp"></jsp:include>
			</li>
		</ul>
	</div>
</nav>