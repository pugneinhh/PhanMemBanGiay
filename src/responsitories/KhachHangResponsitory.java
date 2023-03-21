/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.KhachHang;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import ViewModels.KhachHangModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author HoiVN
 */
public class KhachHangResponsitory {

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> khVModel = new ArrayList<>();
        String sql = "select * \n"
                + "from KhachHang";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                khVModel.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getDate(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khVModel;
    }

    public KhachHangModel getKhachHangByMa(String ma) {
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where MaKH = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                return new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<KhachHangModel> getKHByGT(String gt) {
        ArrayList<KhachHangModel> list = new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where GioiTinh = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, gt);

        try {
            while (rs.next()) {
                KhachHangModel khVM = new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<KhachHangModel> getKHByTrangThai(int TrangThai) {
        ArrayList<KhachHangModel> list = new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where TrangThai = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                KhachHangModel khVM = new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public KhachHang insertKhachHang(KhachHang kh) {
        String sql = "insert into KhachHang values(NewID(), ?, ?, ?, ?, ?, ?,\n"
                + "?, ?, getDate(), getDate(), null, ?)";
        Integer row = JDBCHelper.executeUpdate(sql,
                kh.getMaKH(),
                kh.getLoaiKH(),
                kh.getTenKH(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getTrangThai()
        );
        return kh;
    }

    public KhachHang updateKhachHang(KhachHang kh) {
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
                kh.getNgayTao(),
                kh.getNgaySua(),
                kh.getTrangThai(),
                kh.getMaKH()
        );
        return kh;
    }
 public String getIDkhachhang(String maHD) { // lay id hoadon
        String sql = "select id from khachhang where ma=? ";
        
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, maHD);
            
            ResultSet rs = ps.executeQuery();
            KhachHang hd = new KhachHang();
            while (rs.next()) {
                hd = new KhachHang();
                hd.setIdKH(rs.getString(1));
                
            }
            c.close();
            ps.close();
            rs.close();
            return hd.getIdKH();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Integer deleteCV(String ma) {
        String sql = "delete from KhachHang\n"
                + "where MaKH = ?";
        Integer row = JDBCHelper.executeUpdate(sql, ma);
        return row;
    }
}
