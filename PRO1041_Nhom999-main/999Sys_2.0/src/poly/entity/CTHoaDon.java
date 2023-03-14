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
public class CTHoaDon {
    private int maHD,maSP,soLuong;
    private String ghiChu;
    private boolean trangThai;
    private double giaBan;

    public CTHoaDon() {
    }

    public CTHoaDon(int maHD, int maSP, int soLuong, String ghiChu, boolean trangThai, double giaBan) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.giaBan = giaBan;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
