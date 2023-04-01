/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ViewModels.LichSuGiaoHangModel;
import ViewModels.HoaDonChiTiet_CTSanPham;
import java.util.ArrayList;
import responsitories.HoaDonChiTietLichSuResponsitory;

/**
 *
 * @author HoiVN
 */
public class HoaDonChiTietLichSuService {
    public HoaDonChiTietLichSuResponsitory hoaDonChiTietResponsitory;

    public HoaDonChiTietLichSuService() {
        this.hoaDonChiTietResponsitory = new HoaDonChiTietLichSuResponsitory();
    }
        
    public ArrayList<HoaDonChiTiet_CTSanPham> getAllHoaDonCTSP() {
        return hoaDonChiTietResponsitory.getAllHoaDonCTSP();
    }
    
    public ArrayList<LichSuGiaoHangModel> getAllHoaDonGiaoHang() {
        return hoaDonChiTietResponsitory.getAllHoaDonGiaoHang();
    }
}
