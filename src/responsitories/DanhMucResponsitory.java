/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.DanhMuc;
import Utilities.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanhMucResponsitory {
     public ArrayList<DanhMuc> getAllDanhMuc(){
        ArrayList<DanhMuc> list=new ArrayList<>();
        String sql="SELECT * FROM DanhMuc";
        ResultSet rs=JDBCHelper.excuteQuery(sql);
        
            try {
                while(rs.next()){
                    list.add(new DanhMuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return list;
    }
    public DanhMuc getDMByID(String id){
        
        String sql="SELECT * FROM DanhMuc WHERE ID=?";
        ResultSet rs=JDBCHelper.excuteQuery(sql,id);
        try {
            while(rs.next()){
                return new DanhMuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    public DanhMuc insertDM(DanhMuc dm){
        
        String sql="INSERT INTO DanhMuc VALUES(NEWID(),?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, dm.getMaDM(),dm.getTenDM(),dm.getTrangThai());
        return dm;
    }
    public DanhMuc updateDm(DanhMuc dm){
        
        String sql="UPDATE DanhMuc SET TEN=?,NGAYSUA=GETDATE(),TRANGTHAI=? WHERE MA=?";
        JDBCHelper.executeUpdate(sql, dm.getTenDM(),dm.getTrangThai(),dm.getMaDM());
        return dm;
    }
    public Integer deleteDM(String id){   
        String sql="DELETE FROM DANHMUC WHERE MA=?";
        int row=JDBCHelper.executeUpdate(sql,id);
        return row;
    }
    public static void main(String[] args) {
        //new DanhMucResponsitory().insertDM(new DanhMuc("DM1", "Giày Đế Thấp", 1));
        DanhMucResponsitory dmR = new DanhMucResponsitory();
        System.out.println(dmR.getAllDanhMuc());
        System.out.println(dmR.getDMByID("18c9edbd-5083-4b7c-bb74-ce6aa5764502"));
    }
}
