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
public class MauSac {
    private String idMS;
    private String maMS;
    private String tenMS;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public MauSac() {
    }

    public MauSac(String idMS) {
        this.idMS = idMS;
    }

    public MauSac(String maMS, String tenMS, int trangThai) {
        this.maMS = maMS;
        this.tenMS = tenMS;
        this.trangThai = trangThai;
    }
    
    public MauSac(String idMS, String maMS, String tenMS, Date ngayTao, Date ngaySua, int trangThai) {
        this.idMS = idMS;
        this.maMS = maMS;
        this.tenMS = tenMS;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdMS() {
        return idMS;
    }

    public void setIdMS(String idMS) {
        this.idMS = idMS;
    }

    public String getMaMS() {
        return maMS;
    }

    public void setMaMS(String maMS) {
        this.maMS = maMS;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
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
        return tenMS;
    }

}
