/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhuyenMai;
import ViewModels.KhuyenMaiModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import responsitories.KhuyenMaiResbonsitory;

/**
 *
 * @author Asus
 */
public class KhuyenMaiService {
    
    KhuyenMaiResbonsitory kmr = new KhuyenMaiResbonsitory();
    
    public ArrayList<KhuyenMaiModel> getAllKhuyenMai(){
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        ArrayList<KhuyenMai> km = kmr.getAllKM();
        for(KhuyenMai x : km){
            
            list.add(new KhuyenMaiModel(x.getIdKM(), x.getMaKM(), x.getTenKM(),x.getGiaTri(),x.getGiamToiDa(), x.getNgayBatDau(), x.getNgayKetThuc(),x.getHinhThucApDung(), x.getApDungGiamGia(),x.getLoaiGiamGia(),x.getNgayTao(),x.getNgaySua(),x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<KhuyenMaiModel> getKhuyenMaiHD(){
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        ArrayList<KhuyenMai> km = kmr.getKMHD();
        for(KhuyenMai x : km){
            
            list.add(new KhuyenMaiModel(x.getIdKM(), x.getMaKM(), x.getTenKM(),x.getGiaTri(),x.getGiamToiDa(), x.getNgayBatDau(), x.getNgayKetThuc(),x.getHinhThucApDung(), x.getApDungGiamGia(),x.getLoaiGiamGia(),x.getNgayTao(),x.getNgaySua(),x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<KhuyenMaiModel> getKhuyenMaiSP(){
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        ArrayList<KhuyenMai> km = kmr.getKMSP();
        for(KhuyenMai x : km){
            
            list.add(new KhuyenMaiModel(x.getIdKM(), x.getMaKM(), x.getTenKM(),x.getGiaTri(),x.getGiamToiDa(), x.getNgayBatDau(), x.getNgayKetThuc(),x.getHinhThucApDung(), x.getApDungGiamGia(),x.getLoaiGiamGia(),x.getNgayTao(),x.getNgaySua(),x.getTrangThai()));
        }
        return list;
    }
    public ArrayList<KhuyenMaiModel> getKhuyenMaiAD(){
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        ArrayList<KhuyenMai> km = kmr.getKMAD();
        for(KhuyenMai x : km){
            
            list.add(new KhuyenMaiModel(x.getIdKM(), x.getMaKM(), x.getTenKM(),x.getGiaTri(),x.getGiamToiDa(), x.getNgayBatDau(), x.getNgayKetThuc(),x.getHinhThucApDung(), x.getApDungGiamGia(),x.getLoaiGiamGia(),x.getNgayTao(),x.getNgaySua(),x.getTrangThai()));
        }
        return list;
    }
    
    public KhuyenMaiModel insertKM(KhuyenMaiModel kmm){
        ArrayList<KhuyenMai> list = kmr.getAllKM();
        for(KhuyenMai km : list){
            if(km.getMaKM().equalsIgnoreCase(kmm.getMaKM())){
                return null;
            }
        }
        var x = kmr.insertKM(new KhuyenMai(kmm.getMaKM(), kmm.getTenKM(),kmm.getGiaTri(),kmm.getGiamToiDa(),kmm.getNgayBatDau(),kmm.getNgayKetThuc(),kmm.getHinhThucApDung(), kmm.getApDungGiamGia(), kmm.getLoaiGiamGia(),kmm.getTrangThai()));
        return new KhuyenMaiModel(x.getMaKM(),x.getTenKM(), x.getGiaTri(),x.getGiamToiDa(),x.getNgayBatDau(), x.getNgayKetThuc(), x.getHinhThucApDung(), x.getApDungGiamGia(), x.getLoaiGiamGia(), x.getTrangThai());
        
    }
    public KhuyenMaiModel updateKM(KhuyenMaiModel kmm){
        
        var x =kmr.updateKM(new KhuyenMai(kmm.getMaKM(), kmm.getTenKM(),kmm.getGiaTri(),kmm.getGiamToiDa(),kmm.getNgayBatDau(),kmm.getNgayKetThuc(),kmm.getHinhThucApDung(), kmm.getApDungGiamGia(), kmm.getLoaiGiamGia(),kmm.getTrangThai()));
         return new KhuyenMaiModel(x.getMaKM(),x.getTenKM(), x.getGiaTri(),x.getGiamToiDa(),x.getNgayBatDau(), x.getNgayKetThuc(), x.getHinhThucApDung(), x.getApDungGiamGia(), x.getLoaiGiamGia(), x.getTrangThai());
        
    
    }
    public KhuyenMaiModel updateChuyenTT(KhuyenMaiModel kmm){
        
        var x =kmr.updateChuyenTT(new KhuyenMai(kmm.getMaKM(), kmm.getTenKM(),kmm.getGiaTri(),kmm.getGiamToiDa(),kmm.getNgayBatDau(),kmm.getNgayKetThuc(),kmm.getHinhThucApDung(), kmm.getApDungGiamGia(), kmm.getLoaiGiamGia(),kmm.getTrangThai()));
         return new KhuyenMaiModel(x.getMaKM(),x.getTenKM(), x.getGiaTri(),x.getGiamToiDa(),x.getNgayBatDau(), x.getNgayKetThuc(), x.getHinhThucApDung(), x.getApDungGiamGia(), x.getLoaiGiamGia(), x.getTrangThai());
        
    
    }
    
    
    public Integer deleteKM(String id){
        return kmr.deleteKM(id);
    }
     public ArrayList<KhuyenMaiModel> getIDByMa(String ma){
        ArrayList<KhuyenMaiModel> list = new ArrayList<>();
        ArrayList<KhuyenMai> km = kmr.getIDByMa(ma);
        for(KhuyenMai x : km){          
            list.add(new KhuyenMaiModel(x.getIdKM(), x.getMaKM(), x.getTenKM(),x.getGiaTri(),x.getGiamToiDa(), x.getNgayKetThuc(),
   x.getNgayKetThuc(),x.getHinhThucApDung(), x.getApDungGiamGia(),x.getLoaiGiamGia(),x.getNgayTao(),x.getNgaySua(),x.getTrangThai()));
        }
        return list;
    }
           
     
}