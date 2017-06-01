<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- DC Table Styles I CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<%@ include file="header.jsp"%>


<title>Insert title here</title>
</head>

<body style="background-color: #E6E6FA">

	<center>

		<h2>Manage Category</h2>


		<!-- DC Table Styles II:14 Start -->
		<table class="dc_table_s12" summary="Meeting Results"
			style="width: 70%;">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="category" items="${categoryList}">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.description}</td>

						<td><a
							href="<c:url value="/manage_categories_edit/${category.id}"/>">Edit
								<span class="glyphicon glyphicon-edit"></span>
						</a>| <a
							href="<c:url value="/manage_categories_delete/${category.id}"/>">
								<span class="glyphicon glyphicon-trash"></span>delete
						</a></td>

					</tr>


				</c:forEach>
			</tbody>

		</table>
		
		<br/><br/>

		<a href="manage_category_create" style="" class="btn btn-info">Add
			Category</a>



	</center>



	<%@ include file="footer.jsp"%>

</body>
</html>