/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.ChatLieu;
import DomainModels.ChiTietSanPham;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
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

    public ArrayList<ChiTietSanPham> getAllChiTietSanPhams() {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        String sql = "SELECT SanPham.MaSP , SanPham.Ten ,ChiTietSanPham.GiaNhap , Size , MauSac , "
                + "ChiTietSanPham.SoLuong ,ChiTietSanPham.GiaBan ,DoCao, ChatLieu , "
                + "DanhMuc,SanPham.MoTa,ChiTietSanPham.TrangThai from ChiTietSanPham ,SanPham "
                + "where ChiTietSanPham.id = SanPham.Id ";
        ResultSet rs = JDBCHelper.executeQuery(sql);

        try {
            while (rs.next()) {
                SanPham sp = spr.getSPByID(rs.getString(2));
                DanhMuc dm = dmr.getDMByID(rs.getString(6));
                Size size = sizer.getSizeByID(rs.getString(7));
                MauSac ms = msr.getMSByID(rs.getString(8));
                ChatLieu cl = clr.getCLByID(rs.getString(9));
                DoCao dc = dcr.getDCByID(rs.getString(10));
                list.add(new ChiTietSanPham(rs.getString(1), sp, rs.getBigDecimal(3),
                        rs.getBigDecimal(4), rs.getInt(5), dm, size, ms, cl, dc, rs.getDate(11), rs.getDate(12), rs.getInt(13)));
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
                DanhMuc dm = dmr.getDMByID(rs.getString(6));
                Size size = sizer.getSizeByID(rs.getString(7));
                MauSac ms = msr.getMSByID(rs.getString(8));
                ChatLieu cl = clr.getCLByID(rs.getString(9));
                DoCao dc = dcr.getDCByID(rs.getString(10));
                return new ChiTietSanPham(rs.getString(1), sp, rs.getBigDecimal(3),
                        rs.getBigDecimal(4), rs.getInt(5), dm, size, ms, cl, dc, rs.getDate(11), rs.getDate(12), rs.getInt(13));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ChiTietSanPham insertCTSP(ChiTietSanPham ctsp) {

        String sql = "INSERT INTO ChiTietSanPham VALUES(NEWID(),?,?,?,?,?,?,?,?,?,?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, ctsp.getIdSP(), ctsp.getIdKM(), ctsp.getGiaNhap(),ctsp.getGiaBan(),ctsp.getMaQR(),ctsp.getSoLuong(),ctsp.getIdDM(),ctsp.getIdSize(),ctsp.getIdMS(),ctsp.getIdCL(), ctsp.getIdDC(),ctsp.getNgaySua(),ctsp.getNgayTao(),ctsp.getTrangThai());
        return ctsp;
    }

    public ChiTietSanPham updateCTSP(ChiTietSanPham ctsp) {

        String sql = "UPDATE ChatLieu SET idsp= ?,idkm=?,gianhap=?,giaban= ?, Qr= ? , Soluong = ? , DanhMuc= ?,Size = ?,ChatLieu=?,DoCao = ?,NGAYSUA=GETDATE() WHERE ID=?";
        JDBCHelper.executeUpdate(sql, ctsp.getIdSP(), ctsp.getIdKM(), ctsp.getGiaNhap(),ctsp.getGiaBan(),ctsp.getMaQR(),ctsp.getSoLuong(),ctsp.getIdDM(),ctsp.getIdSize(),ctsp.getIdMS(),ctsp.getIdCL(), ctsp.getIdDC(),ctsp.getNgaySua(),ctsp.getNgayTao(),ctsp.getTrangThai(),ctsp.getIdCTSP());
        return ctsp;
    }

    public Integer deleteCTSP(String id) {
        String sql = "DELETE FROM ChatLieu WHERE MA=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }

   

}
