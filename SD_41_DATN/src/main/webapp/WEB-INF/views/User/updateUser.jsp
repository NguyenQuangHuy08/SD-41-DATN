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
<form action="/user/update/${us.id}" method="post">
    <label>Id: <input name="id" value="${us.id}"/></label>
    <br>
    <label>Email: <input name="email" value="${us.email}"/></label>
    <br>
    <label>Mat khau: <input name="matKhau" value="${us.matKhau}"/></label>
    <br>
    <label>Ten: <input name="tenUser" value="${us.tenUser}"/></label>
    <br>
    <label>Gioi tinh: <input name="gioiTinh" value="${us.gioiTinh}"/></label>
    <br>
    <label>Ngay sinh: <input name="ngaySinh" value="${us.ngaySinh}"/></label>
    <br>
    <label>CCCD: <input name="maCCCD" value="${us.maCCCD}"/></label>
    <br>
    <label>Ho khau: <input name="hoKhau" value="${us.hoKhau}"/></label>
    <br>
    <label>SDT: <input name="soDienThoai" value="${us.soDienThoai}"/></label>
    <br>
    <label>Dia chi: <input name="diaChi" value="${us.diaChi}"/></label>
    <br>
    <label>Ghi Chu: <input name="ghiChu" value="${us.ghiChu}"/></label>
    <br>
    <label>Ngay Tao: <input name="ngayTao" value="${us.ngayTao}"/></label>
    <br>
    <label>Ngay Sua: <input name="ngaySua" value="${us.ngaySua}"/></label>
    <br>
    <label>
        <input type="radio" name="trangThai" checked    value="1" ${us.trangThai=="1"?'checked':''}/>Hoat dong
        <input type="radio" name="trangThai"   value="0"${us.trangThai=="0"?'checked':''}/>Khong hoat dong
    </label>
        <br>
        <button type="submit">add</button>

</form>

</body>
</html>