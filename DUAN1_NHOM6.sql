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

CREATE TABLE GiaoHang(
IDGH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDHD UNIQUEIDENTIFIER,
IDKH UNIQUEIDENTIFIER,
SDT VARCHAR(50),
DiaChi NVARCHAR(50) DEFAULT NULL,
TienHang DECIMAL(20,0) DEFAULT 0,
TienShip DECIMAL(20,0) DEFAULT 0,
TongTien DECIMAL(20,0) DEFAULT 0,
GiamGia VARCHAR(50) DEFAULT NULL,
NgayGiao DATE DEFAULT NULL,
NgayNhan DATE DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
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
INSERT INTO ChucVu(Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'CV02',N'Thu Ngân',getDate(),0)

--NhanVien--
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV01',N'Đinh Thị Quỳnh Nga','01/01/2003',N'Nữ',N'Ninh Bình','0377648225','ngad@gmail.com',
'dinhnga123','6d30ddc8-600e-41c7-8870-a5ff87d2564a','nga123.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV02',N'Nguyễn Thị Phương Anh','02/09/2003',N'Nữ',N'Hà Nội','0982355355','anhdp@gmail.com',
'panh211','6d30ddc8-600e-41c7-8870-a5ff87d2564a','anh1a.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV03',N'Trinh Thị Thủy','05/11/2003',N'Nữ',N'Thanh Hóa','0823556147','thuytt@gmail.com',
'thuytA23','4a9c5cec-a0f7-4d8a-bd6b-db8c6fae92e2','thuyA2.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV04',N'Nguyễn Xuân Quang','10/10/2003',N'Nam',N'Hà Nội','0788233551','quangnt@gmail.com',
'quangM1','4a9c5cec-a0f7-4d8a-bd6b-db8c6fae92e2','quangH.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV05',N'Phạm Quang Anh','04/06/2003',N'Nam',N'Ninh Bình','0355242668','anhqpt@gmail.com',
'anh04','4a9c5cec-a0f7-4d8a-bd6b-db8c6fae92e2','anhP.png',getDate(),1)

--KhachHang--
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH01', 'Cam', 'VIP', 'Hanoi', N'Nam', 'camh123@gmail.com',
'0962335335','01/01/2003', '10/10/2022', getDate(), 1)
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH02', 'Dong', 'M1', N'Đông Anh Hanoi', N'Nam', 'dongq@fpt.edu',
'0912355355', '09/06/2003', '01/01/2023', getDate(), 1)
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH03', 'NgocAnh', 'M3', 'NinhBinh', N'Nữ', 'anhn@fpt.edu',
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
VALUES(NEWID(),'MAGC01','d1581676-6e7f-4afc-9279-f69736e8efd3','af2d6fcd-6ccc-4b9c-91cb-7235c13831b9',
'12h45','12h45',1000000,50000,70000,2000000,N'Đinh Thị Quỳnh Nga Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC02','b344da87-d77b-4195-b7e3-2e816b156914','18087317-cb23-496b-87a4-40c74028174e',
'12h45','12h45',1110000,52000,70000,3500000,N'Trịnh Thị Thủy Giao Ca',N'Nguyễn Xuân Quang Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC03','18087317-cb23-496b-87a4-40c74028174e','af2d6fcd-6ccc-4b9c-91cb-7235c13831b9',
'12h45','12h45',1010000,43000,61000,5240000,N'Nguyễn Xuân Quang Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)

--KhuyenMai--
INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM01',N'Mừng 8/3',20000,30000,'08/03/2023','11/03/2023',N'Giảm theo tiền',N'Hóa Đơn Đầu Tiên',N'Bạn Mới',getDate(),0)

INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM02',N'Mừng Sinh Nhật',10,30000,'06/12/2023','06/16/2023',N'Giảm theo %',N'Hóa Đơn Trên 300000',N'Chương trình',getDate(),0)


--HoaDon--
INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD01','d1581676-6e7f-4afc-9279-f69736e8efd3','80681a3e-7487-4d41-ab67-fab685ac70cc',
'02/02/2022',150000,'a8d3889b-b995-44d2-a831-5dad5f90d272',null,getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD02','18087317-cb23-496b-87a4-40c74028174e','edcec5eb-4c44-49ac-91d1-9f522b7b46c4',
'02/02/2022',300000,'7d0c5e40-8a62-4752-a0b9-bfc6a200c0b9','voucher',getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD03','af2d6fcd-6ccc-4b9c-91cb-7235c13831b9','5ff5624c-538c-4b9d-b6ea-929c246f716e',
'02/02/2022',100000,'a8d3889b-b995-44d2-a831-5dad5f90d272',null,getDate(),0)

--HoaDonChiTiet--
INSERT INTO ChiTietHoaDon(Id,IDHD,IDCTSP,SoLuong,DonGia,NgayBan,NgayTao,TrangThai)
VALUES()

--SanPhamChiTiet--
INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),'bb8fa42c-bfc3-48c7-8215-c9e5c798583e','a8d3889b-b995-44d2-a831-5dad5f90d272',
79000,237000,'SP01.png',100,'a36b9478-8938-4da9-bc2f-37f1a2ebae3e','521b933f-92c3-45cc-adfa-c5cdc643e34a',
'62dbd908-abb0-425f-a16c-cf4ae6c1ec4b','82425e0e-ecce-45e1-a502-dd9ac2e88430','df1976f9-5b91-4a41-8f38-4b357db04e0a',
N'Chất lượng cao',getDate(),0)

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


