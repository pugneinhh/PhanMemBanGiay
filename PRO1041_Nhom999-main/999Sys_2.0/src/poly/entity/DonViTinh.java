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
public class DonViTinh {
    private int maDVT;
    private String tenDVT;
    private boolean trangThai;

    public DonViTinh() {
    }

    public DonViTinh(int maDVT, String tenDVT, boolean trangThai) {
        this.maDVT = maDVT;
        this.tenDVT = tenDVT;
        this.trangThai = trangThai;
    }
    public DonViTinh(String tenDVT, boolean trangThai) {
        this.tenDVT = tenDVT;
        this.trangThai = trangThai;
    }

    public int getMaDVT() {
        return maDVT;
    }

    public void setMaDVT(int maDVT) {
        this.maDVT = maDVT;
    }

    public String getTenDVT() {
        return tenDVT;
    }

    public void setTenDVT(String tenDVT) {
        this.tenDVT = tenDVT;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenDVT;
    }
    
}
