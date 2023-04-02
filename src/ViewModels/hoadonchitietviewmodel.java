package ViewModels;

import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import java.math.BigDecimal;

public class hoadonchitietviewmodel {

    private String idHDCT;
    private HoaDon idHD;
    private ChiTietSanPham idCTSP;
    private int soLuong;
    private BigDecimal donGia;

    public hoadonchitietviewmodel() {
    }

    public hoadonchitietviewmodel(String idHDCT, HoaDon idHD, ChiTietSanPham idCTSP, int soLuong, BigDecimal donGia) {
        this.idHDCT = idHDCT;
        this.idHD = idHD;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public hoadonchitietviewmodel(HoaDon idHD, ChiTietSanPham idCTSP, int soLuong, BigDecimal donGia) {
        this.idHD = idHD;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(String idHDCT) {
        this.idHDCT = idHDCT;
    }

    public HoaDon getIdHD() {
        return idHD;
    }

    public void setIdHD(HoaDon idHD) {
        this.idHD = idHD;
    }

    public ChiTietSanPham getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(ChiTietSanPham idCTSP) {
        this.idCTSP = idCTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

}