
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ include file="header.jsp"%>
</head>
<body style="background-color: #E6E6FA">
	<center>
		<h2>Manage Categories</h2>

		<form:form method="post" action="manage_category_create"
			commandName="createCategoryObj">

			<table>
				<tr>
					<td><form:label path="id">Category ID</form:label></td>
					<td><form:input path="id" disabled="true" /></td>
					<td><form:hidden path="id" /></td>

				</tr>
				<tr>
					<td><form:label path="name">Category Name</form:label></td>
					<td><form:input path="name" /></td>
					<td style="color: red;"><form:errors path="name" /></td>

				</tr>
				<tr>
					<td><form:label path="description">Category Description</form:label></td>
					<td><form:input path="description" /></td>
					<td style="color: red;"><form:errors path="description" /></td>


				</tr>
				<tr>
					<td><input type="submit" class="btn btn-info"
						value="Add Category"></td>
				</tr>
			</table>
		</form:form>
	</center>

<%@ include file="footer.jsp"%>


</body>
</html>