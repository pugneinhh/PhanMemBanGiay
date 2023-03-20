package responsitories;

import DomainModels.KhuyenMai;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class KhuyenMaiResbonsitory {

    public ArrayList<KhuyenMai> getAllKM() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select *from KhuyenMai";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiResbonsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public KhuyenMai getKMByID(String id) {

        String sql = "select *from KhuyenMai where id=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {

                return new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiResbonsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public KhuyenMai insertKM(KhuyenMai KM) {
        String sql = "INSERT INTO KhuyenMai VALUES (NEWID(),?,?,?,?,?,?,?,?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, KM.getMaKM(), KM.getTenKM(), KM.getGiaTri(),
                KM.getGiamToiDa(), KM.getNgayBatDau(), KM.getNgayKetThuc(), KM.getHinhThucApDung(), KM.getApDungGiamGia(), KM.getLoaiGiamGia(), KM.getNgayTao(), KM.getNgaySua(), KM.getTrangThai());
        return KM;
    }

    public KhuyenMai updateKM(KhuyenMai KM) {
        String sql = "UPDATE KhuyenMai SET tenKM=?,giaTri=?,giamToiDa=?,ngayBatDau=?,ngayKetThuc=?,hinhThucApDung=?,apDungGiamGia=?,loaiGiamGia=?,NgayTao=?,NgaySua=GETDATE(),TrangThai=? WHERE maKM=?";
        JDBCHelper.executeUpdate(sql, KM.getTenKM(), KM.getGiaTri(),
                KM.getGiamToiDa(), KM.getNgayBatDau(), KM.getNgayKetThuc(), KM.getHinhThucApDung(), KM.getApDungGiamGia(), KM.getLoaiGiamGia(), KM.getNgayTao(), KM.getNgaySua(), KM.getTrangThai(),KM.getMaKM());
        return KM;
    }

    public Integer deleteKM(String id) {
        String sql = "DELETE FROM KhuyenMai WHERE maKM=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;
    }
}
