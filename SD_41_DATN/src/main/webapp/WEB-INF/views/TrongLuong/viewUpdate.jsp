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
    <title>View Update</title>
</head>
<body class="container">
    <form action="/trong-luong/update/${cd.id}" method="post">
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id" value="${cd.id}">
        <label class="form-label">Ten Trong Luong</label>
        <input type="text" class="form-control" name="tenTrongLuong" value="${cd.tenTrongLuong}">
        <label class="form-label">Ghi Chu</label>
        <input type="text" class="form-control" name="ghiChu" value="${cd.ghiChu}">
        <label class="form-label">Ngay Sua</label>
        <input type="text" class="form-control" name="ngaySua" value="${cd.ngaySua}">
        <label class="form-label">Ngay Tao</label>
        <input type="text" class="form-control" name="ngayTao" value="${cd.ngayTao}">
        <label>Trang Thai:
            <input type="radio" name="trangThai"   value="1" ${cd.trangThai=="1"?'checked':''} />Hoat dong
            <input type="radio" name="trangThai"   value="0" ${cd.trangThai=="0"?'checked':''}>Khong hoat dong
            <br>
            <button type="submit"class="btn btn-primary">Update</button>
    </form>
</body>
</html>