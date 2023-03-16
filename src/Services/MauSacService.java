/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import ViewModels.MauSacModel;
import java.util.ArrayList;
import responsitories.MauSacResponsitory;

/**
 *
 * @author Asus
 */
public class MauSacService {
     MauSacResponsitory msr = new MauSacResponsitory();

    public ArrayList<MauSacModel> getAllMauSac() {
        ArrayList<MauSacModel> list = new ArrayList<>();
        ArrayList<MauSac> ms = msr.getAllMauSac();
        for (MauSac x : ms) {
            list.add(new MauSacModel(x.getIdMS(), x.getMaMS(), x.getTenMS(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public MauSacModel insertMS(MauSacModel msm) {
        ArrayList<MauSac> list = msr.getAllMauSac();
        for (MauSac ms : list) {
            if (ms.getMaMS().equalsIgnoreCase(msm.getMaMS())) {
                return null;
            }
        }
        var x = msr.insertMS(new MauSac(msm.getMaMS(), msm.getTenMS(), msm.getTrangThai()));
        return new MauSacModel(x.getMaMS(), x.getTenMS(), x.getTrangThai());
    }

    public MauSacModel updateMS(MauSacModel msm) {
        var x = msr.updateMS(new MauSac(msm.getMaMS(), msm.getTenMS(), msm.getTrangThai()));
        return new MauSacModel(x.getMaMS(), x.getTenMS(), x.getTrangThai());
    }

    public Integer deleteMS(String id) {
        return msr.deleteMS(id);
    }
}
