<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm sản phẩm</title>
</head>
<body>
<h1>Tìm kiếm sản phẩm</h1>

<form action="${pageContext.request.contextPath}/ChuongTrinhGiamGiaHoaDon/search" method="GET">
    <label for="tenChuongTrinh">Tên chương trình </label>
    <input style="width: 400px" type="text" id="tenChuongTrinh" name="tenChuongTrinh">
    <br>
    <label for="soLuongSanPham">Số lượng sản phẩm :</label>
    <input type="number" id="soLuongSanPham" name="soLuongSanPham">
    <br>
    <label for="phanTramGiam">Phần trăm giảm :</label>
    <input type="number" id="phanTramGiam" name="phanTramGiam">
    <br>
    <label for="soTienHoaDon">Số tiền hóa đơn cần đạt :</label>
    <input type="number" id="soTienHoaDon" name="soTienHoaDon">
    <br>
    <button type="submit">Tìm kiếm</button>
</form>

<h2>Kết quả tìm kiếm:</h2>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<table border="1">
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
    </tr>
    <c:forEach var="hd" items="${hd}">
        <tr>
            <td style="padding-top: 55px; text-align: center">${hd.id}</td>
            <td style="padding-top: 55px; text-align: center">${hd.tenChuongTrinh}</td>
            <td style="padding-top: 55px; text-align: center">${hd.phanTramGiam}%</td>
            <td style="padding-top: 55px; text-align: center">${hd.soLuongSanPham}</td>
            <td style="padding-top: 55px; text-align: center">${hd.soTienHoaDon} VNĐ</td>
            <td style="padding-top: 55px; text-align: center">${hd.ngayBatDau}</td>
            <td style="padding-top: 55px; text-align: center">${hd.ngayKetThuc}</td>
            <td style="padding-top: 55px; text-align: center">${hd.ghiChu}</td>
            <td style="padding-top: 55px; text-align: center">${hd.trangThai==1 ?"Chưa hết hạn" : "Hết hạn"}</td>
        </tr>
    </c:forEach>

    <h1>Test danh sách trùng lặp</h1>
    <h2>Danh sách tất cả các tên:</h2>
    <ul>
        <c:forEach var="item" items="${hd}">
            <li>${item.tenChuongTrinh}</li>
        </c:forEach>
    </ul>

    <h2>Danh sách các tên trùng lặp:</h2>
    <ul>
        <c:forEach var="duplicate" items="${duplicateNames}">
            <li>${duplicate.tenChuongTrinh}</li>
        </c:forEach>
    </ul>

</table>
</body>
</html>
