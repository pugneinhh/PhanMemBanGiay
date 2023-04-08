/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.Size;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class SizeResponsitory {
    public ArrayList<Size> getAllSize(){
        ArrayList<Size> list=new ArrayList<>();
        String sql="SELECT * FROM Size";
        ResultSet rs=JDBCHelper.excuteQuery(sql);
        
          
            try {
                while(rs.next()){
                    list.add(new Size(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(SizeResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        return list;
    }
    public Size getSizeByID(String id){    
        String sql="SELECT * FROM Size WHERE ID=?";
        ResultSet rs=JDBCHelper.excuteQuery(sql,id);
        try {
            while(rs.next()){
                return new Size(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SizeResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    public Size insertSize(Size size){
        
        String sql="INSERT INTO size VALUES(NEWID(),?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, size.getMaSize(),size.getTenSize(),size.getTrangThai());
        return size;
    }
    public Size updateSize(Size size){
        

        String sql="UPDATE size SET TEN=?,NGAYSUA=GETDATE(),TRANGTHAI=? WHERE MA=?";
        JDBCHelper.executeUpdate(sql, size.getTenSize(),size.getTrangThai(),size.getMaSize());

        return size;
    }
    public Integer deleteSize(String id){   
        String sql="DELETE FROM size WHERE MA=?";
        int row=JDBCHelper.executeUpdate(sql,id);
        return row;
    }
    
}
