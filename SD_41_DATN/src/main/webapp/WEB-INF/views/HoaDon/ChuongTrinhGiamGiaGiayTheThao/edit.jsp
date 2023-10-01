<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

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
    <h3 style="text-align: center;">Edit dữ liệu chương trình giảm giá hóa đơn</h3>
    <frm:form
            modelAttribute="chuongTrinhGiamGiaGiayTheThao"
            action="${pageContext.request.contextPath}/ChuongTrinhGiamGiaGiayTheThao/create"
            method="POST"
            enctype="multipart/form-data">
        <div class="form-group">
            <frm:hidden path="id" value="${chuongTrinhGiamGiaGiayTheThao.id}"/>
        </div>
        <div class="row">
            <div class="col-6">
                <label style="margin-left: 30px">Tên chương trình</label>
                <frm:input path="tenChuongTrinhGiamGia" cssStyle="width: 300px;" value = "${chuongTrinhGiamGiaGiayTheThao.tenChuongTrinhGiamGia}" />
            </div>
            <div class="col-6">
                <label style="margin-left: 150px; margin-right: 30px; margin-bottom: 30px">Phần trăm giảm </label>
                <frm:input path="phanTramGiam" cssStyle="width: 200px;" value = "${chuongTrinhGiamGiaGiayTheThao.phanTramGiam}" />
            </div>
            <div class="col-6">
                <label style="margin-left: 150px; margin-right: 66px; margin-bottom: 30px">Ngày bắt đầu</label>
                <frm:input path="ngayBatDau" cssStyle="width: 200px;" type="date" value = "${chuongTrinhGiamGiaGiayTheThao.ngayBatDau}" />
            </div>
            <div class="col-6">
                <label style="margin-left: 150px; margin-right: 66px; margin-bottom: 30px">Ngày kết thúc</label>
                <frm:input path="ngayKetThuc" cssStyle="width: 200px;" type="date" value = "${chuongTrinhGiamGiaGiayTheThao.ngayKetThuc}"/>
                    <%--                                <div class="textTitle"><frm:errors cssStyle="margin-left: 400px; color: red" class="errors" path="name" /></div>--%>
            </div>
            <div class="col-6">
                <label style="margin-left: 150px; margin-right: 66px; margin-bottom: 30px">Ghi chú</label>
                <frm:input path="ghiChu" cssStyle="width: 200px;" type="" value = "${chuongTrinhGiamGiaGiayTheThao.ghiChu}" />
                    <%--                                <div class="textTitle"><frm:errors cssStyle="margin-left: 400px; color: red" class="errors" path="name" /></div>--%>
            </div>
            <div class="col-6">
                <label style="margin-left: 27px; margin-right: 25px; margin-bottom: 50px">Trạng thái</label>
                <frm:select path="trangThai" cssStyle="width: 200px;">
                    <option value="1">
                        Chưa hết hạn
                    </option>
                    <option value="0">
                        Hết hạn
                    </option>
                </frm:select>
            </div>
        </div>
        <button type="submit" onclick="if (!confirm('Bạn chắc chắn muốn thêm không ?')){return false;}else{return true;}" style="margin-left: 400px; margin-bottom: 190px" class="btn btn-primary">Update</button>
    </frm:form>

</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>