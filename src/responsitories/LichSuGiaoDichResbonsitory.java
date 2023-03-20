/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.ChatLieu;
import DomainModels.ChiTietSanPham;
import DomainModels.ChucVu;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhuyenMai;
import DomainModels.MauSac;
import DomainModels.NhanVien;
import DomainModels.SanPham;
import DomainModels.Size;
import Utilities.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class LichSuGiaoDichResbonsitory {
    
    ChiTietSanPhamResponsitory ctsp = new ChiTietSanPhamResponsitory();

    SanPhamResponsitory spr = new SanPhamResponsitory();
    DanhMucResponsitory dmr = new DanhMucResponsitory();
    SizeResponsitory sizer = new SizeResponsitory();
    MauSacResponsitory msr = new MauSacResponsitory();
    ChatLieuResponsitory clr = new ChatLieuResponsitory();
    DoCaoResponsitory dcr = new DoCaoResponsitory();
    KhuyenMaiResbonsitory kmR = new KhuyenMaiResbonsitory();
    public ArrayList<HoaDonChiTiet> getAllhdct() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
//                ChiTietSanPham st = ctsp.getChiTietSanPhamByID(rs.getString(3);
//                list.add(new 
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
        public ChiTietSanPham getNVByID(String id) {
        String sql = "SELECT * FROM ChiTietSanPham WHERE ID=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            
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
}
