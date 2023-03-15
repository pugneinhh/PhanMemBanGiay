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
public class KhuyenMai {
    private String idKM;
    private String maKM;
    private String tenKM;
    private BigDecimal giaTri;
    private BigDecimal giamToiDa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String hinhThucApDung;
    private String apDungGiamGia;
    private String loadGiamGia;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, BigDecimal giaTri, BigDecimal giamToiDa, Date ngayBatDau, Date ngayKetThuc, String hinhThucApDung, String apDungGiamGia, String loadGiamGia, int trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.giaTri = giaTri;
        this.giamToiDa = giamToiDa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hinhThucApDung = hinhThucApDung;
        this.apDungGiamGia = apDungGiamGia;
        this.loadGiamGia = loadGiamGia;
        this.trangThai = trangThai;
    }
    
    public KhuyenMai(String idKM, String maKM, String tenKM, BigDecimal giaTri, BigDecimal giamToiDa, Date ngayBatDau, Date ngayKetThuc, String hinhThucApDung, String apDungGiamGia, String loadGiamGia, Date ngayTao, Date ngaySua, int trangThai) {
        this.idKM = idKM;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.giaTri = giaTri;
        this.giamToiDa = giamToiDa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hinhThucApDung = hinhThucApDung;
        this.apDungGiamGia = apDungGiamGia;
        this.loadGiamGia = loadGiamGia;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public BigDecimal getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(BigDecimal giaTri) {
        this.giaTri = giaTri;
    }

    public BigDecimal getGiamToiDa() {
        return giamToiDa;
    }

    public void setGiamToiDa(BigDecimal giamToiDa) {
        this.giamToiDa = giamToiDa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getHinhThucApDung() {
        return hinhThucApDung;
    }

    public void setHinhThucApDung(String hinhThucApDung) {
        this.hinhThucApDung = hinhThucApDung;
    }

    public String getApDungGiamGia() {
        return apDungGiamGia;
    }

    public void setApDungGiamGia(String apDungGiamGia) {
        this.apDungGiamGia = apDungGiamGia;
    }

    public String getLoadGiamGia() {
        return loadGiamGia;
    }

    public void setLoadGiamGia(String loadGiamGia) {
        this.loadGiamGia = loadGiamGia;
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
