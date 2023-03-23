USE DUAN1_NHOM6
GO

select * from MauSac
select * from ChatLieu
select * from ChiTietSanPham
select b.MaSP , b.Ten ,a.GiaBan,a.SoLuong , a.Size , a.MauSac ,a.SoLuong,a.DoCao, a.ChatLieu ,a.DanhMuc, a.TrangThai,a.MoTa from ChiTietSanPham as a 
join SanPham as b on a.IDSP = b.Id 

SELECT Id,MaSP,Ten,NgayTao,NgaySua,TrangThai FROM SanPham
where MaSP = 'SP11'

select Id,IDSP,IDKM,GiaNhap,GiaBan,QR,HinhAnh,SoLuong, DanhMuc,Size,MauSac,ChatLieu,DoCao,MoTa,NgayTao,NgaySua,TrangThai
from ChiTietSanPham

SELECT * FROM DanhMuc
where Id ='6328DCA6-E605-444D-91F1-05F6E90FA9CB'

select a.IDSP, a.IDKM, a.GiaNhap, a.GiaBan, a.QR, a.HinhAnh, a.SoLuong, a.DanhMuc,
a.size, a.MauSac, a.ChatLieu, a.DoCao, a.MoTa, a.TrangThai from ChiTietSanPham as a
where QR = '20012007'

select * from ChiTietSanPham

select a.IDSP, a.IDKM, a.GiaNhap, a.GiaBan, a.QR, a.HinhAnh, a.SoLuong, a.DanhMuc,
a.size, a.MauSac, a.ChatLieu, a.DoCao, a.MoTa, a.TrangThai, DanhMuc.Ten from ChiTietSanPham as a
join DanhMuc on DanhMuc.Id = a.DanhMuc
where Ten like N'Đế vuông'

select * from SanPham
where Id= ?

UPDATE ChiTietSanPham SET idsp= 'BB8FA42C-BFC3-48C7-8215-C9E5C798583E',gianhap=111000,giaban= 220000,hinhanh= 'SP05' ,
Soluong = 120 , DanhMuc= 'A36B9478-8938-4DA9-BC2F-37F1A2EBAE3E',Size = 
'521B933F-92C3-45CC-ADFA-C5CDC643E34A',mausac='62DBD908-ABB0-425F-A16C-CF4AE6C1EC4B',
ChatLieu='82425E0E-ECCE-45E1-A502-DD9AC2E88430',DoCao = 'DF1976F9-5B91-4A41-8F38-4B357DB04E0A',
Mota='AABB',NGAYSUA=GETDATE() WHERE QR= 20012006

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

delete from ChatLieu where Ma = 'CL00'

delete from ChiTietSanPham where QR = '20012020'