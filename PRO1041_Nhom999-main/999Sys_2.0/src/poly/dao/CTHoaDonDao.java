/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poly.entity.CTHoaDon;
import poly.helper.XJDBC;

/**
 *
 * @author Admin
 */
public class CTHoaDonDao extends BaseDao<CTHoaDon, String>{

    @Override
    public String getQuery(String action) {
        switch(action){
            case "INSERT":
                return "INSERT INTO CT_HOADON(MAHD, MASP, SOLUONG, GIABAN, GHICHU) VALUES (?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE CT_HOADON SET SOLUONG =?, GIABAN = ?, GHICHU =?, TRANGTHAI =? WHERE MAHD = ? and MASP =?";
            case "DELETE":
                return "DELETE FROM CT_HOADON WHERE MAHD = ? and MASP =?";
            case "SELECTBYID":
                return "SELECT SOLUONG, GHICHU, TRANGTHAI FROM CT_HOADON WHERE MAHD = ? and MASP = ?";
            case "SELECTALL":
                return "SELECT CT_HOADON.* FROM   CT_HOADON";
            case "SELECTCTHD":
                return "SELECT * FROM CT_HOADON WHERE MAHD = ?";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, CTHoaDon obj) {
        switch(action){
            case "INSERT":
                return new Object[]{
                    obj.getMaHD(),
                    obj.getMaSP(),
                    obj.getSoLuong(),
                    obj.getGiaBan(),
                    obj.getGhiChu()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getSoLuong(),
                    obj.getGiaBan(),
                    obj.getGhiChu(),
                    obj.isTrangThai(),
                    obj.getMaHD(),
                    obj.getMaSP()
                };
        }
        return null;
    }

    @Override
    public CTHoaDon createEntity(ResultSet rs) throws SQLException {
        CTHoaDon cTHD = new CTHoaDon();
        cTHD.setMaHD(rs.getInt("MAHD"));
        cTHD.setMaSP(rs.getInt("MASP"));
        cTHD.setSoLuong(rs.getInt("SOLUONG"));
        cTHD.setGhiChu(rs.getString("GHICHU"));
        cTHD.setTrangThai(rs.getBoolean("TRANGTHAI"));
        cTHD.setGiaBan(rs.getDouble("GIABAN"));
        return cTHD;
    }
    
    public ArrayList<CTHoaDon> selectCTHD(int maHD) throws Exception{
         ArrayList<CTHoaDon> list = new ArrayList<>();
        ResultSet rs = XJDBC.query(this.getQuery("SELECTCTHD"), maHD);
        while(rs.next()){
            CTHoaDon e2 = createEntity(rs);
            list.add(e2);
        }
        rs.getStatement().getConnection().close();
        return list;
    }
    
    public boolean deleteOnerecord(int maHD, int maSP) throws Exception {
        return XJDBC.update(this.getQuery("DELETE"), maHD, maSP) > 0;
    }
}
