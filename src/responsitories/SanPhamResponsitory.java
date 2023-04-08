/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.SanPham;
import java.util.ArrayList;
import Utilities.JDBCHelper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class SanPhamResponsitory {

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public SanPham getSPByID(String id) {
        String sql = "select * from SanPham\n"
                + "where Id= ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham insertSP(SanPham sp) {

        String sql = "INSERT INTO SanPham VALUES(NEWID(),?,?,?,GetDate(),?)";
        JDBCHelper.executeUpdate(sql,
                sp.getMaSP(), sp.getTenSP(), sp.getNgayTao(), sp.getNgaySua(), sp.getTrangThai());
        return sp;
    }

    public SanPham updateSP(SanPham sp) {

        String sql = "UPDATE ChatLieu SET MASP=?,TEN=?,NGAYSUA=GETDATE(), trangthai = ?  WHERE ID=?";
        JDBCHelper.executeUpdate(sql,
                sp.getMaSP(), sp.getTenSP(), sp.getNgaySua(), sp.getTrangThai(), sp.getIdSP());
        return sp;
    }

    public Integer deleteSP(String id) {
        String sql = "DELETE FROM SanPham WHERE id=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }

   
}
