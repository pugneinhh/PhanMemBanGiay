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

    public ArrayList<KhachHangViewModel> getAllKhachHang() {
        ArrayList<KhachHangViewModel> khModel = new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                khModel.add(new KhachHangViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return khModel;
    }

    public Integer addKhachHang(KhachHang kh) {
        String sql = "insert into KhachHang values(NewID(), ?, ?, ?, ?, ?, ?,\n"
                + "?, ?, ?, ?, ?, ?)";
        Integer row = JDBCHelper.executeUpdate(sql,
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
        return row;
    }

    public Integer updateKhachHang(KhachHang kh) {
        String sql = "update KhachHang set LoaiKH = ?, TenKH = ?, DiaChi = ?, GioiTinh = ?, \n"
                + "Email = ?, SDT = ?, NgaySinh = ?, NgayThamGia = ?, NgayTao = ?, NgaySua = ?, TrangThai = ?\n"
                + "where MaKH = ?";
        Integer row = JDBCHelper.executeUpdate(sql,
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
        return row;
    }

    public Integer deleteKhachHang(String ma) {
        String sql = "delete from KhachHang\n"
                + "where MaKH = ?";
        Integer row = JDBCHelper.executeUpdate(sql,ma);
        return row;
    }
}
