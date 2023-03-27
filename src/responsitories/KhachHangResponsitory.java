/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import DomainModels.KhachHang;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import ViewModels.KhachHangModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author HoiVN
 */
public class KhachHangResponsitory {

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> kh = new ArrayList<>();
        String sql = "select * from KhachHang";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                kh.add(new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getDate(9), rs.getDate(10),
                        rs.getInt(11), rs.getInt(12), rs.getDate(13), rs.getDate(14), rs.getInt(15)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public KhachHangModel getKhachHangByid(String ma) {
        ArrayList<KhachHangModel>list=new ArrayList<>();

        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where ID = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                return (new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public KhachHang getKhachHangByidkmd(String ma) {
        ArrayList<KhachHangModel>list=new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where ID = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                return new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getDate(9), rs.getDate(10),
                        rs.getInt(11), rs.getInt(12), rs.getDate(13), rs.getDate(14), rs.getInt(15));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
      
    }

    public ArrayList<KhachHangModel> getKhachHangBysdt(String sdt) {
        ArrayList<KhachHangModel> kh = new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where SDT like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + sdt + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHangModel khM = new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                kh.add(khM);
            }
            c.close();
            ps.close();
            rs.close();
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<KhachHangModel> getKHByGT(String gt) {
        ArrayList<KhachHangModel> list = new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where GioiTinh like ?";

        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + gt + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHangModel khM = new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                list.add(khM);
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

    public ArrayList<KhachHangModel> getKHByTrangThai(int TrangThai) {
        ArrayList<KhachHangModel> list = new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where TrangThai like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + TrangThai + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHangModel khM = new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                list.add(khM);
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
    
    public KhachHang getMaKHByID(String id) {

        String sql = "select ID,MaKH from KhachHang where ID = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new KhachHang(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public KhachHang getTenKHByID(String id) {

        String sql = "select ID, TenKH from KhachHang where ID = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new KhachHang(rs.getString(1),rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHang insertKhachHang(KhachHang kh) {
        String sql = "INSERT INTO KhachHang(ID,MaKH,LoaiKH,TenKH,DiaChi,GioiTinh,Email,SDT,NgaySinh,NgayThamGia,NgayTao,TrangThai) \n"
                + "VALUES(NewID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, getDate(), ?)";
        JDBCHelper.executeUpdate(sql,
                kh.getMaKH(),
                kh.getLoaiKH(),
                kh.getTenKH(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getNgayThamGia(),
                kh.getTrangThai()
        );
        return kh;
    }

    public KhachHang updateKhachHang(KhachHang kh) {
        String sql = "update KhachHang set LoaiKH = ?, TenKH = ?, DiaChi = ?, GioiTinh = ?, "
                + "Email = ?, SDT = ?, NgaySinh  = ?, NgayThamGia = ?, TrangThai = ?\n"
                + "where MaKH = ?";
        JDBCHelper.executeUpdate(sql,
                kh.getLoaiKH(),
                kh.getTenKH(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getNgayThamGia(),
                kh.getTrangThai(),
                kh.getMaKH()
        );
        return kh;
    }

    public String getIDkhachhang(String maHD) { // lay id hoadon
        String sql = "select id from khachhang where ma=? ";

        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, maHD);

            ResultSet rs = ps.executeQuery();
            KhachHang hd = new KhachHang();
            while (rs.next()) {
                hd = new KhachHang();
                hd.setIdKH(rs.getString(1));

            }
            c.close();
            ps.close();
            rs.close();
            return hd.getIdKH();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer deleteCV(String ma) {
        String sql = "delete from KhachHang\n"
                + "where MaKH = ?";
        Integer row = JDBCHelper.executeUpdate(sql, ma);
        return row;
    }


    public ArrayList<KhachHangModel> getTheoSDT(String SDT) {
         ArrayList<KhachHangModel> list = new ArrayList<>();
        String sql = "select MaKH, TenKH, LoaiKH, DiaChi, GioiTinh, Email, SDT, NgaySinh, NgayThamGia, TrangThai \n"
                + "from KhachHang\n"
                + "where SDT = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                KhachHangModel khVM = new KhachHangModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static void main(String[] args) {
        KhachHangResponsitory khRes = new KhachHangResponsitory();
        //System.out.println(khRes.getAllKhachHang());
        //System.out.println(khRes.getKhachHangBysdt("0962335335"));
        System.out.println(khRes.getMaKHByID("80681A3E-7487-4D41-AB67-FAB685AC70CC"));
    }
   public KhachHang getKHByID(String id){
        
        String sql="SELECT * FROM KhachHang WHERE ID = ? ";
        ResultSet rs=JDBCHelper.excuteQuery(sql,id);
        try {
            while(rs.next()){
                return new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getDate(9), rs.getDate(10),
                        rs.getInt(11), rs.getInt(12), rs.getDate(13), rs.getDate(14), rs.getInt(15));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       return null;
    }
}
