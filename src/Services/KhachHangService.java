/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import ViewModels.KhachHangViewModel;
import java.util.ArrayList;
import responsitories.KhachHangResponsitory;

/**
 *
 * @author HoiVN
 */
public class KhachHangService {

    private final KhachHangResponsitory Khr;

    public KhachHangService() {
        this.Khr = new KhachHangResponsitory();
    }

    public ArrayList<KhachHangViewModel> getAllKhachHang() {
        return Khr.getAllKhachHang();
    }

    public KhachHangViewModel getKhachHangByMa(String ma) {
        return Khr.getKhachHangByMa(ma);
    }
    
    public ArrayList<KhachHangViewModel> getKHByGT(String gt) {
        return Khr.getKHByGT(gt);
    }
    
    public ArrayList<KhachHangViewModel> getKHByTrangThai(int TrangThai) {
        return Khr.getKHByTrangThai(TrangThai);
    }

    public Integer insertKhachHang(KhachHang kh) {
        return Khr.insertKhachHang(kh);
    }

    public Integer updateKhachHang(KhachHang kh) {
        return Khr.updateKhachHang(kh);
    }

    public Integer deleteCV(String ma) {
        return Khr.deleteCV(ma);
    }
}
