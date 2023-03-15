/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Phanh
 */
public class GioHangChiTiet {
    private GioHang idGH;
    private ChiTietSanPham idCTSP;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(GioHang idGH, ChiTietSanPham idCTSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam, int trangThai) {
        this.idGH = idGH;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
        this.trangThai = trangThai;
    }
    
    public GioHangChiTiet(GioHang idGH, ChiTietSanPham idCTSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam, Date ngayTao, Date ngaySua, int trangThai) {
        this.idGH = idGH;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public GioHang getIdGH() {
        return idGH;
    }

    public void setIdGH(GioHang idGH) {
        this.idGH = idGH;
    }

    public ChiTietSanPham getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(ChiTietSanPham idCTSP) {
        this.idCTSP = idCTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
            

}
