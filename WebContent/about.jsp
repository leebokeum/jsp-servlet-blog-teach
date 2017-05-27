<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="./common/header.jsp" />
<body>

	<c:import url="./common/nav.jsp" />

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('img/about-bg.png')">
		<div class="container about">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="page-heading about">
						<h1>${about.title }</h1>
						<!-- <hr class="small"> -->
						<span class="subheading">${about.sub_title }</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				${about.content}
			</div>
			
			
		</div>
		<c:if test="${user ne null }">
			<div style="width: 100px; float: right; margin-right: 15px;">
				<a href="./AboutController?status=edit" class="btn btn-sm btn-success btn-block">수정</a>
			</div>
		</c:if>
	</div>

	<hr>
	<c:import url="./common/footer.jsp" />
</body>

</html>