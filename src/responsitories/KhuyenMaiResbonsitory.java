package responsitories;

import DomainModels.ChatLieu;
import DomainModels.ChiTietSanPham;
import DomainModels.DanhMuc;
import DomainModels.DoCao;
import DomainModels.KhuyenMai;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import Services.ChiTietSanPhamService;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import ViewModels.ChiTietSanPhamModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.List;

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
            ex.printStackTrace();
        }

        return list;
    }
    public ArrayList<KhuyenMai> getKMAD() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select *from KhuyenMai where trangthai=0";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            ex.printStackTrace();
        }
        return null;
    }

    public KhuyenMai insertKM(KhuyenMai KM) {
        String sql = "INSERT INTO KhuyenMai VALUES (NEWID(),?,?,?,?,?,?,?,?,?,GetDate(),null,?)";
        JDBCHelper.executeUpdate(sql, KM.getMaKM(), KM.getTenKM(), KM.getGiaTri(),
                KM.getGiamToiDa(), KM.getNgayBatDau(), KM.getNgayKetThuc(), KM.getHinhThucApDung(), KM.getApDungGiamGia(),
                KM.getLoaiGiamGia(), KM.getTrangThai());
        return KM;
    }

    public KhuyenMai updateKM(KhuyenMai KM) {
        String sql = "UPDATE KhuyenMai SET tenKM=?,giaTri=?,giamToiDa=?, ngayBatDau=?, ngayKetThuc=?,hinhThucApDung=?,apDungGiamGia=?,loaiGiamGia=?,NgaySua=GETDATE(),TrangThai=? WHERE maKM=?";
        JDBCHelper.executeUpdate(sql, KM.getTenKM(), KM.getGiaTri(),
                KM.getGiamToiDa(), KM.getNgayBatDau(), KM.getNgayKetThuc(), KM.getHinhThucApDung(), KM.getApDungGiamGia(), KM.getLoaiGiamGia(), KM.getTrangThai(), KM.getMaKM());
        return KM;
    }

    public Integer deleteKM(String id) {
        String sql = "DELETE FROM KhuyenMai WHERE maKM=?";
        int row = JDBCHelper.executeUpdate(sql, id);
        return row;

    }

//    public KhuyenMai aaaa(KhuyenMai km) {
//        String sql = "YOUR INSERT STATEMENT HERE";
//        Connection conn = DBConnection.getConnection();
//
//        PreparedStatement ps = conn.prepareStatement(sql,
//                Statement.RETURN_GENERATED_KEYS);
//
//        ps.execute();
//
//        ResultSet rs = ps.getGeneratedKeys();
//        int generatedKey = 0;
//        if (rs.next()) {
//            generatedKey = rs.getInt(1);
//        }
//
//        System.out.println("Inserted record's ID: " + generatedKey);
//    }
    public static void main(String[] args) {
        try {
            BigDecimal giatri = null;
            giatri = BigDecimal.valueOf(Double.parseDouble("111000"));
            BigDecimal giamtoida = null;
            giamtoida = BigDecimal.valueOf(Double.parseDouble("222000"));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = date.parse("2022-02-02");
            Date d = date.parse("2022-06-08");
            KhuyenMai km
                    = new KhuyenMaiResbonsitory().insertKM(new KhuyenMai("M5trs34", "wqedfsc",
                            giatri,
                            giamtoida,
                            dt,
                            d,
                            "Giảm theo %", "Hóa Đơn Trên 300000", "Chương trình", 1));
 System.out.println(km.getIdKM());
//            ChiTietSanPhamModel ctspm = new ChiTietSanPhamModel();
//            SanPham sanPham = new SanPham("A4734480-41C2-4116-9C87-15987D56A949");
//            DanhMuc danhMuc = new DanhMuc("9E9C8B02-1440-45A6-8425-042DB956EA11");
//            ChatLieu chatLieu = new ChatLieu("1D08AE8E-8412-49EB-A3ED-37874501AA17");
//            Size size = new Size("368FEBDB-9415-4AA4-8E10-AFD57540A3C1");
//            DoCao doCao = new DoCao("E56635BF-B728-41B7-90D8-42042BCEBD0D");
//            MauSac mauSac = new MauSac("55C01E09-2109-4C30-8846-1041432CB946");
//
//            ctspm.setIdKM(km);
//
//            ctspm.setIdSP(sanPham);
//            ctspm.setIdDM(danhMuc);
//            ctspm.setIdCL(chatLieu);
//            ctspm.setIdDC(doCao);
//            ctspm.setIdMS(mauSac);
//            ctspm.setIdSize(size);
//            ctspm.setMaQR(20012003);
//            ChiTietSanPhamResponsitory ctspr = new ChiTietSanPhamResponsitory();
//            ChiTietSanPhamService ctsps = new ChiTietSanPhamService();
//            ChiTietSanPhamModel cmm = ctsps.updateCTSP(ctspm);
           

        } catch (ParseException ex) {
            Logger.getLogger(KhuyenMaiResbonsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
////        System.out.println(km.get);
//
           KhuyenMaiResbonsitory khuyenMaiRespon=  new KhuyenMaiResbonsitory();
          List<KhuyenMai>  list=  khuyenMaiRespon.getAllKM();
          for (KhuyenMai o : list) {
              System.out.println( o.toString());
        }

    }
    public ArrayList<KhuyenMai> getIDByMa(String ma){
        ArrayList<KhuyenMai> list  = new ArrayList<>();
        String sql = "select * from khuyenmai where makm=?";
         ResultSet rs = JDBCHelper.excuteQuery(sql,ma);
        try {
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4),rs.getBigDecimal(5), rs.getDate(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getInt(13)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;       
    }
}