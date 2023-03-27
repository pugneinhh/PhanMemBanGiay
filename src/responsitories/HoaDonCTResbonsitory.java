package responsitories;

import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.Hoadonct_SanpCT_Sp;
import Utilities.DBConnection;
import java.sql.*;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonCTResbonsitory {

    HoaDonresbonsitory hd = new HoaDonresbonsitory();
    ChiTietSanPhamResponsitory ctsp = new ChiTietSanPhamResponsitory();

    public ArrayList<HoaDonChiTiet> getAllhoadonct()  {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql = "SELECT idctsp,soluong,dongia,N'Thành tiền'=SoLuong*dongia  FROM chitiethoadon";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                ChiTietSanPham ct = ctsp.getChiTietSanPhamByIDkmd(rs.getString(1));
                //list.add(new HoaDonChiTiet(ct, rs.getInt(2), rs.getBigDecimal(3)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public ArrayList<Hoadonct_SanpCT_Sp> gethdByID(String id) {
        ArrayList<Hoadonct_SanpCT_Sp> list = new ArrayList<>();
        String sql = "SELECT SanPham.MaSP,SanPham.Ten,ChiTietHoaDon.soluong,ChiTietHoaDon.DonGia,ChiTietSanPham.IDSP,N'Thành tiền'=ChiTietHoaDon.SoLuong*ChiTietHoaDon.DonGia  FROM ChiTietHoaDon JOIN ChiTietSanPham ON ChiTietHoaDon.IDCTSP=ChiTietSanPham.Id \n" +
"JOIN HoaDon ON ChiTietHoaDon.IDHD=HoaDon.ID JOIN SanPham ON ChiTietSanPham.IDSP=SanPham.Id WHERE HoaDon.MaHD=?";
     
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
        String sql = "select Id from HoaDon WHERE MAHD=?";
     
       try { 
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
           
                return (new HoaDon(rs.getString(1), rs.getString(2)));
            }
             c.close();
            ps.close();
            rs.close();
           
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ChucVuResponsitory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
   
    public HoaDonChiTiet inserthoadonct(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO ChiTietHoaDon(Id,IDHD,IDCTSP,SoLuong,DonGia,NgayBan,NgayTao,TrangThai)\n"
                + "VALUES(NewID(),?,?,?,?,getdate(),getdate(),?)";
        Integer row = JDBCHelper.executeUpdate(sql,
        
                hdct.getIdHD(),
                hdct.getIdCTSP(),
                hdct.getSoLuong(),
                hdct.getDonGia(),
                hdct.getNgayBan(),
                hdct.getNgayTao(),
                hdct.getTrangThai()
                
        
        );
        return hdct;
    }
       public Boolean updatehoadon(HoaDonChiTiet hdct) {
        String sql = "update ChiTietHoaDon set SoLuong=? where IDHD =? and IDCTSP=?";
        Integer row = JDBCHelper.executeUpdate(sql,
                hdct.getSoLuong(),
           hdct.getIdHD(),
                hdct.getIdCTSP()
                
               
                
        );
        
        return row>0;
    }
//           public Boolean updateHoaDonChiTiet(HoaDonChiTiet hdct){
//        String sql ="update HoaDonChiTiet set soluong=? where idhoadon =? and IdChiTietSP =?";
//        try {
//           Connection c = DBContext.getConnection();
//            PreparedStatement ps = c.prepareStatement(sql);
//            ps.setInt(1, hdct.getSl());
//            ps.setString(2, hdct.getIdHoaDon());
//            ps.setString(3, hdct.getIdChiTietSP());
//            int kq = ps.executeUpdate();
//             c.close();
//            ps.close();
//               return kq > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
}
