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
public class TrangThaiGiaoCa {
    private int maTT;
    private String tenTT;

    public TrangThaiGiaoCa() {
    }

    public TrangThaiGiaoCa(int maTT, String tenTT) {
        this.maTT = maTT;
        this.tenTT = tenTT;
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public String getTenTT() {
        return tenTT;
    }

    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }

    @Override
    public String toString() {
        return "Trạng thái: "  + tenTT;
    }
    
}
