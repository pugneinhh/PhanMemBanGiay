/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.ChatLieu;
import DomainModels.ChiTietSanPham;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.KhuyenMai;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import ViewModels.ChiTietSanPhamModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ChiTietSanPhamResponsitory {

    SanPhamResponsitory spr = new SanPhamResponsitory();
    DanhMucResponsitory dmr = new DanhMucResponsitory();
    SizeResponsitory sizer = new SizeResponsitory();
    MauSacResponsitory msr = new MauSacResponsitory();
    ChatLieuResponsitory clr = new ChatLieuResponsitory();
    DoCaoResponsitory dcr = new DoCaoResponsitory();
    KhuyenMaiResbonsitory kmR = new KhuyenMaiResbonsitory();

    public ArrayList<ChiTietSanPham> getAllChiTietSanPhams() {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        String sql = "select Id,IDSP,IDKM,GiaNhap,GiaBan,QR,HinhAnh,SoLuong, "
                + "DanhMuc,Size,MauSac,ChatLieu,DoCao,MoTa,NgayTao,NgaySua,TrangThai\n"
                + "from ChiTietSanPham";

        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                SanPham sp = spr.getSPByID(rs.getString(2));
                KhuyenMai km = kmR.getKMByID(rs.getString(3));
                DanhMuc dm = dmr.getDMByID(rs.getString(9));
                Size size = sizer.getSizeByID(rs.getString(10));
                MauSac ms = msr.getMSByID(rs.getString(11));
                ChatLieu cl = clr.getCLByID(rs.getString(12));
                DoCao dc = dcr.getDCByID(rs.getString(13));
                list.add(new ChiTietSanPham(rs.getString(1), sp, km, rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getInt(6), rs.getString(7), rs.getInt(8), dm, size, ms, cl, dc, rs.getString(14), rs.getDate(15), rs.getDate(16), rs.getInt(17)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ChiTietSanPham getChiTietSanPhamByID(String idCTSP) {

        String sql = "SELECT * FROM ChiTietSanPham WHERE ID=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, idCTSP);
        try {
            while (rs.next()) {
                SanPham sp = spr.getSPByID(rs.getString(2));
                KhuyenMai km = kmR.getKMByID(rs.getString(3));
                DanhMuc dm = dmr.getDMByID(rs.getString(9));
                Size size = sizer.getSizeByID(rs.getString(10));
                MauSac ms = msr.getMSByID(rs.getString(11));
                ChatLieu cl = clr.getCLByID(rs.getString(12));
                DoCao dc = dcr.getDCByID(rs.getString(13));
                return new ChiTietSanPham(rs.getString(1), sp, km, rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getInt(6), rs.getString(7), rs.getInt(8), dm, size, ms, cl, dc, rs.getString(14), rs.getDate(15), rs.getDate(16), rs.getInt(17));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<ChiTietSanPham> getChiTietSanPhamByQR(String ma) {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        String sql = "select a.IDSP, a.IDKM, a.GiaNhap, a.GiaBan, a.QR, a.HinhAnh, "
                + "a.SoLuong, a.DanhMuc,a.size, a.MauSac, a.ChatLieu, a.DoCao, a.MoTa, "
                + "a.TrangThai from ChiTietSanPham as a where QR like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSPByID(rs.getString(1));
                KhuyenMai km = kmR.getKMByID(rs.getString(2));
                DanhMuc dm = dmr.getDMByID(rs.getString(8));
                Size size = sizer.getSizeByID(rs.getString(9));
                MauSac ms = msr.getMSByID(rs.getString(10));
                ChatLieu cl = clr.getCLByID(rs.getString(11));
                DoCao dc = dcr.getDCByID(rs.getString(12));
                ChiTietSanPham ctsp = new ChiTietSanPham(sp, km, rs.getBigDecimal(3), rs.getBigDecimal(4),
                        rs.getInt(5), rs.getString(6), rs.getInt(7), dm, size, ms, cl, dc, rs.getString(13), rs.getInt(14));

                list.add(ctsp);
            }
            c.close();
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ChiTietSanPhamModel> getChiTietSanPhamByDanhMuc(String danhMuc) {
        ArrayList<ChiTietSanPhamModel> listDM = new ArrayList<>();
        String sql = "select a.IDSP, a.IDKM, a.GiaNhap, a.GiaBan, a.QR, a.HinhAnh, a.SoLuong, a.DanhMuc,\n"
                + "a.size, a.MauSac, a.ChatLieu, a.DoCao, a.MoTa, a.TrangThai, DanhMuc.Ten from ChiTietSanPham as a\n"
                + "join DanhMuc on DanhMuc.Id = a.DanhMuc\n"
                + "where Ten like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + danhMuc + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSPByID(rs.getString(1));
                KhuyenMai km = kmR.getKMByID(rs.getString(2));
                DanhMuc dm = dmr.getDMByID(rs.getString(8));
                Size size = sizer.getSizeByID(rs.getString(9));
                MauSac ms = msr.getMSByID(rs.getString(10));
                ChatLieu cl = clr.getCLByID(rs.getString(11));
                DoCao dc = dcr.getDCByID(rs.getString(12));
                ChiTietSanPhamModel ctspM = new ChiTietSanPhamModel(sp, km, rs.getBigDecimal(3), rs.getBigDecimal(4),
                        rs.getInt(5), rs.getString(6), rs.getInt(7), dm, size, ms, cl, dc, rs.getString(13), rs.getInt(14));

                listDM.add(ctspM);
            }
            c.close();
            ps.close();
            rs.close();
            return listDM;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSanPham insertCTSP(ChiTietSanPham ctsp) {
        String sql = "INSERT INTO ChiTietSanPham(Id,IDSP,GiaNhap,GiaBan,"
                + "HinhAnh,SoLuong,DanhMuc,size,MauSac,ChatLieu,DoCao,MoTa,\n"
                + "NgayTao,TrangThai)VALUES(NewID(),?,?,?,?,?,?,?,?,?,?,?,getDate(),?)";
        JDBCHelper.executeUpdate(sql,
                ctsp.getIdSP().getIdSP(),
                ctsp.getGiaNhap(),
                ctsp.getGiaBan(),
                ctsp.getHinhanh(),
                ctsp.getSoLuong(),
                ctsp.getIdDM().getIdDM(),
                ctsp.getIdSize().getIdSize(),
                ctsp.getIdMS().getIdMS(),
                ctsp.getIdCL().getIdCL(),
                ctsp.getIdDC().getIdDC(),
                ctsp.getMota(),
                ctsp.getTrangThai());
        return ctsp;
    }

    public ChiTietSanPham updateCTSP(ChiTietSanPham ctsp) {
        String sql = "UPDATE ChiTietSanPham SET idsp= ?,gianhap=?,giaban= ?,hinhanh= ? , "
                + "Soluong = ? , DanhMuc= ?,Size = ?,mausac=?,ChatLieu=?,DoCao = ?,Mota=?,NGAYSUA=GETDATE(), TrangThai =? WHERE QR=?";
        JDBCHelper.executeUpdate(sql,
                ctsp.getIdSP().getIdSP(),
                ctsp.getGiaNhap(),
                ctsp.getGiaBan(),
                ctsp.getHinhanh(),
                ctsp.getSoLuong(),
                ctsp.getIdDM().getIdDM(),
                ctsp.getIdSize().getIdSize(),
                ctsp.getIdMS().getIdMS(),
                ctsp.getIdCL().getIdCL(),
                ctsp.getIdDC().getIdDC(),
                ctsp.getMota(),
                ctsp.getTrangThai(),
                ctsp.getMaQR());
        return ctsp;
    }

    public Integer updateCTSP1(ChiTietSanPham ctsp) {
        String sql = "UPDATE ChiTietSanPham SET idsp= ?,gianhap=?,giaban= ?,hinhanh= ? , "
                + "Soluong = ? , DanhMuc= ?,Size = ?,mausac=?,ChatLieu=?,DoCao = ?,Mota=?,NGAYSUA=GETDATE() WHERE QR=?";
        Integer row = JDBCHelper.executeUpdate(sql,
                ctsp.getIdSP().getIdSP(),
                ctsp.getGiaNhap(),
                ctsp.getGiaBan(),
                ctsp.getHinhanh(),
                ctsp.getSoLuong(),
                ctsp.getIdDM().getIdDM(),
                ctsp.getIdSize().getIdSize(),
                ctsp.getIdMS().getIdMS(),
                ctsp.getIdCL().getIdCL(),
                ctsp.getIdDC().getIdDC(),
                ctsp.getTrangThai(),
                ctsp.getMaQR());
        return row;
    }

    public Integer deleteCTSP(String qr) {
        String sql = "DELETE FROM CHITIETSANPHAM WHERE QR=?";
        int row = JDBCHelper.executeUpdate(sql, qr);
        return row;
    }

//    public static void main(String[] args) {
//        ChiTietSanPhamResponsitory ctspR = new ChiTietSanPhamResponsitory();
//        //System.out.println(ctspR.getAllChiTietSanPhams());
//        //System.out.println(ctspR.getChiTietSanPhamByID("fa51bbd3-1547-4520-8777-25b9b8838d0d"));
//        //System.out.println(ctspR.getChiTietSanPhamByQR("20012007"));
//        //System.out.println(ctspR.getChiTietSanPhamByDanhMuc("Đế vuông"));
//        SanPham sp = new SanPham("873FF970-FFA2-4ACE-AEC0-04E57AB4E5B1");
//        KhuyenMai km = new KhuyenMai("a8d3889b-b995-44d2-a831-5dad5f90d272");
//        DanhMuc dm = new DanhMuc("123a3758-5533-4002-bebd-c8a36231a730");
//        Size s = new Size("75e2183f-fe21-4b6a-ae1e-a06ec0a8d88e");
//        MauSac ms = new MauSac("677cda65-a33d-4edd-beac-f1ef149c066d");
//        ChatLieu cl = new ChatLieu("4d09303b-aeb7-42cd-be0a-2a4fd703092d");
//        DoCao dc = new DoCao("bfa2e592-0cb3-41fd-bedb-34b49e1989d8");
//        BigDecimal giaN = null;
//        BigDecimal giaB = null;
//
//        giaN = BigDecimal.valueOf(Double.parseDouble("111000"));
//        giaB = BigDecimal.valueOf(Double.parseDouble("222000"));
//
//        Integer kq = ctspR.updateCTSP1(new ChiTietSanPham(null, sp, km, giaN, giaB, 20012006, "SP03.png", 111, dm, s, ms, cl, dc, "AAA", null, null, 0));
//        System.out.println(kq);
//
//    }
}
