/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.KhachHang;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import ViewModels.KhachHangViewModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author HoiVN
 */
public class KhachHangResponsitory {

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> khModel = new ArrayList<>();
        String sql = "select * from KhachHang";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                khModel.add(new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),rs.getDate(9),rs.getDate(10),rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return khModel;
    }
    
    public KhachHang getKhachHangByMa(String ma) {
        String sql = "select * from KhachHang\n"
                + "where MaKH = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                return new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),rs.getDate(9),rs.getDate(10),rs.getDate(11), rs.getDate(12), rs.getInt(13));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHang insertKhachHang(KhachHang kh) {
        String sql = "insert into KhachHang values(NewID(), ?, ?, ?, ?, ?, ?,\n"
                + "?, ?, ?, ?, ?, ?)";
        JDBCHelper.executeUpdate(sql,
                kh.getMaKH(),
                kh.getLoaiKH(),
                kh.getTenKH(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getNgayThamGia(),
                kh.getTrangThai()
        );
        return kh;
    }

    public KhachHang updateKhachHang(KhachHang kh) {
        String sql = "update KhachHang set LoaiKH = ?, TenKH = ?, DiaChi = ?, GioiTinh = ?, \n"
                + "Email = ?, SDT = ?, NgaySinh = ?, NgayThamGia = ?, NgayTao = ?, NgaySua = ?, TrangThai = ?\n"
                + "where MaKH = ?";
        JDBCHelper.executeUpdate(sql,
                kh.getLoaiKH(),
                kh.getTenKH(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getNgayThamGia(),
                kh.getTrangThai(),
                kh.getMaKH()
        );
        return kh;
    }
 public ArrayList<KhachHangViewModel> getTheoSDT(String SDT){
        String sql="select MAKH , LOAIKH,tenkh,diachi,gioitinh,email,sdt,ngaysinh,ngaythamgia,trangthai from khachhang where sdt LIKE ?";
        ArrayList<KhachHangViewModel> list = new ArrayList<>();
        try {
                     Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, "%" + SDT + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                KhachHangViewModel kh = new KhachHangViewModel();
          kh.setMaKH(rs.getString(1));
           kh.setLoaiKH(rs.getString(2));
              kh.setTenKH(rs.getString(3));
              kh.setDiaChi(rs.getString(4));
              kh.setGioiTinh(rs.getString(5));
                kh.setEmail(rs.getString(6));
                kh.setSdt(rs.getString(7));
                kh.setNgaySinh(rs.getDate(8));
                kh.setNgayThamGia(rs.getDate(9));
                kh.setTrangThai(rs.getInt(10));
                list.add(kh);
            }
               c.close();
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer deleteCV(String ma) {
        String sql = "delete from KhachHang\n"
                + "where MaKH = ?";
        int row = JDBCHelper.executeUpdate(sql, ma);
        return row;
    }
}
