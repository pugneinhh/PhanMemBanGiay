/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChatLieu;
import ViewModels.ChatLieuModel;
import java.util.ArrayList;
import responsitories.ChatLieuResponsitory;

/**
 *
 * @author Asus
 */
public class ChatLieuService {
     ChatLieuResponsitory clr = new ChatLieuResponsitory();

    public ArrayList<ChatLieuModel> getAllChatLieu() {
        ArrayList<ChatLieuModel> list = new ArrayList<>();
        ArrayList<ChatLieu> cl = clr.getAllChatLieu();
        for (ChatLieu x : cl) {
            list.add(new ChatLieuModel(x.getIdCL(), x.getMaCL(), x.getTenCL(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
        }
        return list;
    }

    public ChatLieuModel insertCL(ChatLieuModel clm) {
        ArrayList<ChatLieu> list = clr.getAllChatLieu();
        for (ChatLieu cl : list) {
            if (cl.getMaCL().equalsIgnoreCase(clm.getMaCL())) {
                return null;
            }
        }
        var x = clr.insertCL(new ChatLieu(clm.getMaCL(), clm.getTenCL(), clm.getTrangThai()));
        return new ChatLieuModel(x.getMaCL(), x.getTenCL(), x.getTrangThai());
    }

    public ChatLieuModel updateCL(ChatLieuModel clm) {
        var x = clr.updateCL(new ChatLieu(clm.getMaCL(), clm.getTenCL(), clm.getTrangThai()));
        return new ChatLieuModel(x.getMaCL(), x.getTenCL(), x.getTrangThai());
    }

    public Integer deleteCL(String id) {
        return clr.deleteCL(id);
    }
}
