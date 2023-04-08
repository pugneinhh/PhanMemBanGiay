/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories;

import Utilities.JDBCHelper;
import groovy.lang.Category;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Phanh
 */
public class DoanhThuResponsitory {

    public ArrayList<Object> getDoanhThuNgay() {
        ArrayList<Object> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.FNDTNGAY(?)";
        ResultSet rs = JDBCHelper.excuteQuery(sql, new Date());
        try {
            while (rs.next()) {
                String tongtien = rs.getString("doanhthu") == null ? "0 VNĐ" : rs.getString("doanhthu") + " VNĐ";
                list.add(tongtien);
                list.add(rs.getInt(2));
                list.add(rs.getInt(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object> getDoanhThuThang() {
        ArrayList<Object> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.FNDTTHANG(?)";
        ResultSet rs = JDBCHelper.excuteQuery(sql, new Date());
        try {
            while (rs.next()) {
                String tongtien = rs.getString("doanhthu") == null ? "0 VNĐ" : rs.getString("doanhthu") + " VNĐ";
                list.add(tongtien);
                list.add(rs.getInt(2));
                list.add(rs.getInt(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object> getDoanhThuNam() {
        ArrayList<Object> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.FNDTNAM(?)";
        ResultSet rs = JDBCHelper.excuteQuery(sql, new Date());
        try {
            while (rs.next()) {
                String tongtien = rs.getString("doanhthu") == null ? "0 VNĐ" : rs.getString("doanhthu") + " VNĐ";
                list.add(tongtien);
                list.add(rs.getInt(2));
                list.add(rs.getInt(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> getDTNgay(int thang, int nam) {
        ArrayList<Object[]> list = new ArrayList<>();
        String sql = "EXEC SP_DTNGAY ?,?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, thang, nam);
        try {
            while (rs.next()) {
                list.add(new Object[]{
                    rs.getDate(1),
                    rs.getInt(2),
                    rs.getInt(3)
                });

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> getSPDaBan() {
        ArrayList<Object[]> list = new ArrayList<>();
        String sql = "SELECT ChiTietSanPham.QR,S.TEN,SIZE.TEN,DOCAO.TEN,MAUSAC.TEN,DANHMUC.TEN,CHATLIEU.TEN,SUM(ChiTietHoaDon.SoLuong)AS SOLUONG\n"
                + "FROM CHITIETHOADON JOIN ChiTietSanPham ON ChiTietHoaDon.IDCTSP=ChiTietSanPham.ID \n"
                + "JOIN HOADON ON HOADON.ID=ChiTietHoaDon.IDHD \n"
                + "JOIN SANPHAM AS S ON S.ID=CHITIETSANPHAM.IDSP\n"
                + "JOIN SIZE ON SIZE.ID=ChiTietSanPham.Size\n"
                + "JOIN MAUSAC ON MAUSAC.ID=ChiTietSanPham.MauSac\n"
                + "JOIN DOCAO ON DOCAO.ID=ChiTietSanPham.DoCao\n"
                + "JOIN CHATLIEU ON CHATLIEU.ID=ChiTietSanPham.ChatLieu\n"
                + "JOIN DANHMUC ON DANHMUC.ID=ChiTietSanPham.DanhMuc\n"
                + "WHERE HOADON.TRANGTHAI=1   GROUP BY S.TEN,SIZE.TEN,MAUSAC.TEN,DOCAO.TEN,CHATLIEU.TEN,DANHMUC.TEN,QR";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                list.add(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getInt(8)
                });

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> getDTThang(int nam) {
        ArrayList<Object[]> list = new ArrayList<>();
        String sql = "EXEC SP_DTTHANG ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, nam);
        try {
            while (rs.next()) {
                list.add(new Object[]{
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3)
                });

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> getDTNAM() {
        ArrayList<Object[]> list = new ArrayList<>();
        String sql = "EXEC SP_DTCACNAM";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                list.add(new Object[]{
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3)
                });

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Integer> selectYears() {
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(NGAYTao) as [YEAR] FROM HOADON WHERE NGAYTAO IS NOT NULL ORDER BY [YEAR] DESC";
        try {
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<Integer> selectMonths() {
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "SELECT DISTINCT Month(NGAYTAO) as [month] FROM HOADON WHERE NGAYTAO IS NOT NULL ORDER BY [month] DESC";
        try {
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public JFreeChart ChartMon(int thang, int nam) {
        String chartTitle = "Biểu đồ doanh thu tháng " + thang + " năm " + nam;
        String sql = "EXEC SP_DTNGAY ?,?";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet rs = JDBCHelper.excuteQuery(sql, thang, nam);
        try {
            while (rs.next()) {
                dataset.addValue(rs.getInt(3), "Doanh Thu", rs.getDate(1));
            }
            JFreeChart lineChart = ChartFactory.createLineChart(chartTitle.toUpperCase(), "Ngày", "Doanh Thu (VNĐ)", dataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = lineChart.getCategoryPlot();
            plot.setRenderer(new BarRenderer());
            plot.setBackgroundPaint(Color.white);
            plot.setOutlineStroke(new BasicStroke(2.0f));
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);
            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);
            return lineChart;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public JFreeChart ChartYear(int nam) {
        String chartTitle = "Biểu đồ doanh thu năm " + nam;
        String sql = "EXEC SP_DTTHANG ?";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet rs = JDBCHelper.excuteQuery(sql, nam);
        try {
            while (rs.next()) {
                dataset.addValue(rs.getInt(3), "Doanh Thu", rs.getString(1));
            }
            JFreeChart lineChart = ChartFactory.createLineChart(chartTitle.toUpperCase(), "Tháng", "Doanh Thu (VNĐ)", dataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = lineChart.getCategoryPlot();
            plot.setRenderer(new BarRenderer());
            plot.setBackgroundPaint(Color.white);
            plot.setOutlineStroke(new BasicStroke(2.0f));
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);
            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);
            return lineChart;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public JFreeChart ChartNam() {
        String chartTitle = "Biểu đồ doanh thu các năm ";
        String sql = "EXEC SP_DTCACNAM";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                dataset.addValue(rs.getInt(3), "Doanh Thu", rs.getString(1));
            }
            JFreeChart lineChart = ChartFactory.createLineChart(chartTitle.toUpperCase(), "Năm", "Doanh Thu (VNĐ)", dataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = lineChart.getCategoryPlot();
            plot.setRenderer(new BarRenderer());
            plot.setBackgroundPaint(Color.white);
            plot.setOutlineStroke(new BasicStroke(2.0f));
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);
            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);
            return lineChart;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
