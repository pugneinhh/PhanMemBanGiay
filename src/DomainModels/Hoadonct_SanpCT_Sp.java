/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author HP
 */
public class Hoadonct_SanpCT_Sp {

    private String maSP;
    private String tenSP;
    private int sl;
    private BigDecimal donGia;
    private String idSP;

    public Hoadonct_SanpCT_Sp() {
    }

    public Hoadonct_SanpCT_Sp(String maSP, String tenSP, int sl, BigDecimal donGia, String idSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.sl = sl;
        this.donGia = donGia;
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

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

}
