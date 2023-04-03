/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Phanh
 */
public class DoanhThuResponsitory {
    public ArrayList<Object> getDoanhThuNgay(){
        ArrayList<Object> list=new ArrayList<>();
        String sql="SELECT * FROM dbo.FNDTNGAY(?)";
        ResultSet rs=JDBCHelper.excuteQuery(sql, new Date());
        try {
            while(rs.next()){
                 String tongtien = rs.getString("doanhthu")==null? "0 VNĐ" : rs.getString("doanhthu");
                 list.add(tongtien);
                 list.add(rs.getInt(2));
                 list.add(rs.getInt(3));
            }
                } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public ArrayList<Object> getDoanhThuThang(){
        ArrayList<Object> list=new ArrayList<>();
        String sql="SELECT * FROM dbo.FNDTTHANG(?)";
        ResultSet rs=JDBCHelper.excuteQuery(sql, new Date());
        try {
            while(rs.next()){
                 String tongtien = rs.getString("doanhthu")==null? "0 VNĐ" : rs.getString("doanhthu");
                 list.add(tongtien);
                 list.add(rs.getInt(2));
                 list.add(rs.getInt(3));
            }
                } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public ArrayList<Object> getDoanhThuNam(){
        ArrayList<Object> list=new ArrayList<>();
        String sql="SELECT * FROM dbo.FNDTNAM(?)";
        ResultSet rs=JDBCHelper.excuteQuery(sql, new Date());
        try {
            while(rs.next()){
                 String tongtien = rs.getString("doanhthu")==null? "0 VNĐ" : rs.getString("doanhthu");
                 list.add(tongtien);
                 list.add(rs.getInt(2));
                 list.add(rs.getInt(3));
            }
                } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
