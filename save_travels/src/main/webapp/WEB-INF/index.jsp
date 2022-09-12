<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Save Travel</title>
</head>
<body>
<h1>All expenses</h1>

<c:forEach  items="${expenses}" var="exp">
<div class="d-flex">
<p> Name: ${exp.expenseName}</p>
<p> Vendor: ${exp.vendor}</p>
<p> Amount: ${exp.amount}</p>
<p> description: ${exp.description}</p>
<a href="/expense/edit/${exp.id}">   Edit    </a>
<a class="ml-2"href="/expense/delete/${exp.id}">       Delete   </a>
<a class="ml-2"href="/expense/showone/${exp.id}"> Showone   </a>

</div>


</c:forEach>


 
 
 <h1>Form</h1>
 
<form:form action="/newexpense" method="post" modelAttribute="expense">
    <p>
        <form:label path="expenseName">Expense Name</form:label>
        <form:errors class="text-danger" path="expenseName"/>
        <form:input path="expenseName"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors class="text-danger" path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors class="text-danger" path="amount"/>
        <form:input path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors class="text-danger" path="description"/>     
        <form:input type="description" path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    

 
</body>
</html>