/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author Phanh
 */
public class GioHang {
    private String idGH;
    private String maGH;
    private KhachHang idKH;
    private NhanVien idNV;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String diaChi;
    private String sdt;
    private Date ngaySua;
    private int trangThai;

    public GioHang() {
    }

    public GioHang(String maGH, KhachHang idKH, NhanVien idNV, Date ngayThanhToan, String diaChi, String sdt, int trangThai) {
        this.maGH = maGH;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ngayThanhToan = ngayThanhToan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    
    public GioHang(String idGH, String maGH, KhachHang idKH, NhanVien idNV, Date ngayTao, Date ngayThanhToan, String diaChi, String sdt, Date ngaySua, int trangThai) {
        this.idGH = idGH;
        this.maGH = maGH;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdGH() {
        return idGH;
    }

    public void setIdGH(String idGH) {
        this.idGH = idGH;
    }

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public KhachHang getIdKH() {
        return idKH;
    }

    public void setIdKH(KhachHang idKH) {
        this.idKH = idKH;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
