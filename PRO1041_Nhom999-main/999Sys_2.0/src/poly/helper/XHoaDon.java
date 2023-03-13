/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Hashtable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author NTV
 */
public class XHoaDon {
    //Tạo hàm xuất hóa đơn
    public static void XuatHoaDon(int maHD){
        try {
            
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport(System.getProperty("user.dir") + "\\src\\poly\\newgui\\hoadonthanhtoan.jrxml");
            System.out.println(System.getProperty("user.dir"));
            map.put("maHD", maHD);
            Connection con = DriverManager.getConnection(XJDBC.dburl, XJDBC.user, XJDBC.pass);
            JasperPrint p = JasperFillManager.fillReport(report,  map, con);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "hoadon.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void printBarCode(){
        try {
            
            JasperReport report = JasperCompileManager.compileReport(System.getProperty("user.dir") + "\\src\\poly\\newgui\\printBarCodeFrm.jrxml");
            
            Connection con = DriverManager.getConnection(XJDBC.dburl, XJDBC.user, XJDBC.pass);
            JasperPrint p = JasperFillManager.fillReport(report,  null, con);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "mavach.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
