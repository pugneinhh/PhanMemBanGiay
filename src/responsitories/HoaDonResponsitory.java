/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import Utilities.JDBCHelper;
import java.math.BigDecimal;
import java.sql.*;
/**
 *
 * @author HoiVN
 */
public class HoaDonResponsitory {
    
    KhachHangResponsitory khr = new KhachHangResponsitory();
    
    public HoaDon getHDByID(String id) {

        String sql = "select ID,MaHD from HoaDon where Id = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new HoaDon(rs.getString(1),rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        HoaDonResponsitory hd = new HoaDonResponsitory();
        System.out.println(hd.getHDByID("29735070-D7FC-408D-AD91-239E43934250"));
    }
}
