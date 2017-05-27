<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="./common/header.jsp" />
<link href="css/content.css" rel="stylesheet">

<body>

	<c:import url="./common/nav.jsp" />

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('img/post-bg.png')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="post-heading">
						<h1>${content.title }</h1>
						<h2 class="subheading">Problems look mighty small from 150 miles up</h2>
						<span class="meta">Posted by <a href="contact.html">${content.name }</a> ${content.create_date }
						</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Post Content -->
	<article>
		<div class="container">
			<div class="row">
				<div class="col-md-9">${content.content }
					<div class="panel panel-default widget" style="margin-top: 30px;">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-comment"></span>
							<h3 class="panel-title">Reply</h3>
						</div>
						 <div class="panel-body">
							<ul class="list-group">
								<li class="list-group-item">
									<div class="row">
										<div class="col-xs-2 col-md-1">
											<img src="http://placehold.it/80" class="img-circle img-responsive" alt="" />
										</div>
										<div class="col-xs-10 col-md-11">
											<div>
												<a href="#"> Congratulations</a>
												<div class="mic-info">
													By: <a href="#">Check My Athletics</a> on 12 Jun 2014
												</div>
											</div>
											<div class="comment-text">We would like to congratulate John on his achievement...</div>
										</div>
									</div>
								</li>
							</ul>
						</div> 
						<div class="col">
							<div class="panel-body">
								<form role="form">
									<fieldset>
										<div class="form-group">
											<textarea class="form-control" rows="3" placeholder="Write in your wall" autofocus=""></textarea>
										</div>
										<button type="submit" class="[ btn btn-success ]" data-loading-text="Loading...">Post reply</button>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<nav class="nav-sidebar">
						<ul class="nav">
							<c:forEach var="category" items="${categoryList }">
								<c:choose>
									<c:when test="${c_id eq category.id}">
										<li class="active"><a href="./BlogListController?c_id=${category.id}">${category.name} </a></li>
									</c:when>
									<c:otherwise>
										<li><a href="./BlogListController?c_id=${category.id}">${category.name} </a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
			<c:if test="${user ne null }">
				<div style="width: 100px; float: right;">
					<a href="./DeleteController?id=${content.id }" class="btn btn-sm btn-primary btn-block">삭제</a>
				</div>
				<div style="width: 100px; float: right; margin-right: 15px;">
					<a href="./UpdateController?id=${content.id }" class="btn btn-sm btn-success btn-block">수정</a>
				</div>
			</c:if>
		</div>
	</article>
	<hr>
	<c:import url="./common/footer.jsp" />

</body>

</html>