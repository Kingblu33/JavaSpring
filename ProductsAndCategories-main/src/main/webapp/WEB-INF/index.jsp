<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Products and Categories</title>
</head>

<body>
	<div class="container">
		<div class="row p-4 justify-content-center">
			<div class="col-sm-6">
				<h1 class="text-center">Products and Categories</h1>
				<h3 class="text-center"><a href="/products/new">New Product</a> | <a href="/categories/new">New Category</a></h3>
			</div>
		</div>
		
		<div class="row">
			<h3>Categories</h3>
			 <table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th><h4>Category Name</h4></th>
						<th><h4>Product Count</h4></th>
					</tr>					        		
				</thead>
				<tbody>
					<c:forEach items="${ categories }" var="category">
						<tr>
							<td><a href="/categories/${ category.id }"><c:out value="${ category.name }"/></a></td>
							<td><c:out value="${ category.getProducts().size() }"></c:out></td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<h3>Products</h3>
			 <table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th><h4>Product Name</h4></th>
						<th><h4>Product Description</h4></th>
						<th><h4>Category Count</h4></th>
					</tr>					        		
				</thead>
				<tbody>
					<c:forEach items="${ products }" var="product">
						<tr>
							<td><a href="/products/${ product.id }"><c:out value="${ product.name }"/></a></td>
							<td><c:out value="${ product.description }"/></td>
							<td><c:out value="${ product.getCategories().size() }"></c:out></td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>