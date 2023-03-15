/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

import java.util.Date;

/**
 *
 * @author XUÂN THÀNH
 */
public class GiaoHang {
    private int maGiaoHang, maHoaDon, maTrangThai, suDungPoint;
    private String tenKhachHang ,soDienThoai, diaChi, ghiChu;
    private Date ngayGiaoHang;
    private double tienShip;

    public GiaoHang() {
    }

    public GiaoHang(int maGiaoHang, int maHoaDon, int maTrangThai, String tenKhachHang, String soDienThoai, String diaChi, String ghiChu, Date ngayGiaoHang, double tienShip, int suDungPoint) {
        this.maGiaoHang = maGiaoHang;
        this.maHoaDon = maHoaDon;
        this.maTrangThai = maTrangThai;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
        this.ngayGiaoHang = ngayGiaoHang;
        this.tienShip = tienShip;
        this.suDungPoint = suDungPoint;
    }

    public int getMaGiaoHang() {
        return maGiaoHang;
    }

    public void setMaGiaoHang(int maGiaoHang) {
        this.maGiaoHang = maGiaoHang;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public double getTienShip() {
        return tienShip;
    }

    public void setTienShip(double tienShip) {
        this.tienShip = tienShip;
    }

    
    public int getSuDungPoint() {
        return suDungPoint;
    }

    public void setSuDungPoint(int suDungPoint) {
        this.suDungPoint = suDungPoint;
    }

}
