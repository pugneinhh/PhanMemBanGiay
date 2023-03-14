/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

/**
 *
 * @author Admin
 */
public class Size {

    private String maSize;
    private String tenSize;

    private boolean trangThai;

    public Size() {
    }

    public Size(String maSize, String tenSize, boolean trangThai) {
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThai = trangThai;
    }

    
    public Size(String maSize, String tenSize) {
        this.maSize = maSize;
        this.tenSize = tenSize;
    }
    
    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return maSize;
    }

}
