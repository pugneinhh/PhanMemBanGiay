/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.Hoadonct_SanpCT_Sp;
import ViewModels.KhachHangModel;
import ViewModels.hoadonchitietviewmodel;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import responsitories.HoaDonCTResbonsitory;

/**
 *
 * @author HP
 */
public class HoaDonChiTieservice {

    private final HoaDonCTResbonsitory hdctrs;

    public HoaDonChiTieservice() {
        this.hdctrs = new HoaDonCTResbonsitory();
    }

    public ArrayList<HoaDonChiTiet> getAllhoadon() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        ArrayList<DomainModels.HoaDonChiTiet> kh = hdctrs.getAllhoadonct();
        for (DomainModels.HoaDonChiTiet x : kh) {
            list.add(new DomainModels.HoaDonChiTiet(x.getIdCTSP(), x.getSoLuong(), x.getDonGia()));
        }
        return list;
    }

    public ArrayList<Hoadonct_SanpCT_Sp> gettheoMAhd(String MA) {
        return hdctrs.gethdByID(MA);
    }

    public HoaDon gettheoidhd(String id) {
        return hdctrs.getIDHoaDon(id);
    }

    public hoadonchitietviewmodel inserthdct(HoaDonChiTiet hd) {
        ArrayList<HoaDonChiTiet> list = hdctrs.getAllhoadonct();

        var x = hdctrs.inserthoadonct(new HoaDonChiTiet(hd.getIdHDCT(), hd.getIdHD(), hd.getIdCTSP(), hd.getDonGia(), hd.getSoLuong(), hd.getNgayBan(),
                hd.getNgayTao(), hd.getNgaySua(), hd.getTrangThai()));
        return new hoadonchitietviewmodel(x.getIdHD(), x.getIdCTSP(), x.getSoLuong(), x.getDonGia());
    }

    public boolean updateKhachHang(HoaDonChiTiet hd) {
        var x = hdctrs.updatehoadon(new HoaDonChiTiet(hd.getIdHDCT(), hd.getIdHD(), hd.getIdCTSP(), hd.getDonGia(), hd.getSoLuong(), hd.getNgayBan(),
                hd.getNgayTao(), hd.getNgaySua(), hd.getTrangThai()));
        return x;
    }
}
