package ViewModels;

import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import java.math.BigDecimal;
import java.util.Date;

public class HoaDonViewModel {

    private String idHD;
    private String maHD;
    private NhanVien idNV;
    private KhachHang idKH;
    private Date ngayMua;
    private BigDecimal thanhTien;
    private KhuyenMai idKM;
    private String ghiChu;
    private Date ngaySua;
    private Date ngaytao;
    private int trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngayMua, BigDecimal thanhTien, KhuyenMai idKM, String ghiChu, Date ngaySua, Date ngaytao, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngayMua = ngayMua;
        this.thanhTien = thanhTien;
        this.idKM = idKM;
        this.ghiChu = ghiChu;
        this.ngaySua = ngaySua;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
    }

    public HoaDonViewModel(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngaytao, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
    }
    public HoaDonViewModel(String idHD, String maHD, NhanVien idNV, KhachHang idKH, Date ngaytao,String ghiChu, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngaytao = ngaytao;
        this.ghiChu=ghiChu;
        this.trangThai = trangThai;
    }

    public HoaDonViewModel(String idHD, String maHD, NhanVien idNV, KhachHang idKH, BigDecimal thanhTien, Date ngaytao, int trangThai) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.thanhTien = thanhTien;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
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

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
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

    public String trangthai() {
        if (trangThai == 1) {
            return "Đã thanh toán";
        } else if (trangThai == 2) {
            return "Hủy hóa đơn";
        } else {
            return null;
        }
    }
    
}
