/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.GioHang;
import DomainModels.HoaDon;
import Services.GiaoCaService;
import Services.GiaoHangService;
import Services.hoadonservice;
import ViewModels.GiaoHangModel;
import ViewModels.HoaDonViewModel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class GiaoHang extends javax.swing.JFrame {

    CardLayout cardlayout;
    private GiaoHangService ghs = new GiaoHangService();
    DefaultTableModel dtmChoGH;
    DefaultTableModel dtmDangGH;
    DefaultTableModel dtmHuyGH;
    DefaultTableModel dtmGH;
    private hoadonservice hds = new hoadonservice();

    public GiaoHang() {
        initComponents();
        cardlayout = (CardLayout) PnCacGoc.getLayout();

        dtmChoGH = new DefaultTableModel();
        dtmChoGH = (DefaultTableModel) tblChoGiaoHang.getModel();

        dtmDangGH = new DefaultTableModel();
        dtmDangGH = (DefaultTableModel) TblDangGiaoHang.getModel();

        dtmHuyGH = new DefaultTableModel();
        dtmHuyGH = (DefaultTableModel) tblHuyGiaoHang.getModel();

        dtmGH = new DefaultTableModel();
        dtmGH = (DefaultTableModel) tblGiaoHang.getModel();
        loadtableChoGiaoHang();
        loadtableDangGiaoHang();
        loadtableHuyGiaoHang();
        loadtableGiaoHang();
    }

    public void loadtableChoGiaoHang() {
        ArrayList<GiaoHangModel> list = ghs.ChoGiaoHang();
        dtmChoGH.setRowCount(0);
        for (GiaoHangModel x : list) {
            Object[] rowdata = {
                x.getIdGiaoHang(),
                x.getIdHD().getMaHD(),
                x.getIdKH().getTenKH(),
                x.getSdt(),
                x.getDiaChi(),
                x.trangthai()
            };
            dtmChoGH.addRow(rowdata);
        }
    }

    public void loadtableDangGiaoHang() {
        ArrayList<GiaoHangModel> list = ghs.DangGiaoHang();
        dtmDangGH.setRowCount(0);
        for (GiaoHangModel x : list) {
            Object[] rowdata = {
                x.getIdGiaoHang(),
                x.getIdHD().getMaHD(),
                x.getIdKH().getTenKH(),
                x.getSdt(),
                x.getDiaChi(),
                x.trangthai()
            };
            dtmDangGH.addRow(rowdata);
        }
    }

    public void loadtableHuyGiaoHang() {
        ArrayList<GiaoHangModel> list = ghs.HuyGiaoHang();
        dtmHuyGH.setRowCount(0);
        for (GiaoHangModel x : list) {
            Object[] rowdata = {
                x.getIdGiaoHang(),
                x.getIdHD().getMaHD(),
                x.getIdKH().getTenKH(),
                x.getSdt(),
                x.getDiaChi(),
                x.trangthai()
            };
            dtmHuyGH.addRow(rowdata);
        }
    }

    public void loadtableGiaoHang() {
        ArrayList<GiaoHangModel> list = ghs.GiaoHang();
        dtmGH.setRowCount(0);
        for (GiaoHangModel x : list) {
            Object[] rowdata = {
                x.getIdGiaoHang(),
                x.getIdHD().getMaHD(),
                x.getIdKH().getTenKH(),
                x.getSdt(),
                x.getDiaChi(),
                x.trangthai()
            };
            dtmGH.addRow(rowdata);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        PnCacGoc = new javax.swing.JPanel();
        ChoGiaoHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChoGiaoHang = new javax.swing.JTable();
        DangGiaoHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDangGiaoHang = new javax.swing.JTable();
        HuyGiaoHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHuyGiaoHang = new javax.swing.JTable();
        DangGiao = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGiaoHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Chờ Giao Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Đang Giao Hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Giao Hàng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Hủy Giao Hàng");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        PnCacGoc.setLayout(new java.awt.CardLayout());

        tblChoGiaoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã HD", "Tên Khách Hàng", "SDT", "Địa Chỉ ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChoGiaoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChoGiaoHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChoGiaoHang);

        javax.swing.GroupLayout ChoGiaoHangLayout = new javax.swing.GroupLayout(ChoGiaoHang);
        ChoGiaoHang.setLayout(ChoGiaoHangLayout);
        ChoGiaoHangLayout.setHorizontalGroup(
            ChoGiaoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChoGiaoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        ChoGiaoHangLayout.setVerticalGroup(
            ChoGiaoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChoGiaoHangLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PnCacGoc.add(ChoGiaoHang, "CardChoGiaoHang");

        TblDangGiaoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Hóa Đơn", "Tên Khách Hàng", "SDT", "Địa Chỉ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblDangGiaoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDangGiaoHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblDangGiaoHang);

        javax.swing.GroupLayout DangGiaoHangLayout = new javax.swing.GroupLayout(DangGiaoHang);
        DangGiaoHang.setLayout(DangGiaoHangLayout);
        DangGiaoHangLayout.setHorizontalGroup(
            DangGiaoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangGiaoHangLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addContainerGap())
        );
        DangGiaoHangLayout.setVerticalGroup(
            DangGiaoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangGiaoHangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        PnCacGoc.add(DangGiaoHang, "CardDangGiaoHang");

        tblHuyGiaoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã HD", "Tên Khách Hàng", "SDT", "Địa Chỉ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHuyGiaoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHuyGiaoHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHuyGiaoHang);

        javax.swing.GroupLayout HuyGiaoHangLayout = new javax.swing.GroupLayout(HuyGiaoHang);
        HuyGiaoHang.setLayout(HuyGiaoHangLayout);
        HuyGiaoHangLayout.setHorizontalGroup(
            HuyGiaoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HuyGiaoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        HuyGiaoHangLayout.setVerticalGroup(
            HuyGiaoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HuyGiaoHangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        PnCacGoc.add(HuyGiaoHang, "cardHuyGiaoHang");

        tblGiaoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã HD", "Tên Khách Hàng", "SDT", "Địa Chỉ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblGiaoHang);

        javax.swing.GroupLayout DangGiaoLayout = new javax.swing.GroupLayout(DangGiao);
        DangGiao.setLayout(DangGiaoLayout);
        DangGiaoLayout.setHorizontalGroup(
            DangGiaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangGiaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        DangGiaoLayout.setVerticalGroup(
            DangGiaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangGiaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );

        PnCacGoc.add(DangGiao, "CardDangGiao");

        jLabel1.setText("Danh Sách Sản Phẩm");

        jLabel2.setText("Mã Hóa Đơn");

        jLabel3.setText("Tên Khách");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jLabel4.setText("Tổng Tiền đã bao gồm phí ship :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(PnCacGoc, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)
                        .addGap(27, 27, 27)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(265, 265, 265))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(PnCacGoc, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(248, 248, 248))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardlayout.show(PnCacGoc, "CardChoGiaoHang");
        loadtableChoGiaoHang();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cardlayout.show(PnCacGoc, "CardDangGiaoHang");
        loadtableDangGiaoHang();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cardlayout.show(PnCacGoc, "cardHuyGiaoHang");
        loadtableHuyGiaoHang();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        cardlayout.show(PnCacGoc, "CardDangGiao");
//        loadtableGiaoHang();
    int row=TblDangGiaoHang.getSelectedRow();
    if(row<0){
        return;
    }
    String id=TblDangGiaoHang.getValueAt(row, 0).toString();
    GiaoHangModel gh=new GiaoHangModel();
    gh.setIdGiaoHang(id);
    int cd = JOptionPane.showConfirmDialog(this, "bạn có muốn chuyển đổi trạng thái đang giao hàng sang hủy giao hàng không");
      if(cd==JOptionPane.YES_OPTION)
      {
          ghs.updateHuyGH(gh);
          loadtableDangGiaoHang();
      }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblChoGiaoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChoGiaoHangMouseClicked
        int row = tblChoGiaoHang.getSelectedRow();
        if (row == -1) {
            return;
        }
        int cd = JOptionPane.showConfirmDialog(this, "bạn có muốn chuyển đổi trạng thái chờ giao hàng sang đang giao hàng không");
        if (cd != JOptionPane.YES_OPTION) {
            return;
        }

        String id = tblChoGiaoHang.getValueAt(row, 0).toString();
        GiaoHangModel ghm = new GiaoHangModel();
        ghm.setIdGiaoHang(id);

        if (ghs.updateChoGH(ghm) != null) {
            JOptionPane.showMessageDialog(this, "Chuyển đổi trạng thái thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Chuyển đổi trạng thái không  thành công");
        }
        loadtableChoGiaoHang();
    }//GEN-LAST:event_tblChoGiaoHangMouseClicked

    private void TblDangGiaoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDangGiaoHangMouseClicked
        int row = TblDangGiaoHang.getSelectedRow();
        if (row == -1) {
            return;
        }
        int cd = JOptionPane.showConfirmDialog(this, "bạn có muốn chuyển đổi trạng thái đang giao hàng sang  giao hàng không");
        if (cd != JOptionPane.YES_OPTION) {
            return;
        }

        String id = TblDangGiaoHang.getValueAt(row, 0).toString();
        GiaoHangModel ghm = new GiaoHangModel();
        ghm.setIdGiaoHang(id);

        if (ghs.updateDangGH(ghm) != null) {
            JOptionPane.showMessageDialog(this, "Chuyển đổi trạng thái thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Chuyển đổi trạng thái không  thành công");
        }
        loadtableDangGiaoHang();
    }//GEN-LAST:event_TblDangGiaoHangMouseClicked

    private void tblHuyGiaoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHuyGiaoHangMouseClicked
        
    }//GEN-LAST:event_tblHuyGiaoHangMouseClicked

//      private HoaDon getHD(int row, String maHD) {
//        ArrayList<HoaDonViewModel> hdm = hds.getAllhoadon();
//        for (HoaDonViewModel dhm1 : hdm) {
//            if (dhm1.getMahd().equals(maHD)) {
//                return new HoaDon(dhm1.getMahd());
//            }
//        }
//        return null;
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChoGiaoHang;
    private javax.swing.JPanel DangGiao;
    private javax.swing.JPanel DangGiaoHang;
    private javax.swing.JPanel HuyGiaoHang;
    private javax.swing.JPanel PnCacGoc;
    private javax.swing.JTable TblDangGiaoHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblChoGiaoHang;
    private javax.swing.JTable tblGiaoHang;
    private javax.swing.JTable tblHuyGiaoHang;
    // End of variables declaration//GEN-END:variables
}
