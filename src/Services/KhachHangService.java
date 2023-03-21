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
        ArrayList<KhachHangViewModel> list = new ArrayList<>();
        ArrayList<KhachHang> kh = khr.getAllKhachHang();
        for (KhachHang x : kh) {
            list.add(new KhachHangViewModel(x.getMaKH(), x.getTenKH(), x.getLoaiKH(),
                    x.getDiaChi(), x.getGioiTinh(), x.getEmail(), x.getSdt(), x.getNgaySinh(),
                    x.getNgayThamGia(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<KhachHangViewModel> gettheomakh(String SDT){
        return khr.getTheoSDT(SDT);
    }
     public String getIDHoaDon(String maHD) {
        return khr.getIDkhachhang(maHD);
    }
    public KhachHangViewModel insertKhachHang(KhachHangViewModel khVM) {
        ArrayList<KhachHang> list = khr.getAllKhachHang();
        for (KhachHang kh : list) {
            if (kh.getMaKH().equalsIgnoreCase(khVM.getMaKH())) {
                return null;
            }
        }
        var x = khr.insertKhachHang(new KhachHang(khVM.getMaKH(), khVM.getLoaiKH(),
                khVM.getTenKH(), khVM.getDiaChi(), khVM.getGioiTinh(), khVM.getEmail(),
                khVM.getSdt(), khVM.getNgaySinh(), khVM.getNgayThamGia(), khVM.getTrangThai()));
        return new KhachHangViewModel(x.getMaKH(), x.getTenKH(), x.getLoaiKH(),
                x.getDiaChi(), x.getGioiTinh(), x.getEmail(), x.getSdt(), x.getNgaySinh(),
                x.getNgayThamGia(), x.getTrangThai());
=======
        return Khr.getAllKhachHang();
>>>>>>> bf2efa103aa04ba8f3c822f4da01bf432f420dff
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
