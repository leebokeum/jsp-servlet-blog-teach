<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Footer -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<ul class="list-inline text-center">
					<li><a href="https://twitter.com/leebokeum87" target="_blank"> <span class="fa-stack fa-lg"> <i class="fa fa-circle fa-stack-2x"></i>
								<i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li><a href="https://www.facebook.com/leebokeum87" target="_blank"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li><a href="https://github.com/leebokeum" target="_blank"> <span class="fa-stack fa-lg"> <i class="fa fa-circle fa-stack-2x"></i>
								<i class="fa fa-github fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
				</ul>
				<p class="copyright text-muted">Copyright &copy; leebokeum 2016</p>
			</div>
		</div>
	</div>
</footer>


<!-- jQuery -->
<script src="js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/clean-blog.min.js"></script>

<script type="text/javascript">
	$(function() {
		var url = document.location.href.match(/[^\/]+$/)[0];
		if (url == "AboutController") {
			$(".navbar-right li:nth-child(2)").addClass("menu_underline");
		} else if (url == "contact.jsp") {
			$(".navbar-right li:nth-child(3)").addClass("menu_underline");
			$(".navbar-right li a").addClass("color_black");
		} else if (url == "login.jsp") {
			$(".navbar-right li:last-child").addClass("menu_underline");
		} else if (url == "WriteController"){
			$(".navbar-right li:nth-child(4)").addClass("menu_underline");
		}else{
			$(".navbar-right li:first-child").addClass("menu_underline");
		}
	});
</script>