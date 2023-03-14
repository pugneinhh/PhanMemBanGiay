/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poly.entity.DanhMuc;
import poly.helper.XJDBC;

/**
 *
 * @author 98tae
 */
public class DanhMucDao extends BaseDao<DanhMuc, String>{

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO DANHMUC (TENDANHMUC,NGAYTHEM) VALUES (?,?)";
            case "UPDATE":
                return " UPDATE DANHMUC SET TENDANHMUC =?, TRANGTHAI =? ,NGAYTHEM = ? WHERE MADM = ?";
            case "DELETE":
                return "UPDATE DANHMUC SET TRANGTHAI = 0 WHERE MADM = ?";
            case "SELECTBYID":
                return "SELECT TENDANHMUC,TRANGTHAI FROM DANHMUC WHERE MADM = ?";
            case "SELECTALL":
                return "SELECT * FROM DANHMUC";
        }
        return "";
    }
   

    @Override
    public Object[] getParams(String action, DanhMuc obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getTenDanhMuc(),
                    obj.getNgayThem()
                };
            case "UPDATE":
                return new Object[]{
                   obj.getTenDanhMuc(),
                   obj.isTrangThai(),
                   obj.getNgayThem(),
                   obj.getMaDM()
                };
        }
        return null;
    }

    @Override
    public DanhMuc createEntity(ResultSet rs) throws SQLException {
      DanhMuc dm = new DanhMuc();
      dm.setMaDM(rs.getInt("MADM"));
      dm.setTenDanhMuc(rs.getString("TENDANHMUC"));
      dm.setNgayThem(rs.getString("NGAYTHEM"));
      dm.setTrangThai(rs.getBoolean("TRANGTHAI"));
      return dm;
    }
    
   
}