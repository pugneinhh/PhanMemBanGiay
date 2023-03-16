/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class DanhMucModel {
     private String idDM;
    private String maDM;
    private String tenDM;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public DanhMucModel() {
    }

    public DanhMucModel(String idDM, String maDM, String tenDM, Date ngayTao, Date ngaySua, int trangThai) {
        this.idDM = idDM;
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public DanhMucModel(String maDM, String tenDM, int trangThai) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.trangThai = trangThai;
    }

    public String getIdDM() {
        return idDM;
    }

    public void setIdDM(String idDM) {
        this.idDM = idDM;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
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
        return  tenDM ;
    }
    
    
    
}
