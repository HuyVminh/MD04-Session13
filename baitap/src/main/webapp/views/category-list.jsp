<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA. User: ASUS Date: 11/30/2023 Time: 3:41 PM To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<body>
<div class="container">
    <h1 class="text-center text-primary">Danh sách danh mục</h1>
    <a href="add-category" class="btn btn-primary my-3">Thêm mới danh mục</a>
    <c:if test="${!empty mess}">
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                <span class="sr-only">Close</span>
            </button>
            <strong>${mess}</strong>
        </div>
    </c:if>
    <table class="table my-3">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Tên danh mục</th>
            <th scope="col">Trạng thái</th>
            <th scope="col" colspan="2">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td scope="row">${item.categoryId}</td>
                <td scope="row">${item.categoryName}</td>
                <td scope="row">${item.status?"Hoạt động":"Khóa"}</td>
                <td scope="row">
                    <a href="edit-category/${item.categoryId}" class="btn btn-warning">Sửa</a>
                </td>
                <td scope="row">
                    <a href="delete/${item.categoryId}"
                       class="btn ${item.status?"btn-danger":"btn-success"}">${item.status?"Block":"Active"}</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>