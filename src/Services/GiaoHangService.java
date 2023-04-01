/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.GiaoHang;
import ViewModels.GiaoHangModel;
import ViewModels.LichSuGiaoHangModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import responsitories.GiaoHangResponsitory;

/**
 *
 * @author Asus
 */
public class GiaoHangService {

    GiaoHangResponsitory ghr = new GiaoHangResponsitory();

    public ArrayList<GiaoHangModel> getAllGiaoHang() {
        ArrayList<GiaoHangModel> list = new ArrayList<>();
        ArrayList<GiaoHang> gh = ghr.getAllGiaoHang();
        for (GiaoHang x : gh) {

            list.add(new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(),  x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
      
        }
        return list;
    }

    public GiaoHangModel insertGH(GiaoHangModel ghm) {
        ArrayList<GiaoHang> list = ghr.getAllGiaoHang();
        for (GiaoHang gh : list) {
            if (gh.getIdGiaoHang().equalsIgnoreCase(ghm.getIdGiaoHang())) {
                return null;
            }
        }
        var x = ghr.insertGH(new GiaoHang(ghm.getIdGiaoHang(), ghm.getIdHD(), ghm.getIdKH(),  ghm.getSdt(), ghm.getDiaChi(), ghm.getTienHang(), ghm.getTienShip(), ghm.getTongTien(), ghm.getNgayGiao(), ghm.getNgayNhan(), ghm.getNgayTao(), ghm.getNgaySua(), ghm.getTrangThai()));
        return new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(), x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());

    }

    public GiaoHangModel updateChoGH(GiaoHangModel ghm) {

        var x = ghr.updateChoGH(new GiaoHang(ghm.getIdGiaoHang(), ghm.getIdHD(), ghm.getIdKH(), ghm. getSdt(), ghm.getDiaChi(), ghm.getTienHang(), ghm.getTienShip(), ghm.getTongTien(), ghm.getNgayGiao(), ghm.getNgayNhan(), ghm.getNgayTao(), ghm.getNgaySua(), ghm.getTrangThai()));
        return new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(),  x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());

    }
    
     public GiaoHangModel updateDangGH(GiaoHangModel ghm) {

        var x = ghr.updateDangGH(new GiaoHang(ghm.getIdGiaoHang(), ghm.getIdHD(), ghm.getIdKH(),  ghm.getSdt(), ghm.getDiaChi(), ghm.getTienHang(), ghm.getTienShip(), ghm.getTongTien(), ghm.getNgayGiao(), ghm.getNgayNhan(), ghm.getNgayTao(), ghm.getNgaySua(), ghm.getTrangThai()));
        return new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(), x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());

    }
     
      public GiaoHangModel updateHuyGH(GiaoHangModel ghm) {

        var x = ghr.updateHuyGH(new GiaoHang(ghm.getIdGiaoHang(), ghm.getIdHD(), ghm.getIdKH(),  ghm.getSdt(), ghm.getDiaChi(), ghm.getTienHang(), ghm.getTienShip(), ghm.getTongTien(), ghm.getNgayGiao(), ghm.getNgayNhan(), ghm.getNgayTao(), ghm.getNgaySua(), ghm.getTrangThai()));
        return new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(),  x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai());

    }

    public Integer deleteKM(String id) {
        return ghr.deleteGH(id);
    }

    public ArrayList<GiaoHangModel> DangGiaoHang() {
        ArrayList<GiaoHangModel> list = new ArrayList<>();
        ArrayList<GiaoHang> gh = ghr.DangGiaoHang();
        for (GiaoHang x : gh) {

            list.add(new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(), x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<GiaoHangModel> HuyGiaoHang() {
        ArrayList<GiaoHangModel> list = new ArrayList<>();
        ArrayList<GiaoHang> gh = ghr.HuyGiaoHang();
        for (GiaoHang x : gh) {

            list.add(new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(),  x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<GiaoHangModel> GiaoHang() {
        ArrayList<GiaoHangModel> list = new ArrayList<>();
        ArrayList<GiaoHang> gh = ghr.GiaoHang();
        for (GiaoHang x : gh) {

            list.add(new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(),  x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<GiaoHangModel> ChoGiaoHang() {
        ArrayList<GiaoHangModel> list = new ArrayList<>();
        ArrayList<GiaoHang> gh = ghr.ChoGiaoHang();
        for (GiaoHang x : gh) {

            list.add(new GiaoHangModel(x.getIdGiaoHang(), x.getIdHD(), x.getIdKH(),  x.getSdt(), x.getDiaChi(), x.getTienHang(), x.getTienShip(), x.getTongTien(), x.getNgayGiao(), x.getNgayNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

}

