<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chương trình giảm giá hóa đơn</title>
    <%--    <link rel="icon" href="img/background_title.jpg" type="image/x-icon">--%>
    <style>

    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;">List chương trình giảm giá hóa đơn</h3>
    <table>
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên Chương trình</th>
            <th scope="col">Phần trăm giảm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Số tiền hóa đơn cần đạt</th>
            <th scope="col">Ngày bắt đầu</th>
            <th scope="col">Ngày kết thúc</th>
            <th scope="col">Ghi chú</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Functions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hd" items="${list}" varStatus="i">
            <tr>
                <th style="padding-top: 40px" scope="row">${i.index+1}</th>
                <td style="padding-top: 55px; text-align: center">${hd.tenChuongTrinh}</td>
                <td style="padding-top: 55px; text-align: center">${hd.phanTramGiam}%</td>
                <td style="padding-top: 55px; text-align: center">${hd.soLuongSanPham}</td>
                <td style="padding-top: 55px; text-align: center">${hd.soTienHoaDon} VNĐ</td>
                <td style="padding-top: 55px; text-align: center">${hd.ngayBatDau}</td>
                <td style="padding-top: 55px; text-align: center">${hd.ngayKetThuc}</td>
                <td style="padding-top: 55px; text-align: center">${hd.ghiChu}</td>
                <td style="padding-top: 55px; text-align: center">${hd.trangThai==1 ?"Chưa hết hạn" : "Hết hạn"}</td>
                <td>
                    <a class="" href="${pageContext.request.contextPath}"><button style="margin-top: 40px" class="btn-primary">Edit</button></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>