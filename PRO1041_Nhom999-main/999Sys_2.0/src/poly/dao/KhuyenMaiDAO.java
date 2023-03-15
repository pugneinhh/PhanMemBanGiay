/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import poly.entity.KhuyenMai;
import poly.entity.SanPham;
import poly.helper.XJDBC;

/**
 *
 * @author 98tae
 */
public class KhuyenMaiDAO extends BaseDao<KhuyenMai, String> {

    public KhuyenMaiDAO() {
    }

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO KHUYENMAI (MASP, TENKM, HINHTHUCAD, GIAMTOIDA, NGAYBATDAU, NGAYKETTHUC, GIATRI,LOAIKM) VALUES (?,?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE KHUYENMAI SET MASP = ?, TENKM = ?, HINHTHUCAD = ?, GIAMTOIDA = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?, GIATRI = ?, TRANGTHAI = ? WHERE MAKM = ?";
            case "DELETE":
                return "UPDATE KHUYENMAI SET TRANGTHAI = 0 WHERE MAKM = ?";
            case "SELECTBYID":
                return "SELECT MAKM, MASP, TENKM, HINHTHUCAD, GIAMTOIDA, NGAYBATDAU, NGAYKETTHUC, GIATRI TRANGTHAI FROM   KHUYENMAI WHERE (MAKM = ?)";
            case "SELECTALL":
                return "SELECT * FROM KHUYENMAI";
            case "SelectMASP":
                return "Select MASP from DANHMUC join SANPHAM on DANHMUC.MADM = SANPHAM.MADM where DANHMUC.MADM = ?";
            case "INSERTNOMASP":
                return "insert into KHUYENMAI(MASP,TENKM,LOAIKM,HINHTHUCAD,GIATRI,GIAMTOIDA,HDTOITHIEU,NGAYBATDAU,NGAYKETTHUC) values (null,?,?,?,?,?,?,?,?)";
            case "UPDATENULLMASP":
                return "UPDATE KHUYENMAI SET TENKM =?, HINHTHUCAD =?, GIATRI =?, GIAMTOIDA =?, NGAYKETTHUC =?, NGAYBATDAU =? ,HDTOITHIEU = ? ,TRANGTHAI = 1 WHERE MAKM = ?";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, KhuyenMai obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaSP(),
                    obj.getTenKM(),
                    obj.isHinhThucAD(),
                    obj.getGiamToiDa(),
                    obj.getNgayBD(),
                    obj.getNgayKT(),
                    obj.getGiaTri(),
                    obj.isLoaiKM()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaSP(),
                    obj.getTenKM(),
                    obj.isHinhThucAD(),
                    obj.getGiamToiDa(),
                    obj.getNgayBD(),
                    obj.getNgayKT(),
                    obj.getGiaTri(),
                    obj.isTrangThai(),
                    obj.getMaKM()
                };
            case "INSERTNOMASP":
                return new Object[]{
                    obj.getTenKM(),
                    obj.isLoaiKM(),
                    obj.isHinhThucAD(),
                    obj.getGiaTri(),
                    obj.getGiamToiDa(),
                    obj.getHDToiThieu(),
                    obj.getNgayBD(),
                    obj.getNgayKT(),};
            case "UPDATENULLMASP":
                return new Object[]{
                    obj.getTenKM(),
                    obj.isHinhThucAD(),
                    obj.getGiaTri(),
                    obj.getGiamToiDa(),
                    obj.getNgayKT(),
                    obj.getNgayBD(),
                    obj.getHDToiThieu(),
                    obj.getMaKM()
                };
        }
        return null;
    }

    @Override
    public KhuyenMai createEntity(ResultSet rs) throws SQLException {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(rs.getInt("MAKM"));
        km.setMaSP(rs.getInt("MASP"));
        km.setTenKM(rs.getString("TENKM"));
        km.setLoaiKM(rs.getBoolean("LOAIKM"));
        km.setHinhThucAD(rs.getBoolean("HINHTHUCAD"));
        km.setGiaTri(rs.getDouble("GIATRI"));
        km.setGiamToiDa(rs.getDouble("GIAMTOIDA"));
        km.setNgayBD(rs.getString("NGAYBATDAU"));
        km.setNgayKT(rs.getString("NGAYKETTHUC"));
        km.setTrangThai(rs.getBoolean("TRANGTHAI"));
        km.setHDToiThieu(rs.getDouble("HDTOITHIEU"));
        return km;
    }

    public static ArrayList<String> getMaSP_InDanhMuc(int maDM) {
        String sql = "Select MASP from DANHMUC join SANPHAM on DANHMUC.MADM = SANPHAM.MADM where DANHMUC.MADM = ? AND SANPHAM.APDUNGKM = 1\n" +
"AND MASP not in (select MASP from KHUYENMAI )";
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, maDM);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean Insert_NoMaSp(KhuyenMai km) {
        return XJDBC.update(this.getQuery("INSERTNOMASP"), this.getParams("INSERTNOMASP", km)) > 0;
    }
    
    public boolean Update_NoMaSP(KhuyenMai km){
    return XJDBC.update(this.getQuery("UPDATENULLMASP"), this.getParams("UPDATENULLMASP", km)) > 0;
    }
}
