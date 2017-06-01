<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Insert title here</title>
</head>
<body style="background-color: #E6E6FA">
	<center>

		<h2>Manage Product</h2>


		<form:form method="post" action="manage_product_create"
			commandName="createProductObj" enctype="multipart/form-data">
			<table>
				<tr>
					<td><form:label path="id">ID</form:label></td>
					<td><form:input path="id" disabled="true" /></td>
					<td ><form:errors path="id">
						</form:errors></td>
				</tr>

				<tr>
					<td><form:label path="name"> NAME</form:label></td>
					<td><form:input path="name" /></td>
					<td style="color: red;"><form:errors path="name"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" /></td>
					<td style="color: red;"><form:errors path="description"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="price">Price</form:label></td>
					<td><form:input path="price" /></td>
					<td style="color:red; "><form:errors path="price"></form:errors></td>
				</tr>
				<tr>
				<tr>
					<td><form:label path="supplier">
							<spring:message text="Supplier" />
						</form:label></td>
					<td><form:select path="supplier.name" items="${supplierList}"
							itemValue="name" itemLabel="name" class="form-control" /></td>
				</tr>
				<tr>
					<td><form:label path="category">
							<spring:message text="Category" />
						</form:label></td>
					<td><form:select path="category.name" items="${categoryList}"
							itemValue="name" itemLabel="name" class="form-control" /></td>
				</tr>


			<%-- 	<tr>
					<td><form:label path="image">
							<spring:message text="image" />
						</form:label></td>
					<td><form:input path="image" type="file" /></td>

				</tr>  --%>
				
				<input type="file" name="file"/><br/>


			</table>

			<input type="submit" value="Add Product">
		</form:form>
	</center>
	<%@ include file="footer.jsp"%>
</body>
</html>