package responsitories;

import DomainModels.GiaoCa;
import DomainModels.NhanVien;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiaoCaResbonsitory {

    NhanVienResponsitory nv = new NhanVienResponsitory();

    public ArrayList<GiaoCa> getAllGC() {
        ArrayList<GiaoCa> list = new ArrayList<>();
        String sql = "SELECT * FROM GiaoCa";
        ResultSet rs = JDBCHelper.executeQuery(sql);

        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                NhanVien nv2 = nv.getNVByID(rs.getString(4));

                list.add(new GiaoCa(rs.getString(1), rs.getString(2), nv1, nv2, rs.getString(5), rs.getString(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getBigDecimal(9), rs.getBigDecimal(10), rs.getString(11), rs.getString(12), rs.getDate(13), rs.getDate(14), rs.getInt(15)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoCaResbonsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public GiaoCa getGCByID(String id) {

        String sql = "select * from giaoca where id=?";
        ResultSet rs = JDBCHelper.executeQuery(sql, id);
        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                NhanVien nv2 = nv.getNVByID(rs.getString(4));
                return new GiaoCa(rs.getString(1), rs.getString(2), nv1, nv2, rs.getString(5), rs.getString(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getBigDecimal(9), rs.getBigDecimal(10), rs.getString(11), rs.getString(12), rs.getDate(13), rs.getDate(14), rs.getInt(15));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public GiaoCa insertGC(GiaoCa gc) {
        String sql = "INSERT INTO GiaoCa VALUES (NEWID(),?,?,?,?,?,?,?,?,?,?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, gc.getMaGC(), gc.getMaNVGiao(), gc.getMaNVNhan(), gc.getGioNhanCao(), gc.getGioGiaoCa(), gc.getTienCoSo(), gc.getTienPhatSinh(), gc.getDoanhThuCa(), gc.getTongTien(), gc.getGhiChuGiao(),
                 gc.getGhiChuNhan(), gc.getNgayTao(), gc.getNgaySua(), gc.getTrangThai());
        return gc;
    }
       public GiaoCa updateGC(GiaoCa gc) {
        String sql = "UPDATE GiaoCa SET MaGC=?,MaNVGiao=?,MaNVNhan=?,GioNhanCa=?,GioGiaoCa=?,TienCoso=?,TienPhatSinh=?,DoanhThuCa=?,TongTien=?,GhiChuGiao=?, GhiChuNhan=?,NgayTao=?,NgaySua=GETDATE(),TrangThai=? WHERE ID=?";
        JDBCHelper.executeUpdate(sql, gc.getMaGC(), gc.getMaNVGiao(), gc.getMaNVNhan(),gc.getGioNhanCao(),gc.getGioGiaoCa(),gc.getTienCoSo(),gc.getTienPhatSinh(),gc.getDoanhThuCa(),gc.getTongTien(),
                gc.getGhiChuGiao(),gc.getGhiChuNhan(),gc.getNgayTao(),gc.getNgaySua(),gc.getTrangThai(),gc.getIdGC());
        return gc;
    }
    public Integer deleteGC(String id) {
        String sql = "DELETE FROM GiaoCa WHERE MaGC=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }
}
