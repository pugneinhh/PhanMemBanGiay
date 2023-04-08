/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;
import DomainModels.DoCao;
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
public class DoCaoResponsitory {
    
    public ArrayList<DoCao> getAllDoCao(){
        ArrayList<DoCao> list=new ArrayList<>();
        String sql="SELECT * FROM DoCao";
        ResultSet rs=JDBCHelper.excuteQuery(sql);
        
          
            try {
                while(rs.next()){
                    list.add(new DoCao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DoCaoResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        return list;
    }
    public DoCao getDCByID(String id){
        
        String sql="SELECT * FROM DoCao WHERE ID=?";
        ResultSet rs=JDBCHelper.excuteQuery(sql,id);
        try {
            while(rs.next()){
                return new DoCao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoCaoResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    public DoCao insertDC(DoCao dc){
        
        String sql="INSERT INTO DoCao VALUES(NEWID(),?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, dc.getMaDC(),dc.getTenDC(),dc.getTrangThai());
        return dc;
    }
    public DoCao updateDC(DoCao dc){
        
        String sql="UPDATE DoCao SET TEN=?,NGAYSUA=GETDATE(),TRANGTHAI=? WHERE MA=?";
        JDBCHelper.executeUpdate(sql, dc.getTenDC(),dc.getTrangThai(),dc.getMaDC());
        return dc;
    }
    public Integer deleteDC(String id){   
        String sql="DELETE FROM DoCao WHERE MA=?";
        int row=JDBCHelper.executeUpdate(sql,id);
        return row;
    }
    
    
}
