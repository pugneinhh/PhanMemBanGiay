/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;
import java.sql.*;
/**
 *
 * @author Phanh
 */
public class JDBCHelper {
    public static ResultSet excuteQuery(String sql, Object... args) {
        Connection c = null; //để thực hiện câu truy vấn
        ResultSet rs = null; //để nhận dữ liệu kq của câu truy vấn
        PreparedStatement pr = null;  //để thực thi câu truy vấn có tham số
        try {
            c = DBConnection.getConnection();
            pr = c.prepareStatement(sql);
            //duyệt mảng
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i + 1, args[i]); //gán giá trị cho các tham số của pr

            }
            rs = pr.executeQuery(); // thực thi câu truy vấn
           
        } catch (Exception e) {
        }
        return rs;
    }

    public static Integer executeUpdate(String sql, Object... args) {
        Connection c = null;
        Integer row = 0;
        PreparedStatement pr = null;
        try {
            c = DBConnection.getConnection();
            pr = c.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1, args[i]);
            }
            row = pr.executeUpdate();
         return row;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
