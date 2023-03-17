/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.KhachHang;
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
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                khModel.add(new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return khModel;
    }
    
    public KhachHang getKhachHangByMa(String ma) {
        String sql = "select * from KhachHang\n"
                + "where MaKH = 'KH01'";
        ResultSet rs = JDBCHelper.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                return new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
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

    public Integer deleteCV(String ma) {
        String sql = "delete from KhachHang\n"
                + "where MaKH = ?";
        int row = JDBCHelper.executeUpdate(sql, ma);
        return row;
    }
}
