/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.entity;

/**
 *
 * @author 98tae
 */
public class KhuyenMai {

    private int MaKM, MaSP;
    private double GiamToiDa, GiaTri,HDToiThieu;
    private String TenKM, NgayBD, NgayKT;
    private boolean HinhThucAD, TrangThai, LoaiKM;

    public KhuyenMai() {
    }

    public KhuyenMai(int MaKM, int MaSP, double GiamToiDa, double GiaTri, String TenKM, String NgayBD, String NgayKT, boolean HinhThucAD, boolean TrangThai, boolean LoaiKM) {
        this.MaKM = MaKM;
        this.MaSP = MaSP;
        this.GiamToiDa = GiamToiDa;
        this.GiaTri = GiaTri;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.HinhThucAD = HinhThucAD;
        this.TrangThai = TrangThai;
        this.LoaiKM = LoaiKM;
    }

    public KhuyenMai(int MaSP, double GiamToiDa, double GiaTri, String TenKM, String NgayBD, String NgayKT, boolean HinhThucAD, boolean LoaiKM) {
        this.MaSP = MaSP;
        this.GiamToiDa = GiamToiDa;
        this.GiaTri = GiaTri;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.HinhThucAD = HinhThucAD;
        this.LoaiKM = LoaiKM;
    }

    public KhuyenMai(int MaKM, double GiamToiDa, double GiaTri, String TenKM, String NgayBD, String NgayKT, boolean HinhThucAD, boolean TrangThai, boolean LoaiKM) {
        this.MaKM = MaKM;
        this.GiamToiDa = GiamToiDa;
        this.GiaTri = GiaTri;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.HinhThucAD = HinhThucAD;
        this.LoaiKM = LoaiKM;
    }

    public KhuyenMai(double GiamToiDa, double GiaTri, double HDToiThieu, String TenKM, String NgayBD, String NgayKT, boolean HinhThucAD, boolean LoaiKM) {
        this.GiamToiDa = GiamToiDa;
        this.GiaTri = GiaTri;
        this.HDToiThieu = HDToiThieu;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.HinhThucAD = HinhThucAD;
        this.LoaiKM = LoaiKM;
    }


    public boolean isLoaiKM() {
        return LoaiKM;
    }

    public void setLoaiKM(boolean LoaiKM) {
        this.LoaiKM = LoaiKM;
    }

    public int getMaKM() {
        return MaKM;
    }

    public void setMaKM(int MaKM) {
        this.MaKM = MaKM;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public double getGiamToiDa() {
        return GiamToiDa;
    }

    public void setGiamToiDa(double GiamToiDa) {
        this.GiamToiDa = GiamToiDa;
    }

    public double getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(double GiaTri) {
        this.GiaTri = GiaTri;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public boolean isHinhThucAD() {
        return HinhThucAD;
    }

    public void setHinhThucAD(boolean HinhThucAD) {
        this.HinhThucAD = HinhThucAD;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public double getHDToiThieu() {
        return HDToiThieu;
    }

    public void setHDToiThieu(double HDToiThieu) {
        this.HDToiThieu = HDToiThieu;
    }

    @Override
    public String toString() {
        return this.MaKM + " " + this.TenKM;
    }

}
