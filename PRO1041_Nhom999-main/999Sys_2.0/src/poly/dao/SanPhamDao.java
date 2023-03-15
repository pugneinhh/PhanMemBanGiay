/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import poly.entity.SanPham;
import poly.helper.XJDBC;

/**
 *
 * @author 98tae
 */
public class SanPhamDao extends BaseDao<SanPham, Integer> {

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO SANPHAM (MADM, MAVACH,TENSP, ANHSANPHAM, GIANHAP, GIABAN, SOLUONG, NGAYNHAP, MADVT, MAMAU, MASIZE, MACHATLIEU) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE SANPHAM SET MADM =?, TENSP = ?, MAVACH =?, ANHSANPHAM =?, GIANHAP =?, GIABAN =?, SOLUONG =?, NGAYNHAP =?, APDUNGKM =?, MADVT =?, MAMAU =?, MASIZE =?, MACHATLIEU =? WHERE MASP = ?";
            case "DELETE":
                return "UPDATE SANPHAM SET TRANGTHAI = 0 WHERE MASP = ?";
            case "RESTORE":
                return "UPDATE SANPHAM SET TRANGTHAI = 1 WHERE MASP = ?";
            case "SELECTBYID":
                return "SELECT MASP, TENSP + '  ' + SANPHAM.MASIZE + ', ' + TENMAU + ', ' + TENCHATLIEU  AS TENSP, MADM, MAVACH , IIF(dbo.FNSPKM(MASP) IS NULL, GIABAN, dbo.FNSPKM(MASP)) GIABAN,GIANHAP, SOLUONG, ANHSANPHAM, NGAYNHAP, APDUNGKM, SANPHAM.TRANGTHAI, SANPHAM.MACHATLIEU, SANPHAM.MADVT, SANPHAM.MAMAU, SANPHAM.MASIZE  FROM CHATLIEU INNER JOIN SANPHAM ON CHATLIEU.MACHATLIEU = SANPHAM.MACHATLIEU INNER JOIN MAUSAC ON SANPHAM.MAMAU = MAUSAC.MAMAU INNER JOIN SIZE ON SANPHAM.MASIZE = SIZE.MASIZE WHERE (MASP = ?)";
            case "SELECTBYNAME":
                return "SELECT * FROM SANPHAM WHERE TENSP = ? AND MADM = ? AND MASIZE = ? AND MAMAU = ? AND MACHATLIEU = ?";
            case "SELECTALL":
                return "SELECT * FROM SANPHAM";
            case "SELECTWHERE":
                return "SELECT MASP, TENSP + '  ' + SANPHAM.MASIZE + ', ' + TENMAU + ', ' + TENCHATLIEU  AS TENSP, MADM, MAVACH , IIF(dbo.FNSPKM(MASP) IS NULL, GIABAN, dbo.FNSPKM(MASP)) GIABAN,GIANHAP, SOLUONG, ANHSANPHAM, NGAYNHAP, APDUNGKM, SANPHAM.TRANGTHAI, SANPHAM.MACHATLIEU, SANPHAM.MADVT, SANPHAM.MAMAU, SANPHAM.MASIZE  FROM CHATLIEU INNER JOIN SANPHAM ON CHATLIEU.MACHATLIEU = SANPHAM.MACHATLIEU INNER JOIN MAUSAC ON SANPHAM.MAMAU = MAUSAC.MAMAU INNER JOIN SIZE ON SANPHAM.MASIZE = SIZE.MASIZE WHERE MADM like  ? and (MASP like ? or TENSP like ?)";
            case "UPDATEMASP":
                return "UPDATE SANPHAM SET SOLUONG =? WHERE MASP = ?";
            case "getMaxMaVach":
                return "SELECT MAX(MAVACH) FROM SANPHAM";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, SanPham obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaDanhMuc(),
                    obj.getMaVach(),
                    obj.getTenSanPham(),
                    obj.getAnhSanPham(),
                    obj.getGiaNhap(),
                    obj.getGiaBan(),
                    obj.getSoLuong(),
                    obj.getNgayNhap(),
                    obj.getMaDVT(),
                    obj.getMaMau(),
                    obj.getMaSize(),
                    obj.getMaChatLieu()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaDanhMuc(),
                    obj.getTenSanPham(),
                    obj.getMaVach(),
                    obj.getAnhSanPham(),
                    obj.getGiaNhap(),
                    obj.getGiaBan(),
                    obj.getSoLuong(),
                    obj.getNgayNhap(),
                    obj.isApDungKM(),
                    obj.getMaDVT(),
                    obj.getMaMau(),
                    obj.getMaSize(),
                    obj.getMaChatLieu(),
                    obj.getMaSP()
                };
            case "SELECTBYNAME":
                return new Object[]{
                    obj.getTenSanPham(),
                    obj.getMaDanhMuc(),
                    obj.getMaSize(),
                    obj.getMaMau(),
                    obj.getMaChatLieu(),
                };
            case "SELECTWHERE":
                return new Object[]{
                    "%" + (obj.getMaDanhMuc() == 0 ? "" : obj.getMaDanhMuc()) + "%",
                    "%" + obj.getTenSanPham() + "%",
                    "%" + obj.getTenSanPham() + "%"
                };
            case "UPDATEMASP":
                return new Object[]{
                    obj.getSoLuong(),
                    obj.getMaSP()
                };
        }
        return null;
    }

    @Override
    public SanPham createEntity(ResultSet rs) throws SQLException {
        SanPham sp = new SanPham();
        sp.setMaSP(rs.getInt("MASP"));
        sp.setMaDanhMuc(rs.getInt("MADM"));
        sp.setMaVach(rs.getString("MAVACH"));
        sp.setTenSanPham(rs.getString("TENSP"));
        sp.setAnhSanPham(rs.getString("ANHSANPHAM"));
        sp.setGiaNhap(rs.getDouble("GIANHAP"));
        sp.setGiaBan(rs.getDouble("GIABAN"));
        sp.setSoLuong(rs.getInt("SOLUONG"));
        sp.setNgayNhap(rs.getDate("NGAYNHAP"));
        sp.setApDungKM(rs.getBoolean("APDUNGKM"));
        sp.setMaDVT(rs.getInt("MADVT"));
        sp.setMaMau(rs.getInt("MAMAU"));
        sp.setMaSize(rs.getString("MASIZE"));
        sp.setMaChatLieu(rs.getInt("MACHATLIEU"));
        sp.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return sp;
    }

    public ArrayList<SanPham> selectWhere(SanPham sp) throws Exception {
        return selectByquery("SELECTWHERE", this.getParams("SELECTWHERE", sp));
    }
    
    public ArrayList<SanPham> selectByNameSizeColor(SanPham sp) throws Exception {
        return selectByquery("SELECTBYNAME", this.getParams("SELECTBYNAME", sp));
    }

    public static ArrayList<String> ListSp_NoKhuyenMai(boolean boo) {
        String sql = "SELECT MASP FROM  SANPHAM\n"
                + "WHERE APDUNGKM = ?";
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, boo);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean updateSP(SanPham e) throws Exception {
        return XJDBC.update(this.getQuery("UPDATEMASP"), this.getParams("UPDATEMASP", e)) > 0;
    }

    public boolean restore(int key) throws Exception {
        return XJDBC.update(this.getQuery("RESTORE"), key) > 0;
    }

    public List<Object[]> getListSanPhamByListKey(Object[] listKey) {
        String sql = "{CALL sp_timkiem(?,?,?,?,?,?,?)}";
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, listKey);
            while (rs.next()) {
                String pathImage = rs.getString(13);
                if (pathImage == null) {
                    pathImage = "noImage.jpg";
                }
                JLabel ImgLabel = new JLabel();
                ImageIcon icon = new ImageIcon(".\\AnhSP\\" + pathImage);
                Image img = icon.getImage().getScaledInstance(84, 104, Image.SCALE_SMOOTH);
                ImgLabel.setIcon(new ImageIcon(img));
                ImgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                list.add(new Object[]{
                    rs.getObject(1),
                    rs.getObject(3),
                    rs.getObject(2),
                    String.format("%.0f", rs.getObject(4)),
                    String.format("%.0f", rs.getObject(5)),
                    rs.getObject(6),
                    rs.getObject(7),
                    rs.getObject(8),
                    rs.getObject(9),
                    rs.getObject(10),
                    rs.getObject(11),
                    rs.getObject(12),
                    ImgLabel
                });
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Object[]> getListSanPhamDeleted() {
        String sql = "{CALL sp_timkiemSPdaxoa()}";
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                String pathImage = rs.getString(13);
                if (pathImage == null) {
                    pathImage = "noImage.jpg";
                }
                JLabel ImgLabel = new JLabel();
                ImageIcon icon = new ImageIcon(".\\AnhSP\\" + pathImage);
                Image img = icon.getImage().getScaledInstance(84, 104, Image.SCALE_SMOOTH);
                ImgLabel.setIcon(new ImageIcon(img));
                ImgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                list.add(new Object[]{
                    rs.getObject(1),
                    rs.getObject(3),
                    rs.getObject(2),
                    rs.getObject(4),
                    rs.getObject(5),
                    rs.getObject(6),
                    rs.getObject(7),
                    rs.getObject(8),
                    rs.getObject(9),
                    rs.getObject(10),
                    rs.getObject(11),
                    rs.getObject(12),
                    ImgLabel
                });
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public SanPham getSanPhamByMaVach(String MaVach) {
        SanPham sp = new SanPham();
        String sql = "SELECT MASP, TENSP + '  ' + SANPHAM.MASIZE + ', ' + TENMAU + ', ' + TENCHATLIEU  AS TENSP, MADM, MAVACH , IIF(dbo.FNSPKM(MASP) IS NULL, GIABAN, dbo.FNSPKM(MASP)) GIABAN,GIANHAP, SOLUONG, ANHSANPHAM, NGAYNHAP, APDUNGKM, SANPHAM.TRANGTHAI, SANPHAM.MACHATLIEU, SANPHAM.MADVT, SANPHAM.MAMAU, SANPHAM.MASIZE  FROM CHATLIEU INNER JOIN SANPHAM ON CHATLIEU.MACHATLIEU = SANPHAM.MACHATLIEU INNER JOIN MAUSAC ON SANPHAM.MAMAU = MAUSAC.MAMAU INNER JOIN SIZE ON SANPHAM.MASIZE = SIZE.MASIZE where SANPHAM.TRANGTHAI = 1 and MAVACH like ? ";
        try {
            ResultSet rs = XJDBC.query(sql, MaVach);
            if (rs.next()) {
                sp = this.createEntity(rs);
            }
            rs.getStatement().getConnection().close();
            return sp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getMaxMaVach(){
        return Integer.parseInt(XJDBC.value(this.getQuery("getMaxMaVach"))+"");
    }
}
