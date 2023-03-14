/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.LoaiKhachHang;

/**
 *
 * @author Admin
 */
public class LoaiKhachHangDao extends BaseDao<LoaiKhachHang, String>{

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO LOAIKHACHHANG(TENLOAIKH) VALUES (?)";
            case "UPDATE":
                return "UPDATE LOAIKHACHHANG SET TENLOAIKH =?, TRANGTHAI =? WHERE MALOAIKH = ?";
            case "DELETE":
                return "UPDATE LOAIKHACHHANG SET TRANGTHAI = 0 WHERE MALOAIKH = ?";
            case "SELECTBYID":
                return "SELECT  * FROM LOAIKHACHHANG WHERE MALOAIKH = ?";
            case "SELECTALL":
                return "SELECT  * FROM LOAIKHACHHANG";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, LoaiKhachHang obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getTenLoaiKH()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getTenLoaiKH(),
                    obj.isTrangThai(),
                    obj.getMaLoaiKH()
                };
        }
        return null;
    }

    @Override
    public LoaiKhachHang createEntity(ResultSet rs) throws SQLException {
        LoaiKhachHang lKH = new LoaiKhachHang();
        lKH.setMaLoaiKH(rs.getInt("MALOAIKH"));
        lKH.setTenLoaiKH(rs.getString("TENLOAIKH"));
        lKH.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return lKH;
    }

   
}
