<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<p>
    <a href="category-list">Back to category list</a>
</p>
<h1 class="text-center text-danger">Thêm mới danh mục</h1>
<form:form action="add-category" method="POST" modelAttribute="category">
    <div class="form-group">
        <label for="name">Tên danh mục : </label>
        <form:input type="text" class="form-control" id="name" name="name" path="categoryName"/>
    </div>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form:form>
</body>
</html>