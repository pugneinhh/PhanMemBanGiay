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
public class MauSac {

    private int maMau;
    private String tenMau;
    private boolean trangThai;

    public MauSac() {
    }

    public MauSac(int maMau, String tenMau, boolean trangThai) {
        this.maMau = maMau;
        this.tenMau = tenMau;
        this.trangThai = trangThai;
    }

    public MauSac(String tenMau) {
        this.tenMau = tenMau;
    }
    public MauSac(int maMau, boolean trangThai) {
        this.maMau = maMau;
        this.trangThai = trangThai;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenMau;
    }

}
