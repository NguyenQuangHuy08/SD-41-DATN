<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/size/add" method="post">
    <label>Size: <input name="size"/></label>
    <br>
    <label>Ghi Chu: <input name="ghiChu"/></label>
    <br>
    <label>Ngay Tao: <input name="ngayTao"/></label>
    <br>
    <label>Ngay Sua: <input name="ngaySua"/></label>
    <br>
    <label>Trang Thai:
        <input type="radio" name="trangThai" checked    value="1" />Hoat dong
        <input type="radio" name="trangThai"   value="0"/>Khong hoat dong
    <br>
    <button type="submit">add</button>
</form>
<br>
<%--<c:if test="${page.isEmpty()}">--%>
<%--    <h2>Not found any record!!</h2>--%>
<%--</c:if>--%>
<%--<c:if test="${not page.isEmpty()}">--%>
<%--<p>Found ${page.getTotalElements()} records</p>--%>
<%--<button><a href="/chat-lieu/view-add ">add</a></button>--%>
<table class="table" border="1">
    <thead>
    <tr>

        <th scope="col">id</th>
        <th scope="col">Size</th>
        <th scope="col">Ghi Chu</th>
        <th scope="col">Ngay Tao</th>
        <th scope="col">Ngay Sua</th>
        <th scope="col">Trang Thai</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${size}" var="sz">
        <td>${sz.id}</td>
        <td>${sz.size}</td>
        <td>${sz.ghiChu}</td>
            <td>${sz.ngayTao}</td>
            <td>${sz.ngaySua}</td>
            <td>${sz.trangThai}</td>
        <td>
            <button><a href="/size/view-update/${sz.id}">update</a></button>
            <button><a href="/size/delete/${sz.id}">delete</a></button>

        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
    </tr>
</table>
<div>
<%--    <c:if test="${page.getNumber() + 1 > 1}">--%>
<%--    <a href="?page=${page.getNumber()}&id=${param.id}">--%>
<%--        Previous--%>
<%--    </a>--%>
<%--    </c:if>--%>
<%--    <span> ${page.getNumber() + 1} / ${page.getTotalPages()} </span>--%>
<%--    <c:if test="${page.getNumber() + 1 lt page.getTotalPages()}">--%>
<%--    <a href="?page=${page.getNumber() + 2}&id=${param.id}">--%>
<%--        Next--%>
<%--    </a>--%>
<%--    </c:if>--%>
</body>
</html>
<%--    </div>--%>
<%--</c:if>--%>