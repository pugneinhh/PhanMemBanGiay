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
public class HoaDonChiTiet {

    private String idHDCT;
    private HoaDon idHD;
    private ChiTietSanPham idCTSP;
    private BigDecimal donGia;
    private int soLuong;
    private Date ngayBan;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon idHD, ChiTietSanPham idCTSP, int soLuong, BigDecimal donGia, Date ngayBan, int trangThai) {
        this.idHD = idHD;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ngayBan = ngayBan;
        this.trangThai = trangThai;
    }

    public HoaDonChiTiet(String idHDCT, HoaDon idHD, ChiTietSanPham idCTSP, BigDecimal donGia, int soLuong, Date ngayBan, Date ngayTao, Date ngaySua, int trangThai) {
        this.idHDCT = idHDCT;
        this.idHD = idHD;
        this.idCTSP = idCTSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ngayBan = ngayBan;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(String idHDCT) {
        this.idHDCT = idHDCT;
    }

    public HoaDon getIdHD() {
        return idHD;
    }

    public void setIdHD(HoaDon idHD) {
        this.idHD = idHD;
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

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
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
