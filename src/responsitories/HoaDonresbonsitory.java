
package responsitories;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import Utilities.JDBCHelper;
import ViewModels.HoaDonViewModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HoaDonresbonsitory {
    NhanVienResponsitory nv = new NhanVienResponsitory();
    KhachHangResponsitory kh=new KhachHangResponsitory();
    KhuyenMaiResbonsitory km=new KhuyenMaiResbonsitory();
    public ArrayList<HoaDonViewModel> getAllhoadon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT * FROM hoadon";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1=kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1=km.getKMByID(rs.getString(7));
                
                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(9), rs.getDate(10), rs.getInt(11)));
           
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }


    
      public HoaDon getHDbyID(String id) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM hoadon";
        ResultSet rs = JDBCHelper.excuteQuery(sql);

        try {
            while (rs.next()) {                              
                list.add(new HoaDon(rs.getString(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }

       return null;
    }


}
