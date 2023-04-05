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
    public ArrayList<HoaDonViewModel> gethoadonCho() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        ArrayList<HoaDonViewModel> kh = hd.gethoadonCho();
        for (HoaDonViewModel x : kh) {
            list.add(new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgayMua(), x.getThanhTien(), x.getIdKM(), x.getGhiChu(), x.getNgaytao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ArrayList<HoaDonViewModel> getAllhoadonByTrangThai() {
        return hd.getAllhoadonByTrangThai();
    }
    public ArrayList<HoaDonViewModel> getAllhoadonThanhToan() {
        return hd.getAllhoadonThanhToan();
    }
    public ArrayList<HoaDonViewModel> getAllhoadonHuy() {
        return hd.getAllhoadonHuy();
    }

    public HoaDonViewModel insertHoaDon(HoaDonViewModel h) {
        var x = hd.inserthoadon(new HoaDon(h.getIdHD(), h.getMaHD(), h.getIdNV(), h.getIdKH(), h.getNgaytao(), h.getTrangThai()));
        return new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgaytao(), x.getTrangThai());

    }

    public HoaDonViewModel updateHoaDon(HoaDonViewModel h) {
        var x = hd.updatehoadon(new HoaDon(h.getIdHD(), h.getMaHD(), h.getIdNV(), h.getIdKH(), h.getNgaytao(), h.getTrangThai()));
        return new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgaytao(), x.getTrangThai());

    }

    public HoaDonViewModel updateHoaDon_ThanhToan(HoaDonViewModel h) {
        var x = hd.updatehoadon_thanhtoan(new HoaDon(h.getIdHD(), h.getMaHD(), h.getIdNV(), h.getIdKH(), h.getNgayMua(), h.getThanhTien(), h.getIdKM(), h.getGhiChu(), h.getNgaytao(), h.getNgaySua(), h.getTrangThai(),h.getHinhThucThanhToan()));
        return new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgayMua(), x.getThanhTien(), x.getIdKM(), x.getGhiChu(), x.getNgaytao(), x.getNgaySua(), x.getTrangThai(),x.getHinhThucThanhToan());

    }


    public HoaDonViewModel updateHoaDon_HUY(HoaDonViewModel h) {
        var x = hd.updatehoadon_huy(new HoaDon(h.getIdHD(), h.getMaHD(), h.getIdNV(), h.getIdKH(), h.getNgaytao(), h.getTrangThai()));
        return new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgaytao(), x.getTrangThai());
    }
    public HoaDonViewModel updateHoaDon_HuyKH(HoaDonViewModel h) {
        var x = hd.updatehoadon_huyKH(new HoaDon(h.getIdHD(), h.getMaHD(), h.getIdNV(), h.getIdKH(), h.getNgaytao(), h.getTrangThai()));
        return new HoaDonViewModel(x.getIdHD(), x.getMaHD(), x.getIdNV(), x.getIdKH(), x.getNgaytao(), x.getTrangThai());
    }
//        public HoaDonViewModel gethdBymaHD(String maHD) {
//        return hd.gethdBymaHD(maHD);
//    }
}
