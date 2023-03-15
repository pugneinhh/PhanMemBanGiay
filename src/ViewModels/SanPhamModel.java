/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class SanPhamModel {
    private String idSP;
    private String MaSP;
    private String TenSP;
    private int SoLuongSP;
    private BigDecimal donGia;
    private String moTa;
    private String hinhAnh;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public SanPhamModel() {
    }
    
    

    public SanPhamModel(String idSP, String MaSP, String TenSP, int SoLuongSP, BigDecimal donGia, String moTa, String hinhAnh, Date ngayTao, Date ngaySua, int trangThai) {
        this.idSP = idSP;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuongSP = SoLuongSP;
        this.donGia = donGia;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int SoLuongSP) {
        this.SoLuongSP = SoLuongSP;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
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
