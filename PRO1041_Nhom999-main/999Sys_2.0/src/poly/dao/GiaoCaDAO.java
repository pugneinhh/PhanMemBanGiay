/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import poly.entity.GiaoCa;
import poly.entity.TrangThaiGiaoCa;
import poly.helper.Auth;
import poly.helper.XDate;
import poly.helper.XJDBC;

/**
 *
 * @author NTV
 */
public class GiaoCaDAO extends BaseDao<GiaoCa, Object> {

    private Locale localeVN = new Locale("vi", "VN");
    private NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);
    private SimpleDateFormat sdf = new SimpleDateFormat("M d yyyy hh:mm aa");

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO GIAOCA (MANVGIAOCA) VALUES (?)";

            case "UPDATE":
                return "UPDATE GIAOCA SET "
                        + "MANVNHANCA = ?, GIOGIAOCA = ?, "
                        + "TIENPHATSINH = ?, DOANHTHUCA = ?, "
                        + "GHICHUGIAO = ?, TONGTIEN = ?, MATT = ? "
                        + " WHERE MAGIAOCA = ?";

            case "DELETE":
                return "UPDATE GIAOCA SET MATT = ? WHERE MAGIAOCA = ?";

            case "SELECTBYID":
                return "SELECT MAGIAOCA, MANVGIAOCA, MANVNHANCA, GIONHANCA, "
                        + "GIOGIAOCA, TIENCOSO, TIENPHATSINH, "
                        + "dbo.FNDTC(MANVGIAOCA) AS DOANHTHUCA, "
                        + " TONGTIEN, GHICHUGIAO, GHICHUNHAN, MATT FROM GIAOCA WHERE MANVGIAOCA LIKE ? AND (MATT = 2 OR MATT = 3)"
                        + " ORDER BY GIONHANCA DESC";

            case "SELECTALL":
                return "SELECT MAGIAOCA, MANVGIAOCA, MANVNHANCA, GIONHANCA, "
                        + "GIOGIAOCA, TIENCOSO, TIENPHATSINH, "
                        + "DOANHTHUCA, "
                        + " TONGTIEN, GHICHUGIAO, GHICHUNHAN, MATT FROM GIAOCA";

            case "SELECTBYIDNC":
                return "SELECT MAGIAOCA, MANVGIAOCA, MANVNHANCA, GIONHANCA, "
                        + "GIOGIAOCA, TIENCOSO, TIENPHATSINH, "
                        + "DOANHTHUCA, "
                        + " TONGTIEN, GHICHUGIAO, GHICHUNHAN, MATT FROM GIAOCA "
                        + "WHERE MATT = 3 AND MANVNHANCA LIKE ?";

            case "UPDATENC":
                return "UPDATE GIAOCA SET "
                        + "GHICHUNHAN = ?, MATT = ? "
                        + " WHERE MAGIAOCA = ?";
            case "INSERTAFTERNC":
                return "INSERT INTO GIAOCA (MANVGIAOCA, TIENCOSO) VALUES (?,?)";

            case "TTGiaoCa":
                return "SELECT * FROM TTGIAOCA";

            case "SELECTGIAOCA":
                return "SELECT 'CA' + CAST(MAGIAOCA AS VARCHAR) as MAGIAOCA, TK.HOTEN NHANVIENGC, IIF(TK1.HOTEN IS NULL, N'Chưa có', TK1.HOTEN) NHANVIENNC, CONVERT(VARCHAR,GIONHANCA) as GIONHANCA, IIF(GIOGIAOCA IS NULL, N'Chưa giao', CONVERT(VARCHAR,GIOGIAOCA)) as GIOGIAOCA, TIENCOSO, TIENPHATSINH, DOANHTHUCA, TONGTIEN, IIF(GHICHUGIAO IS NULL, N'Chưa có', GHICHUGIAO) GHICHUGIAO, IIF(GHICHUNHAN IS NULL, N'Chưa có', GHICHUNHAN) GHICHUNHAN, TTGC.TENTT \n"
                        + "	FROM GIAOCA GC JOIN TAIKHOAN TK ON TK.MANV = GC.MANVGIAOCA JOIN TTGIAOCA TTGC ON TTGC.MATT = GC.MATT  LEFT JOIN TAIKHOAN TK1 ON TK1.MANV = GC.MANVNHANCA";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, GiaoCa obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaNVGiaoCa()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaNVNhan(),
                    obj.getGioGiaoCa(),
                    obj.getTienPhatSinh(),
                    obj.getDoanhThuCa(),
                    obj.getGhiChuGC(),
                    obj.getTongTien(),
                    obj.getMaTT(),
                    obj.getMaGiaoCa()
                };
            case "UPDATENC":
                return new Object[]{
                    obj.getGhiChuNC(),
                    obj.getMaTT(),
                    obj.getMaGiaoCa()
                };
            case "INSERTAFTERNC":
                return new Object[]{
                    obj.getMaNVGiaoCa(),
                    obj.getTienCoSo()
                };

        }
        return null;
    }

    @Override
    public GiaoCa createEntity(ResultSet rs) throws SQLException {
        GiaoCa gc = new GiaoCa();
        gc.setMaGiaoCa(rs.getInt("MAGIAOCA"));
        gc.setMaTT(rs.getInt("MATT"));
        gc.setMaNVGiaoCa(rs.getString("MANVGIAOCA"));
        gc.setGhiChuGC(rs.getString("GHICHUGIAO"));
        gc.setGhiChuNC(rs.getString("GHICHUNHAN"));
        gc.setMaNVNhan(rs.getString("MANVNHANCA"));
        gc.setGioGiaoCa(rs.getString("GIOGIAOCA"));
        gc.setGioNhanCa(rs.getString("GIONHANCA"));
        gc.setTienCoSo(rs.getDouble("TIENCOSO"));
        gc.setTienPhatSinh(rs.getDouble("TIENPHATSINH"));
        gc.setDoanhThuCa(rs.getDouble("DOANHTHUCA"));
        gc.setTongTien(rs.getDouble("TONGTIEN"));
        return gc;
    }

    public GiaoCa selectByIDNC() throws SQLException {
        ResultSet rs = XJDBC.query(getQuery("SELECTBYIDNC"), Auth.user.getMaNV());
        if (rs.next()) {
            return createEntity(rs);
        }
        return null;
    }

    public boolean updateNC(GiaoCa gc) {
        return XJDBC.update(getQuery("UPDATENC"), getParams("UPDATENC", gc)) > 0;
    }

    public boolean insertAfterGC(GiaoCa gc) {

        return XJDBC.update(getQuery("INSERTAFTERNC"), getParams("INSERTAFTERNC", gc)) > 0;
    }

    public List<Object[]> selectGiaoCa() throws Exception {
        List<Object[]> lst = new ArrayList<>();
        ResultSet rs = XJDBC.query(getQuery("SELECTGIAOCA"));
        while (rs.next()) {
            String tienCS = df.format(rs.getDouble("TIENCOSO"));
            String tienPS = df.format(rs.getDouble("TIENPHATSINH"));
            String doanhThu = df.format(rs.getDouble("DOANHTHUCA"));
            String tongTien = df.format(rs.getDouble("TONGTIEN"));
            String gioNC = XDate.toString(XDate.toDate(rs.getString("GIONHANCA"), "MMMM d yyyy hh:mmaa"), "hh:mm aa dd/MM/yyyy");
            String gioGC = "Chưa giao";
            if (!rs.getString("GIOGIAOCA").equals("Chưa giao")) {
                gioGC = XDate.toString(XDate.toDate(rs.getString("GIOGIAOCA"), "MMMM d yyyy hh:mmaa"), "hh:mm aa dd/MM/yyyy");
            }
            lst.add(new Object[]{
                rs.getString("MAGIAOCA"),
                rs.getString("NHANVIENGC"),
                rs.getString("NHANVIENNC"),
                gioNC,
                gioGC,
                tienCS,
                tienPS,
                doanhThu,
                tongTien,
                rs.getString("GHICHUGIAO"),
                rs.getString("GHICHUNHAN"),
                rs.getString("TENTT")

            });
        }
        return lst;
    }
    
    public List<TrangThaiGiaoCa> selectTTGiaoCa() throws Exception {
        List<TrangThaiGiaoCa> lst = new ArrayList<>();
        ResultSet rs = XJDBC.query(getQuery("TTGiaoCa"));
        while (rs.next()) {
            TrangThaiGiaoCa ttGC = new TrangThaiGiaoCa();
            ttGC.setMaTT(rs.getInt("MATT"));
            ttGC.setTenTT(rs.getString("TENTT"));
            lst.add(ttGC);
        }
        return lst;
    }
    
    public List<Object[]> timKiemCBB(String maNVGC, String maNVNC, int maTT) throws Exception {
        List<Object[]> lst = new ArrayList<>();
        String sql = "{CALL SP_TIMKIEMGIAOCA(?, ?, ?)}";
        ResultSet rs = XJDBC.query(sql, maNVGC, maNVNC, maTT);
        while (rs.next()) {
            String tienCS = df.format(rs.getDouble("TIENCOSO"));
            String tienPS = df.format(rs.getDouble("TIENPHATSINH"));
            String doanhThu = df.format(rs.getDouble("DOANHTHUCA"));
            String tongTien = df.format(rs.getDouble("TONGTIEN"));
            String gioNC = XDate.toString(XDate.toDate(rs.getString("GIONHANCA"), "MMMM d yyyy hh:mmaa"), "hh:mm aa dd/MM/yyyy");
            String gioGC = "Chưa giao";
            if (!rs.getString("GIOGIAOCA").equals("Chưa giao")) {
                gioGC = XDate.toString(XDate.toDate(rs.getString("GIOGIAOCA"), "MMMM d yyyy hh:mmaa"), "hh:mm aa dd/MM/yyyy");
            }
            lst.add(new Object[]{
                rs.getString("MAGIAOCA"),
                rs.getString("NHANVIENGC"),
                rs.getString("NHANVIENNC"),
                gioNC,
                gioGC,
                tienCS,
                tienPS,
                doanhThu,
                tongTien,
                rs.getString("GHICHUGIAO"),
                rs.getString("GHICHUNHAN"),
                rs.getString("TENTT")

            });
        }
        return lst;
    }

    public List<Object[]> timKiemCBB(String maNVGC, String maNVNC) throws Exception {
        List<Object[]> lst = new ArrayList<>();
        String sql = "{CALL SP_TIMKIEMGIAOCA(?, ?, null)}";
        ResultSet rs = XJDBC.query(sql, maNVGC, maNVNC);
        while (rs.next()) {
            String tienCS = df.format(rs.getDouble("TIENCOSO"));
            String tienPS = df.format(rs.getDouble("TIENPHATSINH"));
            String doanhThu = df.format(rs.getDouble("DOANHTHUCA"));
            String tongTien = df.format(rs.getDouble("TONGTIEN"));
            String gioNC = XDate.toString(XDate.toDate(rs.getString("GIONHANCA"), "MMMM d yyyy hh:mmaa"), "hh:mm aa dd/MM/yyyy");
            String gioGC = "Chưa giao";
            if (!rs.getString("GIOGIAOCA").equals("Chưa giao")) {
                gioGC = XDate.toString(XDate.toDate(rs.getString("GIOGIAOCA"), "MMMM d yyyy hh:mmaa"), "hh:mm aa dd/MM/yyyy");
            }
            lst.add(new Object[]{
                rs.getString("MAGIAOCA"),
                rs.getString("NHANVIENGC"),
                rs.getString("NHANVIENNC"),
                gioNC,
                gioGC,
                tienCS,
                tienPS,
                doanhThu,
                tongTien,
                rs.getString("GHICHUGIAO"),
                rs.getString("GHICHUNHAN"),
                rs.getString("TENTT")

            });
        }
        return lst;
    }
}
