/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DanhMuc;
import ViewModels.DanhMucModel;
import java.util.ArrayList;
import responsitories.DanhMucResponsitory;

/**
 *
 * @author Asus
 */
public class DanhMucService {
    DanhMucResponsitory dmr = new DanhMucResponsitory();

    public ArrayList<DanhMucModel> getAllDanhMuc() {
        ArrayList<DanhMucModel> list = new ArrayList<>();
        ArrayList<DanhMuc> dm = dmr.getAllDanhMuc();
        for (DanhMuc x : dm) {
            list.add(new DanhMucModel(x.getIdDM(), x.getMaDM(), x.getTenDM(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public DanhMucModel insertDM(DanhMucModel dmm) {
        ArrayList<DanhMuc> list = dmr.getAllDanhMuc();
        for (DanhMuc dm : list) {
            if (dm.getMaDM().equalsIgnoreCase(dmm.getMaDM())) {
                return null;
            }
        }
        var x = dmr.insertDM(new DanhMuc(dmm.getMaDM(), dmm.getTenDM(), dmm.getTrangThai()));
        return new DanhMucModel(x.getMaDM(), x.getTenDM(), x.getTrangThai());
    }

    public DanhMucModel updateDM(DanhMucModel dmm) {
        var x = dmr.updateDm(new DanhMuc(dmm.getMaDM(), dmm.getTenDM(), dmm.getTrangThai()));
        return new DanhMucModel(x.getMaDM(), x.getTenDM(), x.getTrangThai());
    }

    public Integer deleteDM(String id) {
        return dmr.deleteDM(id);
    }
}
