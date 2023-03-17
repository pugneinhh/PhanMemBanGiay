/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import ViewModels.SanPhamModel;
import java.util.ArrayList;
import responsitories.SanPhamResponsitory;

/**
 *
 * @author Asus
 */
public class SanPhamService {
    SanPhamResponsitory spr = new SanPhamResponsitory();

    public ArrayList<SanPhamModel> getAllSanPham() {
        ArrayList<SanPhamModel> list = new ArrayList<>();
        ArrayList<SanPham> sp = spr.getAllSanPham();
        for (SanPham x : sp) {
            list.add(new SanPhamModel(x.getIdSP(), x.getMaSP(), x.getTenSP(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public SanPhamModel insertSP(SanPhamModel spm) {
        ArrayList<SanPham> list = spr.getAllSanPham();
        for (SanPham sp : list) {
            if (sp.getMaSP().equalsIgnoreCase(spm.getMaSP())) {
                return null;
            }
        }
        var x = spr.insertSP(new SanPham(spm.getMaSP(), spm.getTenSP(), spm.getTrangThai()));
        return new SanPhamModel(x.getMaSP(), x.getTenSP(), x.getTrangThai());
    }

    public SanPhamModel updateSP(SanPhamModel spm) {
        var x = spr.updateSP(new SanPham(spm.getMaSP(), spm.getTenSP(), spm.getTrangThai()));
        return new SanPhamModel(x.getMaSP(), x.getTenSP(), x.getTrangThai());
    }

    public Integer deleteSP(String id) {
        return spr.deleteSP(id);
    }
}
