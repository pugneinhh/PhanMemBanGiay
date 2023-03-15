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
public class DanhMuc {
    private int maDM;
    private String tenDanhMuc,ngayThem;
    private boolean trangThai;

    public DanhMuc() {
    }

    public DanhMuc(int maDM, String tenDanhMuc, String ngayThem, boolean trangThai) {
        this.maDM = maDM;
        this.tenDanhMuc = tenDanhMuc;
        this.ngayThem = ngayThem;
        this.trangThai = trangThai;
    }
    public DanhMuc(String tenDanhMuc, String ngayThem) {
        this.tenDanhMuc = tenDanhMuc;
        this.ngayThem = ngayThem;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenDanhMuc; //To change body of generated methods, choose Tools | Templates.
    }
    
}
