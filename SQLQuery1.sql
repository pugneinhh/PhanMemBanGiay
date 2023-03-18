USE DUAN1_NHOM6
GO

select * from MauSac
select * from ChatLieu
select * from ChiTietSanPham
select b.MaSP , b.Ten ,a.GiaBan,a.SoLuong , a.Size , a.MauSac ,a.SoLuong,a.DoCao, a.ChatLieu ,a.DanhMuc, a.TrangThai,a.MoTa from ChiTietSanPham as a 
join SanPham as b on a.IDSP = b.Id 

SELECT Id,MaSP,Ten,NgayTao,NgaySua,TrangThai FROM SanPham
where MaSP = 'SP11'

select Id,IDSP,IDKM,GiaNhap,GiaBan,QR,SoLuong,HinhAnh, DanhMuc,Size,MauSac,ChatLieu,DoCao,NgayTao,NgaySua,TrangThai 
from ChiTietSanPham

SELECT * FROM DanhMuc
where Id ='6328DCA6-E605-444D-91F1-05F6E90FA9CB'

SELECT ChiTietSanPham.QR , SanPham.Ten ,ChiTietSanPham.GiaNhap,ChiTietSanPham.GiaBan,ChiTietSanPham.SoLuong ,Size ,DoCao, ChatLieu,MauSac , DanhMuc,
ChiTietSanPham.MoTa,ChiTietSanPham.HinhAnh,ChiTietSanPham.TrangThai from ChiTietSanPham ,SanPham 
where ChiTietSanPham.id = SanPham.Id

