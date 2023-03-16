/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.Size;
import ViewModels.SizeModel;
import java.util.ArrayList;
import responsitories.SizeResponsitory;

/**
 *
 * @author Asus
 */
public class SizeService {
     SizeResponsitory sizer = new  SizeResponsitory();

    public ArrayList<SizeModel> getAllSize() {
        ArrayList<SizeModel> list = new ArrayList<>();
        ArrayList<Size> dc = sizer.getAllSize();
        for (Size x : dc) {
            list.add(new SizeModel(x.getIdSize(), x.getMaSize(), x.getTenSize(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public SizeModel insertSize(SizeModel sizem) {
        ArrayList<Size> list = sizer.getAllSize();
        for (Size size : list) {
            if (size.getMaSize().equalsIgnoreCase(sizem.getMaSize())) {
                return null;
            }
        }
        var x = sizer.insertSize(new Size(sizem.getMaSize(), sizem.getTenSize(), sizem.getTrangThai()));
        return new SizeModel(x.getMaSize(), x.getTenSize(), x.getTrangThai());
    }

    public SizeModel updateSize(SizeModel sizem) {
        var x = sizer.updateSize(new Size(sizem.getMaSize(), sizem.getTenSize(),sizem.getTrangThai()));
        return new SizeModel(x.getMaSize(), x.getTenSize(), x.getTrangThai());
    }

    public Integer deleteSize(String id) {
        return sizer.deleteSize(id);
    }
}
