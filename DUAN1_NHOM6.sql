CREATE DATABASE DUAN1_NHOM6
USE DUAN1_NHOM6
GO

CREATE TABLE ChucVu(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
Create TABLE NhanVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MANV VARCHAR(20) UNIQUE,
HoTen NVARCHAR(50) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
GioiTinh NVARCHAR(25) DEFAULT NULL,
DiaChi NVARCHAR(200) DEFAULT NULL,
Sdt VARCHAR(10) DEFAULT NULL,
Email VARCHAR(100) DEFAULT NULL,
MatKhau VARCHAR(20),
IDCV UNIQUEIDENTIFIER,
Hinh VARCHAR(50),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE MauSac(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE ChatLieu(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE DoCao(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE DanhMuc(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE Size(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)


CREATE TABLE KhachHang(
ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaKH VARCHAR(20) UNIQUE,
LoaiKH NVARCHAR(50) DEFAULT NULL,
TenKH NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(200) DEFAULT NULL,
GioiTinh NVARCHAR(50) DEFAULT NULL,
Email VARCHAR(50) DEFAULT NULL,
SDT VARCHAR(50) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
NgayThamGia DATE DEFAULT NULL,
TichDiem INT DEFAULT 0,
DiemEXP INT DEFAULT 0,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE ChiTietSanPham(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDSP UNIQUEIDENTIFIER,
IDKM UNIQUEIDENTIFIER,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
QR int IDENTITY(20012003,1),
HinhAnh VARCHAR(50),
SoLuong int,
DanhMuc UNIQUEIDENTIFIER,
Size UNIQUEIDENTIFIER,
MauSac UNIQUEIDENTIFIER,
ChatLieu UNIQUEIDENTIFIER,
DoCao UNIQUEIDENTIFIER,
MoTa NVARCHAR(100),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE SanPham(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaSP VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)

CREATE TABLE GiaoHang(
IDGH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDHD UNIQUEIDENTIFIER,
IDKH UNIQUEIDENTIFIER,
SDT VARCHAR(50),
DiaChi NVARCHAR(50) DEFAULT NULL,
TienHang DECIMAL(20,0) DEFAULT 0,
TienShip DECIMAL(20,0) DEFAULT 0,
TongTien DECIMAL(20,0) DEFAULT 0,
NgayGiao DATE DEFAULT NULL,
NgayNhan DATE DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
Delete from GiaoHang
INSERT INTO GiaoHang Values(NewID(),'3FFDE3B6-DD66-44D6-BFE2-28FDD6626E86' , '8AD96BF4-D04B-468F-8994-21EFC56283B4', '0987808709', 'Hanoi',1000, 100,100,
'01/01/2003', '10/10/2022', getDate(), 1)

CREATE TABLE HoaDon(
ID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaHD VARCHAR(20) UNIQUE,
IDNV UNIQUEIDENTIFIER,
IDKH UNIQUEIDENTIFIER,
NgayMua DATE DEFAULT NULL,
ThanhTien DECIMAL(20,0) DEFAULT 0,
IDKM UNIQUEIDENTIFIER,
GhiChu NVARCHAR(100) DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)

CREATE TABLE ChiTietHoaDon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDHD UNIQUEIDENTIFIER,
IDCTSP UNIQUEIDENTIFIER,
SoLuong INT DEFAULT NULL,
DonGia DECIMAL(20,0) DEFAULT 0,
NgayBan Date  DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE KhuyenMai(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaKM VARCHAR(20) UNIQUE NULL,
TenKM NVARCHAR(20) NULL,
GiaTri DECIMAL(20,0) DEFAULT 0,
GiamToiDa DECIMAL(20,0) DEFAULT 0,
NgayBatDau DATE DEFAULT NULL,
NgayKetThuc DATE DEFAULT NULL,
HinhThucApDung NVARCHAR(50),
ApDungGiamGia NVARCHAR(50),
LoaiGiamGia NVARCHAR(50) NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0		
)

CREATE TABLE GioHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayThanhToan DATE DEFAULT NULL,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)

CREATE TABLE GioHangChiTiet(
IdGH UNIQUEIDENTIFIER,
IdCTSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
DonGiaKhiGiam DECIMAL(20,0) DEFAULT 0,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
PRIMARY KEY (IdGH,IdCTSP)
)

ALTER TABLE NHANVIEN ADD FOREIGN KEY (IDCV) REFERENCES CHUCVU(ID)
ALTER TABLE GiaoCa ADD FOREIGN KEY (MaNVGiao) REFERENCES NHANVIEN(ID)
ALTER TABLE GiaoCa ADD FOREIGN KEY (MaNVNhan) REFERENCES NHANVIEN(ID)
ALTER TABLE HOADON ADD FOREIGN KEY (IDNV) REFERENCES NHANVIEN(ID)
ALTER TABLE HOADON ADD FOREIGN KEY (IDKM) REFERENCES KHUYENMAI(ID)
ALTER TABLE CHITIETHOADON ADD FOREIGN KEY (IDHD) REFERENCES HOADON(ID)
ALTER TABLE HOADON ADD FOREIGN KEY (IDKH) REFERENCES KHACHHANG(ID)
ALTER TABLE GIAOHANG ADD FOREIGN KEY (IDHD) REFERENCES HOADON(ID)
ALTER TABLE CHITIETHOADON ADD FOREIGN KEY (IDCTSP) REFERENCES ChiTietSanPham(Id)
ALTER TABLE CHITIETSANPHAM ADD FOREIGN KEY (IDSP) REFERENCES SANPHAM(ID)
ALTER TABLE CHITIETSANPHAM ADD FOREIGN KEY (DANHMUC) REFERENCES DANHMUC(ID)
ALTER TABLE CHITIETSANPHAM ADD FOREIGN KEY (SIZE) REFERENCES SIZE(ID)
ALTER TABLE CHITIETSANPHAM ADD FOREIGN KEY (MAUSAC) REFERENCES MAUSAC(ID)
ALTER TABLE CHITIETSANPHAM ADD FOREIGN KEY (CHATLIEU) REFERENCES CHATLIEU(ID)
ALTER TABLE CHITIETSANPHAM ADD FOREIGN KEY (DOCAO) REFERENCES DOCAO(ID)
ALTER TABLE CHITIETSANPHAM ADD FOREIGN KEY (IDKM) REFERENCES KHUYENMAI(ID)
ALTER TABLE GIOHANGCHITIET ADD FOREIGN KEY (IdCTSP) REFERENCES CHITIETSANPHAM(ID)
ALTER TABLE GIOHANGCHITIET ADD FOREIGN KEY (IdGH) REFERENCES GIOHANG(Id)


/* INSERT DULIEU */

--MauSac--
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS01',N'Be',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS02',N'Đen',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS03',N'Trắng',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS04',N'Đỏ',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS05',N'Xanh Blue',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS06',N'Vàng',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS07',N'Hồng',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS08',N'Xám',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS09',N'Nâu',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS10',N'Kem',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS11',N'Tím',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS13',N'Xanh',getDate(),0)
INSERT INTO MauSac(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'MS14',N'Cam',getDate(),0)

--ChatLieu--
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL01',N'Da Bóng',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL02',N'Da Dạ',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL03',N'Da Lì Trơn',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL04',N'Da Nhựa Tổng Hợp',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL05',N'Da PU',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL06',N'Da Tổng Hợp',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL07',N'Da Trơn',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL08',N'Da Vải Tổng Hợp',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL09',N'Vải Nhựa Tổng Hợp',getDate(),0)
INSERT INTO ChatLieu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CL09',N'Vải Tổng Hợp',getDate(),0)

--DoCao--
INSERT INTO DoCao(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DC03',N'3cm',getDate(),0)
INSERT INTO DoCao(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DC05',N'5cm',getDate(),0)
INSERT INTO DoCao(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DC07',N'7cm',getDate(),0)
INSERT INTO DoCao(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DC09',N'9cm',getDate(),0)
INSERT INTO DoCao(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DC11',N'11cm',getDate(),0)
INSERT INTO DoCao(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DC13',N'13cm',getDate(),0)

--Size--
INSERT INTO Size(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'S34',N'Size 34',getDate(),0)
INSERT INTO Size(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'S35',N'Size 35',getDate(),0)
INSERT INTO Size(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'S36',N'Size 36',getDate(),0)
INSERT INTO Size(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'S37',N'Size 37',getDate(),0)
INSERT INTO Size(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'S38',N'Size 38',getDate(),0)
INSERT INTO Size(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'S39',N'Size 39',getDate(),0)
INSERT INTO Size(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'S40',N'Size 40',getDate(),0)

--DanhMuc--
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM01',N'Đế nhọn',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM02',N'Đế vuông',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM03',N'Đế xuồng',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM04',N'Đế thấp',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM05',N'CONE HEELS',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM06',N'SLING BACK HEELS',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM07',N'MULE HEELS',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM08',N'Boot',getDate(),0)
INSERT INTO DanhMuc(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'DM09',N'Sandal',getDate(),0)

--ChucVu--
INSERT INTO ChucVu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CV01',N'Quản lý',getDate(),0)
INSERT INTO ChucVu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CV02',N'Nhân Viên',getDate(),0)
select * from ChucVu
--NhanVien--
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV01',N'Đinh Thị Quỳnh Nga','01/01/2003',N'Nữ',N'Ninh Bình','0377648225','ngad@gmail.com',
'dinhnga123','2fc0d544-f2b0-40ea-aafd-6395d3d18642','Nga.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV1',N'Nguyễn Thị Phương Anh','2003-09-02',N'Nữ',N'Hà Nội','0348055118','anhntpph28990@fpt.edu.vn',
'123','92A9CCDC-4501-4B02-80C7-D6B5874C28ED','Phanh.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV03',N'Trinh Thị Thủy','05/11/2003',N'Nữ',N'Thanh Hóa','0823556147','thuytt@gmail.com',
'thuytA23','eb9eee84-02e7-4b71-9c11-fcae6469fdb9','Thuy.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV04',N'NguyễnTiến Vinh','10/10/2003',N'Nam',N'Hà Nội','0788233551','quangnt@gmail.com',
'quangM1','eb9eee84-02e7-4b71-9c11-fcae6469fdb9','Vinh.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV05',N'Phạm Quang Anh','04/06/2003',N'Nam',N'Ninh Bình','0355242668','anhqpt@gmail.com',
'anh04','eb9eee84-02e7-4b71-9c11-fcae6469fdb9','Quanh.png',getDate(),1)

--KhachHang--
INSERT INTO KhachHang(ID,MaKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH01',  'Cam', 'Hanoi', N'Nam', 'camh123@gmail.com',
'0962335335','01/01/2003', '10/10/2022', getDate(), 1)
select * from KhachHang
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH02', N'Thành viên', N'Đông', N'Đông Anh Hanoi', N'Nam', 'dongq@fpt.edu',
'0912355355', '09/06/2003', '01/01/2023', getDate(), 1)
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH03', N'Thành viên', 'NgocAnh', N'Hải Phòng', N'Nữ', 'anhn@fpt.edu',
'0233567419', '10/01/2003', '02/10/2023', getDate(), 0)

--SanPham--
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP01',N'Giày Cao Gót Hở Eo',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP02',N'Giày Cao Gót  Mũi Nhọn',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP03',N'Giày Cao Gót Mũi Nhọn Gót Trụ',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP04',N'Giày Boot Nữ Trong Suốt',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP05',N'Giày Cao Gót Phối Lưới',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP06',N'Giày Cao Gót BIGTREE',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP07',N'Giày Cao Gót Mũi Tim Khoét Eo',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP08',N'Giày Cao Gót Phối Nơ',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP09',N'Giày Cao Gót Sandal Quai Ngang',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP10',N'Giày Cao Gót Đan Dây',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP11',N'Giày Cao Gót Phối Đá',getDate(),0)
INSERT INTO SanPham (Id,MaSP,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP12',N'Giày Sandal Đế Xuồng Dày',getDate(),0)

--GiaoCa--
INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC01','820b1c68-d2f3-4c2d-991d-923c070b224f','016133f8-7860-4cb8-bc8b-a12767d09e8f',
'12h45','12h45',1000000,50000,70000,2000000,N'Đinh Thị Quỳnh Nga Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC02','48f5e882-3987-43f8-b8c3-433a5ddd0a7e','4f6e13d1-805d-42aa-b390-9fa5d97a2549',
'14h00','14h00',1110000,52000,70000,3500000,N'Trịnh Thị Thủy Giao Ca',N'Nguyễn Tiến Vinh Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC03','12ce26a3-5f6f-48f2-8d46-157d13d015c5','016133f8-7860-4cb8-bc8b-a12767d09e8f',
'20h00','20h00',1010000,43000,61000,5240000,N'Phạm Quang Anh Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)

--KhuyenMai--
INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM01',N'Mừng 8/3',20000,30000,'08/03/2023','11/03/2023',N'Giảm theo tiền',N'Hóa Đơn Đầu Tiên',N'Bạn Mới',getDate(),0)

INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM02',N'Mừng Sinh Nhật',10,30000,'06/12/2023','06/16/2023',N'Giảm theo %',N'Hóa Đơn Trên 300000',N'Chương trình',getDate(),0)

<<<<<<< HEAD
--HoaDon--
=======


--HoaDon--
select *from NHANVIEN
select *from KhachHang
select *from giaohang
select *from ChiTietHoaDon
select *from KhuyenMai
>>>>>>> origin/master
INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD01','48f5e882-3987-43f8-b8c3-433a5ddd0a7e','d91876a6-7527-4487-ba4d-a2cc9d443c0a',
'02/02/2022',150000,'d79be8c1-c4e5-4c32-8fde-89311866505e',null,getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD02','4f6e13d1-805d-42aa-b390-9fa5d97a2549','c6ecd884-4e4b-4e1b-9794-81025f8af7a2',
'02/02/2022',300000,'93c78624-9ce0-403f-a1c7-e9f20e2bbfdb','voucher',getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD03','12ce26a3-5f6f-48f2-8d46-157d13d015c5','a54bf9ce-9623-49f3-8ed3-4045650a1ac8',
'02/02/2022',100000,'93c78624-9ce0-403f-a1c7-e9f20e2bbfdb',null,getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD04','48f5e882-3987-43f8-b8c3-433a5ddd0a7e','c6ecd884-4e4b-4e1b-9794-81025f8af7a2',
'02/02/2022',100000,'93c78624-9ce0-403f-a1c7-e9f20e2bbfdb',null,getDate(),1)

--HoaDonChiTiet--
INSERT INTO ChiTietHoaDon(Id,IDHD,IDCTSP,SoLuong,DonGia,NgayBan,NgayTao,TrangThai)
VALUES(NewID(), '3a66dbd4-c230-4c71-8e19-0a2d67992b42','69ba7b9f-6a48-46e4-86fa-eb298b41da9c',5,20000,'03/03/2023',getDate(),0)

INSERT INTO ChiTietHoaDon(Id,IDHD,IDCTSP,SoLuong,DonGia,NgayBan,NgayTao,TrangThai)
VALUES(NewID(), '4B44DEF7-68EE-4C59-9106-06A437D03902','69BA7B9F-6A48-46E4-86FA-EB298B41DA9C',5,20000,'03/03/2023',getDate(),0)


--SanPhamChiTiet--
INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),'60aca814-58c4-4d2b-baba-8ca2c84e6acb','a7c1efbf-4b83-4fa8-94a4-d179eeac50c4',
79000,237000,'SP01.png',100,'58ff1a77-4d6a-4dab-a3bb-adeeee05703a','09826c17-df84-4b93-b27e-c067016d05e9',
'c21f497a-9d23-445f-95f3-7b74aa96b2cb','ed7ca98f-432f-4b82-8cd0-d5ddc848fbe0','c3c7227e-b838-464e-988d-dfae5d42bd32',N'Chất lượng cao',getDate(),0)

--
INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,
DanhMuc,Size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),
'68332ad8-8382-4fe9-a0c8-f1d3b30df284',
'93c78624-9ce0-403f-a1c7-e9f20e2bbfdb',
89000,267000,
'SP02.png',
100,
'470ea498-a65d-488f-b69c-ff6aedaa3744',
'38445ec9-3616-44c8-b149-81b538ffcc5b',
'12a883b0-dbfe-4dec-9d69-6a4847e83b15',
'4cfd3437-40a1-445a-b587-87bc894ba27c',
'63e3b123-ff99-4dc9-9cd7-2fd821662750',
N'Hàng đẹp'
,getDate(),
0)
--

INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),'325dbd1a-22c6-4ad4-9765-c0276e617ddb','a015cd07-3563-4a8d-9dba-b99b3f57c111',
89000,267000,'SP03.png',100,'02d9f48a-c287-4187-9731-41bc608b7c04','3d8bdcdc-2443-4349-a6f7-c0b2181a399f',
'121c993e-f583-4f93-945f-0fbe776ee53d','e804baac-6cba-46de-a17b-8da661e3905a','bc9adc8e-075a-432b-84bc-147a9a4f3f65',
N'Hàng đẹp',getDate(),0)

--Giao Hang--
INSERT INTO GiaoHang(IDGH,IdHD,IdKH,SDT,DiaChi,TienHang,TienShip,TongTien,NgayGiao,NgayNhan,NgayTao,TrangThai)
VALUES(NewID(),'3D82AAAB-BA91-4FBA-981E-44034CC5380D','c6ecd884-4e4b-4e1b-9794-81025f8af7a2','0325668668',N'HaNoi',150000,15000,150000,
'02/03/2023','10/20/2023',getDate(),2)

INSERT INTO GiaoHang(IDGH,IdHD,IdKH,SDT,DiaChi,TienHang,TienShip,TongTien,NgayGiao,NgayNhan,NgayTao,TrangThai)
VALUES(NewID(),'3a66dbd4-c230-4c71-8e19-0a2d67992b42' ,'d91876a6-7527-4487-ba4d-a2cc9d443c0a', '0987808709', 'Hanoi',100000, 10000,110000,
'01/01/2023', '10/10/2022', getDate(), 3)

INSERT INTO GiaoHang(IDGH,IdHD,IdKH,SDT,DiaChi,TienHang,TienShip,TongTien,NgayGiao,NgayNhan,NgayTao,TrangThai)
VALUES(NewID(),'a54bf9ce-9623-49f3-8ed3-4045650a1ac8' ,'d91876a6-7527-4487-ba4d-a2cc9d443c0a', '0987808709', 'Hanoi',100000, 10000,110000,
'01/01/2003', '10/10/2022', getDate(), 0)

INSERT INTO GiaoHang(IDGH,IdHD,IdKH,SDT,DiaChi,TienHang,TienShip,TongTien,NgayGiao,NgayNhan,NgayTao,TrangThai)
VALUES(NewID(),'CDC6F6A6-6356-46D3-A62B-A30E006FC54C','d91876a6-7527-4487-ba4d-a2cc9d443c0a', '0987808709', 'Hanoi',100000, 10000,110000,
'01/01/2003', '10/10/2022', getDate(), 0)