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
            list.add(new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    
    public ArrayList<ChiTietSanPhamModel> getChiTietSanPhamBan() {
        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
        ArrayList<ChiTietSanPham> ctsp = ctspr.getChiTietSanPhamBan();
        for (ChiTietSanPham x : ctsp) {
            list.add(new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<ChiTietSanPhamModel> getSPTheoGiaNhapLonHon(BigDecimal giaNhap) {
        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
        ArrayList<ChiTietSanPham> ctsp = ctspr.getSPTheoGiaNhapLonHon(giaNhap);
        for (ChiTietSanPham x : ctsp) {
            list.add(new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<ChiTietSanPhamModel> getSPTheoGiaNhapNhoHon(BigDecimal giaNhap) {
        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
        ArrayList<ChiTietSanPham> ctsp = ctspr.getSPTheoGiaNhapNhoHon(giaNhap);
        for (ChiTietSanPham x : ctsp) {
            list.add(new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<ChiTietSanPhamModel> getSPTheoGiaBanNhoHon(BigDecimal giaBan) {
        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
        ArrayList<ChiTietSanPham> ctsp = ctspr.getSPTheoGiaBanNhoHon(giaBan);
        for (ChiTietSanPham x : ctsp) {
            list.add(new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<ChiTietSanPhamModel> getSPTheoGiaBanLonHon(BigDecimal giaBan) {
        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
        ArrayList<ChiTietSanPham> ctsp = ctspr.getSPTheoGiaBanLonHon(giaBan);
        for (ChiTietSanPham x : ctsp) {
            list.add(new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<ChiTietSanPhamModel> getChiTietSanPhamByQR(String ma) {
        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
        ArrayList<ChiTietSanPham> ctsp = ctspr.getChiTietSanPhamByQR(ma);
        for (ChiTietSanPham x : ctsp) {
            list.add(new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<ChiTietSanPhamModel> getChiTietSanPhamByDanhMuc(String danhMuc) {
        return ctspr.getChiTietSanPhamByDanhMuc(danhMuc);
    }

    public ArrayList<ChiTietSanPhamModel> getChiTietSanPhamByid(String ma) {
        return ctspr.getChiTietSanPhamByID(ma);
    }

    public ChiTietSanPham getChiTietSanPhamByidkmd(String ma) {
        return ctspr.getChiTietSanPhamByIDkmd(ma);

    }

    public ChiTietSanPhamModel insertCTSP(ChiTietSanPhamModel ctspm) {
        ArrayList<ChiTietSanPham> list = ctspr.getAllChiTietSanPhams();
        for (ChiTietSanPham ctsp : list) {
            if (ctsp.getMaQR() == ctspm.getMaQR()) {
                return null;
            }
        }
        var x = ctspr.insertCTSP(new ChiTietSanPham(ctspm.getIdSP(), ctspm.getIdKM(), ctspm.getGiaNhap(), ctspm.getGiaBan(), ctspm.getMaQR(), ctspm.getHinhanh(), ctspm.getSoLuong(), ctspm.getIdDM(), ctspm.getIdSize(), ctspm.getIdMS(), ctspm.getIdCL(), ctspm.getIdDC(), ctspm.getMota(), ctspm.getTrangThai()));
        return new ChiTietSanPhamModel(ctspm.getIdSP(), ctspm.getIdKM(), ctspm.getGiaNhap(), ctspm.getGiaBan(), ctspm.getMaQR(), ctspm.getHinhanh(), ctspm.getSoLuong(), ctspm.getIdDM(), ctspm.getIdSize(), ctspm.getIdMS(), ctspm.getIdCL(), ctspm.getIdDC(), ctspm.getMota(), ctspm.getTrangThai());
    }

    public ChiTietSanPhamModel updateCTSP(ChiTietSanPhamModel ctspm) {
        var x = ctspr.updateCTSP(new ChiTietSanPham(ctspm.getIdSP(), ctspm.getIdKM(), ctspm.getGiaNhap(), ctspm.getGiaBan(), ctspm.getMaQR(), ctspm.getHinhanh(), ctspm.getSoLuong(), ctspm.getIdDM(), ctspm.getIdSize(), ctspm.getIdMS(), ctspm.getIdCL(), ctspm.getIdDC(), ctspm.getMota(), ctspm.getTrangThai()));
        return new ChiTietSanPhamModel(ctspm.getIdSP(), ctspm.getIdKM(), ctspm.getGiaNhap(), ctspm.getGiaBan(), ctspm.getMaQR(), ctspm.getHinhanh(), ctspm.getSoLuong(), ctspm.getIdDM(), ctspm.getIdSize(), ctspm.getIdMS(), ctspm.getIdCL(), ctspm.getIdDC(), ctspm.getMota(), ctspm.getTrangThai());
    }

    public ChiTietSanPhamModel updateKM(ChiTietSanPhamModel ctspm) {
        var x = ctspr.updateKM(new ChiTietSanPham(ctspm.getIdKM(), ctspm.getIdDM()));
        return new ChiTietSanPhamModel(ctspm.getIdKM(), ctspm.getIdDM());

    }

    public Integer deleteCTSP(String qr) {
        return ctspr.deleteCTSP(qr);
    }

    public ChiTietSanPhamModel updateByID1(ChiTietSanPhamModel ctspm) {
        var x = ctspr.updateByID1(new ChiTietSanPham(ctspm.getIdCTSP(), ctspm.getIdSP(), ctspm.getIdKM(), ctspm.getGiaNhap(), ctspm.getGiaBan(), ctspm.getMaQR(), ctspm.getHinhanh(), ctspm.getSoLuong(), ctspm.getIdDM(), ctspm.getIdSize(), ctspm.getIdMS(), ctspm.getIdCL(), ctspm.getIdDC(), ctspm.getMota(), ctspm.getNgayTao(), ctspm.getNgaySua(), ctspm.getTrangThai()));
        System.out.println(x.getIdCTSP() + " " + x.getIdKM());
        return new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());
    }

    public ChiTietSanPhamModel update_ThanhToan(ChiTietSanPhamModel ctspm) {
        var x = ctspr.update_ThanhToan(new ChiTietSanPham(ctspm.getIdCTSP(), ctspm.getIdSP(), ctspm.getIdKM(), ctspm.getGiaNhap(), ctspm.getGiaBan(), ctspm.getMaQR(), ctspm.getHinhanh(), ctspm.getSoLuong(), ctspm.getIdDM(), ctspm.getIdSize(), ctspm.getIdMS(), ctspm.getIdCL(), ctspm.getIdDC(), ctspm.getMota(), ctspm.getNgayTao(), ctspm.getNgaySua(), ctspm.getTrangThai()));
        System.out.println(x.getIdCTSP() + " " + x.getIdKM());
        return new ChiTietSanPhamModel(x.getIdCTSP(), x.getIdSP(), x.getIdKM(), x.getGiaNhap(), x.getGiaBan(), x.getMaQR(), x.getHinhanh(), x.getSoLuong(), x.getIdDM(), x.getIdSize(), x.getIdMS(), x.getIdCL(), x.getIdDC(), x.getMota(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());
    }
//     ChiTietSanPhamResponsitory ctspr = new ChiTietSanPhamResponsitory();
//
//    public ArrayList<ChiTietSanPhamModel> getAllChiTietSanPham() {
//        ArrayList<ChiTietSanPhamModel> list = new ArrayList<>();
//        ArrayList<ChiTietSanPham> ctsp = ctspr.getAllChiTietSanPhams();
//        for (ChiTietSanPham x : ctsp) {
//            list.add(new ChiTietSanPhamModel(
//                    x.getIdSP(),
//                    x.getIdSP(), 
//                    x.getSoLuong(), 
//                    x.getIdSize(), x.getIdMS(),
//                    x.getIdDC(), x.getIdCL(), x.getIdDM(),x.getGiaNhap(),
//                    x.getGiaBan(),x.getIdCTSP(), x.getTrangThai(),x.getIdSP()));
//        }
//        return list;
//    }
//
//    public ChiTietSanPhamModel insertCTSP(ChiTietSanPhamModel ctspm) {
//        ArrayList<ChiTietSanPham> list = ctspr.getAllChiTietSanPhams();
//        for (ChiTietSanPham ctsp : list) {
//            if (ctsp.getIdSP().getMaSP().equalsIgnoreCase(ctsp.getIdSP().getMaSP())) {
//                return null;
//            }
//        }
//        //var x = ctspr.insertCTSP(new ChiTietSanPham(ctspm.getGiaNhap(), ctspm.getGiaBan(),ctspm.getSoluong(), ctspm.getTrangthai()));
//       // return new ChiTietSanPhamModel(x.getSoLuong(),x.getGiaNhap(), x.getGiaBan(), x.getTrangThai());
//    }
//
//    public ChiTietSanPhamModel updateCTSP(ChiTietSanPhamModel ctspm) {
//        //var x = ctspr.updateCTSP(new ChiTietSanPham(ctspm.getGiaNhap(), ctspm.getGiaBan(),ctspm.getSoluong(), ctspm.getTrangthai()));
//       //return new ChiTietSanPhamModel(x.getSoLuong(),x.getGiaNhap(), x.getGiaBan(), x.getTrangThai());
//    }
//
//    public Integer deleteCTSP(String id) {
//        return ctspr.deleteCTSP(id);
//    }
}
