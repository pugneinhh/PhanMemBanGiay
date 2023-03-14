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
public class NhanVien {

    private String maNV, passWord, hoTen, ngSinh;
    private boolean gioiTinh;
    private String Email, SDT, diaChi, hinhAnh;
    private int vaiTro;
    private String ngayTao;
    private boolean trangThai;

    public NhanVien() {
    }

    public NhanVien(String maNV, String passWord, String hoTen, String ngSinh, boolean gioiTinh, String Email, String SDT, String diaChi, String hinhAnh, int vaiTro, String ngayTao, boolean trangThai) {
        this.maNV = maNV;
        this.passWord = passWord;
        this.hoTen = hoTen;
        this.ngSinh = ngSinh;
        this.gioiTinh = gioiTinh;
        this.Email = Email;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
        this.vaiTro = vaiTro;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(String ngSinh) {
        this.ngSinh = ngSinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return vaiTro == 101? "Quản lý: " + hoTen : "Nhân viên: " + hoTen;
    }
    
    
}
