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
public class VaiTro {
    private int maVaiTro;
    private String tenVaiTro;
    private boolean trangThai;

    public VaiTro() {
    }

    public VaiTro(int maVaiTro, String tenVaiTro, boolean trangThai) {
        this.maVaiTro = maVaiTro;
        this.tenVaiTro = tenVaiTro;
        this.trangThai = trangThai;
    }

    public int getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(int maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    @Override
    public String toString() {
        return tenVaiTro;
    }
    
}
