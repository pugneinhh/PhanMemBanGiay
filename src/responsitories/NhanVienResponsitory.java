/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import Utilities.JDBCHelper;
import Aplication.QuenMK;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phanh
 */
public class NhanVienResponsitory {

    ChucVuResponsitory cvr = new ChucVuResponsitory();

    public ArrayList<NhanVien> getAllNV() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                ChucVu cv = cvr.getCVByID(rs.getString(10));
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), cv, rs.getString(11), rs.getDate(12), rs.getDate(13), rs.getInt(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public ArrayList<NhanVien> getNVLam() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN WHERE TRANGTHAI=1";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                ChucVu cv = cvr.getCVByID(rs.getString(10));
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), cv, rs.getString(11), rs.getDate(12), rs.getDate(13), rs.getInt(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public ArrayList<NhanVien> getNVNghi() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN WHERE TRANGTHAI=0";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                ChucVu cv = cvr.getCVByID(rs.getString(10));
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), cv, rs.getString(11), rs.getDate(12), rs.getDate(13), rs.getInt(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public NhanVien getNVByID(String id) {
        String sql = "SELECT ID,HOTEN FROM NhanVien WHERE ID=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new NhanVien(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public NhanVien insertNV(NhanVien nv) {
        String sql = "INSERT INTO NHANVIEN VALUES (NEWID(),?,?,?,?,?,?,?,?,?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getMatKhau(), nv.getIdCV().getIdCV(), nv.getHinh(), nv.getTrangThai());
        return nv;
    }

    public NhanVien updateNV(NhanVien nv) {
        String sql = "UPDATE NHANVIEN SET HOTen=?,NGAYSINH=?,GIOITINH=?,DIACHI=?,SDT=?,EMAIL=?,MATKHAU=?,IDCV=?,HINH=?, TRANGTHAI=?,NGAYSUA=GETDATE() WHERE MANV=?";
        JDBCHelper.executeUpdate(sql, nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getMatKhau(), nv.getIdCV().getIdCV(), nv.getHinh(), nv.getTrangThai(),nv.getMaNV());
        return nv;
    }

    public Integer deleteNV(String id) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }
    public ArrayList<NhanVien> getNVLamByCV(String tenCV){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT NHANVIEN.* FROM NHANVIEN JOIN CHUCVU ON NHANVIEN.IDCV=CHUCVU.ID WHERE NHANVIEN.TRANGTHAI=1 AND Ten LIKE ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,"%"+tenCV+"%");

        try {
            while (rs.next()) {
                ChucVu cv = cvr.getCVByID(rs.getString(10));
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), cv, rs.getString(11), rs.getDate(12), rs.getDate(13), rs.getInt(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public ArrayList<NhanVien> getNVNghiByCV(String tenCV){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT NHANVIEN.* FROM NHANVIEN JOIN CHUCVU ON NHANVIEN.IDCV=CHUCVU.ID WHERE NHANVIEN.TRANGTHAI=0 AND Ten LIKE ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,"%"+tenCV+"%");

        try {
            while (rs.next()) {
                ChucVu cv = cvr.getCVByID(rs.getString(10));
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), cv, rs.getString(11), rs.getDate(12), rs.getDate(13), rs.getInt(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public ArrayList<NhanVien> getNVLamBySdt(String sdt){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT NHANVIEN.* FROM NHANVIEN JOIN CHUCVU ON NHANVIEN.IDCV=CHUCVU.ID WHERE NHANVIEN.TRANGTHAI=1 AND SDT LIKE ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,"%"+sdt+"%");

        try {
            while (rs.next()) {
                ChucVu cv = cvr.getCVByID(rs.getString(10));
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), cv, rs.getString(11), rs.getDate(12), rs.getDate(13), rs.getInt(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public ArrayList<NhanVien> getNVNghiBySdt(String sdt){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT NHANVIEN.* FROM NHANVIEN JOIN CHUCVU ON NHANVIEN.IDCV=CHUCVU.ID WHERE NHANVIEN.TRANGTHAI=0 AND SDT LIKE ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,"%"+sdt+"%");

        try {
            while (rs.next()) {
                ChucVu cv = cvr.getCVByID(rs.getString(10));
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), cv, rs.getString(11), rs.getDate(12), rs.getDate(13), rs.getInt(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
      
}
