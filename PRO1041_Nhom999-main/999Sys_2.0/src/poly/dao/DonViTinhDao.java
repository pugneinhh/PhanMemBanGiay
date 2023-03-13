/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.DonViTinh;

/**
 *
 * @author Admin
 */
public class DonViTinhDao extends BaseDao<DonViTinh, String>{

    @Override
    public String getQuery(String action) {
         switch (action) {
            case "INSERT":
                return "INSERT INTO DONVITINH (TENDVT) VALUES (?)";
            case "UPDATE":
                return "UPDATE DONVITINH SET TENDVT =?, TRANGTHAI =? WHERE MADVT = ?";
            case "DELETE":
                return "DELETE FROM DONVITINH WHERE MADVT=?";
            case "SELECTBYID":
                return "SELECT TENDVT, TRANGTHAI FROM DONVITINH WHERE (MADVT = ?)";
            case "SELECTALL":
                return "SELECT * FROM DONVITINH";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, DonViTinh obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getTenDVT()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getTenDVT(),
                    obj.isTrangThai(),
                    obj.getMaDVT()
                };
        }
        return null;
    }

    @Override
    public DonViTinh createEntity(ResultSet rs) throws SQLException {
        DonViTinh dVT = new DonViTinh();
        dVT.setMaDVT(rs.getInt("MADVT"));
        dVT.setTenDVT(rs.getString("TENDVT"));
        dVT.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return dVT;
    }
    
}
