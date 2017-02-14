<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section id="form">
	<!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>Login to your account</h2>
					<c:if test="${param.fail}">
						<p style="color: red;">Fail</p>
					</c:if>
					<form:form action="/login" class="form-inline" method="post">
						<input name="login" placeholder="Login" />
						<input name="password" type="password" />
						<span> <input name="remember-me" type="checkbox"
							class="form-control"><label>Remember me</label>
						</span>
						<button type="submit">Login</button>
					</form:form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OR</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->
					<h2>New User Signup!</h2>
					<c:if test="${param.fail}">
							<p style="color: red;">Fail</p>
					</c:if>
					<form action="/registration" method="post" modelAttribute="user">
						<input name="login" placeholder="Login" /> <input name="mail"
							placeholder="E-mail" /> <input name="password" type="password" />
						<button type="submit" class="btn btn-default">Registration</button>
					</form>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>
</section>
<!--/form-->


