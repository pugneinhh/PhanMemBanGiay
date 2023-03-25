
package Services;

import DomainModels.HoaDon;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;
import responsitories.HoaDonresbonsitory;

/**
 *
 * @author HP
 */
public class hoadonservice {
     private final HoaDonresbonsitory hd;

    public hoadonservice() {
        this.hd = new HoaDonresbonsitory();
    }

    public ArrayList<HoaDonViewModel> getAllhoadon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        ArrayList<HoaDonViewModel> kh = hd.getAllhoadon();
        for (HoaDonViewModel x : kh) {
            list.add(new HoaDonViewModel( x.getIdNV(), x.getIdKH(), x.getNgaymua(),x.getThanhTien(), 
                    x.getIdKM(), x.getGhiChu(), x.getNgaySua(), x.getNgaytao(), x.getTrangThai(), x.getMahd()));
        }
        return list;
    }
    public ArrayList<HoaDonViewModel> gettheoidhd(String id){
        return hd.gethdByID(id);
    }
}
