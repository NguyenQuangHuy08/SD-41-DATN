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
<form action="/chat-lieu/update/${cl.id}" method="post">
    <label>Id: <input name="id"value="${cl.id}"/></label>
    <br>
    <label>Ten: <input name="tenChatLieu"value="${cl.tenChatLieu}"/></label>
    <br>
    <label>Ghi Chu: <input name="ghiChu" value="${cl.ghiChu}"/></label>
    <br>
    <label>Ngay Tao: <input name="ngayTao" value="${cl.ngayTao}"/></label>
    <br>
    <label>Ngay Sua: <input name="ngaySua" value="${cl.ngaySua}"/></label>
    <br>
    <label>
        <input type="radio" name="trangThai" checked    value="1" ${cl.trangThai=="1"?'checked':''}/>Hoat dong
        <input type="radio" name="trangThai"   value="0"${cl.trangThai=="0"?'checked':''}/>Khong hoat dong
    </label>
    <br>

    <button type="submit">update</button>
</form>
</body>
</html>