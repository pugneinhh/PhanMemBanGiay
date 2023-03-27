﻿CREATE DATABASE DUAN1_NHOM6
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
Create TABLE NHANVIEN(
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
CREATE TABLE GiaoCa(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaGC VARCHAR(20) UNIQUE,
MaNVGiao UNIQUEIDENTIFIER,
MaNVNhan UNIQUEIDENTIFIER,
GioNhanCa VARCHAR(20) DEFAULT NULL,
GioGiaoCa VARCHAR(20) DEFAULT NULL,
TienCoso DECIMAL(20,0) DEFAULT 0,
TienPhatSinh DECIMAL(20,0) DEFAULT 0,
DoanhThuCa DECIMAL(20,0) DEFAULT 0,
TongTien DECIMAL(20,0) DEFAULT 0,
GhiChuGiao NVARCHAR(200) DEFAULT NULL,
GhiChuNhan NVARCHAR(200) DEFAULT NULL,
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
size UNIQUEIDENTIFIER,
MauSac UNIQUEIDENTIFIER,
ChatLieu UNIQUEIDENTIFIER,
DoCao UNIQUEIDENTIFIER,
MoTa varchar(100),
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

Drop TABLE GiaoHang(
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
NgayTao DATE DEFAULT NULL,
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
maKM VARCHAR(20) UNIQUE NULL,
tenKM NVARCHAR(20) NULL,
giaTri DECIMAL(20,0) DEFAULT 0,
giamToiDa DECIMAL(20,0) DEFAULT 0,
ngayBatDau DATE DEFAULT NULL,
ngayKetThuc DATE DEFAULT NULL,
hinhThucApDung NVARCHAR(50),
apDungGiamGia NVARCHAR(50),
loaiGiamGia NVARCHAR(50) NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0		
)
delete  from KhuyenMai where makm ='M22234'
select *From khuyenmai
9E9C8B02-1440-45A6-8425-042DB956EA11
select *from DanhMuc
select *from ChatLieu
select *from SanPham
select *from ChiTietSanPham
select * from khuyenmai
select id from ChiTietSanPham where DanhMuc ='9E9C8B02-1440-45A6-8425-042DB956EA11'
update ChiTietSanPham set idkm = 'F86B6461-D3F8-4454-BFB8-127B07DF675B' where id in  (select id from ChiTietSanPham where DanhMuc ='9E9C8B02-1440-45A6-8425-042DB956EA11')
select KhuyenMai.maKM, KhuyenMai.tenKM,KhuyenMai.hinhThucApDung, KhuyenMai.loaiGiamGia,ChiTietSanPham.IDSP,KhuyenMai.ngayBatDau,KhuyenMai.ngayKetThuc,KhuyenMai.TrangThai,ChiTietSanPham.MoTa, giaTri,giamToiDa,apDungGiamGia,KhuyenMai.NgayTao,KhuyenMai.NgaySua
from KhuyenMai join ChiTietSanPham  on KhuyenMai.Id= ChiTietSanPham.IDKM

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

ALTER TABLE ChiTietSanPham ALTER COLUMN MoTa nvarchar(100)

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

select * from NHANVIEN
--NhanVien--
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV01',N'Đinh Thị Quỳnh Nga','01/01/2003',N'Nữ',N'Ninh Bình','0377648225','ngad@gmail.com',
'dinhnga123','892D3F33-96C9-4ABD-9C27-4C83DBE71F8D','nga123.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV02',N'Nguyễn Thị Phương Anh','2003-09-02',N'Nữ',N'Hà Nội','0348055118','anhntpph28990@fpt.edu.vn',
'123a','848ED75B-BA9F-4EDC-94D5-A4C74FF54F5B','Phanh.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV03',N'Trinh Thị Thủy','05/11/2003',N'Nữ',N'Thanh Hóa','0823556147','thuytt@gmail.com',
'thuytA23','1B50EED8-0CEB-4612-AE2F-BA52D24208F9','thuyA2.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV04',N'Nguyễn Xuân Quang','10/10/2003',N'Nam',N'Hà Nội','0788233551','quangnt@gmail.com',
'quangM1','1B50EED8-0CEB-4612-AE2F-BA52D24208F9','quangH.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV05',N'Phạm Quang Anh','04/06/2003',N'Nam',N'Ninh Bình','0355242668','anhqpt@gmail.com',
'anh04','1B50EED8-0CEB-4612-AE2F-BA52D24208F9','anhP.png',getDate(),1)
=======
select *from chucVu
--NhanVien--
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV01',N'Đinh Thị Quỳnh Nga','01/01/2003',N'Nữ',N'Ninh Bình','0377648225','ngad@gmail.com',
'dinhnga123','9B8CD18C-9E92-4391-A0BD-8CE97B6CEB5C','nga123.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV02',N'Nguyễn Thị Phương Anh','02/09/2003',N'Nữ',N'Hà Nội','0982355355','anhdp@gmail.com',
'panh211','9B8CD18C-9E92-4391-A0BD-8CE97B6CEB5C','anh1a.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV03',N'Trinh Thị Thủy','05/11/2003',N'Nữ',N'Thanh Hóa','0823556147','thuytt@gmail.com',
'thuytA23','F62CDC0C-94FB-481E-9A83-B83BC135DD3C','thuyA2.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV04',N'Nguyễn Xuân Quang','10/10/2003',N'Nam',N'Hà Nội','0788233551','quangnt@gmail.com',
'quangM1','F62CDC0C-94FB-481E-9A83-B83BC135DD3C','quangH.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV05',N'Phạm Quang Anh','04/06/2003',N'Nam',N'Ninh Bình','0355242668','anhqpt@gmail.com',
'anh04','F62CDC0C-94FB-481E-9A83-B83BC135DD3C','anhP.png',getDate(),1)
>>>>>>> 8b4f47f7153274ff5f9279135fa4487be8327354

INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV06',N'Phạm Quang Anh','04/06/2003',N'Nam',N'Ninh Bình','0355242668','anhqpt@gmail.com',
'quanh','4a9c5cec-a0f7-4d8a-bd6b-db8c6fae92e2','anhP.png',getDate(),0)

--KhachHang--
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH01', 'Cam', N'Thành viên', 'Hanoi', N'Nam', 'camh123@gmail.com',
'0962335335','01/01/2003', '10/10/2022', getDate(), 1)
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH02', 'Dong', 'M1', N'Đông Anh Hanoi', N'Nam', 'dongq@fpt.edu',
'0912355355', '09/06/2003', '01/01/2023', getDate(), 1)
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH03', 'NgocAnh', 'M3', 'NinhBinh', N'Nữ', 'anhn@fpt.edu',
'0233567419', '10/01/2003', '02/10/2023', getDate(), 0)
INSERT INTO KhachHang Values(NewID(), 'KH01', 'Cam', N'Thành viên', 'Hanoi', N'Nam', 'camh123@gmail.com',
'0962335335','01/01/2003', '10/10/2022', getDate(), 1)
SELECT * FROM KhachHang
UPDATE KHACHHANG SET TichDiem=500000 WHERE MAKH='KH01'
UPDATE KhachHang SET TenKH='Cam',LoaiKH='Thành viên' where makh='KH01'
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



select*from nhanvien

--GiaoCa--
INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)

VALUES(NEWID(),'MAGC01','2885C9C8-7829-4E2B-98D5-CE43999A2132','9CA0F7FB-AAE9-4AD7-9579-D41D19707883',

VALUES(NEWID(),'MAGC01','32A7EEED-CD63-450A-B8B9-24207A878DB3','72C76BB2-60D7-4D38-A12C-18C92B22C77C',

'12h45','12h45',1000000,50000,70000,2000000,N'Đinh Thị Quỳnh Nga Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)

VALUES(NEWID(),'MAGC02','E3341015-82D6-4603-9E5F-15B7B51BBFC6','E429A1F4-F84A-4AE7-A7C6-1A222929BECE',

VALUES(NEWID(),'MAGC02','FFFFADB7-D66C-49AC-B7DC-83E1CE5C46C5','C2CE73F7-78B8-4B81-904D-DA38E5ABF2D5',

'12h45','12h45',1110000,52000,70000,3500000,N'Trịnh Thị Thủy Giao Ca',N'Nguyễn Xuân Quang Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)

VALUES(NEWID(),'MAGC03','E429A1F4-F84A-4AE7-A7C6-1A222929BECE','9CA0F7FB-AAE9-4AD7-9579-D41D19707883',

VALUES(NEWID(),'MAGC03','57D86B60-5508-40CF-88CE-DF1757F85931','32A7EEED-CD63-450A-B8B9-24207A878DB3',

'12h45','12h45',1010000,43000,61000,5240000,N'Nguyễn Xuân Quang Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)
select * from NHANVIEN
--KhuyenMai--
INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM01',N'Mừng 8/3',20000,30000,'08/03/2023','11/03/2023',N'Giảm theo tiền',N'Hóa Đơn Đầu Tiên',N'Bạn Mới',getDate(),0)

INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM02',N'Mừng Sinh Nhật',10,30000,'06/12/2023','06/16/2023',N'Giảm theo %',N'Hóa Đơn Trên 300000',N'Chương trình',getDate(),0)



--HoaDon--
select *from NHANVIEN
select *from KhachHang
select *from giaohang
select *from ChiTietHoaDon
select *from KhuyenMai
INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
select *from Chitiethoadon
=======

INSERT INTO KhuyenMai VALUES (NEWID(),'KM03',N'Mừng Sinh Nhật',10,30000,'01/12/2023','11/01/2023',N'Giảm theo %',N'Hóa Đơn Trên 3020000',N'Chương trình',GetDate(),null,1)



--HoaDon--
select *from NHANVIEN
select *from KhachHang
select *from KhuyenMai
INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)

<<<<<<< HEAD
=======
>>>>>>> origin/master
>>>>>>> 1f95eb57ed2f075285b8faf652ab924e20354735
>>>>>>> origin/master
VALUES(NewID(),'HD01','E3341015-82D6-4603-9E5F-15B7B51BBFC6','89D43549-A371-4536-A561-80C805AF6D26',
'02/02/2022',150000,'38941BF7-B3F5-407C-BDBA-1A357F486512',null,getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD02','3A75CE97-7659-4BE4-9D3D-A7AB670E84E3','560DCF60-5E56-497E-983A-52B3F9510E4D',
'02/02/2022',300000,'38941BF7-B3F5-407C-BDBA-1A357F486512','voucher',getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD03','2885C9C8-7829-4E2B-98D5-CE43999A2132','29C2CCF2-0398-434D-9689-AE734FA36B1E',
'02/02/2022',100000,'C978F3E1-48AA-4317-9D9D-B739D2CB130D',null,getDate(),0)
select *from nhanvien
select *from khuyenmai
select *from khachhang

VALUES(NewID(),'HD01','72C76BB2-60D7-4D38-A12C-18C92B22C77C','8AD96BF4-D04B-468F-8994-21EFC56283B4',
'02/02/2022',150000,'5C7683D6-6BD5-4224-AC9C-3706511F81C6',null,getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD02','32A7EEED-CD63-450A-B8B9-24207A878DB3','8A74875D-1A16-4D09-B119-83E76A4A87D3',
'02/02/2022',300000,'C18BB59D-7564-412C-931A-7CF608FC61C7','voucher',getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD03','F78577DF-2F2C-4764-BC7F-1FC135B410D5','A4F1FD4A-13AC-47F6-9B00-027DEE10F113',
'02/02/2022',10000000,null,null,getDate(),0)
SELECT * FROM NHANVIEN

--HoaDonChiTiet--
INSERT INTO ChiTietHoaDon(Id,IDHD,IDCTSP,SoLuong,DonGia,NgayBan,NgayTao,TrangThai)
VALUES(NewID(),'150A646B-0615-4B0B-BEFB-0DCA5466B4D5','F056F4EB-9096-43A0-92D0-67C61713E641',1,'160000',getdate(),getdate(),0)

--SanPhamChiTiet--
INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,

NgayTao,TrangThai)VALUES(NewID(),'1B2BAEA2-7EAC-433D-9BAD-5031B914A4E6','38941BF7-B3F5-407C-BDBA-1A357F486512',
79000,237000,'SP01.png',100,'F270F10F-4983-4B65-8C79-72D2A2F97CCC','BF9BD25C-7FC8-4181-8FC7-8407DC2789FD',
'89362E6F-75E3-46E8-9AAE-5BB1053DACAA','A85ACB1B-9876-4103-BB6C-63F27990F801','8C586CA7-595C-4349-A32A-DAADC9D7F7E0',

NgayTao,TrangThai)VALUES(NewID(),'33B2639C-74E9-441C-9CBB-2ABF287F0EF1','5C7683D6-6BD5-4224-AC9C-3706511F81C6',
89000,267000,'SP03.png',100,'9E9C8B02-1440-45A6-8425-042DB956EA11','8AE44247-B48F-4517-922C-6B029FFFC4BC',
'91EA9048-5690-4A9C-8F9F-05EEF2323B35','907B759C-EDC2-4346-9092-20D701D11950','151CFAE0-F5AF-4B36-B469-0BE3F586D774',
N'Hàng đẹp',getDate(),0)
select *from DanhMuc
select *from SanPham
select * from chitiethoadon

NgayTao,TrangThai)VALUES(NewID(),'bb8fa42c-bfc3-48c7-8215-c9e5c798583e','a8d3889b-b995-44d2-a831-5dad5f90d272',
79000,237000,'SP01.png',100,'a36b9478-8938-4da9-bc2f-37f1a2ebae3e','521b933f-92c3-45cc-adfa-c5cdc643e34a',
'62dbd908-abb0-425f-a16c-cf4ae6c1ec4b','82425e0e-ecce-45e1-a502-dd9ac2e88430','df1976f9-5b91-4a41-8f38-4b357db04e0a',

N'Chất lượng cao',getDate(),0)
select * from sanpham
select * from khuyenmai
select *from DanhMuc
select * from Size
select * from MauSac
select * from ChatLieu
select * from DoCao

INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),
'a2589eb4-4e8c-47dc-b950-cfe5314f3431',
'a8d3889b-b995-44d2-a831-5dad5f90d272',
89000,267000,
'SP02.png',
100,
'123a3758-5533-4002-bebd-c8a36231a730',
'75e2183f-fe21-4b6a-ae1e-a06ec0a8d88e',
'677cda65-a33d-4edd-beac-f1ef149c066d',
'4d09303b-aeb7-42cd-be0a-2a4fd703092d',
'bfa2e592-0cb3-41fd-bedb-34b49e1989d8',
N'Hàng đẹp'
,getDate(),
0)
select * from GiaoCa
SELECT * FROM SanPham
SELECT * FROM DanhMuc
SELECT * FROM Size
SELECT * FROM MauSac
SELECT * FROM ChatLieu
SELECT * FROM DOCAO
INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,NgayTao,TrangThai)
VALUES(NewID(),
'FE33BC47-7F7F-4BE6-9D7C-05BD015B6623',
null,
111000,
222000,
'SP01.png',
111,
'471840E0-C49A-4975-92EA-862218BFD95B',
'6EEA4437-0941-42BB-9086-373E640EFF2F',
'4BFE8527-1F19-4CBD-B068-4F8214CDD590',
'52802728-9070-4639-A88E-72E8BD28C7AC',
'DED76EC4-528B-480A-80F3-C731E668A21E','TT',getDate(),1)

	SELECT * From chitietsanpham
	UPDATE CHITIETSANPHAM SET QR=2003123 WHERE ID='FE811B08-807C-4AFF-B037-5B1A8C591D50'
CREATE TRIGGER TICHDIEM ON HOADON AFTER INSERT AS
BEGIN
    UPDATE KHACHHANG
	SET DIEMEXP+=(
	SELECT THANHTIEN * 0.01 
	FROM INSERTED
	), TICHDIEM+=(SELECT THANHTIEN *0.01 FROM INSERTED)
	from KhachHang join inserted 
	on KHACHHANG.ID= inserted.IDKH
END
select * from KhachHang
select * from HoaDon
CREATE TRIGGER THANGHANG ON KHACHHANG AFTER UPDATE AS
BEGIN
	IF (select TichDiem from inserted )>50000
BEGIN
	UPDATE KHACHHANG
	SET LOAIKH=N'Vàng'
	from khachhang join inserted on KHACHHANG.ID=INSERTED.ID
END
	IF (select TichDiem from inserted )>100000
BEGIN
	UPDATE KHACHHANG
	SET LOAIKH=N'Kim cương'
	from khachhang join inserted on KHACHHANG.ID=INSERTED.ID
END
END	

CREATE TRIGGER HANGMACDINH ON KHACHHANG AFTER INSERT AS
BEGIN
	UPDATE KHACHHANG
	SET LOAIKH=N'Thành viên'
<<<<<<< HEAD
	WHERE KHACHHANG.ID=INSERTED.ID
END
select * from khachhang
select * from hoadon
select * from Chitietsanpham
select * from sanpham
SELECT idctsp,soluong,dongia,N'Thành tiền'=SoLuong*dongia  FROM chitiethoadon
select  SanPham.ma , sanpham.ten , HoaDonChiTiet.SoLuong,HoaDonChiTiet.DonGia ,ChiTietSP.idSP ,N'Thành tiền'=HoaDonChiTiet.SoLuong*HoaDonChiTiet.DonGia   from HoaDonChiTiet  join ChiTietSP  
                on HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id  join SanPham on sanpham.id=ChiTietSP.IdSp join hoadon on hoadon.id = HoaDonChiTiet.IdHoaDon where HoaDon.Ma =?

SELECT SanPham.MaSP,SanPham.Ten,ChiTietHoaDon.DonGia,ChiTietSanPham.IDSP,N'Thành tiền'=ChiTietHoaDon.SoLuong*ChiTietHoaDon.DonGia  FROM ChiTietHoaDon JOIN ChiTietSanPham ON ChiTietHoaDon.IDCTSP=ChiTietSanPham.Id 
JOIN HoaDon ON ChiTietHoaDon.IDHD=HoaDon.ID JOIN SanPham ON ChiTietSanPham.IDSP=SanPham.Id WHERE HoaDon.MaHD=?
=======
	from khachhang join inserted on KHACHHANG.ID=inserted.ID
END
>>>>>>> 1f95eb57ed2f075285b8faf652ab924e20354735
