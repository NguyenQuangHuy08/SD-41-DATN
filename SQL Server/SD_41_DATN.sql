go
create database SD_41_DATN
go
use SD_41_DATN

---create bảng form 
create table Form
(
		
		Id_Form				 UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
		tenForm				 nvarchar(max)							  null,
		ghiChu				 nvarchar(max)							  null,
		ngayTao				 Date									  null,
		ngaySua			     Date									  null,
		trangThai			 int									  null,
   
)
---create table công dụng
create table CongDung
(
  
     Id_CongDung			UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	 tenCongDung			nvarchar(50)							null,
	 ghiChu					nvarchar(max)							null,
	 ngayTao				Date									null,
	 ngaySua				Date									null,
	 trangThai				int										null

)
---create bảng chất liệu
create table ChatLieu
(
  
     Id_ChatLieu			UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	 tenChatLieu			nvarchar(50)							null,
	 ghiChu					nvarchar(max)							null,						
	 ngayTao				Date									null,
	 ngaySua				Date									null,
	 trangThai				int										null

)
---create bảng hướng dẫn bảo quản
create table HuongDanBaoQuan
(
   
     Id_HuongDanBaoQuan				UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	 tenHuongDanBaoQuan				nvarchar(50)							null,
	 ghiChu							nvarchar(max)							null,
	 ngayTao						Date									null,
	 ngaySua						Date									null,
	 trangThai						int										null

)
---create bảng Lót giầy
create table LotGiay
(
		
	Id_LotGiay				UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenLotGiay			    nvarchar(50)							null,
	ghiChu					nvarchar(max)							null,
	ngayTao				    Date									null,
	ngaySua					Date									null,
	trangThai				int										null

)
---create bảng Cổ giầy
create table CoGiay
(

	Id_CoGiay               UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenCoGiay			    nvarchar(50)								null,
	ghiChu					nvarchar(max)							null,
	ngayTao				    Date									null,
	ngaySua					Date									null,
	trangThai				int										null

)
---create bảng Đế giầy
create table DeGiay
(

	Id_DeGiay              UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenDeGiay			   nvarchar(50)							   null,
	ghiChu				   nvarchar(max)						   null,
	ngayTao				   Date									   null,
	ngaySua				   Date									   null,
	trangThai			   int									   null

)
---create bảng Dây giầy
create table DayGiay
(

	Id_DayGiay					UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenDayGiay					nvarchar(50)							null,
	chieuDaiDayGiay				nvarchar(50)						    null,	
	ghiChu						nvarchar(max)							null,
	ngayTao						Date									null,
	ngaySua						Date									null,
	trangThai					int										null

)
---create bảng trọng lượng 
create table TrongLuong
(

	Id_TrongLuong					UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenTrongLuong					nvarchar(50)							null,
	ghiChu							nvarchar(max)							null,
	ngayTao							Date									null,
	ngaySua							Date									null,
	trangThai						int										null

)
---create bảng thương hiệu
create table ThuongHieu
(

	Id_ThuongHieu					UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenThuongHieu					nvarchar(50)							null,
	ghiChu							nvarchar(max)							null,
	ngayTao							Date									null,
	ngaySua							Date									null,
	trangThai						int										null

)


---create bảng Sản Phẩm
create table GiayTheThao
(
  
    Id_GiayTheThao              UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	Id_Form						UNIQUEIDENTIFIER 						null,
	Id_CongDung     			UNIQUEIDENTIFIER							,
	Id_ChatLieu					UNIQUEIDENTIFIER							,
	Id_HuongDanBaoQuan			UNIQUEIDENTIFIER							,
	Id_LotGiay					UNIQUEIDENTIFIER							,
	Id_CoGiay					UNIQUEIDENTIFIER							,
	Id_DeGiay					UNIQUEIDENTIFIER						    ,
	Id_DayGiay					UNIQUEIDENTIFIER							,
	Id_TrongLuong				UNIQUEIDENTIFIER							,
	Id_ThuongHieu				UNIQUEIDENTIFIER							,
	kieuBuoc					nvarchar(50)							null,			
	gioiTinh					nvarchar(5)								null,
	dinhTanGiay					nvarchar(50)							null,
	tenGiayTheThao				nvarchar(50)							null,
	giaBan						DECIMAL(20, 0) DEFAULT 0				null,
	moTa						nvarchar(max)							null,
	ghiChu						nvarchar(max)							null,
	ngayTao						Date									null,
	ngaySua						Date									null,
	trangThai					int										null
		 
	
	 Constraint FK_GiayTheThao_Form						Foreign key(Id_Form)			References Form,
	 Constraint FK_GiayTheThao_CongDung					Foreign key(Id_CongDung)		References CongDung,
	 Constraint FK_GiayTheThao_ChatLieu					Foreign key(Id_ChatLieu)		References ChatLieu,
	 Constraint FK_GiayTheThao_HuongDanBaoQuan			Foreign key(Id_HuongDanBaoQuan)		References HuongDanBaoQuan,
	 Constraint FK_GiayTheThao_LotGiay					Foreign key(Id_LotGiay)			References LotGiay,
	 Constraint FK_GiayTheThao_CoGiay					Foreign key(Id_CoGiay)			References CoGiay,
	 Constraint FK_GiayTheThao_DeGiay					Foreign key(Id_DeGiay)			References DeGiay,
	 Constraint FK_GiayTheThao_DayGiay					Foreign key(Id_DayGiay)			References DayGiay,
	 Constraint FK_GiayTheThao_TrongLuong				Foreign key(Id_TrongLuong)			References TrongLuong,
	 Constraint FK_GiayTheThao_ThuongHieu				Foreign key(Id_ThuongHieu)			References ThuongHieu

)
---create bảng image
create table Image
(
	
	Id_Image              UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	Id_GiayTheThao		  UNIQUEIDENTIFIER							,
	Url_Image			  nvarchar(max)							null,
	ghiChu			      nvarchar(max)							null,
	ngayTao				  Date								    null,
	ngaySua				  Date									null,
	trangThai			  int									null

	Constraint FK_Image_GiayTheThao					Foreign key(Id_GiayTheThao)		References GiayTheThao,

)
---create bảng chương trình giảm giá
create table ChuongTrinhGiamGiaGiayTheThao
(
	
	Id_ChuongTrinhGiamGiaGiayTheThao              UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenChuongTrinhGiamGia						  nvarchar(max)							  null,
	phanTramGiam								  int									  null,
	ngayBatDau									  Date									  null,
	ngayKetThuc									  Date									  null,
	ghiChu										  nvarchar(max)							  null,
	ngayTao										  Date								      null,
	ngaySua										  Date									  null,
	trangThai									  int									  null

)
---create bảng chương trình giảm giá chi tiết giầy thể thao
create table ChuongTrinhGiamGiaChiTietGiayTheThao
(
	
	Id_ChuongTrinhGiamGiaChiTietGiayTheThao              UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	Id_ChuongTrinhGiamGiaGiayTheThao					 UNIQUEIDENTIFIER							 ,
	Id_GiayTheThao										 UNIQUEIDENTIFIER							 ,
	soTienDaGiam										 DECIMAL(20, 0) DEFAULT 0				 null,
	ghiChu												 nvarchar(max)							 null,			
	ngayTao												 Date								     null,
	ngaySua												 Date									 null,
	trangThai											 int									 null

	Constraint FK_ChuongTrinhGiamGiaChiTietGiayTheThao_ChuongTrinhGiamGiaGiayTheThao		  Foreign key(Id_ChuongTrinhGiamGiaGiayTheThao)		References ChuongTrinhGiamGiaGiayTheThao,
	Constraint FK_ChuongTrinhGiamGiaChiTietGiayTheThao_GiayTheThao							  Foreign key(Id_GiayTheThao)						References GiayTheThao

)
---create bảng Size
create table Size
(
	
	Id_Size              UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	size			     int							 		 null,
	ghiChu				 nvarchar(max)							 null,
	ngayTao				 Date								     null,
	ngaySua				 Date									 null,
	trangThai			 int									 null

)
---create table Màu sắc
create table MauSac
(
	
	Id_MauSac              UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	tenMauSac			   nvarchar(50)								null,
	ghiChu				   nvarchar(max)							null,
	ngayTao				   Date										null,
	ngaySua				   Date										null,
	trangThai			   int										null

)
---create bảng Chi tiết sản phẩm
create table GiayTheThaoChiTiet
(
	
	Id_GiayTheThaoChiTiet					UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	Id_GiayTheThao							UNIQUEIDENTIFIER							,
	Id_Size									UNIQUEIDENTIFIER							,
	Id_MauSac								UNIQUEIDENTIFIER							,
	soLuong									int										null,	
	ghiChu									nvarchar(max)							null,	
	ngayTao									Date									null,
	ngaySua									Date									null,
	trangThai								int										null

	 Constraint FK_GiayTheThaoChiTiet_GiayTheThao			Foreign key(Id_GiayTheThao)			References GiayTheThao,
     Constraint FK_GiayTheThaoChiTiet_Size					Foreign key(Id_Size)				References Size,
     Constraint FK_ChiTietSanPham_MauSac					Foreign key(Id_MauSac)				References MauSac,

)
---create table User
create table Users
( 
        Id_User				  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
		email			      nvarchar(50)							   null,
		matKhau				  nvarchar(30)							   null,
		tenUser				  nvarchar(30)							   null,
		gioiTinh			  nvarchar(5)							   null,
		ngaySinh              Date									   null,
		maCCCD				  nvarchar(30)							   null,
		hoKhau				  nvarchar(30)							   null,
		soDienThoai			  nvarchar(30)							   null,
		diaChi				  nvarchar(max)							   null,	
		ghiChu				  nvarchar(max)							   null,
		ngayTao				  Date									   null,
		ngaySua				  Date									   null,
		trangThai			  int									   null,

)
---create bảng KhachHang
create table KhachHang
(
 
       Id_KhachHang			  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	   email			      nvarchar(30)							   null,
	   matKhau				  nvarchar(30)							   null,
	   tenKhachHang			  nvarchar(30)							   null,
	   gioiTinh				  nvarchar(5)							   null,
	   ngaySinh				  Date									   null,
	   soDienThoai			  nvarchar(30)							   null,
	   diaChi				  nvarchar(max)							   null,
	   ghiChu				  nvarchar(max)							   null,
	   ngayTao				  Date							   null,
	   ngaySua				  Date							   null,
	   trangThai			  int							   null,

)
---create bảng HoaDon
create table HoaDon
(
      Id_HoaDon						   UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	  Id_KhachHang					   UNIQUEIDENTIFIER							   ,	
	  Id_Users						   UNIQUEIDENTIFIER							   ,
	  thanhTien						   DECIMAL(20, 0) DEFAULT 0			       null,
	  ghiChu						   nvarchar(max)						   null,
	  ngayTao						   Date									   null,
	  ngayThanhToan					   Date									   null,
	  ngaySua						   Date									   null,
	  trangThai					       int									   null,

	 Constraint FK_HoaDon_KhachHang						Foreign key(Id_KhachHang)			References KhachHang,
	 Constraint FK_HoaDon_Users							Foreign key(Id_Users)				References Users,

)
---create bảng chương trình giảm giá hóa đơn
create table ChuongTrinhGiamGiaHoaDon
(
        Id_ChuongTrinhGiamGiaHoaDon			UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
		tenChuongTrinh						nvarchar(50)							null,
		phanTramGiam						int										null,
        soLuongSanPham						int										null,
		soTienHoaDon						DECIMAL(20, 0) DEFAULT 0				null,
		ngayBatDau							Date									null,
		ngayKetThuc							Date									null,
		ghiChu							    nvarchar(max)							null,
		ngayTao							    Date									null,
		ngaySua								Date									null,
		trangThai							int										null,

)
---create bảng chương trình giảm giá chi tiết hóa đơn
create table ChuongTrinhGiamGiaChiTietHoaDon
(
           Id_ChuongTrinhGiamGiaChiTietHoaDon			UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
           Id_ChuongTrinhGiamGiaHoaDon			        UNIQUEIDENTIFIER							,
		   Id_HoaDon									UNIQUEIDENTIFIER							,
		   soTienDaGiam									DECIMAL(20, 0) DEFAULT 0				null,
		   ghiChu										nvarchar(max)							null,
		   ngayTao										Date									null,
		   ngaySua										Date									null,
		   trangThai									int										null,
        
		Constraint FK_ChuongTrinhGiamGiaChiTietHoaDon_ChuongTrinhGiamGiaHoaDon  Foreign key(Id_ChuongTrinhGiamGiaHoaDon) References ChuongTrinhGiamGiaHoaDon,
		Constraint FK_ChuongTrinhGiamGiaChiTietHoaDon_HoaDon					Foreign key(Id_HoaDon) References HoaDon,
      
)
---create bảng Hóa Đơn Chi Tiết
create table HoaDonChiTiet
(
   
     Id_HoaDonChiTiet			UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	 Id_HoaDon					UNIQUEIDENTIFIER							,
	 Id_GiayTheThaoChiTiet		UNIQUEIDENTIFIER							,
	 soLuong					int										 null,
	 donGia						DECIMAL(20, 0) DEFAULT 0			     null,	
     ghiChu						nvarchar(max)							 null,
	 ngayTao				    Date									 null,
	 ngaySua					Date									 null,
	 trangThai					int										 null,

	 Constraint FK_HoaDonChiTiet_HoaDon							Foreign key(Id_HoaDon)								References HoaDon,
	 Constraint FK_HoaDonChiTiet_GiayTheThaoChiTiet				Foreign key(Id_GiayTheThaoChiTiet)				References GiayTheThaoChiTiet,

)
---create bảng phiếu giao hàng
create table PhieuGiaoHang
(
			Id_PhieuGiaoHang					UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
			Id_KhachHang						UNIQUEIDENTIFIER							,
			Id_Users							UNIQUEIDENTIFIER							,
			Id_HoaDon							UNIQUEIDENTIFIER							,
			tenNguoiNhan						nvarchar(50)							null,
			diaChiNhanHang						nvarchar(max)							null,
			soDienThoaiNhanHang					nvarchar(20)							null,
			phiShip								DECIMAL(20, 0) DEFAULT 0			    null,
			ghiChu								nvarchar(max)							null,
			ngayTao								Date									null,
			ngaySua								Date									null,
			trangThai							int										null,

			Constraint FK_PhieuGiaoHang_HoaDon			Foreign key(Id_HoaDon)			References HoaDon,
			Constraint FK_PhieuGiaoHang_KhachHang		Foreign key(Id_KhachHang)		References KhachHang,
			Constraint FK_PhieuGiaoHang_Users			Foreign key(Id_Users)			References Users,

)
---create bảng Giỏ Hàng
create table GioHang
(
			
      Id_GioHang				UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	  Id_Users					UNIQUEIDENTIFIER DEFAULT NEWID()			,
	  Id_KhachHang				UNIQUEIDENTIFIER DEFAULT NEWID()			,
	  ghiChu					nvarchar(max)							 null,
	  ngayTao					Date									 null,
	  ngaySua					Date									 null,
	  trangThai					int										 null,

	 Constraint FK_GioHang_Users						Foreign key(Id_Users)						References Users,
	 Constraint FK_GioHang_KhachHang					Foreign key(Id_KhachHang)					References KhachHang,

)
---create bảng Giỏ hàng chi tiết
create table GioHangChiTiet
(
	
	 Id_GiayTheThaoChiTiet			UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	 Id_GioHang						UNIQUEIDENTIFIER DEFAULT NEWID(),
	 Id_ChiTietSanPham				UNIQUEIDENTIFIER DEFAULT NEWID(),
	 soLuong					    int										null,
	 donGia							DECIMAL(20, 0) DEFAULT 0			    null,
	 donGiaKhiGiam					DECIMAL(20, 0) DEFAULT 0			    null,	
	 ngayTao						Date									null,
	 ngaySua						Date									null,
	 trangThai					    int									    null,

	 Constraint FK_GioHangChiTiet_GioHang								Foreign key(Id_GioHang)								References GioHang,
	 Constraint FK_GioHangChiTiet_GiayTheThaoChiTiet					Foreign key(Id_GiayTheThaoChiTiet)					References GiayTheThaoChiTiet,

)

---insert dữ liệu

---insert dữ liệu bảng chương trình giảm giá hóa đơn
insert into ChuongTrinhGiamGiaHoaDon(tenChuongTrinh, phanTramGiam , soLuongSanPham , soTienHoaDon , ngayBatDau , ngayKetThuc , ghiChu ,ngayTao, trangThai) values(N'Chương trình khai xuân giảm giá hóa đơn',5,4,300000,'2023-09-27','2023-10-01',N'Chương trình giảm giá có hạn','2023-09-27',1)
insert into ChuongTrinhGiamGiaHoaDon(tenChuongTrinh, phanTramGiam , soLuongSanPham , soTienHoaDon , ngayBatDau , ngayKetThuc , ghiChu ,ngayTao, trangThai) values(N'Chương trình vui tết trung thu',10,6,200000,'2023-09-27','2023-10-01',N'Chương trình giảm giá có hạn','2023-09-27',1)
insert into ChuongTrinhGiamGiaHoaDon(tenChuongTrinh, phanTramGiam , soLuongSanPham , soTienHoaDon , ngayBatDau , ngayKetThuc , ghiChu ,ngayTao, trangThai) values(N'Chương trình vui tết thiếu nhi 1/6',20,4,300000,'2023-09-27','2023-10-01',N'Chương trình giảm giá có hạn','2023-09-27',1)
insert into ChuongTrinhGiamGiaHoaDon(tenChuongTrinh, phanTramGiam , soLuongSanPham , soTienHoaDon , ngayBatDau , ngayKetThuc , ghiChu ,ngayTao, trangThai) values(N'Chương trình khai chương quán',5,4,300000,'2023-09-27','2023-10-01',N'Chương trình giảm giá có hạn','2023-09-27',1)



select * from ChuongTrinhGiamGiaHoaDon
---delete from ChuongTrinhGiamGiaHoaDon where Id_ChuongTrinhGiamGiaHoaDon = 'D3A1A8DC-D6C4-44B5-BB2A-AB696A5424D9'
