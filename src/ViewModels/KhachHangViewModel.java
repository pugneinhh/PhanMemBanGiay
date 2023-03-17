/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author HoiVN
 */
public class KhachHangViewModel {
    private String maKH;
    private String tenKH;
    private String loaiKH;
    private String diaChi;
    private String gioiTinh;
    private String email;
    private String sdt;
    private Date ngaySinh;
    private Date ngayThamGia;
    private int trangThai;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String maKH, String tenKH, String loaiKH, String diaChi, String gioiTinh, String email, String sdt, Date ngaySinh, Date ngayThamGia, int trangThai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.loaiKH = loaiKH;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.ngayThamGia = ngayThamGia;
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHangViewModel{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", loaiKH=" + loaiKH + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", email=" + email + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + ", ngayThamGia=" + ngayThamGia + ", trangThai=" + trangThai + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{maKH,tenKH,loaiKH,diaChi,gioiTinh,
            email,sdt,ngaySinh,ngayThamGia,trangThai==1?"Còn hoạt động":"Ngừng hoạt động"           
        };
    }
}
