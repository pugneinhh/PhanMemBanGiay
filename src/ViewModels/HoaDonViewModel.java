
package ViewModels;

import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import java.math.BigDecimal;
import java.util.Date;


public class HoaDonViewModel {
    private NhanVien idNV;
    private KhachHang idKH;
    private Date ngaymua;
    private BigDecimal thanhTien;
    private KhuyenMai idKM;
    private String ghiChu;
    private Date ngaySua;
     private Date ngaytao;
    private int trangThai;
    private String mahd;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(NhanVien idNV, KhachHang idKH, Date ngaymua, BigDecimal thanhTien, KhuyenMai idKM, String ghiChu, Date ngaySua, Date ngaytao, int trangThai, String mahd) {
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngaymua = ngaymua;
        this.thanhTien = thanhTien;
        this.idKM = idKM;
        this.ghiChu = ghiChu;
        this.ngaySua = ngaySua;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
        this.mahd = mahd;
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

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
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

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }


    
}
