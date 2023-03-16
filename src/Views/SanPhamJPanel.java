/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Services.ChatLieuService;
import Services.DanhMucService;
import Services.DoCaoService;
import Services.MauSacService;
import Services.SizeService;
import ViewModels.ChatLieuModel;
import ViewModels.DanhMucModel;
import ViewModels.DoCaoModel;
import ViewModels.MauSacModel;
import ViewModels.SizeModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class SanPhamJPanel extends javax.swing.JPanel {

    DanhMucService dms;
    DefaultTableModel dtmDM;

    MauSacService mss;
    DefaultTableModel dtmMS;

    ChatLieuService cls;
    DefaultTableModel dtmCL;

    DoCaoService dcs;
    DefaultTableModel dtmDC;

    SizeService sizes;
    DefaultTableModel dtmsize;

    public SanPhamJPanel() {
        initComponents();
        dms = new DanhMucService();
        dtmDM = new DefaultTableModel();
        dtmDM = (DefaultTableModel) tblDanhMuc.getModel();
        loadtableDM();

        mss = new MauSacService();
        dtmMS = new DefaultTableModel();
        dtmMS = (DefaultTableModel) tblMauSac.getModel();
        loadtableMauSac();

        cls = new ChatLieuService();
        dtmCL = new DefaultTableModel();
        dtmCL = (DefaultTableModel) tblChatLieu.getModel();
        loadtableChatLieu();

        dcs = new DoCaoService();
        dtmDC = new DefaultTableModel();
        dtmDC = (DefaultTableModel) tblDoCao.getModel();
        loadtableDoCao();

        sizes = new SizeService();
        dtmsize = new DefaultTableModel();
        dtmsize = (DefaultTableModel) tblSize.getModel();
        loadtableSize();

    }

    //////////////////////////////////////////////DanhMuc/////////////////////////////////////////////////////////////////
    public void loadtableDM() {
        ArrayList<DanhMucModel> list = dms.getAllDanhMuc();
        dtmDM.setRowCount(0);
        for (DanhMucModel x : list) {
            Object[] rowdata = {
                x.getMaDM(),
                x.getTenDM(),
                x.getTrangThai() == 0 ? "Còn" : "Hết"
            };
            dtmDM.addRow(rowdata);
        }
    }

    private void clearDM() {
        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");
        rdoConDanhMuc.setSelected(true);

    }

    private DanhMucModel getDanhMucForm() {
        String maDanhMuc = txtMaDanhMuc.getText().trim();
        String tenDanhMuc = txtTenDanhMuc.getText().trim();
        int tt = rdoConDanhMuc.isSelected() == true ? 0 : 1;
        if (maDanhMuc.length() == 0 || tenDanhMuc.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mã và Tên Danh Mục");
            return null;
        }
        DanhMucModel ds = new DanhMucModel(maDanhMuc, tenDanhMuc, tt);
        return ds;
    }
    //////////////////////////////////////////////DanhMuc/////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////MauSac/////////////////////////////////////////////////////////////////
    public void loadtableMauSac() {
        ArrayList<MauSacModel> list = mss.getAllMauSac();
        dtmMS.setRowCount(0);
        for (MauSacModel x : list) {
            Object[] rowdata = {
                x.getMaMS(),
                x.getTenMS(),
                x.getTrangThai() == 0 ? "Còn" : "Hết"
            };
            dtmMS.addRow(rowdata);
        }
    }

    private void clearMauSac() {
        txtMaMauSac.setText("");
        txtTenMauSac.setText("");
        rdoConMauSac.setSelected(true);

    }

    private MauSacModel getMauSacForm() {
        String maMauSac = txtMaMauSac.getText().trim();
        String tenMauSac = txtTenMauSac.getText().trim();
        int tt = rdoConMauSac.isSelected() == true ? 0 : 1;
        if (maMauSac.length() == 0 || tenMauSac.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mã và Tên Danh Màu");
            return null;
        }
        MauSacModel ms = new MauSacModel(maMauSac, tenMauSac, tt);
        return ms;
    }
    ////////////////////////////////////////////// Màu  Sắc  /////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////Chất Liệu/////////////////////////////////////////////////////////////////
    public void loadtableChatLieu() {
        ArrayList<ChatLieuModel> list = cls.getAllChatLieu();
        dtmCL.setRowCount(0);
        for (ChatLieuModel x : list) {
            Object[] rowdata = {
                x.getMaCL(),
                x.getTenCL(),
                x.getTrangThai() == 0 ? "Còn" : "Hết"
            };
            dtmCL.addRow(rowdata);
        }
    }

    private void clearChatLieu() {
        txtMaChatLieu.setText("");
        txtTenChatLieu.setText("");
        rdoConChatLieu.setSelected(true);

    }

    private ChatLieuModel getChatLieuForm() {
        String maChatLieu = txtMaChatLieu.getText().trim();
        String tenChatLieu = txtTenChatLieu.getText().trim();
        int tt = rdoConChatLieu.isSelected() == true ? 0 : 1;
        if (maChatLieu.length() == 0 || tenChatLieu.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mã và Tên Chất Liệu");
            return null;
        }
        ChatLieuModel cl = new ChatLieuModel(maChatLieu, tenChatLieu, tt);
        return cl;
    }
    ////////////////////////////////////////////// Chất Liệu  /////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////Độ cao/////////////////////////////////////////////////////////////////
    public void loadtableDoCao() {
        ArrayList<DoCaoModel> list = dcs.getAllDoCao();
        dtmDC.setRowCount(0);
        for (DoCaoModel x : list) {
            Object[] rowdata = {
                x.getMaDC(),
                x.getTenDC(),
                x.getTrangThai() == 0 ? "Còn" : "Hết"
            };
            dtmDC.addRow(rowdata);
        }
    }

    private void clearDoCao() {
        txtMaDoCao.setText("");
        txtTenDoCao.setText("");
        rdoConDoCao.setSelected(true);

    }

    private DoCaoModel getDoCaoForm() {
        String maDoCao = txtMaDoCao.getText().trim();
        String tenDoCao = txtTenDoCao.getText().trim();
        int tt = rdoConDoCao.isSelected() == true ? 0 : 1;
        if (maDoCao.length() == 0 || tenDoCao.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mã và Tên Độ Cao");
            return null;
        }
        DoCaoModel dc = new DoCaoModel(maDoCao, tenDoCao, tt);
        return dc;
    }
    ////////////////////////////////////////////// Dộ Cao  /////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////Size/////////////////////////////////////////////////////////////////
    public void loadtableSize() {
        ArrayList<SizeModel> list = sizes.getAllSize();
        dtmsize.setRowCount(0);
        for (SizeModel x : list) {
            Object[] rowdata = {
                x.getMaSize(),
                x.getTenSize(),
                x.getTrangThai() == 0 ? "Còn" : "Hết"
            };
            dtmsize.addRow(rowdata);
        }
    }

    private void clearSize() {
        txtMaSize.setText("");
        txtTenSize.setText("");
        rdoConSize.setSelected(true);

    }

    private SizeModel getSizeForm() {
        String maSize = txtMaSize.getText().trim();
        String tenSize = txtTenSize.getText().trim();
        int tt = rdoConDoCao.isSelected() == true ? 0 : 1;
        if (maSize.length() == 0 || tenSize.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mã và Tên Độ Cao");
            return null;
        }
        SizeModel size = new SizeModel(maSize, tenSize, tt);
        return size;
    }

    ////////////////////////////////////////////// Size  /////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupDanhMuc = new javax.swing.ButtonGroup();
        buttonGroupMauSac = new javax.swing.ButtonGroup();
        buttonGroupChatLieu = new javax.swing.ButtonGroup();
        buttonGroupDoCao = new javax.swing.ButtonGroup();
        buttonGroupSize = new javax.swing.ButtonGroup();
        buttonGroupSanPham = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jTextField16 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jTextField15 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtMaDanhMuc = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTenDanhMuc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rdoConDanhMuc = new javax.swing.JRadioButton();
        rdoHetDanhMuc = new javax.swing.JRadioButton();
        btnThemDanhMuc = new javax.swing.JButton();
        btnCapNhatDanhMuc = new javax.swing.JButton();
        btnXoaDanhMuc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMaMauSac = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtTenMauSac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdoConMauSac = new javax.swing.JRadioButton();
        rdoHetMauSac = new javax.swing.JRadioButton();
        btnThemMauSac = new javax.swing.JButton();
        btnCapNhatMauSac = new javax.swing.JButton();
        btnXoaMauSac = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtMaChatLieu = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtTenChatLieu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdoConChatLieu = new javax.swing.JRadioButton();
        rdoHetChatLieu = new javax.swing.JRadioButton();
        btnThemChatLieu = new javax.swing.JButton();
        btnCapNhatChatLieu = new javax.swing.JButton();
        BtnXoaChatLieu = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtMaDoCao = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtTenDoCao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoConDoCao = new javax.swing.JRadioButton();
        rdoHetDoCao = new javax.swing.JRadioButton();
        btnThemDoCao = new javax.swing.JButton();
        btnCapNhatDoCao = new javax.swing.JButton();
        btnXoaDoCao = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDoCao = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtMaSize = new javax.swing.JTextField();
        txtTenSize = new javax.swing.JTextField();
        rdoConSize = new javax.swing.JRadioButton();
        rdoHetSize = new javax.swing.JRadioButton();
        btnThemSize = new javax.swing.JButton();
        btnCapNhatSize = new javax.swing.JButton();
        btnXoaSize = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));

        jLabel13.setText("Ma SP");

        jLabel14.setText("Số Lượng");

        jLabel15.setText("Giá Bán");

        jLabel16.setText("Mô Tả");

        jLabel17.setText("Giá nhập");

        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Cập Nhật");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Xóa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel18.setText("Độ cao");

        jLabel19.setText("Trạng Thái");

        buttonGroupSanPham.add(jRadioButton3);
        jRadioButton3.setText("Còn");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroupSanPham.add(jRadioButton4);
        jRadioButton4.setText("Hết");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        jButton9.setText("UpLoad");

        jLabel12.setText("Size");

        jLabel20.setText("Màu Sắc");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel21.setText("Chất Liệu");

        jLabel24.setText("Danh Mục");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Tên SP");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel20))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField12)
                                    .addComponent(jTextField13)
                                    .addComponent(jComboBox2, 0, 141, Short.MAX_VALUE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(71, 71, 71))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jButton7)
                .addGap(118, 118, 118)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton6, jButton7, jButton8, jButton9});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)
                                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel15)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jRadioButton3)
                                            .addComponent(jRadioButton4)
                                            .addComponent(jLabel19)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel21)
                                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton8))
                .addGap(28, 28, 28))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton6, jButton7, jButton8, jButton9});

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Sản Phẩm"));

        jLabel22.setText("Danh Mục");

        jButton10.setText("Tìm Kiếm Sản Phẩm theo Mã");

        jLabel23.setText("Điều Kiện Giá");

        jLabel25.setText("Giá Tiền");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ">=" }));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giá Nhập" }));

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Giá Bán", "Giá Tiền", "Số Lượng", "Size", "Độ Cao", "Chất Liệu", "Màu Sắc", "Danh Mục", "Mô Tả", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1028, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel6);

        jLabel9.setText("Mã Danh Mục");

        jLabel28.setText("Tên Danh Mục");

        jLabel2.setText("Trạng Thái");

        buttonGroupDanhMuc.add(rdoConDanhMuc);
        rdoConDanhMuc.setText("Còn");

        buttonGroupDanhMuc.add(rdoHetDanhMuc);
        rdoHetDanhMuc.setText("Hết hạn");

        btnThemDanhMuc.setText("Thêm");
        btnThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDanhMucActionPerformed(evt);
            }
        });

        btnCapNhatDanhMuc.setText("Cập Nhật");
        btnCapNhatDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDanhMucActionPerformed(evt);
            }
        });

        btnXoaDanhMuc.setText("Xóa");
        btnXoaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDanhMucActionPerformed(evt);
            }
        });

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Danh Mục", "Tên Danh Mục", "Trạng Thái"
            }
        ));
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhMuc);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(btnThemDanhMuc)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btnCapNhatDanhMuc)
                                .addGap(182, 182, 182)
                                .addComponent(btnXoaDanhMuc))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoConDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHetDanhMuc)))
                        .addGap(0, 151, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhatDanhMuc, btnThemDanhMuc, btnXoaDanhMuc});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(rdoConDanhMuc)
                    .addComponent(rdoHetDanhMuc))
                .addGap(37, 37, 37)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDanhMuc)
                    .addComponent(btnCapNhatDanhMuc)
                    .addComponent(btnXoaDanhMuc))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCapNhatDanhMuc, btnThemDanhMuc, btnXoaDanhMuc});

        jTabbedPane2.addTab("Quản Lý Danh Mục", jPanel12);

        jLabel10.setText("Mã Màu Sắc");

        jLabel29.setText("Tên Màu Sắc");

        jLabel3.setText("Trạng Thái");

        buttonGroupMauSac.add(rdoConMauSac);
        rdoConMauSac.setText("Còn");

        buttonGroupMauSac.add(rdoHetMauSac);
        rdoHetMauSac.setText("Hết hạn");

        btnThemMauSac.setText("Thêm");
        btnThemMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauSacActionPerformed(evt);
            }
        });

        btnCapNhatMauSac.setText("Cập Nhật");
        btnCapNhatMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatMauSacActionPerformed(evt);
            }
        });

        btnXoaMauSac.setText("Xóa");
        btnXoaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauSacActionPerformed(evt);
            }
        });

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Màu Sắc", "Tên Màu Sắc", "Trạng Thái"
            }
        ));
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblMauSac);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnThemMauSac)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(btnCapNhatMauSac)
                        .addGap(195, 195, 195)
                        .addComponent(btnXoaMauSac))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoConMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoHetMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhatMauSac, btnThemMauSac, btnXoaMauSac});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(rdoConMauSac)
                    .addComponent(rdoHetMauSac))
                .addGap(40, 40, 40)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMauSac)
                    .addComponent(btnCapNhatMauSac)
                    .addComponent(btnXoaMauSac))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lý Màu Sắc", jPanel13);

        jLabel11.setText("Mã Chất Liệu");

        txtMaChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaChatLieuActionPerformed(evt);
            }
        });

        jLabel30.setText("Tên Chất Liệu");

        jLabel4.setText("Trạng Thái");

        buttonGroupChatLieu.add(rdoConChatLieu);
        rdoConChatLieu.setText("Còn");

        buttonGroupChatLieu.add(rdoHetChatLieu);
        rdoHetChatLieu.setText("Hết hạn");

        btnThemChatLieu.setText("Thêm");
        btnThemChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChatLieuActionPerformed(evt);
            }
        });

        btnCapNhatChatLieu.setText("Cập Nhật");
        btnCapNhatChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatChatLieuActionPerformed(evt);
            }
        });

        BtnXoaChatLieu.setText("Xóa");
        BtnXoaChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnXoaChatLieuActionPerformed(evt);
            }
        });

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chất Liệu", "Tên Chất Liệu", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblChatLieu);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnThemChatLieu)
                                .addGap(100, 100, 100)))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnCapNhatChatLieu)
                                .addGap(141, 141, 141)
                                .addComponent(BtnXoaChatLieu))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoConChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHetChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 161, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6)))
                .addContainerGap())
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnXoaChatLieu, btnCapNhatChatLieu, btnThemChatLieu});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rdoConChatLieu)
                    .addComponent(rdoHetChatLieu))
                .addGap(43, 43, 43)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemChatLieu)
                    .addComponent(btnCapNhatChatLieu)
                    .addComponent(BtnXoaChatLieu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Chất Liệu", jPanel14);

        jLabel31.setText("Mã Độ Cao");

        jLabel32.setText("Tên Độ Cao");

        jLabel5.setText("Trạng Thái");

        buttonGroupDoCao.add(rdoConDoCao);
        rdoConDoCao.setText("Còn");
        rdoConDoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConDoCaoActionPerformed(evt);
            }
        });

        buttonGroupDoCao.add(rdoHetDoCao);
        rdoHetDoCao.setText("Hết hạn");

        btnThemDoCao.setText("Thêm");
        btnThemDoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDoCaoActionPerformed(evt);
            }
        });

        btnCapNhatDoCao.setText("Cập Nhật");
        btnCapNhatDoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDoCaoActionPerformed(evt);
            }
        });

        btnXoaDoCao.setText("Xóa");
        btnXoaDoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDoCaoActionPerformed(evt);
            }
        });

        tblDoCao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Độ Cao", "Tên Độ Cao", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoCaoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblDoCao);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaDoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnThemDoCao)
                                .addGap(44, 44, 44)))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(btnCapNhatDoCao)
                                .addGap(146, 146, 146)
                                .addComponent(btnXoaDoCao))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenDoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoConDoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHetDoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 177, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhatDoCao, btnThemDoCao, btnXoaDoCao});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtMaDoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtTenDoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rdoConDoCao)
                    .addComponent(rdoHetDoCao))
                .addGap(43, 43, 43)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDoCao)
                    .addComponent(btnCapNhatDoCao)
                    .addComponent(btnXoaDoCao))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Độ Cao", jPanel15);

        jLabel8.setText("Mã Size");

        jLabel26.setText("Tên Size");

        jLabel27.setText("Trạng Thái");

        buttonGroupSize.add(rdoConSize);
        rdoConSize.setText("Còn");
        rdoConSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConSizeActionPerformed(evt);
            }
        });

        buttonGroupSize.add(rdoHetSize);
        rdoHetSize.setText("Hết hạn");

        btnThemSize.setText("Thêm");
        btnThemSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSizeActionPerformed(evt);
            }
        });

        btnCapNhatSize.setText("Cập Nhật");
        btnCapNhatSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSizeActionPerformed(evt);
            }
        });

        btnXoaSize.setText("Xóa");
        btnXoaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSizeActionPerformed(evt);
            }
        });

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Size", "Tên Size", "Trạng Thái"
            }
        ));
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSize);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(btnThemSize)))
                        .addGap(90, 90, 90)
                        .addComponent(jLabel26)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhatSize))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(rdoConSize)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHetSize, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnXoaSize)))
                        .addGap(0, 215, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhatSize, btnThemSize, btnXoaSize});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoConSize)
                    .addComponent(rdoHetSize))
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSize)
                    .addComponent(btnCapNhatSize)
                    .addComponent(btnXoaSize))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Quản Lý Size", jPanel11);

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
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi Tiết Sản Phẩm", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void rdoConSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoConSizeActionPerformed

    private void btnThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDanhMucActionPerformed
        DanhMucModel dmm = getDanhMucForm();
        if (dmm == null) {
            return;
        }
        if (dms.insertDM(dmm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            loadtableDM();
            clearDM();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại do trùng mã Danh Mục");
        }
    }//GEN-LAST:event_btnThemDanhMucActionPerformed

    private void btnCapNhatDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDanhMucActionPerformed
        int row = tblDanhMuc.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sưa");

            return;
        }
        DanhMucModel dmm = getDanhMucForm();
        if (dmm == null) {
            return;
        }
        dmm.setMaDM(tblDanhMuc.getValueAt(row, 0).toString());
        if (dms.updateDM(dmm) != null) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
            loadtableDM();
            clearDM();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
        }
    }//GEN-LAST:event_btnCapNhatDanhMucActionPerformed

    private void btnXoaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDanhMucActionPerformed
        int row = tblDanhMuc.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Dòng Cần Xóa");
            return;
        }
        String maDanhMuc = tblDanhMuc.getValueAt(row, 0).toString();
        int xn = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Danh Mục sản phẩm này không");
        if (xn == JOptionPane.YES_OPTION) {
            if (dms.deleteDM(maDanhMuc) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa Danh Mục Sản Phẩm Thành Công");
                loadtableDM();
                clearDM();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Danh Mục Thất Bại");
        }
    }//GEN-LAST:event_btnXoaDanhMucActionPerformed

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        int row = tblDanhMuc.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaDanhMuc.setText(tblDanhMuc.getValueAt(row, 0).toString());
        txtTenDanhMuc.setText(tblDanhMuc.getValueAt(row, 1).toString());
        String tt = tblDanhMuc.getValueAt(row, 2).toString();
        if (tt.equalsIgnoreCase("Còn")) {
            rdoConDanhMuc.setSelected(true);
        } else {
            rdoHetDanhMuc.setSelected(true);
        }
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void btnThemMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauSacActionPerformed
        MauSacModel msm = getMauSacForm();
        if (msm == null) {
            return;
        }
        if (mss.insertMS(msm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            loadtableMauSac();
            clearMauSac();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại do trùng mã Màu Sắc");
        }
    }//GEN-LAST:event_btnThemMauSacActionPerformed

    private void btnCapNhatMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatMauSacActionPerformed
        int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");

            return;
        }
        MauSacModel msm = getMauSacForm();
        if (msm == null) {
            return;
        }
        msm.setMaMS(tblMauSac.getValueAt(row, 0).toString());
        if (mss.updateMS(msm) != null) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
            loadtableMauSac();
            clearMauSac();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
        }
    }//GEN-LAST:event_btnCapNhatMauSacActionPerformed

    private void btnXoaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauSacActionPerformed
        int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Dòng Cần Xóa");
            return;
        }
        String maMauSac = tblMauSac.getValueAt(row, 0).toString();
        int xn = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Màu Sắc sản phẩm này không");
        if (xn == JOptionPane.YES_OPTION) {
            if (mss.deleteMS(maMauSac) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa Màu Sắc Sản Phẩm Thành Công");
                loadtableMauSac();
                clearMauSac();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Màu Sắc Thất Bại");
        }
    }//GEN-LAST:event_btnXoaMauSacActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaMauSac.setText(tblMauSac.getValueAt(row, 0).toString());
        txtTenMauSac.setText(tblMauSac.getValueAt(row, 1).toString());
        String tt = tblMauSac.getValueAt(row, 2).toString();
        if (tt.equalsIgnoreCase("Còn")) {
            rdoConMauSac.setSelected(true);
        } else {
            rdoHetMauSac.setSelected(true);
        }
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void txtMaChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChatLieuActionPerformed

    private void btnThemChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChatLieuActionPerformed
        ChatLieuModel clm = getChatLieuForm();
        if (clm == null) {
            return;
        }
        if (cls.insertCL(clm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            loadtableChatLieu();
            clearChatLieu();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại do trùng mã Chất Liệu");
        }
    }//GEN-LAST:event_btnThemChatLieuActionPerformed

    private void btnCapNhatChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatChatLieuActionPerformed
        int row = tblChatLieu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");

            return;
        }
        ChatLieuModel clm = getChatLieuForm();
        if (clm == null) {
            return;
        }
        clm.setMaCL(tblChatLieu.getValueAt(row, 0).toString());
        if (cls.updateCL(clm) != null) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
            loadtableChatLieu();
            clearChatLieu();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
        }
    }//GEN-LAST:event_btnCapNhatChatLieuActionPerformed

    private void BtnXoaChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnXoaChatLieuActionPerformed
        int row = tblChatLieu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Dòng Cần Xóa");
            return;
        }
        String maChatLieu = tblChatLieu.getValueAt(row, 0).toString();
        int xn = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Chất Liệu sản phẩm này không");
        if (xn == JOptionPane.YES_OPTION) {
            if (cls.deleteCL(maChatLieu) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa Chất Liệu Sản Phẩm Thành Công");
                loadtableChatLieu();
                clearChatLieu();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Xóa chất Liệu Thất Bại");
        }
    }//GEN-LAST:event_BtnXoaChatLieuActionPerformed

    private void tblChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuMouseClicked
        int row = tblChatLieu.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaChatLieu.setText(tblChatLieu.getValueAt(row, 0).toString());
        txtTenChatLieu.setText(tblChatLieu.getValueAt(row, 1).toString());
        String tt = tblChatLieu.getValueAt(row, 2).toString();
        if (tt.equalsIgnoreCase("Còn")) {
            rdoConChatLieu.setSelected(true);
        } else {
            rdoHetChatLieu.setSelected(true);
        }
    }//GEN-LAST:event_tblChatLieuMouseClicked

    private void rdoConDoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConDoCaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoConDoCaoActionPerformed

    private void btnThemDoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDoCaoActionPerformed
        DoCaoModel dcm = getDoCaoForm();
        if (dcm == null) {
            return;
        }
        if (dcs.insertDC(dcm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            loadtableDoCao();
            clearDoCao();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại do trùng mã Độ Cao");
        }
    }//GEN-LAST:event_btnThemDoCaoActionPerformed

    private void btnCapNhatDoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDoCaoActionPerformed
        int row = tblDoCao.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");

            return;
        }
        DoCaoModel dcm = getDoCaoForm();
        if (dcm == null) {
            return;
        }
        dcm.setMaDC(tblDoCao.getValueAt(row, 0).toString());
        if (dcs.updateDC(dcm) != null) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
            loadtableDoCao();
            clearDoCao();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
        }
    }//GEN-LAST:event_btnCapNhatDoCaoActionPerformed

    private void btnXoaDoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDoCaoActionPerformed
        int row = tblDoCao.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Dòng Cần Xóa");
            return;
        }
        String maDoCao = tblDoCao.getValueAt(row, 0).toString();
        int xn = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Độ Cao sản phẩm này không");
        if (xn == JOptionPane.YES_OPTION) {
            if (dcs.deleteDC(maDoCao) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa Độ Cao Sản Phẩm Thành Công");
                loadtableDoCao();
                clearDoCao();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Độ Cao Thất Bại");
        }
    }//GEN-LAST:event_btnXoaDoCaoActionPerformed

    private void tblDoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoCaoMouseClicked
        int row = tblDoCao.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaDoCao.setText(tblDoCao.getValueAt(row, 0).toString());
        txtTenDoCao.setText(tblDoCao.getValueAt(row, 1).toString());
        String tt = tblDoCao.getValueAt(row, 2).toString();
        if (tt.equalsIgnoreCase("Còn")) {
            rdoConDoCao.setSelected(true);
        } else {
            rdoHetDoCao.setSelected(true);
        }
    }//GEN-LAST:event_tblDoCaoMouseClicked

    private void btnThemSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSizeActionPerformed
        SizeModel sizem = getSizeForm();
        if (sizem == null) {
            return;
        }
        if (sizes.insertSize(sizem) != null) {
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            loadtableSize();
            clearSize();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại do trùng mã Size");
        }
    }//GEN-LAST:event_btnThemSizeActionPerformed

    private void btnCapNhatSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSizeActionPerformed
        int row = tblSize.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");

            return;
        }
        SizeModel sizem = getSizeForm();
        if (sizem == null) {
            return;
        }
        sizem.setMaSize(tblSize.getValueAt(row, 0).toString());
        if (sizes.updateSize(sizem) != null) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
            loadtableSize();
            clearSize();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
        }
    }//GEN-LAST:event_btnCapNhatSizeActionPerformed

    private void btnXoaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSizeActionPerformed
        int row = tblSize.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Dòng Cần Xóa");
            return;
        }
        String maSize = tblSize.getValueAt(row, 0).toString();
        int xn = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Size sản phẩm này không");
        if (xn == JOptionPane.YES_OPTION) {
            if (sizes.deleteSize(maSize) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa Size Sản Phẩm Thành Công");
                loadtableSize();
                clearSize();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Size Thất Bại");
        }
    }//GEN-LAST:event_btnXoaSizeActionPerformed

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        int row = tblSize.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMaSize.setText(tblSize.getValueAt(row, 0).toString());
        txtTenSize.setText(tblSize.getValueAt(row, 1).toString());
        String tt = tblSize.getValueAt(row, 2).toString();
        if (tt.equalsIgnoreCase("Còn")) {
            rdoConSize.setSelected(true);
        } else {
            rdoHetSize.setSelected(true);
        }
    }//GEN-LAST:event_tblSizeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnXoaChatLieu;
    private javax.swing.JButton btnCapNhatChatLieu;
    private javax.swing.JButton btnCapNhatDanhMuc;
    private javax.swing.JButton btnCapNhatDoCao;
    private javax.swing.JButton btnCapNhatMauSac;
    private javax.swing.JButton btnCapNhatSize;
    private javax.swing.JButton btnThemChatLieu;
    private javax.swing.JButton btnThemDanhMuc;
    private javax.swing.JButton btnThemDoCao;
    private javax.swing.JButton btnThemMauSac;
    private javax.swing.JButton btnThemSize;
    private javax.swing.JButton btnXoaDanhMuc;
    private javax.swing.JButton btnXoaDoCao;
    private javax.swing.JButton btnXoaMauSac;
    private javax.swing.JButton btnXoaSize;
    private javax.swing.ButtonGroup buttonGroupChatLieu;
    private javax.swing.ButtonGroup buttonGroupDanhMuc;
    private javax.swing.ButtonGroup buttonGroupDoCao;
    private javax.swing.ButtonGroup buttonGroupMauSac;
    private javax.swing.ButtonGroup buttonGroupSanPham;
    private javax.swing.ButtonGroup buttonGroupSize;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JRadioButton rdoConChatLieu;
    private javax.swing.JRadioButton rdoConDanhMuc;
    private javax.swing.JRadioButton rdoConDoCao;
    private javax.swing.JRadioButton rdoConMauSac;
    private javax.swing.JRadioButton rdoConSize;
    private javax.swing.JRadioButton rdoHetChatLieu;
    private javax.swing.JRadioButton rdoHetDanhMuc;
    private javax.swing.JRadioButton rdoHetDoCao;
    private javax.swing.JRadioButton rdoHetMauSac;
    private javax.swing.JRadioButton rdoHetSize;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTable tblDoCao;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtMaChatLieu;
    private javax.swing.JTextField txtMaDanhMuc;
    private javax.swing.JTextField txtMaDoCao;
    private javax.swing.JTextField txtMaMauSac;
    private javax.swing.JTextField txtMaSize;
    private javax.swing.JTextField txtTenChatLieu;
    private javax.swing.JTextField txtTenDanhMuc;
    private javax.swing.JTextField txtTenDoCao;
    private javax.swing.JTextField txtTenMauSac;
    private javax.swing.JTextField txtTenSize;
    // End of variables declaration//GEN-END:variables
}
