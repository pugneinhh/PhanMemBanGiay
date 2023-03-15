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
public class KhachHang {

    private String maKH;
    private int maLoaiKH, tichDiem, diemEXP;
    private String hoTen;
    private Date ngaySinh, ngayTao;
    private boolean gioiTinh;
    private String email, SDT, diaChi;
    private boolean trangThai;

    public KhachHang() {
    }

    public KhachHang(String maKH, int maLoaiKH, int tichDiem, int diemEXP, String hoTen, Date ngaySinh, Date ngayTao, boolean gioiTinh, String email, String SDT, String diaChi, boolean trangThai) {
        this.maKH = maKH;
        this.maLoaiKH = maLoaiKH;
        this.tichDiem = tichDiem;
        this.diemEXP = diemEXP;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getMaLoaiKH() {
        return maLoaiKH;
    }

    public void setMaLoaiKH(int maLoaiKH) {
        this.maLoaiKH = maLoaiKH;
    }

    public int getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(int tichDiem) {
        this.tichDiem = tichDiem;
    }

    public int getDiemEXP() {
        return diemEXP;
    }

    public void setDiemEXP(int diemEXP) {
        this.diemEXP = diemEXP;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
