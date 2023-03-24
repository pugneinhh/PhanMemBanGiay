/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.ChatLieu;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author Asus
 */
public class ChatLieuResponsitory {

    public ArrayList<ChatLieu> getAllChatLieu() {
        ArrayList<ChatLieu> list = new ArrayList<>();
        String sql = "SELECT * FROM CHATLIEU";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new ChatLieu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ChatLieu getCLByID(String id) {

        String sql = "SELECT * FROM ChatLieu WHERE ID=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new ChatLieu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ChatLieu insertCL(ChatLieu cl)  {

        String sql = "INSERT INTO ChatLieu VALUES(NEWID(),?,?,GetDate(),null,?)";
//        JDBCHelper.executeUpdate(sql, cl.getMaCL(),cl.getTenCL(),cl.getTrangThai());

        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            ps.setObject(1, cl.getMaCL());
            ps.setObject(2, cl.getTenCL());
            ps.setObject(3, cl.getTrangThai());

            ps.executeUpdate();
           
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
//                String id = rs.getString(1);
                  String ten = rs.getString(1);
                System.out.println("  "+ten);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return cl;
    }

    public ChatLieu updateCL(ChatLieu cl) {

        String sql = "UPDATE ChatLieu SET TEN=?,NGAYSUA=GETDATE(),TRANGTHAI=? WHERE MA=?";
        Connection con = DBConnection.getConnection();

        JDBCHelper.executeUpdate(sql, cl.getTenCL(), cl.getTrangThai(), cl.getMaCL());
        return cl;
    }

    public Integer deleteCL(String id) {
        String sql = "DELETE FROM ChatLieu WHERE MA=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }

    public static void main(String[] args) {
        ChatLieuResponsitory chatLieuRespon = new ChatLieuResponsitory();
        ChatLieu _chatLieu = new ChatLieu("cl122233332233", "dfsf", 2);
       
            ChatLieu chatLieu= chatLieuRespon.insertCL(_chatLieu);
       
          System.out.println("  "+chatLieu.getIdCL());

    }
}
