USE DUAN1_NHOM6
GO
select * from KhachHang
where MaKH = 'KH01'
insert into KhachHang values(NewID(), 'KH01', 'ThuyMeo', 'VIP', 'Hanoi', N'Nữ', 'thuymeo@123',
'0962335335', '01/01/2003', '10/10/2022', '02/02/2022', '02/02/2022', 1)
insert into KhachHang values(NewID(), 'KH02', 'HienVuong', 'M1', N'Đông Anh Hanoi', N'Nữ', 'hienv@gmail.com',
'0912355355', '09/06/2003', '01/01/2023', '02/02/2022', '02/02/2022', 1)
insert into KhachHang values(NewID(), 'KH03', 'QuangAnh', 'M3', 'NinhBinh', N'Nam', 'anhq@fpt.edu',
'0233567419', '10/01/2003', '02/10/2023', '02/02/2022', '02/02/2022', 0)

select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai 
from KhachHang
where GioiTinh = N'Nam'
where TrangThai = 0
where MaKH = 'KH01'

update KhachHang set LoaiKH = 'VIP', TenKH = 'ThuyMeo', DiaChi = 'Hanoi', GioiTinh = N'Nữ', 
Email = 'thuymeo@123', SDT = '0982335335', NgaySinh = '01/01/2003', NgayThamGia = '10/10/2022', NgayTao = '02/02/2022', NgaySua = '02/02/2022', TrangThai = 0
where MaKH = 'KH01'

delete from KhachHang
where MaKH = 'KH01'

