/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.GiaoHang;
import DomainModels.GioHang;
import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import Utilities.JDBCHelper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class GiaoHangResponsitory {

    
    HoaDonResponsitory hdr = new HoaDonResponsitory();
    KhachHangResponsitory khr = new KhachHangResponsitory();
    

    public ArrayList<GiaoHang> getAllGiaoHang() {
        ArrayList<GiaoHang> list = new ArrayList<>();
        String sql = "SELECT * FROM GiaoHang ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                KhachHang kh = khr.getKHByID(rs.getString(3));
                HoaDon hd = hdr.gethdByID(rs.getString(2));
                list.add(new GiaoHang(rs.getString(1), hd, kh, rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getDate(9), rs.getDate(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return list;
    }
    public GiaoHang getByIDGiaoHang(String id) {
        ArrayList<GiaoHang> list = new ArrayList<>();
        String sql = "SELECT * FROM GiaoHang where id = ? ";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                KhachHang kh = khr.getKHByID(rs.getString(3));
                HoaDon hd = hdr.gethdByID(rs.getString(2));
                list.add(new GiaoHang(rs.getString(1), hd, kh, rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getDate(9), rs.getDate(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoHangResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public GiaoHang insertGH(GiaoHang gh) {
        String sql = "insert into GiaoHang values (NEWID(),?,?,?,?,?,?,?,?,?,GETDATE(),null,?)";
        JDBCHelper.executeUpdate(sql, gh.getIdGiaoHang(), gh.getIdHD(), gh.getIdKH(), gh.getSdt(), gh.getDiaChi(), gh.getTienHang(), gh.getTienShip(), gh.getTongTien(), gh.getNgayGiao(), gh.getNgayNhan(), gh.getNgayTao(), gh.getNgaySua(), gh.getTrangThai());
        return gh;
    }

    public GiaoHang updateChoGH(GiaoHang gh) {
        String sql = "update  giaohang set trangthai =1 where idgh =?";
        JDBCHelper.executeUpdate(sql,  gh.getIdGiaoHang());
        return gh;
    }
    
      public GiaoHang updateDangGH(GiaoHang gh) {
        String sql = "update  giaohang set trangthai =2 where idgh =?";
        JDBCHelper.executeUpdate(sql,  gh.getIdGiaoHang());
        return gh;
    }
      
       public GiaoHang updateHuyGH(GiaoHang gh) {
        String sql = "update  giaohang set trangthai =3 where idgh =?";
        JDBCHelper.executeUpdate(sql,  gh.getIdGiaoHang());
        return gh;
    }

    public Integer deleteGH(String id) {
        String sql = " delete from giaohang where id = ?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }
    
    public ArrayList<GiaoHang> DangGiaoHang() {
        ArrayList<GiaoHang> list = new ArrayList<>();
        String sql = "SELECT * FROM GiaoHang where trangthai = 1 ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                KhachHang kh = khr.getKHByID(rs.getString(3));
                HoaDon hd = hdr.gethdByID(rs.getString(2));
//                GioHang gh = ghr.getAllGHByID(rs.getString(sql));
               

                list.add(new GiaoHang(rs.getString(1), hd, kh, rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getDate(9), rs.getDate(10), rs.getDate(11),rs.getDate(12),rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    
    public ArrayList<GiaoHang> HuyGiaoHang() {
        ArrayList<GiaoHang> list = new ArrayList<>();
        String sql = "SELECT * FROM GiaoHang where trangthai = 2 ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                KhachHang kh = khr.getKHByID(rs.getString(3));
                HoaDon hd = hdr.gethdByID(rs.getString(2));
//                GioHang gh = ghr.getAllGHByID(rs.getString(sql));
                

                list.add(new GiaoHang(rs.getString(1), hd, kh, rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getDate(9), rs.getDate(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    
    public ArrayList<GiaoHang> GiaoHang() {
        ArrayList<GiaoHang> list = new ArrayList<>();
        String sql = "SELECT * FROM GiaoHang where trangthai = 3 ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                KhachHang kh = khr.getKHByID(rs.getString(3));
                HoaDon hd = hdr.gethdByID(rs.getString(2));
//                GioHang gh = ghr.getAllGHByID(rs.getString(sql));
               

                list.add(new GiaoHang(rs.getString(1), hd, kh, rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getDate(9), rs.getDate(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    
     public ArrayList<GiaoHang> ChoGiaoHang() {
        ArrayList<GiaoHang> list = new ArrayList<>();
        String sql = "SELECT * FROM GiaoHang where trangthai = 0 ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                KhachHang kh = khr.getKHByID(rs.getString(3));
                HoaDon hd = hdr.gethdByID(rs.getString(2));
//                GioHang gh = ghr.getAllGHByID(rs.getString(sql));
                

                list.add(new GiaoHang(rs.getString(1), hd, kh, rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getDate(9), rs.getDate(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
     
     
     
      

}

