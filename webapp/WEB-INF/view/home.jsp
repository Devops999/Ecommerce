<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<!-- DC Horizontal Carousel CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/carousel_hor/css/dc_carousel_hor.css" />
<!-- jQuery Library (skip this step if already called on page ) -->
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/jquery.min.js"></script>
<!-- (do not call twice) -->
<!-- DC Horizontal Carousel JS -->
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/jquery.bxslider2.min.js"></script>
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/dc_jqcarousel.js"></script>
<!-- DC Elastislide CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/carousel_hor/css/elastislide.css" />
<!-- DC Elastislide JS -->
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/modernizr.custom.js"></script>
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/jquerypp.custom.js"></script>
<script type="text/javascript"
	src="http://cdn.dcodes.net/2/carousel_hor/js/jquery.elastislide.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Home</title>

<%@ include file="header.jsp"%>
<body style="background-color: #E6E6FA">

	${msg}
	<security:authorize access="hasRole('ROLE_USER')">
	
	<div id="myCarousel" class="carousel slide" data-ride="carousel" >
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="resources/images/22.jpg">
				</div>

				
				<div class="item">
					<img src="resources/images/33.jpg">
				</div>

				<div class="item">
					<img src="resources/images/44.jpg
					
					
					">
				</div>



				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

	<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>


<br>
</security:authorize>


	


	<%@ include file="footer.jsp"%>
</body>
</html>