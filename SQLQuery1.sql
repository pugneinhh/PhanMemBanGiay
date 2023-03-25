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

--select KhachHang.MaKH, KhachHang.TenKH, KhachHang.SDT, HoaDon.NgayMua, ChiTietSanPham.IDSP, ChiTietSanPham.SoLuong, ChiTietSanPham.GiaBan from ChiTietSanPham
--join KhachHang on KhachHang.MaKH =

select b.Id, b.IDHD, a.IDSP, b.DonGia, b.SoLuong, a.Size, a.MauSac, a.ChatLieu, a.DanhMuc, a.DoCao from ChiTietSanPham as a
join ChiTietHoaDon as b on b.IdCTSP = a.Id

select HoaDon.ID, ChiTietSanPham.IDSP, ChiTietHoaDon.DonGia, ChiTietHoaDon.SoLuong, ChiTietSanPham.size,
ChiTietSanPham.MauSac, ChiTietSanPham.ChatLieu, ChiTietSanPham.DanhMuc, ChiTietSanPham.DoCao from ChiTietHoaDon
join ChiTietSanPham on ChiTietSanPham.Id = ChiTietHoaDon.IDCTSP
join HoaDon on HoaDon.ID = ChiTietHoaDon.IDHD


select HoaDon.MaHD, HoaDon.IDNV, HoaDon.IDKH, KhachHang.TenKH, GiaoHang.SDT, GiaoHang.DiaChi, HoaDon.NgayMua, GiaoHang.NgayGiao, GiaoHang.GiamGia, GiaoHang.TienShip, GiaoHang.TongTien, GiaoHang.TrangThai from HoaDon
join GiaoHang on GiaoHang.IDHD = HoaDon.ID
join KhachHang on KhachHang.ID = HoaDon.IDKH

select MaKH, TenKH from KhachHang where ID = '5FF5624C-538C-4B9D-B6EA-929C246F716E'

select * from NHANVIEN where ID = '18087317-CB23-496B-87A4-40C74028174E'

select ID, IDKH from HoaDon where Id = '29735070-D7FC-408D-AD91-239E43934250'
SELECT * From chitietsanpham
UPDATE CHITIETSANPHAM SET QR=2003123 WHERE ID='FE811B08-807C-4AFF-B037-5B1A8C591D50'

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
	IF inserted.TICHDIEM>50000
BEGIN
	UPDATE KHACHHANG 
	SET LOAIKH =N'VÀNG'
	from khachhang join inserted on KHACHHANG.ID=INSERTED.ID
END
	IF inserted.TICHDIEM>100000
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
	from khachhang join inserted on KHACHHANG.ID=inserted.ID
END