/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.ChatLieu;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.KhuyenMai;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class ChiTietSanPhamModel {
    private String idCTSP;
    private SanPham idSP;
    private KhuyenMai idKM;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private int maQR;
    private String hinhanh;
    private int soLuong;
    private DanhMuc idDM;
    private Size idSize;
    private MauSac idMS;
    private ChatLieu idCL;
    private DoCao idDC;
    private String mota;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public ChiTietSanPhamModel() {
    }

    public ChiTietSanPhamModel(String idCTSP, SanPham idSP, KhuyenMai idKM, BigDecimal giaNhap, BigDecimal giaBan, int maQR, String hinhanh, int soLuong, DanhMuc idDM, Size idSize, MauSac idMS, ChatLieu idCL, DoCao idDC, String mota, Date ngayTao, Date ngaySua, int trangThai) {
        this.idCTSP = idCTSP;
        this.idSP = idSP;
        this.idKM = idKM;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.maQR = maQR;
        this.hinhanh = hinhanh;
        this.soLuong = soLuong;
        this.idDM = idDM;
        this.idSize = idSize;
        this.idMS = idMS;
        this.idCL = idCL;
        this.idDC = idDC;
        this.mota = mota;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public ChiTietSanPhamModel(SanPham idSP, KhuyenMai idKM, BigDecimal giaNhap, BigDecimal giaBan, int maQR, String hinhanh, int soLuong, DanhMuc idDM, Size idSize, MauSac idMS, ChatLieu idCL, DoCao idDC, String mota, int trangThai) {
        this.idSP = idSP;
        this.idKM = idKM;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.maQR = maQR;
        this.hinhanh = hinhanh;
        this.soLuong = soLuong;
        this.idDM = idDM;
        this.idSize = idSize;
        this.idMS = idMS;
        this.idCL = idCL;
        this.idDC = idDC;
        this.mota = mota;
        this.trangThai = trangThai;
    }

    public ChiTietSanPhamModel(SanPham idSP, BigDecimal giaNhap, BigDecimal giaBan, String hinhanh, int soLuong, DanhMuc idDM, Size idSize, MauSac idMS, ChatLieu idCL, DoCao idDC, String mota, int trangThai) {
        this.idSP = idSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.hinhanh = hinhanh;
        this.soLuong = soLuong;
        this.idDM = idDM;
        this.idSize = idSize;
        this.idMS = idMS;
        this.idCL = idCL;
        this.idDC = idDC;
        this.mota = mota;
        this.trangThai = trangThai;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public KhuyenMai getIdKM() {
        return idKM;
    }

    public void setIdKM(KhuyenMai idKM) {
        this.idKM = idKM;
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

    public int getMaQR() {
        return maQR;
    }

    public void setMaQR(int maQR) {
        this.maQR = maQR;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DanhMuc getIdDM() {
        return idDM;
    }

    public void setIdDM(DanhMuc idDM) {
        this.idDM = idDM;
    }

    public Size getIdSize() {
        return idSize;
    }

    public void setIdSize(Size idSize) {
        this.idSize = idSize;
    }

    public MauSac getIdMS() {
        return idMS;
    }

    public void setIdMS(MauSac idMS) {
        this.idMS = idMS;
    }

    public ChatLieu getIdCL() {
        return idCL;
    }

    public void setIdCL(ChatLieu idCL) {
        this.idCL = idCL;
    }

    public DoCao getIdDC() {
        return idDC;
    }

    public void setIdDC(DoCao idDC) {
        this.idDC = idDC;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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
