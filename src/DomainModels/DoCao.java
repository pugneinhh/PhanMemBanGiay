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
public class DoCao {
    private String idDC;
    private String maDC;
    private String tenDC;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public DoCao() {
    }

    public DoCao(String maDC, String tenDC, int trangThai) {
        this.maDC = maDC;
        this.tenDC = tenDC;
        this.trangThai = trangThai;
    }
    
    public DoCao(String idDC, String maDC, String tenDC, Date ngayTao, Date ngaySua, int trangThai) {
        this.idDC = idDC;
        this.maDC = maDC;
        this.tenDC = tenDC;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdDC() {
        return idDC;
    }

    public void setIdDC(String idDC) {
        this.idDC = idDC;
    }

    public String getMaDC() {
        return maDC;
    }

    public void setMaDC(String maDC) {
        this.maDC = maDC;
    }

    public String getTenDC() {
        return tenDC;
    }

    public void setTenDC(String tenDC) {
        this.tenDC = tenDC;
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
        return tenDC;
    }

}
