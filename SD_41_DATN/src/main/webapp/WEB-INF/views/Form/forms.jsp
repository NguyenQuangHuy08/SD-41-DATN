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
<form action="/form/add" method="post">
    <label>Ten: <input name="tenForm"/></label>
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
<%--<button><a href="/chat-lieu/view-add ">add</a></button>--%>
<table class="table" border="1">
    <thead>
    <tr>

        <th scope="col">id</th>
        <th scope="col">Ten Form</th>
        <th scope="col">Ghi Chu</th>
        <th scope="col">Ngay Tao</th>
        <th scope="col">Ngay Sua</th>
        <th scope="col">Trang Thai</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${form}" var="fm">
        <td>${fm.id}</td>
        <td>${fm.tenForm}</td>
        <td>${fm.ghiChu}</td>
            <td>${fm.ngayTao}</td>
            <td>${fm.ngaySua}</td>
            <td>${fm.trangThai}</td>
        <td>
            <button><a href="/form/view-update/${fm.id}">update</a></button>
            <button><a href="/form/delete/${fm.id}">delete</a></button>

        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
    </tr>
</table>
</body>
</html>