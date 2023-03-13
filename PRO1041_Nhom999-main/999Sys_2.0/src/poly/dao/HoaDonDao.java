/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import poly.entity.HoaDon;
import poly.helper.XJDBC;

/**
 *
 * @author Admin
 */
public class HoaDonDao extends BaseDao<HoaDon, String> {

    private Locale localeVN = new Locale("vi", "VN");
    private NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "SET IDENTITY_INSERT [dbo].[HOADON] ON  INSERT INTO HOADON (MAHOADON, MANV, MAKH, MATT, NGAYMUA, GIAMGIA, THANHTIEN) VALUES (?,?,?,?,?,?,?)  SET IDENTITY_INSERT [dbo].[HOADON] OFF";
            case "UPDATE":
                return "UPDATE HOADON SET MANV =?, MAKH =?, MATT =?, NGAYMUA =?, GIAMGIA =?, THANHTIEN =? WHERE MAHOADON = ?";
            case "UPDATEXOAMAKH":
                return "UPDATE [dbo].[HOADON] SET [MAKH] = null WHERE [MAHOADON] = ?";
            case "DELETE":
                return "DELETE FROM HOADON WHERE MAHOADON =?";
            case "SELECTBYID":
                return "SELECT * FROM HOADON WHERE MAHOADON = ?";
            case "SELECTALL":
                return "SELECT * FROM HOADON";
            case "SELECTMAXMAHD":
                return "SELECT MAX(MAHOADON) AS 'MAXMAHD' FROM HOADON";
            case "CBBMaKH":
                return "SELECT DISTINCT IIF(MAKH is null,N'Khách Lẻ',MAKH)  FROM HOADON ";
            case "CBBMaNV":
                return "SELECT DISTINCT MaNV FROM HOADON ";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, HoaDon obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaHD(),
                    obj.getMaNV(),
                    obj.getMaKH(),
                    obj.getMaTT(),
                    obj.getNgayMua(),
                    obj.getGiamGia(),
                    obj.getThanhTien()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaNV(),
                    obj.getMaKH(),
                    obj.getMaTT(),
                    obj.getNgayMua(),
                    obj.getGiamGia(),
                    obj.getThanhTien(),
                    obj.getMaHD()
                };
        }
        return null;
    }

    @Override
    public HoaDon createEntity(ResultSet rs) throws SQLException {
        HoaDon hD = new HoaDon();
        hD.setMaHD(rs.getInt("MAHOADON"));
        hD.setMaNV(rs.getString("MANV"));
        hD.setMaKH(rs.getString("MAKH"));
        hD.setNgayMua(rs.getString("NGAYMUA"));
        hD.setGiamGia(rs.getDouble("GIAMGIA"));
        hD.setThanhTien(rs.getDouble("THANHTIEN"));
        hD.setMaTT(rs.getInt("MATT"));
        return hD;
    }

    public int getMaxMaHD() {
        return (int) XJDBC.value(this.getQuery("SELECTMAXMAHD"));
    }

    public boolean updateMaKH(int key) throws Exception {
        return XJDBC.update(this.getQuery("UPDATEXOAMAKH"), key) > 0;
    }

    public List<Object[]> getListGIAOHANG(Object[] listObject) throws Exception {
        String sql = "{CALL SP_TimKiemHDGiaoHang(?,?)}";
        List<Object[]> listGiaoHang = new ArrayList<>();
        ResultSet rs = XJDBC.query(sql, listObject);
        while (rs.next()) {
            listGiaoHang.add(new Object[]{
                rs.getObject("MAHOADON"),
                rs.getObject("MANV"),
                rs.getObject("HOTEN"),
                rs.getObject("MAKH"),
                rs.getObject("TENKHACHHANG"),
                rs.getObject("SDT"),
                rs.getObject("DIACHI"),
                rs.getObject("NGAYMUA"),
                rs.getObject("NGAYGIAOHANG"),
                df.format(rs.getObject("GIAMGIA")),
                df.format(rs.getObject("TIENSHIPHANG")),
                df.format(rs.getObject("THANHTIEN")),
                rs.getObject("TENTT"),
                rs.getObject("GHICHU")
            });
        }
        return listGiaoHang;
    }

    public List<Object[]> getListHD(Object[] listObject) throws Exception {
        String sql = "{CALL SP_TimKiemHD(?,?)}";
        List<Object[]> listHD = new ArrayList<>();
        ResultSet rs = XJDBC.query(sql, listObject);
        while (rs.next()) {
            listHD.add(new Object[]{
                rs.getObject("MAHOADON"),
                rs.getObject("MANV"),
                rs.getObject("HOTEN"),
                rs.getObject("MAKH"),
                rs.getObject("NGAYMUA"),
                df.format(rs.getObject("GIAMGIA")),
                df.format(rs.getObject("THANHTIEN")),
                rs.getObject("TENTT"),
                rs.getObject("GHICHU"),});
        }
        return listHD;
    }

    public List<Object[]> getListCTSPByMaHD(int key) throws Exception {
        String sql = "{CALL SP_TimKiemCTSP(?)}";
        List<Object[]> listCTSP = new ArrayList<>();
        ResultSet rs = XJDBC.query(sql, key);
        while (rs.next()) {
            listCTSP.add(new Object[]{
                rs.getObject("MASP"),
                rs.getObject("TENSP"),
                rs.getObject("MAVACH"),
                df.format(rs.getObject("GIABAN")),
                rs.getObject("SOLUONG"),
                rs.getObject("TENDANHMUC"),
                rs.getObject("TENDVT"),
                rs.getObject("MASIZE"),
                rs.getObject("TENMAU"),
                rs.getObject("TENCHATLIEU"),
                rs.getObject("NGAYNHAP")
            });
        }
        rs.getStatement().getConnection().close();
        return listCTSP;
    }

    public List<String> getCbbMaKH() throws Exception {
        List<String> list = new ArrayList<>();
        ResultSet rs = XJDBC.query(this.getQuery("CBBMaKH"));
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        rs.getStatement().getConnection().close();
        return list;
    }

    public List<String> getCbbMaNV() throws Exception {
        List<String> list = new ArrayList<>();
        ResultSet rs = XJDBC.query(this.getQuery("CBBMaNV"));
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        rs.getStatement().getConnection().close();
        return list;
    }
}
