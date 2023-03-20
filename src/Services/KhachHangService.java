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

    KhachHangResponsitory khr = new KhachHangResponsitory();

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
    }

    public KhachHangViewModel updateKhachHang(KhachHangViewModel khVM) {
        var x = khr.updateKhachHang(new KhachHang(khVM.getMaKH(), khVM.getLoaiKH(),
                khVM.getTenKH(), khVM.getDiaChi(), khVM.getGioiTinh(), khVM.getEmail(),
                khVM.getSdt(), khVM.getNgaySinh(), khVM.getNgayThamGia(), khVM.getTrangThai()));
        return new KhachHangViewModel(x.getMaKH(), x.getTenKH(), x.getLoaiKH(),
                x.getDiaChi(), x.getGioiTinh(), x.getEmail(), x.getSdt(), x.getNgaySinh(),
                x.getNgayThamGia(), x.getTrangThai());
    }

    public Integer deleteCV(String ma) {
        return khr.deleteCV(ma);
    }
}
