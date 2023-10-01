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
    <h3 style="text-align: center;">List chương trình giảm giá giầy thể thao </h3>
    <br>
    <div class="" style="margin-top: 30px; margin-bottom: 30px">
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
    </div>

    <a href="/ChuongTrinhGiamGiaHoaDon/list">
        <button>Back</button>
    </a>
    <div class="thongBao">
<%--           Tìm kiếm thành công --%>
            <label>${messageDone}</label>
<%--            Không tìm thấy id có mã--%>
            <label>${messageFind}</label>
<%--            Không tìm thầy sản phẩm--%>
            <label>${messageErFind}</label>
            <label>${message}</label>
            <label>${messageErFindSoLuong}</label>

    </div>


    <table>
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên Chương trình giảm giá</th>
            <th scope="col">Phần trăm giảm</th>
            <th scope="col">Ngày bắt đầu</th>
            <th scope="col">Ngày kết thúc</th>
            <th scope="col">Ghi chú</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Functions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hd" items="${listPage}" varStatus="i">
            <tr>
                <th style="padding-top: 40px" scope="row">${i.index+1}</th>
                <td style="padding-top: 55px; text-align: center">${hd.tenChuongTrinhGiamGia}</td>
                <td style="padding-top: 55px; text-align: center">${hd.phanTramGiam}%</td>
                <td style="padding-top: 55px; text-align: center">${hd.ngayBatDau}</td>
                <td style="padding-top: 55px; text-align: center">${hd.ngayKetThuc}</td>
                <td style="padding-top: 55px; text-align: center">${hd.ghiChu}</td>
                <td style="padding-top: 55px; text-align: center">${hd.trangThai==1 ?"Chưa hết hạn" : "Hết hạn"}</td>
                <td>
                       <a class="col-sm-4" href="${pageContext.request.contextPath}/ChuongTrinhGiamGiaGiayTheThao/edit/${hd.id}"><button class="btn btn-primary">Edit</button></a>
                 </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <ul class="pagination" style="margin-left: 500px">
            <c:forEach begin="1" end="${totalPage}" varStatus="status">
                <li class="page-item">
                    <a href="${pageContext.request.contextPath}/ChuongTrinhGiamGiaGiayTheThao/list?pageNum=${status.index}" class="page-link">${status.index}</a>
                </li>
            </c:forEach>
        </ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>