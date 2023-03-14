/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.NhanVien;

/**
 *
 * @author Admin
 */
public class NhanVienDao extends BaseDao<NhanVien, String> {

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO TAIKHOAN (MANV, MAVAITRO, HOTEN, MATKHAU, NGAYSINH, GIOITINH, EMAIL, SDT, DIACHI, ANHDAIDIEN, NGAYTAO, TRANGTHAI)\n"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE TAIKHOAN SET MAVAITRO =?, HOTEN =?, MATKHAU =?, NGAYSINH =?, GIOITINH =?, EMAIL =?, SDT =?, DIACHI =?, ANHDAIDIEN =?, NGAYTAO =?, TRANGTHAI =? WHERE MANV = ?";
            case "DELETE":
                return "UPDATE TAIKHOAN SET TRANGTHAI = 0 WHERE MANV = ? ";
            case "SELECTBYID":
                return "SELECT * FROM TAIKHOAN where MANV = ?";
            case "SELECTALL":
                return "SELECT * FROM TAIKHOAN";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, NhanVien obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaNV(),
                    obj.getVaiTro(),
                    obj.getHoTen(),
                    obj.getPassWord(),
                    obj.getNgSinh(),
                    obj.isGioiTinh(),
                    obj.getEmail(),
                    obj.getSDT(),
                    obj.getDiaChi(),
                    obj.getHinhAnh(),
                    obj.getNgayTao(),
                    obj.isTrangThai()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getVaiTro(),
                    obj.getHoTen(),
                    obj.getPassWord(),
                    obj.getNgSinh(),
                    obj.isGioiTinh(),
                    obj.getEmail(),
                    obj.getSDT(),
                    obj.getDiaChi(),
                    obj.getHinhAnh(),
                    obj.getNgayTao(),
                    obj.isTrangThai(),
                    obj.getMaNV()
                };
        }
        return null;
    }

    @Override
    public NhanVien createEntity(ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNV(rs.getString("MANV"));
        nv.setPassWord(rs.getString("MATKHAU"));
        nv.setVaiTro(rs.getInt("MAVAITRO"));
        nv.setHoTen(rs.getString("HOTEN"));
        nv.setNgSinh(rs.getString("NGAYSINH"));
        nv.setGioiTinh(rs.getBoolean("GIOITINH"));
        nv.setEmail(rs.getString("EMAIL"));
        nv.setSDT(rs.getString("SDT"));
        nv.setDiaChi(rs.getString("DIACHI"));
        nv.setHinhAnh(rs.getString("ANHDAIDIEN"));
        nv.setNgayTao(rs.getString("NGAYTAO"));
        nv.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return nv;
    }

}
