<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="header.jsp"%>



	<center>
		<form:form method="post" action="registration" commandName="userobj">


			<h2>REGISTER</h2>
			<table>
				<%-- 	<tr>
				<td><form:label path="id">User Id</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
				<td><form:hidden path="id" /></td>
			</tr>  --%>
				<tr>
					<td><form:label path="name">User Name</form:label></td>
					<td><form:input path="name" /></td>
					<td style="color: red"><form:errors path="name" /></td>

				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:input path="password" /></td>
					<td style="color: red"><form:errors path="password" /></td>

			 	</tr>
<%---				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" /></td>
					<td style="color: red;"><form:errors path="email" /></td>

				</tr>
				<tr>
					<td><form:label path="contact">Phone</form:label></td>
					<td><form:input path="contact" /></td>
					<td style="color: red"><form:errors path="contact" /></td>

				</tr>
				<tr>
					<td><input type="submit" value="Register"
						class="btn btn-primary "></td>


				</tr>
--%>

			</table>
		</form:form>
	</center>




	<%@ include file="footer.jsp"%>
</body>
</html>