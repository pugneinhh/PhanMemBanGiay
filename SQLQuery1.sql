USE DUAN1_QLBanGiay
GO
USE DUAN1_NHOM6
GO
select * from MauSac
select * from ChatLieu
select * from ChiTietSanPham
select b.Ma , b.Ten ,a.GiaBan,a.SoLuong , a.Size , a.MauSac ,a.SoLuong,a.DoCao, a.ChatLieu ,a.DanhMuc, a.TrangThai,a.MoTa from ChiTietSanPham as a 
join SanPham as b on a.IDSP = b.Id 

SELECT Id,Ma,Ten,NgayTao,NgaySua,TrangThai FROM SanPham
where Ma = 'SP11'

select Id,IDSP,IDKM,GiaNhap,GiaBan,QR,HinhAnh,SoLuong, DanhMuc,Size,MauSac,ChatLieu,DoCao,MoTa,NgayTao,NgaySua,TrangThai
from ChiTietSanPham

SELECT * FROM DanhMuc
where Id ='689A4DE2-5886-4E77-8DB2-B794036ED024'

select a.IDSP, a.IDKM, a.GiaNhap, a.GiaBan, a.QR, a.HinhAnh, a.SoLuong, a.DanhMuc,
a.size, a.MauSac, a.ChatLieu, a.DoCao, a.MoTa, a.TrangThai from ChiTietSanPham as a
where QR = '20012005'

select * from ChiTietSanPham

select a.IDSP, a.IDKM, a.GiaNhap, a.GiaBan, a.QR, a.HinhAnh, a.SoLuong, a.DanhMuc,
a.size, a.MauSac, a.ChatLieu, a.DoCao, a.MoTa, a.TrangThai, DanhMuc.Ten from ChiTietSanPham as a
join DanhMuc on DanhMuc.Id = a.DanhMuc
where Ten like N'Đế vuông'

select * from SanPham
where Id= ?

UPDATE ChiTietSanPham SET idsp= '60ACA814-58C4-4D2B-BABA-8CA2C84E6ACB',gianhap=111000,giaban= 220000,hinhanh= 'SP05' ,
Soluong = 120 , DanhMuc= '58FF1A77-4D6A-4DAB-A3BB-ADEEEE05703A',Size = 
'09826C17-DF84-4B93-B27E-C067016D05E9',mausac='121c993e-f583-4f93-945f-0fbe776ee53d',
ChatLieu='4ae2e322-9e35-455e-a4d2-d647f86525c6',DoCao = 'cea96a63-7e55-4ea5-8871-045393732bd2',
Mota='AABB',NGAYSUA=GETDATE() WHERE QR= 20012004

select * from NHANVIEN

select *from NHANVIEN

select*from KhuyenMai

select KhuyenMai.maKM, KhuyenMai.tenKM,KhuyenMai.hinhThucApDung, KhuyenMai.loaiGiamGia,ChiTietSanPham.IDSP,KhuyenMai.ngayBatDau,KhuyenMai.ngayKetThuc,KhuyenMai.TrangThai,ChiTietSanPham.MoTa, giaTri,giamToiDa,apDungGiamGia,KhuyenMai.NgayTao,KhuyenMai.NgaySua
from KhuyenMai join ChiTietSanPham  on KhuyenMai.Id= ChiTietSanPham.IDKM

select * from chucvu

select * from sanpham
select * from khuyenmai
select *from DanhMuc
select * from Size
select * from MauSac
select * from ChatLieu
select * from DoCao
select * from ChiTietSanPham
select * from KhachHang
delete from ChiTietSanPham where QR = '20012021'

select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai
from KhachHang

SELECT * From chitietsanpham
UPDATE CHITIETSANPHAM SET QR=2003123 WHERE ID='FE811B08-807C-4AFF-B037-5B1A8C591D50'

CREATE TRIGGER TICHDIEM ON HOADON AFTER INSERT AS
BEGIN
    UPDATE KHACHHANG
	SET DIEM=DIEM+(
	SELECT THANHTIEN
	FROM INSERTED
	)
	WHERE KHACHHANG.ID= INSERTED.IDKH
END

CREATE TRIGGER THANGHANG ON KHACHHANG AFTER UPDATE AS
BEGIN
	IF INSERTED.DIEM>100
BEGIN
	UPDATE KHACHHANG 
	SET LOAIKH =N'VÀNG'
	WHERE KHACHHANG.ID=INSERTED.ID
END
	IF INSERTED.DIEM>500
BEGIN
	UPDATE KHACHHANG
	SET LOAIKH=N'Kim cương'
	WHERE KHACHHANG.ID=INSERTED.ID
END
END	

CREATE TRIGGER HANGMACDINH ON KHACHHANG AFTER INSERT AS
BEGIN
	UPDATE KHACHHANG
	SET LOAIKH=N'Thành viên'
	WHERE KHACHHANG.ID=INSERTED.ID
END