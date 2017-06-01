<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

</head>
<body>

	<c:if test="${isUserClickedCategory==true }">
		<jsp:include page="category.jsp" />
	</c:if>

	<c:if test="${isAdminClickedSuppliers==true }">
		<jsp:include page="supplier.jsp" />
	</c:if>

	<c:if test="${isUserClickedProducts==true }">
		<jsp:include page="product.jsp" />
	</c:if>



</body>
</html>