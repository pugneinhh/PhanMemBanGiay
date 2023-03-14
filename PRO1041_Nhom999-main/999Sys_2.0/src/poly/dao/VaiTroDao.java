/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.VaiTro;

/**
 *
 * @author Admin
 */
public class VaiTroDao extends BaseDao<VaiTro, String> {

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO VAITRO (TENVAITRO) VALUES (?)";
            case "UPDATE":
                return "UPDATE VAITRO SET TENVAITRO =?, TRANGTHAI =? WHERE MAVAITRO = ?";
            case "DELETE":
                return "DELETE FROM VAITRO WHERE MAVAITRO = ?";
            case "SELECTByID":
                return "SELECT * FROM VAITRO WHERE MAVAITRO =?";
            case "SELECTALL":
                return "SELECT * FROM VAITRO";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, VaiTro obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getTenVaiTro()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getTenVaiTro(),
                    obj.isTrangThai(),
                    obj.getMaVaiTro()
                };
        }
        return null;
    }

    @Override
    public VaiTro createEntity(ResultSet rs) throws SQLException {
        VaiTro vT = new VaiTro();
        vT.setMaVaiTro(rs.getInt("MAVAITRO"));
        vT.setTenVaiTro(rs.getString("TENVAITRO"));
        vT.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return vT;
    }
}
