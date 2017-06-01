
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="header.jsp"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"></c:url>"></script>
</head>


<body>

	<div class="container-wrapper">
		<div class="container">


			<div class="bg-img">
				<section>
					<div class="jumbotron">
						<div class="container">
							<h3>Cart</h3>
							<p>All the selected products in your shopping cart</p>
						</div>
					</div>
				</section>

				<div data-ng-app="myapp" data-ng-controller="productController">
					<div class="cart-table">
						<h1>your's CartId is ${cartId}</h1>
						<div data-ng-init="getCart(${cartId})">
							<br> List of products purchased

							<div>
								<a class="btn btn-danger pull-left"
									data-ng-click="clearCart(${cartId})"> <span
									class="glyphicon glyphicon-remove-sign"> </span> Clear Cart
								</a>
							</div>
							<table class="table table-hover">
								<thead>

									<tr>
										<th>CARTITEM ID</th>
										<th>PRODUCT NAME</th>
										<th>QUANTITY</th>
										<th>PRICE</th>
										<th>TOTAL PRICE</th>

									</tr>
								</thead>
								<tr data-ng-repeat="cartitem in cart.cartItems">
									<td>{{cartitem.cartItemId}}</td>

									<br />
									<br />
									<br />
									<br />
									<br />
									<td>{{cartitem.product.name}}</td>
									<td>{{cartitem.quantity}}</td>
									<td>INR {{cartitem.product.price}}</td>
									<td>INR {{cartitem.totalPrice}}</td>
									<td><a class="btn btn-warning" href="#"
										data-ng-click="removeFromCart(${cartitem.cartItemId})"> <span
											class="glyphicon glyphicon-remove"></span> Remove
									</a></td>
								</tr>

							</table>
							<h3 class="grandtotal">
								GrandTotal Price : <strong>INR
									{{calculateGrandTotal()}}</strong>
							</h3>
						</div>

						<c:url value="/getAllProducts" var="url"></c:url>
						<a href="${url }" class="btn btn-primary">Continue shopping</a>


						<c:url value="/order/${cartId}" var="url"></c:url>
						<a href="${url}" class="btn btn-primary btn-lg pull-right">Checkout
						</a>


					</div>
				</div>
			</div>
		</div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>
