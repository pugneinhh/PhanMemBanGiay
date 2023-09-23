/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.Hoadonct_SanpCT_Sp;
import DomainModels.KhachHang;
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
            list.add(new HoaDonChiTiet(x.getIdHDCT(), x.getIdHD(), x.getIdCTSP(), x.getDonGia(), x.getSoLuong(), x.getNgayBan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<HoaDonChiTiet> getAllhoadon_byMa(String idHD) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        ArrayList<DomainModels.HoaDonChiTiet> kh = hdctrs.getAllhoadonct_byMa(idHD);
        for (DomainModels.HoaDonChiTiet x : kh) {
            list.add(new HoaDonChiTiet(x.getIdHDCT(), x.getIdHD(), x.getIdCTSP(), x.getDonGia(), x.getSoLuong(), x.getNgayBan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<Hoadonct_SanpCT_Sp> gettheoMAhd(String MA) {
        return hdctrs.gethdByID(MA);
    }

    public HoaDon gettheoidhd(String id) {
        return hdctrs.getIDHoaDon(id);
    }

    public KhachHang getKhachHangByidkmd(String ma) {
        return hdctrs.getKhachHangByidkmd(ma);
    }

    public hoadonchitietviewmodel inserthdct(hoadonchitietviewmodel hd) {
        var x = hdctrs.inserthoadonct(new HoaDonChiTiet(hd.getIdHDCT(), hd.getIdHD(), hd.getIdCTSP(), hd.getSoLuong(), hd.getDonGia()));
        return new hoadonchitietviewmodel(x.getIdHDCT(), x.getIdHD(), x.getIdCTSP(), x.getSoLuong(), x.getDonGia());
    }

    public boolean updateKhachHang(HoaDonChiTiet hd) {
        var x = hdctrs.updatehoadon(new HoaDonChiTiet(hd.getIdHDCT(), hd.getIdHD(), hd.getIdCTSP(), hd.getDonGia(), hd.getSoLuong(), hd.getNgayBan(),
                hd.getNgayTao(), hd.getNgaySua(), hd.getTrangThai()));
        return x;
    }

    public hoadonchitietviewmodel updateHDCT(hoadonchitietviewmodel hdct) {
        var x = hdctrs.updateHDCT(new HoaDonChiTiet(hdct.getIdHDCT(), hdct.getIdHD(), hdct.getIdCTSP(), hdct.getSoLuong(), hdct.getDonGia()));
        return new hoadonchitietviewmodel(x.getIdHDCT(), x.getIdHD(), x.getIdCTSP(), x.getSoLuong(), x.getDonGia());

    }
        public int deleteHDCT(String idhd,String idctsp) {
        var x = hdctrs.deleteHDCT(idhd,idctsp);
        return x;

    }

    public hoadonchitietviewmodel updateHDCT_ThanhToan(hoadonchitietviewmodel hdct) {
        var x = hdctrs.updateHDCT_ThanhToan(new HoaDonChiTiet(hdct.getIdHDCT(), hdct.getIdHD(), hdct.getIdCTSP(), hdct.getSoLuong(), hdct.getDonGia()));
        return new hoadonchitietviewmodel(x.getIdHDCT(), x.getIdHD(), x.getIdCTSP(), x.getSoLuong(), x.getDonGia());

    }
    public hoadonchitietviewmodel updateHDCT_huyThanhToan(hoadonchitietviewmodel hdct) {
        var x = hdctrs.updateHDCT_huyThanhToan(new HoaDonChiTiet(hdct.getIdHDCT(), hdct.getIdHD(), hdct.getIdCTSP(), hdct.getSoLuong(), hdct.getDonGia()));
        return new hoadonchitietviewmodel(x.getIdHDCT(), x.getIdHD(), x.getIdCTSP(), x.getSoLuong(), x.getDonGia());

    }
}
