/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.GiaoCa;
import ViewModels.GiaoCaModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import responsitories.GiaoCaResbonsitory;

/**
 *
 * @author Asus
 */
public class GiaoCaService {
    GiaoCaResbonsitory gcr = new GiaoCaResbonsitory();

    public ArrayList<GiaoCaModel> getAllGiaoCa() {
        ArrayList<GiaoCaModel> list = new ArrayList<>();
        ArrayList<GiaoCa> gc = gcr.getAllGC();
        for (GiaoCa x : gc) {
            list.add(new GiaoCaModel(x.getIdGC(), x.getMaGC(),x.getMaNVGiao(),x.getMaNVNhan(), x.getGioGiaoCa(),x.getGioNhanCao(),x.getTienCoSo(),x.getTienPhatSinh(), x.getDoanhThuCa(), x.getTongTien(),x.getGhiChuGiao(),x.getGhiChuNhan(),x.getNgayTao(),x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }
    
     public GiaoCaModel insertGC (GiaoCaModel gcm) {
        ArrayList<GiaoCa> gc = gcr.getAllGC();
        for (GiaoCa gca : gc) {
            if (gca.getMaGC().equalsIgnoreCase(gcm.getMaGC())) {
                return null;
            }
        }
        var x = gcr.insertGC(new GiaoCa(gcm.getIdGC(),gcm.getMaGC(),gcm.getMaNVGiao(), gcm.getMaNVNhan(),gcm.getGioGiaoCa(),gcm.getGioNhanCao(),gcm.getTienCoSo(),gcm.getTienPhatSinh(),gcm.getDoanhThuCa(),gcm.getTongTien(), gcm.getGhiChuGiao(),gcm.getGhiChuNhan(),gcm.getNgayTao(),gcm.getNgaySua(),gcm.getTrangThai()));
        return new GiaoCaModel(x.getIdGC(), x.getMaGC(),x.getMaNVGiao(),x.getMaNVNhan(), x.getGioGiaoCa(),x.getGioNhanCao(),x.getTienCoSo(),x.getTienPhatSinh(), x.getDoanhThuCa(), x.getTongTien(),x.getGhiChuGiao(),x.getGhiChuNhan(),x.getNgayTao(),x.getNgaySua(), x.getTrangThai());

    }

    public GiaoCaModel updateGC(GiaoCaModel gcm) {
        var x = gcr.insertGC(new GiaoCa(gcm.getIdGC(),gcm.getMaGC(),gcm.getMaNVGiao(), gcm.getMaNVNhan(),gcm.getGioGiaoCa(),gcm.getGioNhanCao(),gcm.getTienCoSo(),gcm.getTienPhatSinh(),gcm.getDoanhThuCa(),gcm.getTongTien(), gcm.getGhiChuGiao(),gcm.getGhiChuNhan(),gcm.getNgayTao(),gcm.getNgaySua(),gcm.getTrangThai()));
        return new GiaoCaModel(x.getIdGC(), x.getMaGC(),x.getMaNVGiao(),x.getMaNVNhan(), x.getGioGiaoCa(),x.getGioNhanCao(),x.getTienCoSo(),x.getTienPhatSinh(), x.getDoanhThuCa(), x.getTongTien(),x.getGhiChuGiao(),x.getGhiChuNhan(),x.getNgayTao(),x.getNgaySua(), x.getTrangThai());


    }

    public Integer deleteGC(String id) {
        return gcr.deleteGC(id);
    }
}
