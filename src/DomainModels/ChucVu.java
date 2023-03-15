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
public class ChucVu {
    private String idCV;
    private String maCV;
    private String tenCV;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public ChucVu() {
    }

    public ChucVu(String maCV, String tenCV, int trangThai) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.trangThai = trangThai;
    }
    
    public ChucVu(String idCV, String maCV, String tenCV, Date ngayTao, Date ngaySua, int trangThai) {
        this.idCV = idCV;
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
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
        return tenCV ;
    }
    
}
