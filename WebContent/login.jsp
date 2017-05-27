<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="./common/header.jsp" />
<link href="css/signin.css" rel="stylesheet">

<body>
	<c:import url="./common/nav.jsp" />
	
	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('img/login-bg.png')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading login">
						<h1>Login</h1>
						<!-- <hr class="small"> -->
						<span class="subheading">Hi there. if you want to write something. <br> please login right now! </span>
						<p>www.leebokeum.com</p>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="container">
		<c:if test="${user eq null }">
			<form class="form-signin" action="./LoginController" method="post">
				<!-- <h2 class="form-signin-heading">로그인 하세요.</h2> -->
				<label for="inputEmail" class="sr-only">Email address</label> <input type="text" id="inputEmail" class="form-control" name="user_id" placeholder="ID" required autofocus> 
				<label
					for="inputPassword" class="sr-only">Password</label> <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me"> Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
				<c:if test="${confirm ne null }">
					<h4>${confirm }</h4>
				</c:if>
			</form>
		</c:if>
		<c:if test="${user ne null }">
				<form class="form-signin" action="./LogoutController" method="post">
					<button class="btn btn-lg btn-primary btn-block" type="submit">로그아웃</button>
			</form>
		</c:if>
	</div>
	<c:import url="./common/footer.jsp" />
</body>
</html>