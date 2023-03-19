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

