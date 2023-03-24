/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.GiaoCa;
import DomainModels.NhanVien;
import Services.GiaoCaService;
import Services.NhanVienService;
import ViewModels.GiaoCaModel;
import ViewModels.NhanVienModel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class QLGiaoCa extends javax.swing.JPanel {

    GiaoCaService gcs;
    NhanVienService nvs;
    DefaultTableModel dtmGC;
    DefaultComboBoxModel<GiaoCa> dcmnvGC;
    DefaultComboBoxModel<GiaoCa> dcmnvNC;

    public QLGiaoCa() {
        initComponents();
        gcs = new GiaoCaService();
        nvs = new NhanVienService();
        dcmnvNC = new DefaultComboBoxModel<>();
        dcmnvGC = new DefaultComboBoxModel<>();
        dtmGC = new DefaultTableModel();
        dtmGC = (DefaultTableModel) tblGiaoCa.getModel();
//        loadComBoNVGC();
//        loadComBoNVNC();
        loadtable();

    }

//    public void loadComBoNVGC() {
//        ArrayList<GiaoCaModel> list = gcs.getAllGiaoCa();
//        for (GiaoCaModel x : list) {
//            dcmnvGC.addElement(new GiaoCa(x.getIdGC(), x.getMaGC(), x.getMaNVGiao(), x.getMaNVNhan(), x.getGioGiaoCa(), x.getGioNhanCao(), x.getTienCoSo(), x.getTienPhatSinh(), x.getDoanhThuCa(), x.getTongTien(), x.getGhiChuGiao(), x.getGhiChuNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
//        }
//    }
//
//    public void loadComBoNVNC() {
//        ArrayList<GiaoCaModel> list = gcs.getAllGiaoCa();
//        for (GiaoCaModel x : list) {
//            dcmnvNC.addElement(new GiaoCa(x.getIdGC(), x.getMaGC(), x.getMaNVGiao(), x.getMaNVNhan(), x.getGioGiaoCa(), x.getGioNhanCao(), x.getTienCoSo(), x.getTienPhatSinh(), x.getDoanhThuCa(), x.getTongTien(), x.getGhiChuGiao(), x.getGhiChuNhan(), x.getNgayTao(), x.getNgaySua(), x.getTrangThai()));
//        }
//    }

    public void loadtable() {
        ArrayList<GiaoCaModel> list = gcs.getAllGiaoCa();
        dtmGC.setRowCount(0);
        for (GiaoCaModel x : list) {
            Object[] rowdata = {
                x.getMaGC(),
                x.getMaNVNhan(),
                x.getMaNVGiao(),
                x.getGioGiaoCa(),
                x.getGioNhanCao(),
                x.getTienCoSo(),
                x.getTienPhatSinh(),
                x.getDoanhThuCa(),
                x.getTongTien(),
                x.getGhiChuGiao(),
                x.getGhiChuNhan(),
                x.getTrangThai() == 0 ? "A" : "B"
            };
            dtmGC.addRow(rowdata);
        }
    }

    private void clear() {
        txtMaGC.setText("");
        cbbGiaoCa.setSelectedIndex(0);
        txtGioNhanCa.setText("");

        txtTienCoSO.setText("");
        txtDoanhThuCa.setText("");
        txtGhiChuGiao.setText("");
        cbbNhanCa.setSelectedIndex(0);
        txtGioGiaoa.setText("");
        rdo1.setSelected(true);
        txtTienPhatSinh.setText("");
        txtTongTien.setText("");
        txtGhiChuNhan.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaGC = new javax.swing.JTextField();
        txtGioNhanCa = new javax.swing.JTextField();
        txtTienCoSO = new javax.swing.JTextField();
        txtGioGiaoa = new javax.swing.JTextField();
        txtTienPhatSinh = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChuGiao = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChuNhan = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGiaoCa = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtDoanhThuCa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        cbbNhanCa = new javax.swing.JComboBox<>();
        cbbGiaoCa = new javax.swing.JComboBox<>();
        rdo1 = new javax.swing.JRadioButton();
        rdo2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ GIAO CA");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jComboBox2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setText("Mã giao ca");

        jLabel3.setText("Nhân viên giao ca");

        jLabel4.setText("Giờ nhận ca");

        jLabel5.setText("Tiền cơ sơ");

        jLabel6.setText("Nhân viên nhận ca");

        jLabel7.setText("Giờ giao ca");

        jLabel8.setText("Trang thái");

        jLabel9.setText("Tiền phát sinh");

        txtGioNhanCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioNhanCaActionPerformed(evt);
            }
        });

        jLabel10.setText("Ghi chú giao");

        txtGhiChuGiao.setColumns(20);
        txtGhiChuGiao.setRows(5);
        jScrollPane1.setViewportView(txtGhiChuGiao);

        jLabel11.setText("Ghi chú nhận");

        txtGhiChuNhan.setColumns(20);
        txtGhiChuNhan.setRows(5);
        jScrollPane2.setViewportView(txtGhiChuNhan);

        tblGiaoCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã giao ca ", "Nhân viên giao ca", "Nhân viên nhận ca", "Giờ giao ca", "Giờ Nhận ca", "Tiền cơ sở", "Tiền phát sinh", "Doanh thu ca ", "Tổng tiền", "Ghi chú ca", "Ghi chú nhận", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGiaoCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiaoCaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGiaoCa);

        jLabel12.setText("Doanh thu ca");

        jLabel13.setText("Tổng tiền");

        cbbNhanCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NV01", "NV02", "NV03", "NV04", "NV05" }));

        cbbGiaoCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NV01", "NV02", "NV03", "NV04", "NV05" }));

        buttonGroup1.add(rdo1);
        rdo1.setText("A");

        buttonGroup1.add(rdo2);
        rdo2.setText("B");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaGC)
                            .addComponent(txtGioNhanCa)
                            .addComponent(txtTienCoSO)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDoanhThuCa)
                            .addComponent(cbbGiaoCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(144, 144, 144)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTienPhatSinh, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtGioGiaoa, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addComponent(cbbNhanCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rdo1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdo2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtMaGC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNhanCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(txtGioGiaoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(txtGioNhanCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo1)
                    .addComponent(rdo2))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(txtTienCoSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienPhatSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDoanhThuCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Xuất EXECL");

        jButton2.setText("Thêm");

        jButton3.setText("Câp Nhật");

        jButton4.setText("Xóa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jButton2)
                .addGap(107, 107, 107)
                .addComponent(jButton3)
                .addGap(106, 106, 106)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

    }// </editor-fold>//GEN-END:initComponents

    private void txtGioNhanCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioNhanCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioNhanCaActionPerformed

    private void tblGiaoCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiaoCaMouseClicked
        int row = tblGiaoCa.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaGC.setText(tblGiaoCa.getValueAt(row, 0).toString());
        String nvgiaoca = tblGiaoCa.getValueAt(row, 1).toString();
        cbbGiaoCa.getModel().setSelectedItem(getNV(row, nvgiaoca));
        String nvnhanca = tblGiaoCa.getValueAt(row, 2).toString();
        cbbNhanCa.getModel().setSelectedItem(getNV(row, nvnhanca));

        txtGioGiaoa.setText(tblGiaoCa.getValueAt(row, 3).toString());
        txtGioNhanCa.setText(tblGiaoCa.getValueAt(row, 4).toString());
        txtTienCoSO.setText(tblGiaoCa.getValueAt(row, 5).toString());
        txtDoanhThuCa.setText(tblGiaoCa.getValueAt(row, 7).toString());
        txtGhiChuGiao.setText(tblGiaoCa.getValueAt(row, 9).toString());
//         cbbNhanCa.setSelectedIndex(0);
//         txtGioGiaoa.setText("");
        String tt = tblGiaoCa.getValueAt(row, 11).toString();
        if (tt.equalsIgnoreCase("A")) {
            rdo1.setSelected(true);
        } else {
            rdo2.setSelected(true);
        }
        rdo1.setSelected(true);
        txtTienPhatSinh.setText(tblGiaoCa.getValueAt(row, 6).toString());
        txtTongTien.setText(tblGiaoCa.getValueAt(row, 8).toString());
        txtGhiChuNhan.setText(tblGiaoCa.getValueAt(row, 10).toString());

    }//GEN-LAST:event_tblGiaoCaMouseClicked
    private NhanVien getNV(int row, String tenNV) {
        ArrayList<NhanVienModel> vm = nvs.getAllNV();
        for (NhanVienModel nvm : vm) {
            if (nvm.getHoTen().equals(tenNV)) {
                return new NhanVien(nvm.getIdNV(), nvm.getMaNV(), nvm.getHoTen(), nvm.getNgaySinh(), nvm.getGioiTinh(), nvm.getDiaChi(), nvm.getSdt(), nvm.getEmail(), nvm.getMatKhau(), nvm.getIdCV(), nvm.getHinh(), nvm.getNgayTao(), nvm.getNgaySua(), nvm.getTrangThai());
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbGiaoCa;
    private javax.swing.JComboBox<String> cbbNhanCa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JRadioButton rdo2;
    private javax.swing.JTable tblGiaoCa;
    private javax.swing.JTextField txtDoanhThuCa;
    private javax.swing.JTextArea txtGhiChuGiao;
    private javax.swing.JTextArea txtGhiChuNhan;
    private javax.swing.JTextField txtGioGiaoa;
    private javax.swing.JTextField txtGioNhanCa;
    private javax.swing.JTextField txtMaGC;
    private javax.swing.JTextField txtTienCoSO;
    private javax.swing.JTextField txtTienPhatSinh;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
