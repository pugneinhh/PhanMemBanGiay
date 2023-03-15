/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DoCao;
import ViewModels.DoCaoModel;
import java.util.ArrayList;
import responsitories.DoCaoResponsitory;

/**
 *
 * @author Asus
 */
public class DoCaoService {
    DoCaoResponsitory dcr = new DoCaoResponsitory();

    public ArrayList<DoCaoModel> getAllDoCao() {
        ArrayList<DoCaoModel> list = new ArrayList<>();
        ArrayList<DoCao> dc = dcr.getAllDoCao();
        for (DoCao x : dc) {
            list.add(new DoCaoModel(x.getIdDC(), x.getMaDC(), x.getTenDC(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public DoCaoModel insertDC(DoCaoModel dcm) {
        ArrayList<DoCao> list = dcr.getAllDoCao();
        for (DoCao dc : list) {
            if (dc.getMaDC().equalsIgnoreCase(dcm.getMaDC())) {
                return null;
            }
        }
        var x = dcr.insertDC(new DoCao(dcm.getMaDC(), dcm.getTenDC(), dcm.getTrangThai()));
        return new DoCaoModel(x.getMaDC(), x.getTenDC(), x.getTrangThai());
    }

    public DoCaoModel updateDC(DoCaoModel dcm) {
        var x = dcr.updateDC(new DoCao(dcm.getMaDC(), dcm.getTenDC(),dcm.getTrangThai()));
        return new DoCaoModel(x.getMaDC(), x.getTenDC(), x.getTrangThai());
    }

    public Integer deleteDC(String id) {
        return dcr.deleteDC(id);
    }
}
