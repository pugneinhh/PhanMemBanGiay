package Services;

import DomainModels.HoaDon;
import ViewModels.HoaDonViewModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import responsitories.HoaDonResponsitory;
import responsitories.HoaDonresbonsitory;

/**
 *
 * @author HP
 */
public class hoadonservice {

    private final HoaDonResponsitory hd = new HoaDonResponsitory();


    public ArrayList<HoaDonViewModel> getAllhoadon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        ArrayList<HoaDonViewModel> kh = hd.getAllhoadon();
        for (HoaDonViewModel x : kh) {
            list.add(new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgayMua(), x.getThanhTien(), x.getIdKM(), x.getGhiChu(), x.getNgaytao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<HoaDonViewModel> getHoaDonCho() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        ArrayList<HoaDonViewModel> kh = hd.getHoaDonCho();
        for (HoaDonViewModel x : kh) {
            list.add(new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgayMua(), x.getThanhTien(), x.getIdKM(), x.getGhiChu(), x.getNgaytao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

//    public ArrayList<HoaDonViewModel> gettheoidhd(String id) {
//        return hd.gethdByID(id);
//    }

    public HoaDonViewModel insertHoaDon(HoaDonViewModel h) {
        var x = hd.inserthoadon(new HoaDon(h.getIdHD(), h.getMaHD(), h.getIdNV(), h.getIdKH(), h.getNgaytao(), h.getTrangThai()));
        return new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgaytao(), x.getTrangThai());

    }
    public HoaDonViewModel updateHoaDon(HoaDonViewModel h) {
        var x = hd.updatehoadon(new HoaDon(h.getIdHD(), h.getMaHD(), h.getIdNV(), h.getIdKH(), h.getNgaytao(), h.getTrangThai()));
        return new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgaytao(), x.getTrangThai());

    }
}