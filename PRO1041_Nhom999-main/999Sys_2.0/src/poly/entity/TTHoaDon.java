/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

/**
 *
 * @author Phương Linh
 */

public class TTHoaDon {
    private int maTT;
    private String tenTT;

    public TTHoaDon(int maTT, String tenTT) {
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
        return this.tenTT;
    }

    public TTHoaDon() {
    }
    
}
