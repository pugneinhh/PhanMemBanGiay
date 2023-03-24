/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author HoiVN
 */
public class GiaoHangModel {
    private HoaDon maHD;
    private NhanVien maNV;
    private KhachHang maKH;
    private KhachHang hoTen;
    private String sdt;
    private String diaChi;
    private Date ngayMua;
    private Date ngayGiao;
    private String giamGia;
    private BigDecimal tienShip;
    private BigDecimal thanhTien;
    private int trangThai;

    public GiaoHangModel() {
    }

    public GiaoHangModel(HoaDon maHD, NhanVien maNV, KhachHang maKH, KhachHang hoTen, String sdt, String diaChi, Date ngayMua, Date ngayGiao, String giamGia, BigDecimal tienShip, BigDecimal thanhTien, int trangThai) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngayMua = ngayMua;
        this.ngayGiao = ngayGiao;
        this.giamGia = giamGia;
        this.tienShip = tienShip;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public HoaDon getMaHD() {
        return maHD;
    }

    public void setMaHD(HoaDon maHD) {
        this.maHD = maHD;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public KhachHang getMaKH() {
        return maKH;
    }

    public void setMaKH(KhachHang maKH) {
        this.maKH = maKH;
    }

    public KhachHang getHoTen() {
        return hoTen;
    }

    public void setHoTen(KhachHang hoTen) {
        this.hoTen = hoTen;
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

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public BigDecimal getTienShip() {
        return tienShip;
    }

    public void setTienShip(BigDecimal tienShip) {
        this.tienShip = tienShip;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "GiaoHangModel{" + "maHD=" + maHD + ", maNV=" + maNV + ", maKH=" + maKH + ", hoTen=" + hoTen + ", sdt=" + sdt + ", diaChi=" + diaChi + ", ngayMua=" + ngayMua + ", ngayGiao=" + ngayGiao + ", giamGia=" + giamGia + ", tienShip=" + tienShip + ", thanhTien=" + thanhTien + ", trangThai=" + trangThai + '}';
    }
    
}
