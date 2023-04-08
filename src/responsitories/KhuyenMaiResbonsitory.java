package responsitories;

import DomainModels.ChatLieu;
import DomainModels.ChiTietSanPham;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.KhuyenMai;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import Services.ChiTietSanPhamService;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import ViewModels.ChiTietSanPhamModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.List;

public class KhuyenMaiResbonsitory {

    public ArrayList<KhuyenMai> getAllKM() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select *from KhuyenMai";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public ArrayList<KhuyenMai> getKMHD() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select *from KhuyenMai WHERE APDUNGGIAMGIA like N'Hóa đơn'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public ArrayList<KhuyenMai> getKMSP() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select *from KhuyenMai WHERE APDUNGGIAMGIA like N'Sản phẩm'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public ArrayList<KhuyenMai> getKMAD() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select * from KhuyenMai where trangthai=0 and apdunggiamgia like N'Hóa Đơn'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public KhuyenMai getKMByID(String id) {

        String sql = "select *from KhuyenMai where id=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {

                return new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public KhuyenMai insertKM(KhuyenMai KM) {
        String sql = "INSERT INTO KhuyenMai VALUES (NEWID(),?,?,?,?,?,?,?,?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, KM.getMaKM(), KM.getTenKM(), KM.getGiaTri(),
                KM.getGiamToiDa(), KM.getNgayBatDau(), KM.getNgayKetThuc(), KM.getHinhThucApDung(), KM.getApDungGiamGia(),
                KM.getLoaiGiamGia(), KM.getTrangThai());
        return KM;
    }

    public KhuyenMai updateKM(KhuyenMai KM) {
        String sql = "UPDATE KhuyenMai SET tenKM=?,giaTri=?,giamToiDa=?, ngayBatDau=?, ngayKetThuc=?,hinhThucApDung=?,apDungGiamGia=?,loaiGiamGia=?,NgaySua=GETDATE(),TrangThai=? WHERE maKM=?";
        JDBCHelper.executeUpdate(sql, KM.getTenKM(), KM.getGiaTri(),
                KM.getGiamToiDa(), KM.getNgayBatDau(), KM.getNgayKetThuc(), KM.getHinhThucApDung(), KM.getApDungGiamGia(), KM.getLoaiGiamGia(), KM.getTrangThai(), KM.getMaKM());
        return KM;
    }

    public KhuyenMai updateChuyenTT(KhuyenMai KM) {
        String sql = "UPDATE KhuyenMai SET NgaySua=GETDATE(),TrangThai=1 WHERE maKM=?";
        JDBCHelper.executeUpdate(sql, KM.getMaKM());
        return KM;
    }

    public Integer deleteKM(String id) {
        String sql = "DELETE FROM KhuyenMai WHERE maKM=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;

    }


    public ArrayList<KhuyenMai> getIDByMa(String ma) {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select * from khuyenmai where makm=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
}
