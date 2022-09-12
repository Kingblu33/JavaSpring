<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Product Page</title>
</head>

<body>
	<div class="container">
		<div class="row p-4 justify-content-center">
			<div>
				<h3 class="text-center"><a href="/">Home</a> | <a href="/products/new">New Product</a> | <a href="/categories/new">New Category</a></h3>
				<h1 class="text-center"><c:out value="${product.name}"/></h1>
			</div>
		</div>
		
		<div class="row">
		    <div class="col-sm">
		      	<h2>Categories:</h2>
				<ul>
					<c:forEach items="${product.categories}" var="category">
						<li><h2><c:out value="${category.name}"/></h2></li>
					</c:forEach>
				</ul>
		    </div>
		    <div class="col-sm">
		     	<c:if test="${!empty categories}">
					<h2>Add a Category</h2>
					<form action="/products/${product.id}" method="POST">
						<div class="form-group" style="font-size: 30px;">
							<label for="category">Category:</label>
							<select name="category">
								<c:forEach items="${categories}" var="category">
			        					<option value="${category.id}"><c:out value="${category.name}"/></option>
			   					</c:forEach>
							</select>
						</div>
						<div class="row justify-content-center p-4">
							<input type="submit" style="font-size: 30px;" value="Add" class="btn btn-success"/>
						</div>
					</form>
				</c:if>
		    </div>
		  </div>
		
	</div>

</body>
</html>