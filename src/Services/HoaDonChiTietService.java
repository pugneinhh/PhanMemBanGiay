/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ViewModels.GiaoHangModel;
import ViewModels.HoaDonChiTiet_CTSanPham;
import java.util.ArrayList;
import responsitories.HoaDonChiTietResponsitory;

/**
 *
 * @author HoiVN
 */
public class HoaDonChiTietService {
    public HoaDonChiTietResponsitory hoaDonChiTietResponsitory;

    public HoaDonChiTietService() {
        this.hoaDonChiTietResponsitory = new HoaDonChiTietResponsitory();
    }
        
    public ArrayList<HoaDonChiTiet_CTSanPham> getAllHoaDonCTSP() {
        return hoaDonChiTietResponsitory.getAllHoaDonCTSP();
    }
    
    public ArrayList<GiaoHangModel> getAllHoaDonGiaoHang() {
        return hoaDonChiTietResponsitory.getAllHoaDonGiaoHang();
    }
}
