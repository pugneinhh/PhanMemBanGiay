/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.newgui;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import poly.dao.GiaoCaDAO;
import poly.dao.NhanVienDao;
import poly.entity.NhanVien;
import poly.entity.TrangThaiGiaoCa;
import poly.helper.Messeger;
import poly.helper.XExcel;
import poly.helper.XInternal;

/**
 *
 * @author NTV
 */
public class QLGiaoCaFrm extends javax.swing.JInternalFrame {

    private GiaoCaDAO gcDAO;
    private NhanVienDao nvDAO;

    /**
     * Creates new form QLGiaoCaFrm
     */
    public QLGiaoCaFrm() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGiaoCa = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMaGC = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblNhanVienGC = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblGioNC = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTienCS = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblDoanhThuCa = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblNVNC = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblGioGC = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        lblTrangThai = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        lblPhatSinh = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChuGC = new javax.swing.JTextArea();
        jPanel26 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChuNC = new javax.swing.JTextArea();
        jPanel27 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnXuat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cbxNV = new javax.swing.JComboBox<>();
        cbxTT = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1163, 45));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ GIAO CA");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 153, 51)));
        jPanel2.setLayout(new java.awt.BorderLayout(10, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 5, 1, new java.awt.Color(255, 153, 255)));
        jPanel3.setPreferredSize(new java.awt.Dimension(1143, 319));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 153, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));
        jPanel3.add(jPanel7, java.awt.BorderLayout.NORTH);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 302));

        tblGiaoCa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblGiaoCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Giao Ca", "Nhân Viên Giao", "Nhân Viên Nhận", "Giờ Nhận Ca", "Giờ Giao Ca", "Tiền Cơ Sở", "Tiền Phát Sinh", "Doanh Thu Ca", "Tổng Tiền", "Ghi Chú Giao", "Ghi Chú Nhận", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGiaoCa.setRowHeight(28);
        tblGiaoCa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGiaoCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiaoCaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGiaoCa);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.SOUTH);

        jPanel10.setPreferredSize(new java.awt.Dimension(1143, 500));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 153, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 200, 10, 10, new java.awt.Color(255, 153, 255)));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        jPanel14.setBackground(new java.awt.Color(255, 153, 255));
        jPanel14.setLayout(new java.awt.GridLayout(5, 1, 0, 10));

        jPanel11.setBackground(new java.awt.Color(255, 153, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(1143, 36));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("Mã Giao Ca:");
        jLabel2.setPreferredSize(new java.awt.Dimension(170, 24));
        jPanel11.add(jLabel2, java.awt.BorderLayout.WEST);

        lblMaGC.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblMaGC.setText("jLabel19");
        jPanel11.add(lblMaGC, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel11);

        jPanel15.setBackground(new java.awt.Color(255, 153, 255));
        jPanel15.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Nhân Viên Giao Ca:");
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel15.add(jLabel3, java.awt.BorderLayout.WEST);

        lblNhanVienGC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNhanVienGC.setText("jLabel11");
        jPanel15.add(lblNhanVienGC, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 153, 255));
        jPanel16.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Giờ Nhận Ca:");
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel16.add(jLabel4, java.awt.BorderLayout.WEST);

        lblGioNC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblGioNC.setText("jLabel12");
        jPanel16.add(lblGioNC, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 153, 255));
        jPanel17.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Tiền Cơ Sở:");
        jLabel5.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel17.add(jLabel5, java.awt.BorderLayout.WEST);

        lblTienCS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTienCS.setText("jLabel13");
        jPanel17.add(lblTienCS, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(255, 153, 255));
        jPanel18.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Doanh Thu Ca:");
        jLabel6.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel18.add(jLabel6, java.awt.BorderLayout.WEST);

        lblDoanhThuCa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblDoanhThuCa.setText("jLabel14");
        jPanel18.add(lblDoanhThuCa, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel18);

        jPanel12.add(jPanel14);

        jPanel13.setBackground(new java.awt.Color(255, 153, 255));
        jPanel13.setLayout(new java.awt.GridLayout(5, 1, 0, 10));

        jPanel19.setBackground(new java.awt.Color(255, 153, 255));
        jPanel19.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Nhân Viên Nhận Ca:");
        jLabel7.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel19.add(jLabel7, java.awt.BorderLayout.WEST);

        lblNVNC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNVNC.setText("jLabel15");
        jPanel19.add(lblNVNC, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 153, 255));
        jPanel20.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Giờ Giao Ca:");
        jLabel8.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel20.add(jLabel8, java.awt.BorderLayout.WEST);

        lblGioGC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblGioGC.setText("jLabel16");
        jPanel20.add(lblGioGC, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel20);

        jPanel29.setBackground(new java.awt.Color(255, 153, 255));
        jPanel29.setLayout(new java.awt.BorderLayout(10, 0));

        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTrangThai.setText("jLabel15");
        jPanel29.add(lblTrangThai, java.awt.BorderLayout.CENTER);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("Trạng Thái:");
        jLabel16.setPreferredSize(new java.awt.Dimension(170, 20));
        jPanel29.add(jLabel16, java.awt.BorderLayout.LINE_START);

        jPanel13.add(jPanel29);

        jPanel28.setBackground(new java.awt.Color(255, 153, 255));
        jPanel28.setLayout(new java.awt.BorderLayout(10, 0));

        lblPhatSinh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblPhatSinh.setText("jLabel13");
        jPanel28.add(lblPhatSinh, java.awt.BorderLayout.CENTER);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Tiền Phát Sinh:");
        jLabel14.setPreferredSize(new java.awt.Dimension(170, 20));
        jPanel28.add(jLabel14, java.awt.BorderLayout.WEST);

        jPanel13.add(jPanel28);

        jPanel22.setBackground(new java.awt.Color(255, 153, 255));
        jPanel22.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Tổng Tiền:");
        jLabel10.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel22.add(jLabel10, java.awt.BorderLayout.WEST);

        lblTongTien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTongTien.setText("jLabel18");
        jPanel22.add(lblTongTien, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel22);

        jPanel12.add(jPanel13);

        jPanel10.add(jPanel12, java.awt.BorderLayout.LINE_START);

        jPanel23.setBackground(new java.awt.Color(255, 153, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 200, 10, 10, new java.awt.Color(255, 153, 255)));
        jPanel23.setPreferredSize(new java.awt.Dimension(1143, 150));
        jPanel23.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        jPanel25.setBackground(new java.awt.Color(255, 153, 255));
        jPanel25.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Ghi Chú Giao:");
        jLabel11.setMinimumSize(new java.awt.Dimension(125, 36));
        jLabel11.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel25.add(jLabel11, java.awt.BorderLayout.WEST);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(306, 86));

        txtGhiChuGC.setEditable(false);
        txtGhiChuGC.setColumns(20);
        txtGhiChuGC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtGhiChuGC.setLineWrap(true);
        txtGhiChuGC.setRows(5);
        jScrollPane2.setViewportView(txtGhiChuGC);

        jPanel25.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel26.setBackground(new java.awt.Color(255, 153, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(150, 130));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel25.add(jPanel26, java.awt.BorderLayout.LINE_END);

        jPanel23.add(jPanel25);

        jPanel24.setBackground(new java.awt.Color(255, 153, 255));
        jPanel24.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Ghi Chú Nhận:");
        jLabel12.setPreferredSize(new java.awt.Dimension(170, 36));
        jPanel24.add(jLabel12, java.awt.BorderLayout.WEST);

        txtGhiChuNC.setEditable(false);
        txtGhiChuNC.setColumns(20);
        txtGhiChuNC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtGhiChuNC.setLineWrap(true);
        txtGhiChuNC.setRows(5);
        jScrollPane3.setViewportView(txtGhiChuNC);

        jPanel24.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel27.setBackground(new java.awt.Color(255, 153, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(150, 130));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel27, java.awt.BorderLayout.LINE_END);

        jPanel23.add(jPanel24);

        jPanel10.add(jPanel23, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(255, 153, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 0, 0, new java.awt.Color(255, 153, 51)));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 5));

        btnXuat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXuat.setText("Xuất Excel");
        btnXuat.setPreferredSize(new java.awt.Dimension(125, 36));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });
        jPanel9.add(btnXuat);

        jPanel2.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(255, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 0, 5, new java.awt.Color(255, 153, 255)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1143, 100));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        jPanel6.setBackground(new java.awt.Color(255, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bộ Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        cbxNV.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cbxNV.setPreferredSize(new java.awt.Dimension(270, 36));
        cbxNV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNVItemStateChanged(evt);
            }
        });
        jPanel6.add(cbxNV);

        cbxTT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cbxTT.setPreferredSize(new java.awt.Dimension(270, 36));
        cbxTT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTTItemStateChanged(evt);
            }
        });
        jPanel6.add(cbxTT);

        jPanel4.add(jPanel6);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGiaoCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiaoCaMouseClicked
        // TODO add your handling code here:
        setText();
    }//GEN-LAST:event_tblGiaoCaMouseClicked

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        try {
            // TODO add your handling code here:
            File file = XExcel.xuatExcel(tblGiaoCa, "GiaoCa");
            if (file != null) {
                Messeger.alert(this, "Đã tạo xong: " + file.getAbsolutePath());
            } else {
                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Messeger.showErrorDialog(null, ex.getMessage(), "Error");
        }

    }//GEN-LAST:event_btnXuatActionPerformed

    private void cbxNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNVItemStateChanged
        // TODO add your handling code here:
        fillToTable(false);
    }//GEN-LAST:event_cbxNVItemStateChanged

    private void cbxTTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTTItemStateChanged
        // TODO add your handling code here:
        fillToTable(false);
    }//GEN-LAST:event_cbxTTItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox<String> cbxNV;
    private javax.swing.JComboBox<String> cbxTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDoanhThuCa;
    private javax.swing.JLabel lblGioGC;
    private javax.swing.JLabel lblGioNC;
    private javax.swing.JLabel lblMaGC;
    private javax.swing.JLabel lblNVNC;
    private javax.swing.JLabel lblNhanVienGC;
    private javax.swing.JLabel lblPhatSinh;
    private javax.swing.JLabel lblTienCS;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblGiaoCa;
    private javax.swing.JTextArea txtGhiChuGC;
    private javax.swing.JTextArea txtGhiChuNC;
    // End of variables declaration//GEN-END:variables

    private void init() {
        XInternal.uncorated(this);
        gcDAO = new GiaoCaDAO();
        nvDAO = new NhanVienDao();
        fillToCBBTTGC();
        fillToCBBNV();

        fillToTable(true);
        tblGiaoCa.setRowSelectionInterval(0, 0);
        setText();
    }

    private void fillToTable(boolean chon) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblGiaoCa.getModel();
            model.setRowCount(0);
            List<Object[]> lst = new ArrayList<>();
            if (chon) {
                lst = gcDAO.selectGiaoCa();
            } else if (!cbxTT.getSelectedItem().equals("Trạng thái")) {
                String maNVGC = "";
                String maNVNC = "";
                if (!cbxNV.getSelectedItem().equals("Nhân viên")) {
                    NhanVien nv = (NhanVien) cbxNV.getSelectedItem();

                    if (nv != null) {
                        maNVGC = nv.getMaNV();
                        maNVNC = nv.getMaNV();
                    }
                }
                TrangThaiGiaoCa ttGC = (TrangThaiGiaoCa) cbxTT.getSelectedItem();
                lst = gcDAO.timKiemCBB(maNVGC, maNVNC, ttGC.getMaTT());
            } else {
                String maNVGC = "";
                String maNVNC = "";
                if (cbxNV.getSelectedItem() != null) {
                if (!cbxNV.getSelectedItem().equals("Nhân viên")) {
                    NhanVien nv = (NhanVien) cbxNV.getSelectedItem();

                    if (nv != null) {
                        maNVGC = nv.getMaNV();
                        maNVNC = nv.getMaNV();
                    }
                }}
                lst = gcDAO.timKiemCBB(maNVGC, maNVNC);
            }
            for (Object[] ob : lst) {
                model.addRow(ob);
            }
            tblGiaoCa.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table,
                        Object value, boolean isSelected, boolean hasFocus, int row, int col) {

                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                    String ghichu = table.getModel().getValueAt(row, 9).toString();
                    String trangThai = table.getModel().getValueAt(row, 11).toString();
                    if (!ghichu.equals("Chưa có") | trangThai.equals("Chờ giao ca") | trangThai.equals("Thất bại")) {
                        if (trangThai.equals("Chờ giao ca")) {
                            setBackground(Color.YELLOW);
                            setForeground(Color.RED);
                        } else if (!ghichu.equals("Chưa có")) {
                            setBackground(Color.PINK);
                            setForeground(Color.BLACK);
                        } else {
                            setBackground(Color.RED);
                            setForeground(Color.YELLOW);
                        }
                    } else {
                        setBackground(table.getBackground());
                        setForeground(table.getForeground());
                    }
                    return this;
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
            Messeger.showErrorDialog(null, ex.getMessage(), "Error");
        }
    }

    private void fillToCBBNV() {
        try {
            List<NhanVien> lst = new ArrayList<>();
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbxNV.getModel();
            lst = nvDAO.selectAll();
            model.removeAllElements();
            model.addElement("Nhân viên");
            for (NhanVien nhanVien : lst) {
                model.addElement(nhanVien);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fillToCBBTTGC() {
        try {
            List<TrangThaiGiaoCa> lst = new ArrayList<>();
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbxTT.getModel();
            lst = gcDAO.selectTTGiaoCa();
            model.removeAllElements();
            model.addElement("Trạng thái");
            for (TrangThaiGiaoCa ttGC : lst) {
                model.addElement(ttGC);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setText() {
        int row = tblGiaoCa.getSelectedRow();
        if (row < 0) {
            return;
        }
        lblMaGC.setText(String.valueOf(tblGiaoCa.getValueAt(row, 0)));
        lblNhanVienGC.setText(String.valueOf(tblGiaoCa.getValueAt(row, 1)));
        lblNVNC.setText(String.valueOf(tblGiaoCa.getValueAt(row, 2)));
        lblGioNC.setText(String.valueOf(tblGiaoCa.getValueAt(row, 3)));
        lblGioGC.setText(String.valueOf(tblGiaoCa.getValueAt(row, 4)));
        lblTienCS.setText(String.valueOf(tblGiaoCa.getValueAt(row, 5)));
        lblPhatSinh.setText(String.valueOf(tblGiaoCa.getValueAt(row, 6)));
        lblDoanhThuCa.setText(String.valueOf(tblGiaoCa.getValueAt(row, 7)));
        lblTongTien.setText(String.valueOf(tblGiaoCa.getValueAt(row, 8)));
        txtGhiChuGC.setText(String.valueOf(tblGiaoCa.getValueAt(row, 9)));
        txtGhiChuNC.setText(String.valueOf(tblGiaoCa.getValueAt(row, 10)));
        lblTrangThai.setText(String.valueOf(tblGiaoCa.getValueAt(row, 11)));
    }

    private List<Object[]> chonFillToTable(Boolean chon) {
        List<Object[]> lst = new ArrayList<>();
        try {
            if (chon) {
                lst = gcDAO.selectGiaoCa();
            } else if (!cbxTT.getSelectedItem().equals("Trạng thái")) {
                String maNVGC = "";
                String maNVNC = "";
                NhanVien nv = (NhanVien) cbxNV.getSelectedItem();
                if (nv != null) {
                    maNVGC = nv.getMaNV();
                    maNVNC = nv.getMaNV();
                }
                TrangThaiGiaoCa ttGC = (TrangThaiGiaoCa) cbxTT.getSelectedItem();
                lst = gcDAO.timKiemCBB(maNVGC, maNVNC, ttGC.getMaTT());
            } else {
                String maNVGC = "";
                String maNVNC = "";
                NhanVien nv = (NhanVien) cbxNV.getSelectedItem();
                if (nv != null) {
                    maNVGC = nv.getMaNV();
                    maNVNC = nv.getMaNV();
                }
                lst = gcDAO.timKiemCBB(maNVGC, maNVNC);
            }
        } catch (Exception ex) {
            Logger.getLogger(QLGiaoCaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
}
