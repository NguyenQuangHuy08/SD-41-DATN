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
    <title>Home</title>
</head>
<body class="container">
<h1>Form Control</h1>
<form action="/day-giay/add" method="post">
    <label class="form-label">Ten Day Giay</label>
    <input type="text" class="form-control" name="tenCongDung">
    <label class="form-label">Chieu Dai Day Giay</label>
    <input type="text" class="form-control" name="chieuDaiDayGiay">
    <label class="form-label">Ghi Chu</label>
    <input type="text" class="form-control" name="ghiChu">
    <label class="form-label">Ngay Sua</label>
    <input type="text" class="form-control" name="ngaySua">
    <label class="form-label">Ngay Tao</label>
    <input type="text" class="form-control" name="ngayTao">
    <label>Trang Thai:
        <input type="radio" name="trangThai" checked    value="1" />Hoat dong
        <input type="radio" name="trangThai"   value="0"/>Khong hoat dong
    </label>
        <br>
    <button type="submit"class="btn btn-primary">ADD</button>
</form>
<br>
<br>
<table class="table table-bordered">
    <thead>
    <tr>

        <th scope="col">ID</th>
        <th scope="col">Ten Day Giay</th>
        <th scope="col">Chieu Dai</th>
        <th scope="col">Ghi Chu</th>
        <th scope="col">Ngay Tao</th>
        <th scope="col">Ngay Sua</th>
        <th scope="col">Trang Thai</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${dayGiay}" var="fm">
        <td>${fm.id}</td>
        <td>${fm.tenDayGiay}</td>
        <td>${fm.chieuDaiDayGiay}</td>
        <td>${fm.ghiChu}</td>
        <td>${fm.ngayTao}</td>
        <td>${fm.ngaySua}</td>
        <td>${fm.trangThai}</td>
        <td>
            <a href="/day-giay/delete/${fm.id}"><button type="button" class="btn btn-outline-primary">Delete</button></a>
            <a href="/day-giay/view-update/${fm.id}"><button type="button" class="btn btn-outline-primary">View Update</button></a>
        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
    </tr>
</table>
</body>
</html>