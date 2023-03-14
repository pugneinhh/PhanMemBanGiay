/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.TTHoaDon;

/**
 *
 * @author Phương Linh
 */
public class TTHoaDonDao extends BaseDao<TTHoaDon, String>{

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO [dbo].[TT_HOADON] ([TENTT]) VALUES (?)";
            case "UPDATE":
                return "UPDATE [dbo].[TT_HOADON] SET [TENTT] = ? WHERE MATT = ?";
            case "DELETE":
                return "DELETE FROM [dbo].[TT_HOADON] WHERE MATT = ?";
            case "SELECTBYID":
                return "SELECT * FROM TT_HOADON WHERE MATT = ?";
            case "SELECTALL":
                return "SELECT * FROM TT_HOADON";

        }
        return "";
    }

    @Override
    public Object[] getParams(String action, TTHoaDon obj) {
         switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaTT(),
                    obj.getTenTT()};
            case "UPDATE":
                return new Object[]{
                    obj.getTenTT(),
                    obj.getMaTT()
                };
        }
        return null;
    }

    @Override
    public TTHoaDon createEntity(ResultSet rs) throws SQLException {
        TTHoaDon TTHD = new TTHoaDon();
        TTHD.setMaTT(rs.getInt("MATT"));
        TTHD.setTenTT(rs.getString("TENTT"));
       return TTHD;
    }
    
}
