<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- DC Table Styles I CSS -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
		
	
<%@ include file="header.jsp"%>
	
	
</head>
<body style="background-color:#E6E6FA">
<center>
	<h2>
		Manage Supplier
	</h2>
	
	

 <table class="dc_table_s12" summary="Sample Table" style="width:80%;">
    <caption>
    </caption>
    <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    <tfoot>
      <tr>
        <th scope="row"><a href="manage_supplier_create" class="btn btn-primary">AddSupplier</th>
        <td colspan="7"></a></td>
      </tr>
    </tfoot>
   
			
		<c:forEach var="supplier" items="${supplierList}">
			<tr>
				<td>${supplier.id}</td>
				<td>${supplier.name}</td>
				<td>${supplier.address}</td>

				<td><a
					href="<c:url value="/manage_supplier_edit/${supplier.id}"/>">Edit
						<span class="glyphicon glyphicon-edit"></span>
				</a>| <a href="<c:url value="/manage_supplier_delete/${supplier.id}"/>">
						<span class="glyphicon glyphicon-trash"></span>delete
				</a></td>

			</tr>
		</c:forEach>

	</table>
	</center>
	
		
	
<%@ include file="footer.jsp"%>
	
	
	
</body>
</html>

