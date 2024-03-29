/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Utilities.JDBCHelper;
import Utilities.ModelGoogleChart;
import Utilities.ModelPieChart;
import Utilities.PieChart;
import Utilities.WebPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartPanel;
import responsitories.DoanhThuResponsitory;

/**
 *
 * @author Asus
 */
public class ThongKeJPanel extends javax.swing.JPanel {

    DoanhThuResponsitory dtr = new DoanhThuResponsitory();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtmSP = new DefaultTableModel();
    DefaultComboBoxModel<Object> dcmyear = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<Object> dcmmonth = new DefaultComboBoxModel<>();
    private WebPanel web;

    /**
     * Creates new form ThongKe
     */
    public ThongKeJPanel() {
        initComponents();
        loadThongKeNgay();
        loadThongKeThang();
        loadThongKeNam();
        dtm = (DefaultTableModel) tblDoanhThu.getModel();
        dtmSP = (DefaultTableModel) tblSPBan.getModel();
        cbbNam.setModel((DefaultComboBoxModel) dcmyear);
        cbbThang.setModel((DefaultComboBoxModel) dcmmonth);
        loadComboNam();
        loadComboThang();
        loadDTNgay();
        tblDoanhThu.getTableHeader().setBackground(Color.pink);
        tblSPBan.getTableHeader().setBackground(Color.pink);
        addChartDays();
        loadSPBan();

//        pieChart1.addData(new ModelPieChart("Tigher", 150, new Color(23, 126, 238)));
//        pieChart1.addData(new ModelPieChart("ABC", 100, new Color(221, 65, 65)));
//        pieChart1.addData(new ModelPieChart("Coca", 1, new Color(47, 157, 64)));
//        pieChart1.addData(new ModelPieChart("Vita", 60, new Color(196, 151, 58)));
        showData();
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        getDMChayNhat();
        getSPChayNhat();

//        web = new WebPanel();
//        web.load(getContent());
//        panel.add(web);
    }

//    private String getContent() {
//        ModelGoogleChart data = new ModelGoogleChart("Monthly Income");
//        data.addData("ABC", 80);
//        data.addData("Tiger", 150);
//        data.addData("Vital", 300);
//        data.addData("Fanta", 250);
//        data.addData("Coca", 180);
//        return data.toChartContent();
//    }
    private void getDMChayNhat() {
        try {
            String sql = "SELECT TOP 1  DANHMUC.TEN,SUM(CHITIETHOADON.SOLUONG) AS SL FROM CHITIETHOADON JOIN CHITIETSANPHAM AS CTSP \n"
                    + "ON CTSP.ID=ChiTietHoaDon.IDCTSP JOIN DanhMuc ON DANHMUC.ID=CTSP.DanhMuc\n"
                    + "JOIN HOADON ON ChiTietHoaDon.IDHD=HoaDon.ID\n"
                    + "WHERE HOADON.TRANGTHAI=1\n"
                    + "GROUP BY DANHMUC.TEN ORDER BY SL DESC";
            int index = 0;
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                String tenDM = rs.getString(1);
                int sl = rs.getInt(2);
                lblDanhMuc.setText(tenDM);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getSPChayNhat() {
        try {
            String sql = "SELECT  TOP 1 SANPHAM.TEN,SUM(CHITIETHOADON.SOLUONG) AS SL FROM CHITIETHOADON \n"
                    + " JOIN CHITIETSANPHAM AS CTSP ON CTSP.ID=ChiTietHoaDon.IDCTSP JOIN SANPHAM ON SANPHAM.ID=CTSP.IDSP\n"
                    + "JOIN HOADON ON ChiTietHoaDon.IDHD=HoaDon.ID\n"
                    + "WHERE HOADON.TRANGTHAI=1 \n"
                    + "GROUP BY SANPHAM.TEN ORDER BY SL DESC";
            int index = 0;
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                String tenDM = rs.getString(1);
                int sl = rs.getInt(2);
                lblTenSP.setText(tenDM);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showData() {

        try {
            String sql = "SELECT  DANHMUC.TEN,SUM(CHITIETHOADON.SOLUONG) AS SL FROM CHITIETHOADON JOIN CHITIETSANPHAM AS CTSP \n"
                    + "ON CTSP.ID=ChiTietHoaDon.IDCTSP JOIN DanhMuc ON DANHMUC.ID=CTSP.DanhMuc\n"
                    + "JOIN HOADON ON ChiTietHoaDon.IDHD=HoaDon.ID\n"
                    + "WHERE HOADON.TRANGTHAI=1\n"
                    + "GROUP BY DANHMUC.TEN";
            int index = 0;
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                String tenDM = rs.getString(1);
                int sl = rs.getInt(2);
                pieChart1.addData(new ModelPieChart(tenDM, sl, getColor(index++)));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Color getColor(int index) {
        Color[] color = new Color[]{new Color(255, 153, 153), new Color(102, 255, 255), new Color(0, 153, 255), new Color(255, 255, 51), new Color(255, 51, 51), new Color(51, 255, 0), new Color(255, 153, 51), new Color(255, 51, 255), new Color(0, 153, 153)};

        return color[index];
    }

    private void loadComboNam() {
        ArrayList<Integer> lnam = dtr.selectYears();
        for (Integer i : lnam) {
            dcmyear.addElement(i);
        }
    }

    private void loadComboThang() {
        ArrayList<Integer> lthang = dtr.selectMonths();
        for (Integer i : lthang) {
            dcmmonth.addElement(i);
        }
    }

    private void loadThongKeNgay() {
        ArrayList<Object> list = dtr.getDoanhThuNgay();
        lblTienNgay.setText(list.get(0).toString());
        lblTCNgay.setText(list.get(1).toString());
        lblBHNgay.setText(list.get(2).toString());
    }

    private void loadThongKeThang() {
        ArrayList<Object> list = dtr.getDoanhThuThang();
        lblTienThang.setText(list.get(0).toString());
        lblTCThang.setText(list.get(1).toString());
        lblBHThang.setText(list.get(2).toString());
    }

    private void loadThongKeNam() {
        ArrayList<Object> list = dtr.getDoanhThuThang();
        lblTienNam.setText(list.get(0).toString());
        lblTCNam.setText(list.get(1).toString());
        lblBHNam.setText(list.get(2).toString());
    }

    private void loadDTNgay() {
        dtm.setRowCount(0);
        if (cbbThang.getSelectedItem() != null & cbbNam.getSelectedItem() != null) {
            int month = Integer.parseInt(cbbThang.getSelectedItem().toString());
            int year = Integer.parseInt(cbbNam.getSelectedItem().toString());
            ArrayList<Object[]> list = dtr.getDTNgay(month, year);
            for (Object[] o : list) {

                dtm.addRow(o);
            }
        }

    }

    private void loadDTThang() {
        dtm.setRowCount(0);
        if (cbbNam.getSelectedItem() != null) {
            int year = Integer.parseInt(cbbNam.getSelectedItem().toString());
            ArrayList<Object[]> list = dtr.getDTThang(year);
            for (Object[] o : list) {

                dtm.addRow(o);
            }
        }

    }

    private void loadDTNam() {
        dtm.setRowCount(0);

        ArrayList<Object[]> list = dtr.getDTNAM();
        for (Object[] o : list) {
            dtm.addRow(o);

        }

    }

    private void loadSPBan() {
        dtmSP.setRowCount(0);
        ArrayList<Object[]> listSp = dtr.getSPDaBan();
        for (Object[] o : listSp) {
            dtmSP.addRow(o);
        }
    }

    private void addChartDays() {
        if (cbbThang.getSelectedItem() != null & cbbNam.getSelectedItem() != null) {
            try {
                int month = Integer.parseInt(cbbThang.getSelectedItem().toString());
                int year = Integer.parseInt(cbbNam.getSelectedItem().toString());
                pnChart.removeAll();
                ChartPanel chartPanel = new ChartPanel(dtr.ChartMon(month, year));
                chartPanel.setMouseZoomable(false);
                pnChart.setLayout(new CardLayout());
                pnChart.setPreferredSize(new Dimension(pnChart.getWidth(), pnChart.getHeight()));
                pnChart.add(chartPanel);
                pnChart.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void addChartMonths() {
        if (cbbNam.getSelectedItem() != null) {
            try {

                int year = Integer.parseInt(cbbNam.getSelectedItem().toString());
                pnChart.removeAll();
                ChartPanel chartPanel = new ChartPanel(dtr.ChartYear(year));
                chartPanel.setMouseZoomable(false);
                pnChart.setLayout(new CardLayout());
                pnChart.setPreferredSize(new Dimension(pnChart.getWidth(), pnChart.getHeight()));
                pnChart.add(chartPanel);
                pnChart.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void addChartYears() {

        try {

            pnChart.removeAll();
            ChartPanel chartPanel = new ChartPanel(dtr.ChartNam());
            chartPanel.setMouseZoomable(false);
            pnChart.setLayout(new CardLayout());
            pnChart.setPreferredSize(new Dimension(pnChart.getWidth(), pnChart.getHeight()));
            pnChart.add(chartPanel);
            pnChart.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public File XuatFileExcel(JTable table, String name) {
        FileOutputStream fos = null;
        try {
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("Danh sách sản phẩm đã bán");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(0);
            cell = (XSSFCell) row.createCell(0, CellType.STRING);
            cell.setCellValue("BẢNG DANH SÁCH CHI TIẾT SẢN PHẨM");
            
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
            row = sheet.createRow(1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã BarCode");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên sản phẩm");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Size");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Độ cao");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Màu săc");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Danh mục");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Chất liệu");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Đã bán");

            for (int i = 0; i < table.getRowCount(); i++) {
                row = sheet.createRow(2 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 0).toString());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 1).toString());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 2).toString());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 3).toString());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 4).toString());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 5).toString());
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 6).toString());
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(table.getValueAt(i, 7).toString());

            }
            JFileChooser j = new JFileChooser();
            j.setDialogTitle("Chọn thư mục lưu: ");
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int r = j.showSaveDialog(null);
            String excelFilePath;
            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                excelFilePath = j.getSelectedFile().getAbsolutePath();
            } // if the user cancelled the operation
            else {
                return null;
            }
            String path = excelFilePath + "\\" + name + ".xlsx";
            File file = new File(path);
            file.getParentFile().mkdirs();

            FileOutputStream outFile;
            outFile = new FileOutputStream(file);
            workBook.write(outFile);
            return file;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTienNgay = new javax.swing.JLabel();
        lblTCNgay = new javax.swing.JLabel();
        lblBHNgay = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbbTime = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblTienNam = new javax.swing.JLabel();
        lblTCNam = new javax.swing.JLabel();
        lblBHNam = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblTienThang = new javax.swing.JLabel();
        lblTCThang = new javax.swing.JLabel();
        lblBHThang = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        pnChart = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPBan = new javax.swing.JTable();
        pieChart1 = new Utilities.PieChart();
        btnXuatFile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblDanhMuc = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(102, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Doanh Thu Ngày");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tiền");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Thành Công");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Bị Hủy");

        lblTienNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTienNgay.setForeground(new java.awt.Color(255, 51, 51));
        lblTienNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTienNgay.setText("-");

        lblTCNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTCNgay.setForeground(new java.awt.Color(255, 51, 51));
        lblTCNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTCNgay.setText("-");

        lblBHNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBHNgay.setForeground(new java.awt.Color(255, 51, 51));
        lblBHNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBHNgay.setText("-");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(65, 65, 65)
                        .addComponent(lblTienNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblBHNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addComponent(lblTCNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblTienNgay))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTCNgay))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblBHNgay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 153));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Thời Gian");

        cbbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày Trong Tháng", "Tháng Trong Năm", "Năm" }));
        cbbTime.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTimeItemStateChanged(evt);
            }
        });

        jLabel6.setText("Tháng");

        jLabel7.setText("Năm");

        cbbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThangItemStateChanged(evt);
            }
        });

        cbbNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel9.setBackground(new java.awt.Color(0, 255, 102));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Doanh Thu Năm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Tiền");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Thành Công");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Bị Hủy");

        lblTienNam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTienNam.setForeground(new java.awt.Color(255, 51, 51));
        lblTienNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTienNam.setText("-");

        lblTCNam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTCNam.setForeground(new java.awt.Color(255, 51, 51));
        lblTCNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTCNam.setText("-");

        lblBHNam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBHNam.setForeground(new java.awt.Color(255, 51, 51));
        lblBHNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBHNam.setText("-");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(65, 65, 65)
                        .addComponent(lblTienNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTCNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBHNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(61, 61, 61))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblTienNam))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblTCNam))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblBHNam))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 153, 102));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Doanh Thu Tháng");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tiền");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Thành Công");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Bị Hủy");

        lblTienThang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTienThang.setForeground(new java.awt.Color(255, 51, 51));
        lblTienThang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTienThang.setText("-");

        lblTCThang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTCThang.setForeground(new java.awt.Color(255, 51, 51));
        lblTCThang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTCThang.setText("-");

        lblBHThang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBHThang.setForeground(new java.awt.Color(255, 51, 51));
        lblBHThang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBHThang.setText("-");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(65, 65, 65)
                        .addComponent(lblTienThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBHThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTCThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(45, 45, 45))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblTienThang))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblTCThang))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblBHThang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(241, 128, 128));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Số Hóa Đơn", "Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setRowHeight(40);
        jScrollPane1.setViewportView(tblDoanhThu);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jTabbedPane2.addTab("Bảng", jPanel7);

        javax.swing.GroupLayout pnChartLayout = new javax.swing.GroupLayout(pnChart);
        pnChart.setLayout(pnChartLayout);
        pnChartLayout.setHorizontalGroup(
            pnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1141, Short.MAX_VALUE)
        );
        pnChartLayout.setVerticalGroup(
            pnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Biểu Đồ", pnChart);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(83, 83, 83)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Doanh Thu", jPanel2);

        tblSPBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã BarCode", "Tên Sản Phẩm", "Size", "Độ cao", "Màu sắc", "Danh mục", "Chất liệu", "Đã bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSPBan);
        if (tblSPBan.getColumnModel().getColumnCount() > 0) {
            tblSPBan.getColumnModel().getColumn(0).setResizable(false);
            tblSPBan.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblSPBan.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblSPBan.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblSPBan.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        pieChart1.setBackground(new java.awt.Color(255, 255, 255));

        btnXuatFile.setBackground(new java.awt.Color(153, 255, 255));
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        btnXuatFile.setText("Xuất File Excel");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Thống Kê Danh Mục");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Danh mục bán chạy nhất:");

        lblDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDanhMuc.setForeground(new java.awt.Color(255, 0, 0));

        lblTenSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenSP.setForeground(new java.awt.Color(255, 0, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tên sản phẩm bán chạy nhất:");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/podium.png"))); // NOI18N
        jLabel13.setText("jLabel13");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(lblDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(lblDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatFile)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Sản Phẩm Đã Bán", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("THỐNG KÊ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jTabbedPane1)
                .addGap(9, 9, 9))
            .addGroup(layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNamItemStateChanged
        loadDTThang();
    }//GEN-LAST:event_cbbNamItemStateChanged

    private void cbbThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThangItemStateChanged
        loadDTNgay();
    }//GEN-LAST:event_cbbThangItemStateChanged

    private void cbbTimeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTimeItemStateChanged
        int index = cbbTime.getSelectedIndex();
        switch (index) {
            case 0:
                addChartDays();
                loadDTNgay();
                break;
            case 1:
                addChartMonths();
                loadDTThang();
                break;
            case 2:
                addChartYears();
                loadDTNam();
                break;
        }
    }//GEN-LAST:event_cbbTimeItemStateChanged

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        try {
            File file = XuatFileExcel(tblSPBan, "Thống kê sản phẩm đã bán");
            if (file != null) {
                JOptionPane.showMessageDialog(this, "Đã tạo xong: " + file.getAbsolutePath());

            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        getDMChayNhat();
        getSPChayNhat();
        showData();
        loadSPBan();
    }//GEN-LAST:event_jLabel11MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JComboBox<String> cbbTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblBHNam;
    private javax.swing.JLabel lblBHNgay;
    private javax.swing.JLabel lblBHThang;
    private javax.swing.JLabel lblDanhMuc;
    private javax.swing.JLabel lblTCNam;
    private javax.swing.JLabel lblTCNgay;
    private javax.swing.JLabel lblTCThang;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblTienNam;
    private javax.swing.JLabel lblTienNgay;
    private javax.swing.JLabel lblTienThang;
    private Utilities.PieChart pieChart1;
    private javax.swing.JPanel pnChart;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblSPBan;
    // End of variables declaration//GEN-END:variables
}
