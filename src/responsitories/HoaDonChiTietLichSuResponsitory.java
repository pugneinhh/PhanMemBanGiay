/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.ChatLieu;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.MauSac;
import DomainModels.NhanVien;
import DomainModels.SanPham;
import DomainModels.Size;
import Utilities.JDBCHelper;
import ViewModels.GiaoHangModel;
import ViewModels.HoaDonChiTiet_CTSanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author HoiVN
 */
public class HoaDonChiTietLichSuResponsitory {

    SanPhamResponsitory spR = new SanPhamResponsitory();
    HoaDonResponsitory hdR = new HoaDonResponsitory();
    DanhMucResponsitory dmr = new DanhMucResponsitory();
    SizeResponsitory sizer = new SizeResponsitory();
    MauSacResponsitory msr = new MauSacResponsitory();
    ChatLieuResponsitory clr = new ChatLieuResponsitory();
    DoCaoResponsitory dcr = new DoCaoResponsitory();
    NhanVienResponsitory nvr = new NhanVienResponsitory();
    KhachHangResponsitory khr = new KhachHangResponsitory();

    public ArrayList<HoaDonChiTiet_CTSanPham> getAllHoaDonCTSP() {
        ArrayList<HoaDonChiTiet_CTSanPham> list = new ArrayList<>();
        String sql = "select HoaDon.ID, ChiTietSanPham.IDSP, ChiTietHoaDon.DonGia, ChiTietHoaDon.SoLuong, ChiTietSanPham.size,\n"
                + "ChiTietSanPham.MauSac, ChiTietSanPham.ChatLieu, ChiTietSanPham.DanhMuc, ChiTietSanPham.DoCao from ChiTietHoaDon\n"
                + "join ChiTietSanPham on ChiTietSanPham.Id = ChiTietHoaDon.IDCTSP\n"
                + "join HoaDon on HoaDon.ID = ChiTietHoaDon.IDHD";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                HoaDon hd = hdR.getHDByID(rs.getString(1));
                SanPham sp = spR.getSPByID(rs.getString(2));
                Size size = sizer.getSizeByID(rs.getString(5));
                MauSac ms = msr.getMSByID(rs.getString(6));
                ChatLieu cl = clr.getCLByID(rs.getString(7));
                DanhMuc dm = dmr.getDMByID(rs.getString(8));
                DoCao dc = dcr.getDCByID(rs.getString(9));
                list.add(new HoaDonChiTiet_CTSanPham(hd, sp, rs.getBigDecimal(3), rs.getInt(4), size, ms, cl, dm, dc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<GiaoHangModel> getAllHoaDonGiaoHang() {
        ArrayList<GiaoHangModel> list = new ArrayList<>();
        String sql = "select HoaDon.ID, HoaDon.IDNV, HoaDon.IDKH, KhachHang.ID, GiaoHang.SDT, GiaoHang.DiaChi, HoaDon.NgayMua, GiaoHang.NgayGiao, GiaoHang.GiamGia, GiaoHang.TienShip, GiaoHang.TongTien, GiaoHang.TrangThai from HoaDon\n"
                + "join GiaoHang on GiaoHang.IDHD = HoaDon.ID\n"
                + "join KhachHang on KhachHang.ID = HoaDon.IDKH";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                HoaDon hd = hdR.getHDByID(rs.getString(1));
                NhanVien nv = nvr.getNVByID(rs.getString(2));
                KhachHang kh = khr.getMaKHByID(rs.getString(3));
                KhachHang khTen = khr.getTenKHByID(rs.getString(4));
                list.add(new GiaoHangModel(hd, nv, kh, khTen, rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getString(9), rs.getBigDecimal(10), rs.getBigDecimal(11), rs.getInt(12)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        HoaDonChiTietLichSuResponsitory hdR = new HoaDonChiTietLichSuResponsitory();
//        System.out.println(hdR.getAllHoaDonCTSP());
        System.out.println(hdR.getAllHoaDonGiaoHang());
    }
}
