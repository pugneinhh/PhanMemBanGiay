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
public class ChatLieu {

    private String idCL;
    private String maCL;
    private String tenCL;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public ChatLieu() {
    }

    public ChatLieu(String idCL) {
        this.idCL = idCL;
    }

    public ChatLieu(String maCL, String tenCL, int trangThai) {
        this.maCL = maCL;
        this.tenCL = tenCL;
        this.trangThai = trangThai;
    }
    
    public ChatLieu(String idCL, String maCL, String tenCL, Date ngayTao, Date ngaySua, int trangThai) {
        this.idCL = idCL;
        this.maCL = maCL;
        this.tenCL = tenCL;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdCL() {
        return idCL;
    }

    public void setIdCL(String idCL) {
        this.idCL = idCL;
    }

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
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
        return tenCL;
    }

}
