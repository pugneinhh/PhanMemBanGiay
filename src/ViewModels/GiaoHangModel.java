/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class GiaoHangModel {

    private String idGiaoHang;
    private HoaDon idHD;
    private KhachHang idKH;
    private String sdt;
    private String diaChi;
    private BigDecimal tienHang;
    private BigDecimal tienShip;
    private BigDecimal tongTien;
    private Date ngayGiao;
    private Date ngayNhan;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;
    private String ghiChu;

    public GiaoHangModel() {
    }

    public GiaoHangModel(String idGiaoHang, HoaDon idHD, KhachHang idKH, String sdt, String diaChi, BigDecimal tienHang, BigDecimal tienShip, BigDecimal tongTien, Date ngayGiao, Date ngayNhan, Date ngayTao, Date ngaySua, int trangThai, String ghiChu) {
        this.idGiaoHang = idGiaoHang;
        this.idHD = idHD;
        this.idKH = idKH;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tienHang = tienHang;
        this.tienShip = tienShip;
        this.tongTien = tongTien;
        this.ngayGiao = ngayGiao;
        this.ngayNhan = ngayNhan;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    

  

    public String getIdGiaoHang() {
        return idGiaoHang;
    }

    public void setIdGiaoHang(String idGiaoHang) {
        this.idGiaoHang = idGiaoHang;
    }

    public HoaDon getIdHD() {
        return idHD;
    }

    public void setIdHD(HoaDon idHD) {
        this.idHD = idHD;
    }

    public KhachHang getIdKH() {
        return idKH;
    }

    public void setIdKH(KhachHang idKH) {
        this.idKH = idKH;
    }

   

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public BigDecimal getTienHang() {
        return tienHang;
    }

    public void setTienHang(BigDecimal tienHang) {
        this.tienHang = tienHang;
    }

    public BigDecimal getTienShip() {
        return tienShip;
    }

    public void setTienShip(BigDecimal tienShip) {
        this.tienShip = tienShip;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
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

    public String trangthai() {
        if (trangThai == 0) {
            return "Chờ Giao Hàng";
        } else if (trangThai == 1) {
            return "Đang Giao Hàng";
        } else if (trangThai == 2) {
            return "Giao Hàng";
        } else if (trangThai == 3) {
            return "Hủy Giao Hàng";
        } else {
            return null;

        }

    }

}

