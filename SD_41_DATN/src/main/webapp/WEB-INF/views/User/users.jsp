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
<form action="/user/add" method="post">
    <label>Email: <input name="email"/></label>
    <br>
    <label>Mat khau: <input name="matKhau"/></label>
    <br>
    <label>Ten: <input name="tenUser"/></label>
    <br>
    <label>Gioi tinh: <input name="gioiTinh"/></label>
    <br>
    <label>Ngay sinh: <input name="ngaySinh"/></label>
    <br>
    <label>CCCD: <input name="maCCCD"/></label>
    <br>
    <label>Ho khau: <input name="hoKhau"/></label>
    <br>
    <label>SDT: <input name="soDienThoai"/></label>
    <br>
    <label>Dia chi: <input name="diaChi"/></label>
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
    </label>
</form>
<br>
<%--<button><a href="/chat-lieu/view-add ">add</a></button>--%>
<table class="table" border="1">
    <thead>
    <tr>

        <th scope="col">id</th>
        <th scope="col">Email</th>
        <th scope="col">Mat khau</th>
        <th scope="col">Ten User</th>
        <th scope="col">Gioi Tinh</th>
        <th scope="col">Ngay Sinh</th>
        <th scope="col">CCCD</th>
        <th scope="col">Ho khau</th>
        <th scope="col">So Dien Thoai</th>
        <th scope="col">Dia chi</th>
        <th scope="col">Ghi Chu</th>
        <th scope="col">Ngay Tao</th>
        <th scope="col">Ngay Sua</th>
        <th scope="col">Trang Thai</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${user}" var="us">
            <td>${us.id}</td>
            <td>${us.email}</td>
            <td>${us.matKhau}</td>
            <td>${us.tenUser}</td>
            <td>${us.gioiTinh}</td>
            <td>${us.ngaySinh}</td>
            <td>${us.maCCCD}</td>
            <td>${us.hoKhau}</td>
            <td>${us.soDienThoai}</td>
            <td>${us.diaChi}</td>
            <td>${us.ghiChu}</td>
            <td>${us.ngayTao}</td>
            <td>${us.ngaySua}</td>
            <td>${us.trangThai}</td>

        <td>
            <button><a href="/user/view-update/${us.id}">update</a></button>
            <button><a href="/user/delete/${us.id}">delete</a></button>

        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
    </tr>
</table>
</body>
</html>