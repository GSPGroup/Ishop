<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header"></div>
		<ul class="nav navbar-nav">
			<a href="/"><img src="resources/images/home/logo.png" alt="" /></a>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<security:authorize access="isAuthenticated()and hasRole('ROLE_USER')">
				<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
			</security:authorize>
			<security:authorize	access="isAuthenticated() and hasRole('ROLE_ADMIN')">
			<li><a href="/admin"><i class="fa fa-star"></i>Admin panel</a>	</li>
			</security:authorize>
			<security:authorize access="!isAuthenticated()">
				<li><a href="/login"><i class="fa fa-lock"></i> Login</a></li>
			</security:authorize>

			<li><a>${authUser.login}</a></li>
			<security:authorize access="isAuthenticated()">
				<li><form:form action="/logout" method="post"
						class="navbar-form navbar-right">
						<button type="submit" class="btn btn-default">Logout</button>
					</form:form></li>
			</security:authorize>
		</ul>
	</div>
</nav>