/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.ChatLieu;

/**
 *
 * @author Admin
 */
public class ChatLieuDao extends BaseDao<ChatLieu, String>{

    @Override
    public String getQuery(String action) {
        switch(action){
            case "INSERT":
                return "INSERT INTO CHATLIEU(TENCHATLIEU) VALUES (?)";
            case "UPDATE":
                return "UPDATE CHATLIEU SET TENCHATLIEU =?, TRANGTHAI =? WHERE MACHATLIEU = ?";
            case "DELETE":
                return "UPDATE CHATLIEU SET TRANGTHAI =0 WHERE MACHATLIEU = ?";
            case "SELECTBYID":
                return "SELECT * FROM CHATLIEU	WHERE MACHATLIEU = ?";
            case "SELECTALL":
                return "SELECT * FROM CHATLIEU";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, ChatLieu obj) {
        switch(action){
            case "INSERT":
                return new Object[]{
                    obj.getTenChatLieu()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getTenChatLieu(),
                    obj.isTrangThai(),
                    obj.getMaChatLieu()
                };
        }
        return null;
    }

    @Override
    public ChatLieu createEntity(ResultSet rs) throws SQLException {
        ChatLieu cl = new ChatLieu();
        cl.setMaChatLieu(rs.getInt("MACHATLIEU"));
        cl.setTenChatLieu(rs.getString("TENCHATLIEU"));
        cl.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return cl;
    }
    
}
