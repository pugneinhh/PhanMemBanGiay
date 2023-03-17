/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChiTietSanPham;
import ViewModels.ChiTietSanPhamModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import responsitories.ChiTietSanPhamResponsitory;

/**
 *
 * @author Asus
 */
public class ChiTietSanPhamService {
     ChiTietSanPhamResponsitory ctspr = new ChiTietSanPhamResponsitory();

    public ArrayList<ChiTietSanPhamModel> getAllChiTietSanPham() {
        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
        ArrayList<ChiTietSanPham> ctsp = ctspr.getAllChiTietSanPhams();
        for (ChiTietSanPham x : ctsp) {
            list.add(new ChiTietSanPhamModel(
                    x.getIdSP(),
                    x.getIdSP(), 
                    x.getSoLuong(), 
                    x.getIdSize(), x.getIdMS(),
                    x.getIdDC(), x.getIdCL(), x.getIdDM(),x.getGiaNhap(),
                    x.getGiaBan(),x.getIdCTSP(), x.getTrangThai(),x.getIdSP()));
        }
        return list;
    }

    public ChiTietSanPhamModel insertCTSP(ChiTietSanPhamModel ctspm) {
        ArrayList<ChiTietSanPham> list = ctspr.getAllChiTietSanPhams();
        for (ChiTietSanPham ctsp : list) {
            if (ctsp.getIdSP().getMaSP().equalsIgnoreCase(ctsp.getIdSP().getMaSP())) {
                return null;
            }
        }
        var x = ctspr.insertCTSP(new ChiTietSanPham(ctspm.getGiaNhap(), ctspm.getGiaBan(),ctspm.getSoluong(), ctspm.getTrangthai()));
        return new ChiTietSanPhamModel(x.getSoLuong(),x.getGiaNhap(), x.getGiaBan(), x.getTrangThai());
    }

    public ChiTietSanPhamModel updateCTSP(ChiTietSanPhamModel ctspm) {
        var x = ctspr.updateCTSP(new ChiTietSanPham(ctspm.getGiaNhap(), ctspm.getGiaBan(),ctspm.getSoluong(), ctspm.getTrangthai()));
       return new ChiTietSanPhamModel(x.getSoLuong(),x.getGiaNhap(), x.getGiaBan(), x.getTrangThai());
    }

    public Integer deleteCTSP(String id) {
        return ctspr.deleteCTSP(id);
    }
}