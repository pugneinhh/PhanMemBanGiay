/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class SanPham {

       private int maSP,maDanhMuc;
    private String maVach,anhSanPham,tenSanPham;
    private double giaNhap,giaBan;
    private int soLuong;
    private Date ngayNhap;
    private boolean apDungKM;
    private int maDVT,maMau;
    private String maSize;
    private int maChatLieu;
    private boolean trangThai;

    public SanPham() {
    }

    public SanPham(int maSP, int maDanhMuc, String maVach, String anhSanPham, String tenSanPham, double giaNhap, double giaBan, int soLuong, Date ngayNhap, boolean apDungKM, int maDVT, int maMau, String maSize, int maChatLieu, boolean trangThai) {
        this.maSP = maSP;
        this.maDanhMuc = maDanhMuc;
        this.maVach = maVach;
        this.anhSanPham = anhSanPham;
        this.tenSanPham = tenSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.apDungKM = apDungKM;
        this.maDVT = maDVT;
        this.maMau = maMau;
        this.maSize = maSize;
        this.maChatLieu = maChatLieu;
        this.trangThai = trangThai;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isApDungKM() {
        return apDungKM;
    }

    public void setApDungKM(boolean apDungKM) {
        this.apDungKM = apDungKM;
    }

    public int getMaDVT() {
        return maDVT;
    }

    public void setMaDVT(int maDVT) {
        this.maDVT = maDVT;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public int getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(int maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return maSP+"";
    }

    public void getMaSP(int intValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
