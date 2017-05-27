<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="./common/header.jsp" />
<script src="ckeditor/ckeditor.js"></script>
<link href="css/write.css" rel="stylesheet">
<body>
	<c:choose>
		<c:when test="${content ne null}">
			<c:url var="actionUrl" value="./UpdateController" />
		</c:when>
		<c:otherwise>
			<c:url var="actionUrl" value="./SaveContentController" />
		</c:otherwise>
	</c:choose>
	<c:import url="./common/nav.jsp" />
	<header class="intro-header" style="background-image: url('img/home-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>Bok's Blog</h1>
						<hr class="small">
						<span class="subheading">I'm a new creation in Jesus Christ.</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">

				<form class="form-horizontal" role="form" action="${actionUrl }" method="post" id="content">
					<div class="form-group">
						<label class="control-label col-sm-2" for="title">제목 :</label>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${content ne null }">
									<input type="hidden" name="id" value="${content.id }">
									<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해주세요" value="${content.title }" required="required">
								</c:when>
								<c:otherwise>
									<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해주세요" required="required">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="sub_title">부제목 :</label>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${content ne null }">
									<input type="text" class="form-control" name="sub_title" id="sub_title" placeholder="제목을 입력해주세요" value="${content.sub_title }">
								</c:when>
								<c:otherwise>
									<input type="text" class="form-control" name="sub_title" id="sub_title" placeholder="제목을 입력해주세요">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="content">내용 :</label>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${content ne null }">
									<textarea  id="editor" name= "content" class="form-control"  placeholder="내용을 입력해주세요">${content.content}</textarea>
								</c:when>
								<c:otherwise>
									<textarea id="editor" name= "content" class="form-control" placeholder="내용을 입력해주세요"></textarea>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">작성자 :</label>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${content ne null }">
									<input type="text" class="form-control" name="name" id="name" placeholder="작성자 이름" value="${content.name }" required="required">
								</c:when>
								<c:otherwise>
									<input type="text" class="form-control" name="name" id="name" placeholder="작성자 이름" value="${user.name }" required="required">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">카테고리 :</label>
						<div class="col-sm-10">
							<select class="form-control" id="selectCategory" name="category_id" required="required">
								<c:forEach var="category" items="${categoryList }">
									<option value= "${category.id}">${category.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">카테고리 추가 :</label>
						<div class="col-sm-10">
							<input type="text" name="name" class="form-control" style="width: 300px; display: inline-block;" id="add_category" form="addCategoyForm" placeholder="카테고리 추가" required="required">
							<button type="submit" class="btn btn-default btn-sm" form="addCategoyForm" >추가</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button form="content" type="submit" class="btn btn-default btn-lg">Submit</button>
						</div>
					</div>
				</form>
				
				<form id="addCategoyForm">
				</form>
				</div>
			</div>
		</div>
	<hr>
	<c:import url="./common/footer.jsp" />
	<script type="text/javascript">
		$(function() {
			CKEDITOR.replace('editor', { height : 500 });
			
			$("#addCategoyForm").submit(
					function(e) {
						$.ajax({
							type : 'POST',
							url : './AddCategoryController',
							data : $("#addCategoyForm").serialize(),
							success : function(result) {
								$('#selectCategory').append(
										$("<option></option>").attr("value",
												result.category_id).text(
												$("#add_category").val()));
							}
						});
						e.preventDefault();
					});
		});
	</script>
</body>

</html>