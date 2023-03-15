/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import Utilities.JDBCHelper;
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
        ResultSet rs = JDBCHelper.executeQuery(sql);

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
        ResultSet rs = JDBCHelper.executeQuery(sql, id);
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
        JDBCHelper.executeUpdate(sql, nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getMatKhau(), nv.getIdCV(), nv.getHinh(), nv.getTrangThai());
        return nv;
    }

    public NhanVien updateNV(NhanVien nv) {
        String sql = "UPDATE NHANVIEN SET HOTen=?,NGAYSINH=?,GIOITINH=?,DIACHI=?,SDT=?,EMAIL=?,MATKHAU=?,IDCV=?,HINH=?, TRANGTHAI=?,NGAYSUA=GETDATE() WHERE MANV=?";
        JDBCHelper.executeUpdate(sql, nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getMatKhau(), nv.getIdCV(), nv.getHinh(), nv.getTrangThai(),nv.getMaNV());
        return nv;
    }

    public Integer deleteNV(String id) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }
}
