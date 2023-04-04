package responsitories;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import Utilities.JDBCHelper;
import ViewModels.HoaDonViewModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HoaDonResponsitory {

    NhanVienResponsitory nv = new NhanVienResponsitory();
    KhachHangResponsitory kh = new KhachHangResponsitory();
    KhuyenMaiResbonsitory km = new KhuyenMaiResbonsitory();

    public ArrayList<HoaDonViewModel> getAllhoadon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT * FROM hoadon";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(9), rs.getDate(10), rs.getInt(11)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public ArrayList<HoaDonViewModel> gethoadonCho() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT * FROM hoadon WHERE TRANGTHAI=0";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(9), rs.getDate(10), rs.getInt(11)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public HoaDon gethdByID(String id) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoadon where id=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));
                return new HoaDon(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(10), rs.getDate(9), rs.getInt(11));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public HoaDon inserthoadon(HoaDon hd) {
        String sql = "INSERT INTO dbo.HoaDon(ID,MaHD,IDNV,NgayTao,TrangThai) VALUES(NewID(),?,?,getdate(),?)";
        JDBCHelper.executeUpdate(sql,
                hd.getMaHD(),
                hd.getIdNV().getIdNV(),
                hd.getTrangThai()
        );
        return hd;
    }

    public HoaDon updatehoadon(HoaDon hd) {
        String sql = "UPDATE  dbo.HoaDon SET IDKH = ? WHERE MAHD = ?";
        JDBCHelper.executeUpdate(sql,
                hd.getIdKH().getIdKH(),
                hd.getMaHD()
        );
        return hd;
    }

    public HoaDon updatehoadon_thanhtoan(HoaDon hd) {
        String sql = "UPDATE  dbo.HoaDon SET THANHTIEN = ? ,TRANGTHAI = 1 , NGAYMUA = GETDATE() WHERE MAHD = ?";
        JDBCHelper.executeUpdate(sql,
                hd.getThanhTien(),
                hd.getMaHD()
        );
        return hd;
    }

    public HoaDon updatehoadon_huy(HoaDon hd) {
        String sql = "UPDATE  dbo.HoaDon SET TRANGTHAI = 2 , NGAYMUA = null , NGAYSUA = GETDATE(),GHICHU=? WHERE MAHD = ?";
        JDBCHelper.executeUpdate(sql,hd.getGhiChu(),
                hd.getMaHD()
        );
        return hd;
    }

    public ArrayList<HoaDonViewModel> getAllhoadonByTrangThai() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon\n"
                + "where TrangThai = 1 or TrangThai = 2";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(10), rs.getDate(9), rs.getInt(11)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public ArrayList<HoaDonViewModel> getAllhoadonThanhToan() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon\n"
                + "where TrangThai = 1 ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(10), rs.getDate(9), rs.getInt(11)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public ArrayList<HoaDonViewModel> getAllhoadonHuy() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon\n"
                + "where TrangThai = 2 ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(10), rs.getDate(9), rs.getInt(11)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    
    public static void main(String[] args) {
        HoaDonResponsitory hdR = new HoaDonResponsitory();
        System.out.println(hdR.getAllhoadonByTrangThai());
    }

}
