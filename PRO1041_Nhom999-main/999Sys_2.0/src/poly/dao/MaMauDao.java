/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.MauSac;

/**
 *
 * @author Admin
 */
public class MaMauDao extends BaseDao<MauSac, String>{

    @Override
    public String getQuery(String action) {
        switch(action){
            case "INSERT":
                return "INSERT INTO MAUSAC (TENMAU) VALUES (?)";
            case "UPDATE":
                return "UPDATE MAUSAC SET TENMAU =?, TRANGTHAI =? WHERE MAMAU = ?";
            case "DELETE":
                return "UPDATE MAUSAC SET  TRANGTHAI = 0 WHERE MAMAU = ?";
            case "SELECTBYID":
                return "SELECT * FROM MAUSAC WHERE (MAMAU = ?)";
            case "SELECTALL":
                return "SELECT * FROM MAUSAC";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, MauSac obj) {
        switch(action){
            case "INSERT":
                return new Object[]{
                    obj.getTenMau(),
                };
            case "UPDATE":
                return new Object[]{
                    obj.getTenMau(),
                    obj.isTrangThai(),
                    obj.getMaMau()
                };
        }
        return null;
    }

    @Override
    public MauSac createEntity(ResultSet rs) throws SQLException {
        MauSac mS = new MauSac();
        mS.setMaMau(rs.getInt("MAMAU"));
        mS.setTenMau(rs.getString("TENMAU"));
        mS.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return mS;
    }
    
}
