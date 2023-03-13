/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

/**
 *
 * @author Admin
 */
public class ChatLieu {
    private int maChatLieu;
    private String tenChatLieu;
    private boolean trangThai;

    public ChatLieu() {
    }

    public ChatLieu(int maChatLieu, String tenChatLieu, boolean trangThai) {
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.trangThai = trangThai;
    }
    public ChatLieu(String tenChatLieu, boolean trangThai) {
        this.tenChatLieu = tenChatLieu;
        this.trangThai = trangThai;
    }

    public int getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(int maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return this.tenChatLieu;
    }
    
}
