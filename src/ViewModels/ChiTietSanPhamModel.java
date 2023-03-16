/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.ChatLieu;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import java.math.BigDecimal;

/**
 *
 * @author Asus
 */
public class ChiTietSanPhamModel {
    private SanPham MaSP;
    private SanPham TenSP;
    private int soluong;
    private Size tensSize;
    private MauSac tenMS;
    private DoCao tenDC;
    private ChatLieu tenCL;
    private DanhMuc tenDM;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String mota;
    private int trangthai;
    private SanPham hinhanh;

    public ChiTietSanPhamModel() {
    }

    public ChiTietSanPhamModel(int soluong, BigDecimal giaNhap, BigDecimal giaBan, int trangthai) {
        this.soluong = soluong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangthai = trangthai;
    }

    public ChiTietSanPhamModel(SanPham MaSP, SanPham TenSP, int soluong, Size tensSize, MauSac tenMS, DoCao tenDC, ChatLieu tenCL, DanhMuc tenDM, BigDecimal giaNhap, BigDecimal giaBan, String mota, int trangthai, SanPham hinhanh) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.soluong = soluong;
        this.tensSize = tensSize;
        this.tenMS = tenMS;
        this.tenDC = tenDC;
        this.tenCL = tenCL;
        this.tenDM = tenDM;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.mota = mota;
        this.trangthai = trangthai;
        this.hinhanh = hinhanh;
    }

    public SanPham getMaSP() {
        return MaSP;
    }

    public void setMaSP(SanPham MaSP) {
        this.MaSP = MaSP;
    }

    public SanPham getTenSP() {
        return TenSP;
    }

    public void setTenSP(SanPham TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Size getTensSize() {
        return tensSize;
    }

    public void setTensSize(Size tensSize) {
        this.tensSize = tensSize;
    }

    public MauSac getTenMS() {
        return tenMS;
    }

    public void setTenMS(MauSac tenMS) {
        this.tenMS = tenMS;
    }

    public DoCao getTenDC() {
        return tenDC;
    }

    public void setTenDC(DoCao tenDC) {
        this.tenDC = tenDC;
    }

    public ChatLieu getTenCL() {
        return tenCL;
    }

    public void setTenCL(ChatLieu tenCL) {
        this.tenCL = tenCL;
    }

    public DanhMuc getTenDM() {
        return tenDM;
    }

    public void setTenDM(DanhMuc tenDM) {
        this.tenDM = tenDM;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public SanPham getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(SanPham hinhanh) {
        this.hinhanh = hinhanh;
    }

    
    
}
