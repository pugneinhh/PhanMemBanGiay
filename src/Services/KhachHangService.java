/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import ViewModels.KhachHangModel;
import java.util.ArrayList;
import responsitories.KhachHangResponsitory;

/**
 *
 * @author HoiVN
 */
public class KhachHangService {

    private final KhachHangResponsitory khr;

    public KhachHangService() {
        this.khr = new KhachHangResponsitory();
    }

    public ArrayList<KhachHangModel> getAllKhachHang() {
        ArrayList<KhachHangModel> list = new ArrayList<>();
        ArrayList<KhachHang> kh = khr.getAllKhachHang();
        for (KhachHang x : kh) {
            list.add(new KhachHangModel(x.getIdKH(), x.getMaKH(), x.getLoaiKH(), x.getTenKH(), x.getDiaChi(), x.getGioiTinh(), x.getEmail(), x.getSdt(), x.getNgaySinh(), x.getNgayThamGia(), x.getTichDiem(), x.getDiemEXP(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public KhachHangModel gettheomakh(String SDT){
        return khr.getKhachHangByid(SDT);
    }
     public ArrayList<KhachHangModel> gettheosdt(String SDT){
        return khr.getKhachHangBysdt(SDT);
    }
     public String getIDHoaDon(String maHD) {
        return khr.getIDkhachhang(maHD);
    }


    public KhachHangModel insertKhachHang(KhachHangModel khVM) {
        ArrayList<KhachHang> list = khr.getAllKhachHang();
        for (KhachHang kh : list) {
            if (kh.getMaKH().equalsIgnoreCase(khVM.getMaKH())) {
                return null;
            }
        }
        var x = khr.insertKhachHang(new KhachHang(khVM.getMaKH(), khVM.getLoaiKH(),
                khVM.getTenKH(), khVM.getDiaChi(), khVM.getGioiTinh(), khVM.getEmail(),
                khVM.getSdt(), khVM.getNgaySinh(), khVM.getNgayThamGia(), khVM.getTrangThai()));
        return new KhachHangModel(x.getMaKH(), x.getTenKH(), x.getLoaiKH(),
                x.getDiaChi(), x.getGioiTinh(), x.getEmail(), x.getSdt(), x.getNgaySinh(),
                x.getNgayThamGia(), x.getTrangThai());

    }

//
//    public KhachHang getKhachHangByMa(String ma) {
//        return khr.getKhachHangByMa(ma);
//    }
    


    public ArrayList<KhachHangModel> getKhachHangBysdt(String sdt) {
        return khr.getKhachHangBysdt(sdt);
    }

//    public String getIDHoaDon(String maHD) {
//        return khr.getIDkhachhang(maHD);
//    }
//
//    public KhachHangModel gettheomakh(String ma) {
//        return khr.gettheomakh(ma);
//    }


    public ArrayList<KhachHangModel> getKHByGT(String gt) {
        return khr.getKHByGT(gt);
    }

    public ArrayList<KhachHangModel> getKHByTrangThai(int TrangThai) {
        return khr.getKHByTrangThai(TrangThai);
    }

    public KhachHangModel updateKhachHang(KhachHangModel khVM) {
        var x = khr.updateKhachHang(new KhachHang(khVM.getMaKH(), khVM.getLoaiKH(),
                khVM.getTenKH(), khVM.getDiaChi(), khVM.getGioiTinh(), khVM.getEmail(),
                khVM.getSdt(), khVM.getNgaySinh(), khVM.getNgayThamGia(), khVM.getTrangThai()));
        return new KhachHangModel(x.getMaKH(), x.getTenKH(), x.getLoaiKH(),
                x.getDiaChi(), x.getGioiTinh(), x.getEmail(), x.getSdt(), x.getNgaySinh(),
                x.getNgayThamGia(), x.getTrangThai());
    }

    public Integer deleteCV(String ma) {
        return khr.deleteCV(ma);
    }
}
