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
public class HoaDon {
    private String idHD;
    private String maHD;
    private NhanVien idNV;
    private KhachHang idKH;
    private Date ngayMua;
    private BigDecimal thanhTien;
    private KhuyenMai idKM;
    private String ghiChu;
    private Date ngaySua;
    private Date ngaytao;
    private int trangThai;
    private int hinhThucThanhToan;

    public HoaDon() {
    }

    public HoaDon(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngayMua, BigDecimal thanhTien, KhuyenMai idKM, String ghiChu, Date ngaySua, Date ngaytao, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngayMua = ngayMua;
        this.thanhTien = thanhTien;
        this.idKM = idKM;
        this.ghiChu = ghiChu;
        this.ngaySua = ngaySua;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
    }
    public HoaDon(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngayMua, BigDecimal thanhTien, KhuyenMai idKM, String ghiChu, Date ngaySua, Date ngaytao, int trangThai,int hinhThucThanhToan) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngayMua = ngayMua;
        this.thanhTien = thanhTien;
        this.idKM = idKM;
        this.ghiChu = ghiChu;
        this.ngaySua = ngaySua;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }
    
    public HoaDon(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngaytao, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
    }
    public HoaDon(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngaytao,String ghiChu, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngaytao = ngaytao;
        this.ghiChu=ghiChu;
        this.trangThai = trangThai;
    }

    public HoaDon(String idHD, String maHD, NhanVien idNV, KhachHang idKH, BigDecimal thanhTien, Date ngaytao, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.thanhTien = thanhTien;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
    }
    
    public HoaDon(String idHD, String maHD) {
        this.idHD = idHD;
        this.maHD = maHD;
    }
    public HoaDon(String idHD) {
        this.idHD = idHD;
    }
    public int getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public KhachHang getIdKH() {
        return idKH;
    }

    public void setIdKH(KhachHang idKH) {
        this.idKH = idKH;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public KhuyenMai getIdKM() {
        return idKM;
    }

    public void setIdKM(KhuyenMai idKM) {
        this.idKM = idKM;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return maHD;
    }    

    public BigDecimal getThanhToan(){
        return thanhTien;
    }
}
