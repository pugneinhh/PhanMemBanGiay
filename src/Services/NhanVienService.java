/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import ViewModels.NhanVienModel;
import java.util.ArrayList;
import responsitories.NhanVienResponsitory;

/**
 *
 * @author Phanh
 */
public class NhanVienService {

    NhanVienResponsitory nvr = new NhanVienResponsitory();

    public ArrayList<NhanVienModel> getAllNV() {
        ArrayList<NhanVienModel> list = new ArrayList<>();
        ArrayList<NhanVien> ds = nvr.getAllNV();
        for (NhanVien x : ds) {
            list.add(new NhanVienModel(x.getIdNV(), x.getMaNV(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getMatKhau(), x.getIdCV(), x.getHinh(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<NhanVienModel> getNVLam() {
        ArrayList<NhanVienModel> list = new ArrayList<>();
        ArrayList<NhanVien> ds = nvr.getNVLam();
        for (NhanVien x : ds) {
            list.add(new NhanVienModel(x.getIdNV(), x.getMaNV(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getMatKhau(), x.getIdCV(), x.getHinh(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<NhanVienModel> getNVNghi() {
        ArrayList<NhanVienModel> list = new ArrayList<>();
        ArrayList<NhanVien> ds = nvr.getNVNghi();
        for (NhanVien x : ds) {
            list.add(new NhanVienModel(x.getIdNV(), x.getMaNV(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getMatKhau(), x.getIdCV(), x.getHinh(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<NhanVienModel> getNVLamByCV(String tenCV,String sdt) {
        ArrayList<NhanVienModel> list = new ArrayList<>();
        ArrayList<NhanVien> ds = nvr.getNVLamByCV(tenCV,sdt);
        for (NhanVien x : ds) {
            list.add(new NhanVienModel(x.getIdNV(), x.getMaNV(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getMatKhau(), x.getIdCV(), x.getHinh(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<NhanVienModel> getNVNghiByCV(String tenCV,String sdt) {
        ArrayList<NhanVienModel> list = new ArrayList<>();
        ArrayList<NhanVien> ds = nvr.getNVLamByCV(tenCV,sdt);
        for (NhanVien x : ds) {
            list.add(new NhanVienModel(x.getIdNV(), x.getMaNV(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getMatKhau(), x.getIdCV(), x.getHinh(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    

    public NhanVienModel insertNV(NhanVienModel nvm) {
        ArrayList<NhanVien> ds = nvr.getAllNV();
        for (NhanVien nvien : ds) {
            if (nvien.getMaNV().equalsIgnoreCase(nvm.getMaNV())) {
                return null;
            }
        }
        var x = nvr.insertNV(new NhanVien(nvm.getIdNV(), nvm.getMaNV(), nvm.getHoTen(), nvm.getNgaySinh(), nvm.getGioiTinh(), nvm.getDiaChi(), nvm.getSdt(), nvm.getEmail(), nvm.getMatKhau(), nvm.getIdCV(), nvm.getHinh(), nvm.getNgayTao(), nvm.getNgaySua(), nvm.getTrangThai()));
        return new NhanVienModel(x.getIdNV(), x.getMaNV(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getMatKhau(), x.getIdCV(), x.getHinh(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());

    }

    public NhanVienModel updateNV(NhanVienModel nvm) {
        var x = nvr.updateNV(new NhanVien(nvm.getIdNV(), nvm.getMaNV(), nvm.getHoTen(), nvm.getNgaySinh(), nvm.getGioiTinh(), nvm.getDiaChi(), nvm.getSdt(), nvm.getEmail(), nvm.getMatKhau(), nvm.getIdCV(), nvm.getHinh(), nvm.getNgayTao(), nvm.getNgaySua(), nvm.getTrangThai()));
        return new NhanVienModel(x.getIdNV(), x.getMaNV(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getMatKhau(), x.getIdCV(), x.getHinh(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());

    }

    public Integer deleteNV(String id) {
        return nvr.deleteNV(id);
    }
}
