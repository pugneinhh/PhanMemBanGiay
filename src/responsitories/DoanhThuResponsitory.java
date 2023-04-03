/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
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
    public ArrayList<Object[]> getDTNgay(int thang,int nam){
        ArrayList<Object[]> list=new ArrayList<>();
        String sql="EXEC SP_DTNGAY ?,?";
        ResultSet rs=JDBCHelper.excuteQuery(sql, thang,nam);
        try {
            while(rs.next()){
                 list.add(new Object[]{
                     rs.getDate(1),
                     rs.getInt(2),
                     rs.getInt(3)
                 });
                 
            }
                } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public ArrayList<Object[]> getDTThang(int nam){
        ArrayList<Object[]> list=new ArrayList<>();
        String sql="EXEC SP_DTTHANG ?";
        ResultSet rs=JDBCHelper.excuteQuery(sql,nam);
        try {
            while(rs.next()){
                 list.add(new Object[]{
                     rs.getInt(1),
                     rs.getInt(2),
                     rs.getInt(3)
                 });
                 
            }
                } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public ArrayList<Object[]> getDTNAM(int nam){
        ArrayList<Object[]> list=new ArrayList<>();
        String sql="EXEC SP_DTNAM ?";
        ResultSet rs=JDBCHelper.excuteQuery(sql,nam);
        try {
            while(rs.next()){
                 list.add(new Object[]{
                     rs.getInt(1),
                     rs.getInt(2),
                     rs.getInt(3)
                 });
                 
            }
                } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public ArrayList<Integer> selectYears() {
        ArrayList<Integer> list = new ArrayList<>();
         String sql = "SELECT DISTINCT YEAR(NGAYTao) as [YEAR] FROM HOADON WHERE NGAYTAO IS NOT NULL ORDER BY [YEAR] DESC";
        try {
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public ArrayList<Integer> selectMonths() {
        ArrayList<Integer> list = new ArrayList<>();
         String sql = "SELECT DISTINCT Month(NGAYTAO) as [month] FROM HOADON WHERE NGAYTAO IS NOT NULL ORDER BY [month] DESC";
        try {
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
   
}
