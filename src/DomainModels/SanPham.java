/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Phanh
 */
public class SanPham {

    private String idSP;
    private String maSP;
    private String tenSP;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
    }

    public SanPham(String idSP, String maSP, String tenSP, Date ngayTao, Date ngaySua, int trangThai) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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

}
