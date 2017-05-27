<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="./common/header.jsp" />
<body>
	<c:import url="./common/nav.jsp" />

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('img/home-bg.jpg')">
		<div class="container main">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading home">
						<h1>Bokeum's Blog</h1>
						<!-- <hr class="small"> -->
						<span class="subheading">I'm a new creation in Jesus Christ.</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-md-9">

				<c:forEach var="content" items="${contentList }">
					<div class="post-preview">
						<a href="./ContentController?id=${content.id }">
							<h2 class="post-title">${content.title}</h2>
							<h3 class="post-subtitle">${content.sub_title }</h3>
						</a>
						<p class="post-meta">
							Posted by <a href="contact.html">${content.name}</a> ${content.create_date}
						</p>
					</div>
				</c:forEach>

				<!-- Pager -->

				<ul class="pager">
					<c:if test="${currentPage != 1}">
						<li class="previous"><a href="./BlogListController?p=${currentPage - 1}">&larr; Newer</a></li>
					</c:if>
					<c:if test="${totalPage != currentPage}">
						<li class="next"><a href="./BlogListController?p=${currentPage + 1}">Older&rarr;</a></li>
					</c:if>
				</ul>
			</div>
			<div class="col-md-3">
				<!-- <div style="width: 100%; height : 300px; border: 1px solid black;">
					카테고리 목록
				</div> -->
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
	</div>

	<hr>
	<c:import url="./common/footer.jsp" />
</body>

</html>