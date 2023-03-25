/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.NhanVien;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class GiaoCaModel {
    private String idGC;
    private String maGC;
    private NhanVien maNVGiao;
    private NhanVien maNVNhan;
    private String gioGiaoCa;
    private String gioNhanCao;
    private BigDecimal tienCoSo;
    private BigDecimal tienPhatSinh;
    private BigDecimal doanhThuCa;
    private BigDecimal tongTien;
    private String ghiChuGiao;
    private String ghiChuNhan;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public GiaoCaModel() {
    }

    public GiaoCaModel(String maGC, NhanVien maNVGiao, NhanVien maNVNhan, String gioGiaoCa, String gioNhanCao, BigDecimal tienCoSo, BigDecimal tienPhatSinh, BigDecimal doanhThuCa, BigDecimal tongTien, String ghiChuGiao, String ghiChuNhan, int trangThai) {
        this.maGC = maGC;
        this.maNVGiao = maNVGiao;
        this.maNVNhan = maNVNhan;
        this.gioGiaoCa = gioGiaoCa;
        this.gioNhanCao = gioNhanCao;
        this.tienCoSo = tienCoSo;
        this.tienPhatSinh = tienPhatSinh;
        this.doanhThuCa = doanhThuCa;
        this.tongTien = tongTien;
        this.ghiChuGiao = ghiChuGiao;
        this.ghiChuNhan = ghiChuNhan;
        this.trangThai = trangThai;
    }

    public GiaoCaModel(String idGC, String maGC, NhanVien maNVGiao, NhanVien maNVNhan, String gioGiaoCa, String gioNhanCao, BigDecimal tienCoSo, BigDecimal tienPhatSinh, BigDecimal doanhThuCa, BigDecimal tongTien, String ghiChuGiao, String ghiChuNhan, Date ngayTao, Date ngaySua, int trangThai) {
        this.idGC = idGC;
        this.maGC = maGC;
        this.maNVGiao = maNVGiao;
        this.maNVNhan = maNVNhan;
        this.gioGiaoCa = gioGiaoCa;
        this.gioNhanCao = gioNhanCao;
        this.tienCoSo = tienCoSo;
        this.tienPhatSinh = tienPhatSinh;
        this.doanhThuCa = doanhThuCa;
        this.tongTien = tongTien;
        this.ghiChuGiao = ghiChuGiao;
        this.ghiChuNhan = ghiChuNhan;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdGC() {
        return idGC;
    }

    public void setIdGC(String idGC) {
        this.idGC = idGC;
    }

    public String getMaGC() {
        return maGC;
    }

    public void setMaGC(String maGC) {
        this.maGC = maGC;
    }

    public NhanVien getMaNVGiao() {
        return maNVGiao;
    }

    public void setMaNVGiao(NhanVien maNVGiao) {
        this.maNVGiao = maNVGiao;
    }

    public NhanVien getMaNVNhan() {
        return maNVNhan;
    }

    public void setMaNVNhan(NhanVien maNVNhan) {
        this.maNVNhan = maNVNhan;
    }

    public String getGioGiaoCa() {
        return gioGiaoCa;
    }

    public void setGioGiaoCa(String gioGiaoCa) {
        this.gioGiaoCa = gioGiaoCa;
    }

    public String getGioNhanCao() {
        return gioNhanCao;
    }

    public void setGioNhanCao(String gioNhanCao) {
        this.gioNhanCao = gioNhanCao;
    }

    public BigDecimal getTienCoSo() {
        return tienCoSo;
    }

    public void setTienCoSo(BigDecimal tienCoSo) {
        this.tienCoSo = tienCoSo;
    }

    public BigDecimal getTienPhatSinh() {
        return tienPhatSinh;
    }

    public void setTienPhatSinh(BigDecimal tienPhatSinh) {
        this.tienPhatSinh = tienPhatSinh;
    }

    public BigDecimal getDoanhThuCa() {
        return doanhThuCa;
    }

    public void setDoanhThuCa(BigDecimal doanhThuCa) {
        this.doanhThuCa = doanhThuCa;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChuGiao() {
        return ghiChuGiao;
    }

    public void setGhiChuGiao(String ghiChuGiao) {
        this.ghiChuGiao = ghiChuGiao;
    }

    public String getGhiChuNhan() {
        return ghiChuNhan;
    }

    public void setGhiChuNhan(String ghiChuNhan) {
        this.ghiChuNhan = ghiChuNhan;
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
