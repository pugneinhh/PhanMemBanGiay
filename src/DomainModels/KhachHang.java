/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author Phanh
 */
public class KhachHang {

    private String idKH;
    private String maKH;
    private String loaiKH;
    private String tenKH;
    private String diaChi;
    private String gioiTinh;
    private String email;
    private String sdt;
    private Date ngaySinh;
    private Date ngayThamGia;
    private int tichDiem;
    private int diemEXP;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public KhachHang() {
    }
    
    public KhachHang(String maKH, String loaiKH, String tenKH, String diaChi, String gioiTinh, String email, String sdt, Date ngaySinh, Date ngayThamGia, int trangThai) {
        this.maKH = maKH;
        this.loaiKH = loaiKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.ngayThamGia = ngayThamGia;
        this.trangThai = trangThai;
    }

    public KhachHang(String idKH, String maKH, String loaiKH, String tenKH, String diaChi, String gioiTinh, String email, String sdt, Date ngaySinh, Date ngayThamGia, int tichDiem, int diemEXP, Date ngayTao, Date ngaySua, int trangThai) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.loaiKH = loaiKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.ngayThamGia = ngayThamGia;
        this.tichDiem = tichDiem;
        this.diemEXP = diemEXP;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public KhachHang(String idKH, String maKH, String loaiKH, String tenKH, String diaChi, String gioiTinh, String email, String sdt, Date ngaySinh, Date ngayTao, int trangThai) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.loaiKH = loaiKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public int getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(int tichDiem) {
        this.tichDiem = tichDiem;
    }

    public int getDiemEXP() {
        return diemEXP;
    }

    public void setDiemEXP(int diemEXP) {
        this.diemEXP = diemEXP;
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

    @Override
    public String toString() {
        return tenKH;
    }
}
