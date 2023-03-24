/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.ChatLieu;
import DomainModels.ChiTietSanPham;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.HoaDon;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author HoiVN
 */
public class HoaDonChiTiet_CTSanPham {
    private HoaDon maHD;
    private SanPham tenSP;
    private BigDecimal giaBan;
    private int soLuong;
    private Size size;
    private MauSac mauSac;
    private ChatLieu chatLieu;
    private DanhMuc danhMuc;
    private DoCao doCao;

    public HoaDonChiTiet_CTSanPham() {
    }

    public HoaDonChiTiet_CTSanPham(HoaDon maHD, SanPham tenSP, BigDecimal giaBan, int soLuong, Size size, MauSac mauSac, ChatLieu chatLieu, DanhMuc danhMuc, DoCao doCao) {
        this.maHD = maHD;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.danhMuc = danhMuc;
        this.doCao = doCao;
    }

    public HoaDon getMaHD() {
        return maHD;
    }

    public void setMaHD(HoaDon maHD) {
        this.maHD = maHD;
    }

    public SanPham getTenSP() {
        return tenSP;
    }

    public void setTenSP(SanPham tenSP) {
        this.tenSP = tenSP;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public DoCao getDoCao() {
        return doCao;
    }

    public void setDoCao(DoCao doCao) {
        this.doCao = doCao;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet_CTSanPham{" + "maHD=" + maHD + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", size=" + size + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu + ", danhMuc=" + danhMuc + ", doCao=" + doCao + '}';
    }

}
