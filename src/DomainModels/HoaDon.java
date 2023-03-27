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
    private Date ngayTao;
    private BigDecimal thanhTien;
    private BigDecimal tienShip;
    private KhuyenMai idKM;
    private String ghiChu;
    private Date ngaySua;
    private int trangThai;

    public HoaDon() {
    }

<<<<<<< HEAD
    public HoaDon(String idHD, String maHD) {
        this.idHD = idHD;
        this.maHD = maHD;
    }

    public HoaDon(String idHD, String maHD, KhachHang idKH) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idKH = idKH;
    }

    public HoaDon(NhanVien idNV, KhachHang idKH, BigDecimal thanhTien, BigDecimal tienShip, KhuyenMai idKM, String ghiChu, int trangThai) {
        this.idNV = idNV;
        this.idKH = idKH;
        this.thanhTien = thanhTien;
        this.tienShip = tienShip;
        this.idKM = idKM;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public HoaDon(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngayTao, BigDecimal thanhTien, BigDecimal tienShip, KhuyenMai idKM, String ghiChu, Date ngaySua, int trangThai) {
=======
    public HoaDon(String maHD) {
        this.maHD = maHD;
    }

    public HoaDon(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngayTao, BigDecimal thanhTien, KhuyenMai idKM, String ghiChu, Date ngaySua, Date ngaytao, int trangThai, String mahd) {
>>>>>>> origin/master
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngayTao = ngayTao;
        this.thanhTien = thanhTien;
        this.tienShip = tienShip;
        this.idKM = idKM;
        this.ghiChu = ghiChu;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public BigDecimal getTienShip() {
        return tienShip;
    }

    public void setTienShip(BigDecimal tienShip) {
        this.tienShip = tienShip;
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

<<<<<<< HEAD
}
=======
    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    @Override
    public String toString() {
        return  maHD;
    }

    


}
>>>>>>> origin/master
