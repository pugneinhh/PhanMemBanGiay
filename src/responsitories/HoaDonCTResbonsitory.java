package responsitories;

import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.Hoadonct_SanpCT_Sp;
import DomainModels.KhachHang;
import Utilities.DBConnection;
import java.sql.*;
import Utilities.JDBCHelper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonCTResbonsitory {

    HoaDonResponsitory hd = new HoaDonResponsitory();
    ChiTietSanPhamResponsitory ctsp = new ChiTietSanPhamResponsitory();

    public ArrayList<HoaDonChiTiet> getAllhoadonct() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql = "SELECT * FROM chitiethoadon";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                HoaDon h = hd.gethdByID(rs.getString(2));
                ChiTietSanPham ct = ctsp.getChiTietSanPhamByIDkmd(rs.getString(3));
                list.add(new HoaDonChiTiet(rs.getString(1), h, ct, rs.getBigDecimal(5), rs.getInt(4), rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getInt(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public ArrayList<HoaDonChiTiet> getAllhoadonct_byMa(String idHD) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql = "SELECT * FROM chitiethoadon where idHD = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,idHD);
        try {
            while (rs.next()) {
                HoaDon h = hd.gethdByID(rs.getString(2));
                ChiTietSanPham ct = ctsp.getChiTietSanPhamByIDkmd(rs.getString(3));
                list.add(new HoaDonChiTiet(rs.getString(1), h, ct, rs.getBigDecimal(5), rs.getInt(4), rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getInt(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public ArrayList<Hoadonct_SanpCT_Sp> gethdByID(String id) {
        ArrayList<Hoadonct_SanpCT_Sp> list = new ArrayList<>();
        String sql = "SELECT SanPham.MaSP,SanPham.Ten,ChiTietHoaDon.soluong,ChiTietHoaDon.DonGia,ChiTietSanPham.IDSP,N'Thành tiền'=ChiTietHoaDon.SoLuong*ChiTietHoaDon.DonGia  FROM ChiTietHoaDon JOIN ChiTietSanPham ON ChiTietHoaDon.IDCTSP=ChiTietSanPham.Id \n"
                + "JOIN HoaDon ON ChiTietHoaDon.IDHD=HoaDon.ID JOIN SanPham ON ChiTietSanPham.IDSP=SanPham.Id WHERE HoaDon.MaHD=?";

        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Hoadonct_SanpCT_Sp(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBigDecimal(4), rs.getString(5)));
            }
            c.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ChucVuResponsitory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }

    public HoaDon getIDHoaDon(String maHD) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "select Id,MAHD from HoaDon WHERE MAHD=?";

        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new HoaDon(rs.getString(1), rs.getString(2));
            }
            c.close();
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public HoaDonChiTiet inserthoadonct(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO chitiethoadon(Id,IDHD,IDCTSP,SoLuong,DonGia,NgayTao)\n"
                + "VALUES(NewID(),?,?,?,?,getdate())";
        JDBCHelper.executeUpdate(sql,
                hdct.getIdHD().getIdHD(),
                hdct.getIdCTSP().getIdCTSP(),
                hdct.getSoLuong(),
                hdct.getDonGia()
        );
        return hdct;
    }

    public Boolean updatehoadon(HoaDonChiTiet hdct) {
        String sql = "update ChiTietHoaDon set SoLuong=? where IDHD =? and IDCTSP=?";
        Integer row = JDBCHelper.executeUpdate(sql,
                hdct.getSoLuong(),
                hdct.getIdHD().getIdHD(),
                hdct.getIdCTSP().getIdCTSP()
        );

        return row > 0;
    }

    public KhachHang getKhachHangByidkmd(String ma) {

        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where ID = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                return new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public HoaDonChiTiet updateHDCT(HoaDonChiTiet hdct) {
        String sql = "UPDATE chitiethoadon SET SOLUONG = ?,DONGIA=? WHERE IDHD = ? AND IDCTSP = ?";
        JDBCHelper.executeUpdate(sql, hdct.getSoLuong(),hdct.getDonGia(), hdct.getIdHD().getIdHD(), hdct.getIdCTSP().getIdCTSP());
        return hdct;
    }
    public int deleteHDCT(String idhd ,String idctsp) {
        String sql = "DELETE FROM chitiethoadon WHERE IDHD =? and IDCTSP = ?";
        int row = JDBCHelper.executeUpdate(sql,idhd,idctsp );
        return row;
    }
    
    public HoaDonChiTiet updateHDCT_ThanhToan(HoaDonChiTiet hdct) {
        String sql = "UPDATE chitiethoadon SET TRANGTHAI = 1 , NGAYBAN =GETDATE() WHERE ID = ? ";
        JDBCHelper.executeUpdate(sql, hdct.getIdHDCT());
        return hdct;
    }
    public HoaDonChiTiet updateHDCT_huyThanhToan(HoaDonChiTiet hdct) {
        String sql = "UPDATE chitiethoadon SET TRANGTHAI = 0 , NGAYBAN =NULL WHERE ID = ? ";
        JDBCHelper.executeUpdate(sql, hdct.getIdHDCT());
        return hdct;
    }

   
}
