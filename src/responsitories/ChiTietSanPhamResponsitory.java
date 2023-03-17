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
import Utilities.JDBCHelper;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    KhuyenMaiResbonsitory kmr = new KhuyenMaiResbonsitory();

    public ArrayList<ChiTietSanPham> getAllChiTietSanPhams() {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        String sql = "SELECT ChiTietSanPham.QR , SanPham.Ten ,ChiTietSanPham.GiaNhap,ChiTietSanPham.GiaBan,"
                + "ChiTietSanPham.SoLuong ,Size ,DoCao, ChatLieu,MauSac , DanhMuc,\n"
                + "ChiTietSanPham.MoTa,ChiTietSanPham.HinhAnh,ChiTietSanPham.TrangThai from ChiTietSanPham ,SanPham \n"
                + "where ChiTietSanPham.id = SanPham.Id ";
        ResultSet rs = JDBCHelper.executeQuery(sql);

        try {
            while (rs.next()) {
                SanPham sp = spr.getSPByID(rs.getString(2));
                KhuyenMai km = kmr.getKMByID(rs.getString(3));
                DanhMuc dm = dmr.getDMByID(rs.getString(9));
                Size size = sizer.getSizeByID(rs.getString(10));
                MauSac ms = msr.getMSByID(rs.getString(11));
                ChatLieu cl = clr.getCLByID(rs.getString(12));
                DoCao dc = dcr.getDCByID(rs.getString(13));
                list.add(new ChiTietSanPham(rs.getString(1), sp, km, rs.getBigDecimal(4),rs.getBigDecimal(5), rs.getInt(6),rs.getString(7), rs.getInt(8), dm, size, ms, cl, dc,rs.getString(14),rs.getDate(15), rs.getDate(16), rs.getInt(17)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ChiTietSanPham getChiTietSanPhamByID(String id) {

        String sql = "SELECT * FROM ChiTietSanPham WHERE ID=?";
        ResultSet rs = JDBCHelper.executeQuery(sql, id);
        try {
            while (rs.next()) {
                SanPham sp = spr.getSPByID(rs.getString(2));
                KhuyenMai km = kmr.getKMByID(rs.getString(3));
                DanhMuc dm = dmr.getDMByID(rs.getString(9));
                Size size = sizer.getSizeByID(rs.getString(10));
                MauSac ms = msr.getMSByID(rs.getString(11));
                ChatLieu cl = clr.getCLByID(rs.getString(12));
                DoCao dc = dcr.getDCByID(rs.getString(13));
              return new ChiTietSanPham(rs.getString(1), sp, km, rs.getBigDecimal(4),rs.getBigDecimal(5), rs.getInt(6),rs.getString(7), rs.getInt(8), dm, size, ms, cl, dc,rs.getString(14),rs.getDate(15), rs.getDate(16), rs.getInt(17));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ChiTietSanPham insertCTSP(ChiTietSanPham ctsp) {

        String sql = "INSERT INTO ChiTietSanPham VALUES(NEWID(),?,?,?,?,?,?,?,?,?,?,?,?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, ctsp.getIdSP(), ctsp.getIdKM(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getMaQR(),ctsp.getHinhanh(),ctsp.getSoLuong(), ctsp.getIdDM(), ctsp.getIdSize(), ctsp.getIdMS(), ctsp.getIdCL(), ctsp.getIdDC(),ctsp.getMota(), ctsp.getNgaySua(), ctsp.getNgayTao(), ctsp.getTrangThai());
        return ctsp;
    }

    public ChiTietSanPham updateCTSP(ChiTietSanPham ctsp) {

        String sql = "UPDATE ChatLieu SET idsp= ?,idkm=?,gianhap=?,giaban= ?,hinhanh= ? , Soluong = ? , DanhMuc= ?,Size = ?,mausac=?,ChatLieu=?,DoCao = ?,Mota=?,NGAYSUA=GETDATE() WHERE QR=?";
        JDBCHelper.executeUpdate(sql, ctsp.getIdSP(), ctsp.getIdKM(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getHinhanh(), ctsp.getSoLuong(), ctsp.getIdDM(), ctsp.getIdSize(), ctsp.getIdMS(), ctsp.getIdCL(), ctsp.getIdDC(), ctsp.getTrangThai(), ctsp.getMaQR());
        return ctsp;
    }

    public Integer deleteCTSP(String qr) {
        String sql = "DELETE FROM ChatLieu WHERE QR=?";
        int row = JDBCHelper.executeUpdate(sql, qr);
        return row;
    }

}
