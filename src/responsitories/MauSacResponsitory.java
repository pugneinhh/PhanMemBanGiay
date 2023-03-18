/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.MauSac;
import java.util.ArrayList;
import Utilities.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class MauSacResponsitory {
    public ArrayList<MauSac> getAllMauSac(){
        ArrayList<MauSac> list=new ArrayList<>();
        String sql="SELECT * FROM MauSac";
        ResultSet rs=JDBCHelper.excuteQuery(sql);
        
          
            try {
                while(rs.next()){
                    list.add(new MauSac(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(MauSacResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        return list;
    }
    public MauSac getMSByID(String id){
        
        String sql="SELECT * FROM MauSac WHERE ID=?";
        ResultSet rs=JDBCHelper.excuteQuery(sql,id);
        try {
            while(rs.next()){
                return new MauSac(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MauSacResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    public MauSac insertMS(MauSac ms){
        

        String sql="INSERT INTO MauSac VALUES(NEWID(),?,?,GetDate(),null,?)";


        JDBCHelper.executeUpdate(sql, ms.getMaMS(),ms.getTenMS(),ms.getTrangThai());
        return ms;
    }
    public MauSac updateMS(MauSac ms){
        
        String sql="UPDATE MauSac SET TEN=?,NGAYSUA=GETDATE(),TrangThai=? WHERE MA=?";
        JDBCHelper.executeUpdate(sql, ms.getTenMS(),ms.getTrangThai(),ms.getMaMS());
        return ms;
    }
    public Integer deleteMS(String id){   
        String sql="DELETE FROM MauSac WHERE MA=?";
        int row=JDBCHelper.executeUpdate(sql,id);
        return row;
    }
    
}
