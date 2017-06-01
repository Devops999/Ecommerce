<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Insert title here</title>
</head>
<body style="background-color:#E6E6FA">
<center>
	<h2>Manage Suppliers</h2>

	<form:form method="post" action="manage_supplier_create"
		commandName="createSupplierObj">

		<table>
			<tr>
				<td><form:label path="id">ID</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
				<td><form:errors path="id" /></td>

			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>

			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" /></td>


			</tr>
			<tr>
				<td><form:label path="mobile">Contact</form:label></td>
				<td><form:input path="mobile" /></td>
				<td><form:errors path="mobile" /></td>


			</tr>

			<tr>
				<td><input type="submit" value="Add Supplier"></td>
			</tr>
		</table>
	</form:form>
	</center>



<%@ include file="footer.jsp"%>
</body>
</html>