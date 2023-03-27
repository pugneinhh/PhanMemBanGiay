CREATE DATABASE DUAN1_QLBanGiay
USE DUAN1_QLBanGiay
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
MaNV VARCHAR(20) UNIQUE,
HoTen NVARCHAR(50) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
GioiTinh NVARCHAR(25) DEFAULT NULL,
DiaChi NVARCHAR(200) DEFAULT NULL,
Sdt VARCHAR(10) DEFAULT NULL,
Email VARCHAR(100) DEFAULT NULL,
MatKhau VARCHAR(20),
IdCV UNIQUEIDENTIFIER,
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
TienCoSo DECIMAL(20,0) DEFAULT 0,
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
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
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
IdSP UNIQUEIDENTIFIER,
IdKM UNIQUEIDENTIFIER,
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
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)
CREATE TABLE GiaoHang(
IdGH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdHD UNIQUEIDENTIFIER,
IdKH UNIQUEIDENTIFIER,
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
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaHD VARCHAR(20) UNIQUE,
IdNV UNIQUEIDENTIFIER,
IdKH UNIQUEIDENTIFIER,
NgayMua DATE DEFAULT NULL,
ThanhTien DECIMAL(20,0) DEFAULT 0,
IdKM UNIQUEIDENTIFIER,
GhiChu NVARCHAR(100) DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
NgaySua DATE DEFAULT NULL,
TrangThai INT DEFAULT 0
)

CREATE TABLE ChiTietHoaDon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdHD UNIQUEIDENTIFIER,
IdCTSP UNIQUEIDENTIFIER,
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

--NhanVien--
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV01',N'Đinh Thị Quỳnh Nga','01/01/2003',N'Nữ',N'Ninh Bình','0377648225','ngad@gmail.com',
'dinhnga123','58d9dd0f-a857-48f9-b9d7-ddbf872b5d66','Nga.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV02',N'Nguyễn Thị Phương Anh','2003-09-02',N'Nữ',N'Hà Nội','0348055118','anhntpph28990@fpt.edu.vn',
'123a','58d9dd0f-a857-48f9-b9d7-ddbf872b5d66','Phanh.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV03',N'Trinh Thị Thủy','05/11/2003',N'Nữ',N'Thanh Hóa','0823556147','thuytt@gmail.com',
'thuytA23','c74ae05c-2633-4eba-ad93-1d839ad33dd5','Thuy.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV04',N'NguyễnTiến Vinh','10/10/2003',N'Nam',N'Hà Nội','0788233551','quangnt@gmail.com',
'quangM1','c74ae05c-2633-4eba-ad93-1d839ad33dd5','Vinh.png',getDate(),1)
INSERT INTO NHANVIEN(Id,MANV,HoTen,NgaySinh,GioiTinh,DiaChi,Sdt,Email,MatKhau,IDCV,Hinh,NgayTao,TrangThai)
VALUES(NewID(),'NV05',N'Phạm Quang Anh','04/06/2003',N'Nam',N'Ninh Bình','0355242668','anhqpt@gmail.com',
'anh04','c74ae05c-2633-4eba-ad93-1d839ad33dd5','Quanh.png',getDate(),1)

--KhachHang--
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH01', N'Thành viên', 'Cam', 'Hanoi', N'Nam', 'camh123@gmail.com',
'0962335335','01/01/2003', '10/10/2022', getDate(), 1)
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH02', N'Thành viên', N'Đông', N'Đông Anh Hanoi', N'Nam', 'dongq@fpt.edu',
'0912355355', '09/06/2003', '01/01/2023', getDate(), 1)
INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) 
VALUES(NewID(), 'KH03', N'Thành viên', 'NgocAnh', N'Hải Phòng', N'Nữ', 'anhn@fpt.edu',
'0233567419', '10/01/2003', '02/10/2023', getDate(), 0)

--SanPham--
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP01',N'Giày Cao Gót Hở Eo',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP02',N'Giày Cao Gót  Mũi Nhọn',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP03',N'Giày Cao Gót Mũi Nhọn Gót Trụ',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP04',N'Giày Boot Nữ Trong Suốt',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP05',N'Giày Cao Gót Phối Lưới',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP06',N'Giày Cao Gót BIGTREE',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP07',N'Giày Cao Gót Mũi Tim Khoét Eo',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP08',N'Giày Cao Gót Phối Nơ',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP09',N'Giày Cao Gót Sandal Quai Ngang',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP10',N'Giày Cao Gót Đan Dây',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP11',N'Giày Cao Gót Phối Đá',getDate(),0)
INSERT INTO SanPham (Id,Ma,Ten,NgayTao,TrangThai) VALUES(NewID(),'SP12',N'Giày Sandal Đế Xuồng Dày',getDate(),0)

--GiaoCa--
INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC01','8faac46d-5c31-4df7-953b-a191f77cef0e','6a8f34f7-a78c-4cdb-8d70-610f25b0ae0d',
'12h45','12h45',1000000,50000,70000,2000000,N'Đinh Thị Quỳnh Nga Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC02','dab43510-f69e-47f4-99c3-3b00881ac0ca','62ee2512-8947-48db-8d01-df93b9487330',
'12h45','12h45',1110000,52000,70000,3500000,N'Trịnh Thị Thủy Giao Ca',N'Nguyễn Tiến Vinh Nhận Ca',getDate(),0)

INSERT INTO GiaoCa(Id,MaGC,MaNVGiao,MaNVNhan,GioNhanCa,GioGiaoCa,TienCoso,TienPhatSinh,DoanhThuCa,TongTien,
GhiChuGiao,GhiChuNhan,NgayTao,TrangThai)
VALUES(NEWID(),'MAGC03','a1708559-bc3c-487f-8ef6-304e6e3a2d06','6a8f34f7-a78c-4cdb-8d70-610f25b0ae0d',
'12h45','12h45',1010000,43000,61000,5240000,N'Phạm Quang Anh Giao Ca',N'Nguyễn Thị Phương Anh Nhận Ca',getDate(),0)

--KhuyenMai--
INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM01',N'Mừng 8/3',20000,30000,'08/03/2023','11/03/2023',N'Giảm theo tiền',N'Hóa Đơn Đầu Tiên',N'Bạn Mới',getDate(),0)

INSERT INTO KhuyenMai(Id,maKM,tenKM,giaTri,giamToiDa,ngayBatDau,ngayKetThuc,hinhThucApDung,apDungGiamGia,loaiGiamGia,NgayTao,TrangThai)
VALUES(NewID(),'KM02',N'Mừng Sinh Nhật',10,30000,'06/12/2023','06/16/2023',N'Giảm theo %',N'Hóa Đơn Trên 300000',N'Chương trình',getDate(),0)

--HoaDon--
INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD01','62ee2512-8947-48db-8d01-df93b9487330','4d7824ca-3f02-4808-b7b2-8a50afa1466d',
'02/02/2022',150000,'a015cd07-3563-4a8d-9dba-b99b3f57c111',null,getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD02','dab43510-f69e-47f4-99c3-3b00881ac0ca','1e3ae5bd-d76f-4a3f-b0f9-9cdf951fb2fa',
'02/02/2022',300000,'a7c1efbf-4b83-4fa8-94a4-d179eeac50c4','voucher',getDate(),0)

INSERT INTO HoaDon(ID,MaHD,IDNV,IDKH,NgayMua,ThanhTien,IDKM,GhiChu,NgayTao,TrangThai)
VALUES(NewID(),'HD03','a1708559-bc3c-487f-8ef6-304e6e3a2d06','fd8e98c4-1ec3-47b7-9601-f53c7554445e',
'02/02/2022',100000,'a7c1efbf-4b83-4fa8-94a4-d179eeac50c4',null,getDate(),0)

--HoaDonChiTiet--
INSERT INTO ChiTietHoaDon(Id,IDHD,IDCTSP,SoLuong,DonGia,NgayBan,NgayTao,TrangThai)
VALUES(NewID(), '5b772589-e7d2-41ad-a35a-1740eeae3597','c4c5e43d-5b82-4e1d-bb1e-495a3b93662d',5,20000,'03/03/2023',getDate(),0)


--SanPhamChiTiet--
INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),'60aca814-58c4-4d2b-baba-8ca2c84e6acb','a7c1efbf-4b83-4fa8-94a4-d179eeac50c4',
79000,237000,'SP01.png',100,'58ff1a77-4d6a-4dab-a3bb-adeeee05703a','09826c17-df84-4b93-b27e-c067016d05e9',
'c21f497a-9d23-445f-95f3-7b74aa96b2cb','ed7ca98f-432f-4b82-8cd0-d5ddc848fbe0','c3c7227e-b838-464e-988d-dfae5d42bd32',N'Chất lượng cao',getDate(),0)

INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,
DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),
'6bebe121-2d31-4e4d-b41a-b1400acbfcc7',
'a7c1efbf-4b83-4fa8-94a4-d179eeac50c4',
89000,267000,
'SP02.png',
100,
'ffcf4b8b-c23f-484f-a5c0-0924b5d6713c',
'3ea41c17-51ef-41d9-bb78-e5af49fc6c68',
'e10de987-dede-4102-ac62-2dfb535eae90',
'4ae2e322-9e35-455e-a4d2-d647f86525c6',
'cea96a63-7e55-4ea5-8871-045393732bd2',
N'Hàng đẹp'
,getDate(),
0)

INSERT INTO ChiTietSanPham(Id,IDSP,IDKM,GiaNhap,GiaBan,HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,
NgayTao,TrangThai)VALUES(NewID(),'325dbd1a-22c6-4ad4-9765-c0276e617ddb','a015cd07-3563-4a8d-9dba-b99b3f57c111',
89000,267000,'SP03.png',100,'02d9f48a-c287-4187-9731-41bc608b7c04','3d8bdcdc-2443-4349-a6f7-c0b2181a399f',
'121c993e-f583-4f93-945f-0fbe776ee53d','e804baac-6cba-46de-a17b-8da661e3905a','bc9adc8e-075a-432b-84bc-147a9a4f3f65',
N'Hàng đẹp',getDate(),0)