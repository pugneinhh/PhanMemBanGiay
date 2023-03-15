/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import ViewModels.ChucVuModel;
import java.util.ArrayList;
import responsitories.ChucVuResponsitory;

/**
 *
 * @author Phanh
 */
public class ChucVuService {

    ChucVuResponsitory cvr = new ChucVuResponsitory();

    public ArrayList<ChucVuModel> getAllChucVu() {
        ArrayList<ChucVuModel> list = new ArrayList<>();
        ArrayList<ChucVu> cv = cvr.getAllChucVu();
        for (ChucVu x : cv) {
            list.add(new ChucVuModel(x.getIdCV(), x.getMaCV(), x.getTenCV(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ChucVuModel insertCV(ChucVuModel cvm) {
        ArrayList<ChucVu> list = cvr.getAllChucVu();
        for (ChucVu cv : list) {
            if (cv.getMaCV().equalsIgnoreCase(cvm.getMaCV())) {
                return null;
            }
        }
        var x = cvr.insertCV(new ChucVu(cvm.getMaCV(), cvm.getTenCV(), cvm.getTrangThai()));
        return new ChucVuModel(x.getMaCV(), x.getTenCV(), x.getTrangThai());
    }

    public ChucVuModel updateCV(ChucVuModel cvm) {
        var x = cvr.updateCV(new ChucVu(cvm.getMaCV(), cvm.getTenCV(), cvm.getTrangThai()));
        return new ChucVuModel(x.getMaCV(), x.getTenCV(), x.getTrangThai());
    }

    public Integer deleteCV(String id) {
        return cvr.deleteCV(id);
    }
}
