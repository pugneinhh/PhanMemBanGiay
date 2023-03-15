/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

/**
 *
 * @author NTV
 */
public class GiaoCa {
    private int maGiaoCa, maTT;
    private String maNVGiaoCa, maNVNhan, gioNhanCa, gioGiaoCa, ghiChuGC, ghiChuNC;
    private double tienCoSo, tienPhatSinh, doanhThuCa, tienDaThuHoi, tongTien;

    public GiaoCa() {
    }

    public GiaoCa(int maGiaoCa, int maTT, String maNVGiaoCa, String maNVNhan, String gioNhanCa, String gioGiaoCa, String ghiChuGC, String ghiChuNC, double tienCoSo, double tienPhatSinh, double doanhThuCa, double tienDaThuHoi, double tongTien) {
        this.maGiaoCa = maGiaoCa;
        this.maTT = maTT;
        this.maNVGiaoCa = maNVGiaoCa;
        this.maNVNhan = maNVNhan;
        this.gioNhanCa = gioNhanCa;
        this.gioGiaoCa = gioGiaoCa;
        this.ghiChuGC = ghiChuGC;
        this.ghiChuNC = ghiChuNC;
        this.tienCoSo = tienCoSo;
        this.tienPhatSinh = tienPhatSinh;
        this.doanhThuCa = doanhThuCa;
        this.tienDaThuHoi = tienDaThuHoi;
        this.tongTien = tongTien;
    }
    
    public GiaoCa(int maTT, String maNVGiaoCa, String maNVNhan, String gioNhanCa, String gioGiaoCa, String ghiChuGC, String ghiChuNC, double tienCoSo, double tienPhatSinh, double doanhThuCa, double tienDaThuHoi, double tongTien) {
        this.maTT = maTT;
        this.maNVGiaoCa = maNVGiaoCa;
        this.maNVNhan = maNVNhan;
        this.gioNhanCa = gioNhanCa;
        this.gioGiaoCa = gioGiaoCa;
        this.ghiChuGC = ghiChuGC;
        this.ghiChuNC = ghiChuNC;
        this.tienCoSo = tienCoSo;
        this.tienPhatSinh = tienPhatSinh;
        this.doanhThuCa = doanhThuCa;
        this.tienDaThuHoi = tienDaThuHoi;
        this.tongTien = tongTien;
    }

    public GiaoCa(String maNVGiaoCa, double tongTien) {
        this.maNVGiaoCa = maNVGiaoCa;
        this.tienCoSo = tongTien;
    }
    
    public GiaoCa(String maNVGiaoCa) {
        this.maNVGiaoCa = maNVGiaoCa;
    }
    
    public int getMaGiaoCa() {
        return maGiaoCa;
    }

    public void setMaGiaoCa(int maGiaoCa) {
        this.maGiaoCa = maGiaoCa;
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public String getMaNVGiaoCa() {
        return maNVGiaoCa;
    }

    public void setMaNVGiaoCa(String maNVGiaoCa) {
        this.maNVGiaoCa = maNVGiaoCa;
    }

    public String getMaNVNhan() {
        return maNVNhan;
    }

    public void setMaNVNhan(String maNVNhan) {
        this.maNVNhan = maNVNhan;
    }

    public String getGioNhanCa() {
        return gioNhanCa;
    }

    public void setGioNhanCa(String gioNhanCa) {
        this.gioNhanCa = gioNhanCa;
    }

    public String getGioGiaoCa() {
        return gioGiaoCa;
    }

    public void setGioGiaoCa(String gioGiaoCa) {
        this.gioGiaoCa = gioGiaoCa;
    }

    public String getGhiChuGC() {
        return ghiChuGC;
    }

    public void setGhiChuGC(String ghiChuGC) {
        this.ghiChuGC = ghiChuGC;
    }

    public String getGhiChuNC() {
        return ghiChuNC;
    }

    public void setGhiChuNC(String ghiChuNC) {
        this.ghiChuNC = ghiChuNC;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTienCoSo() {
        return tienCoSo;
    }

    public void setTienCoSo(double tienCoSo) {
        this.tienCoSo = tienCoSo;
    }

    public double getTienPhatSinh() {
        return tienPhatSinh;
    }

    public void setTienPhatSinh(double tienPhatSinh) {
        this.tienPhatSinh = tienPhatSinh;
    }

    public double getDoanhThuCa() {
        return doanhThuCa;
    }

    public void setDoanhThuCa(double doanhThuCa) {
        this.doanhThuCa = doanhThuCa;
    }

    public double getTienDaThuHoi() {
        return tienDaThuHoi;
    }

    public void setTienDaThuHoi(double tienDaThuHoi) {
        this.tienDaThuHoi = tienDaThuHoi;
    }
    
    
}
