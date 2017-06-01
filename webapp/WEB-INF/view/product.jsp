<!DOCTYPE html >
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"></c:url>"></script>



<%@ include file="header.jsp"%>
</head>
<body style="background-color: #E6E6FA">


	<div data-ng-app="myapp">

		<div data-ng-controller="productController"
			data-ng-init="getAllProducts()">

			Search: <input type="text" data-ng-model="searchCondition">

			<h1>
				<center>
					<h1>List of Products</h1>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<a href="manage_product_create" class="btn btn-primary"
							role="button">Add Product</a>
					</security:authorize>
				</center>

			</h1>




			<!-- DC Table Styles I:3 Start -->
			<center>
				<table class="dc_table_s3" summary="Sample Table"
					style="width: 90%;">

					<thead>
						<tr>
							<th width="35%" height="35%">IMAGE</th>

							<th>NAME</th>
							<th>PRICE</th>
							<th>DESCRIPTION</th>
							<th><security:authorize
									access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
									<h5>DETAILS</h5>
								</security:authorize></th>
							<th><security:authorize access="hasRole('ROLE_ADMIN')">
									<h5>EDIT/DELETE</h5>

								</security:authorize></th>

						</tr>

					</thead>
					<tbody>
						<tr data-ng-repeat="product in products | filter:searchCondition">


							<c:url value="resources/images/{{product.id}}.png" var="src" />
							<td><img src="${src}" style="width: 20%" align="middle" /></td>



							<td align="center">{{product.name}}</td>
							<td align="center">{{product.price}}</td>
							<td align="center">{{product.description}}</td>



							<td align="center"><security:authorize
									access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
									<a href="getProductsByProductId/{{product.id}}">{{product.id}}</a>

								</security:authorize></td>

							<td align="center"><security:authorize
									access="hasRole('ROLE_ADMIN')">

									<a href="<c:url value="/manage_product_edit/{{product.id}}"/>">Edit
										<span class="glyphicon glyphicon-edit"></span>
									</a>| <a
										href="<c:url value="/manage_product_delete/{{product.id}}"/>">
										<span class="glyphicon glyphicon-trash"></span>delete
									</a>

								</security:authorize></td>


						</tr>



					</tbody>

				</table>
			</center>

			<!-- DC Table Styles I:3 End -->
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
