/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChucVu;
import Services.ChucVuService;
import Services.NhanVienService;
import ViewModels.ChucVuModel;
import ViewModels.NhanVienModel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phanh
 */
public class NhanVienJPanel extends javax.swing.JPanel {

    ChucVuService cvs;
    NhanVienService nvs;
    DefaultTableModel dtmCV;
    DefaultComboBoxModel<ChucVu> dcmCV;
    DefaultTableModel dtmNVLam;
    DefaultTableModel dtmNVNghi;
    String filename = null;

    /**
     * Creates new form QLyNhanVien
     */
    public NhanVienJPanel() {
        initComponents();
        cvs = new ChucVuService();
        nvs = new NhanVienService();
        dtmCV = new DefaultTableModel();
        dtmCV = (DefaultTableModel) tblChucVu.getModel();
        dcmCV = new DefaultComboBoxModel<>();
        dtmNVLam = new DefaultTableModel();
        dtmNVNghi = new DefaultTableModel();
        dtmNVLam = (DefaultTableModel) tblNVLam.getModel();
        dtmNVNghi = (DefaultTableModel) tblNVNghi.getModel();
        cbbCV.setModel((DefaultComboBoxModel) dcmCV);
        cbbTimCV.setModel((DefaultComboBoxModel) dcmCV);
        loadTableCV();
        loadComboCV();
        loadTableLam();
        loadTableNghi();
    }

    private void loadComboCV() {
        ArrayList<ChucVuModel> list = cvs.getAllChucVu();
        for (ChucVuModel x : list) {
            dcmCV.addElement(new ChucVu(x.getIdCV(), x.getMaCV(), x.getTenCV(), x.getTrangThai()));

        }
    }

    private void loadTableLam() {
        dtmNVLam.setRowCount(0);
        ArrayList<NhanVienModel> list = nvs.getNVLam();
        for (NhanVienModel nhanVienM : list) {
            dtmNVLam.addRow(nhanVienM.toDataRow());
        }
    }

    private void loadTableNghi() {
        dtmNVNghi.setRowCount(0);
        ArrayList<NhanVienModel> list = nvs.getNVNghi();
        for (NhanVienModel nhanVienM : list) {
            dtmNVNghi.addRow(nhanVienM.toDataRow());
        }
    }
    private void loadTimLamByCV( String tenCV) {
        dtmNVLam.setRowCount(0);
        ArrayList<NhanVienModel> list = nvs.getNVLamByCV(tenCV);
        for (NhanVienModel nhanVienM : list) {
            dtmNVLam.addRow(nhanVienM.toDataRow());
        }
    }
    private void loadTimNghiByCV( String tenCV) {
        dtmNVNghi.setRowCount(0);
        ArrayList<NhanVienModel> list = nvs.getNVNghiByCV(tenCV);
        for (NhanVienModel nhanVienM : list) {
            dtmNVNghi.addRow(nhanVienM.toDataRow());
        }
    }
    private void loadTimLamBySdt( String sdt) {
        dtmNVLam.setRowCount(0);
        ArrayList<NhanVienModel> list = nvs.getNVLamBySdt( sdt);
        for (NhanVienModel nhanVienM : list) {
            dtmNVLam.addRow(nhanVienM.toDataRow());
        }
    }

    private void loadTimNghiBySdt( String sdt) {
        dtmNVNghi.setRowCount(0);
        ArrayList<NhanVienModel> list = nvs.getNVNghiBySdt( sdt);
        for (NhanVienModel nhanVienM : list) {
            dtmNVNghi.addRow(nhanVienM.toDataRow());
        }
    }

    private void clearNV() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        Date d = new Date();
        txtNsinh.setDate(d);
        txtDchi.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
        txtPass.setText("");
        rdoNam.setSelected(true);
        rdoDiLam.setSelected(true);
        cbbCV.setSelectedIndex(0);
        lblHinh.setIcon(new ImageIcon("src\\AnhNV\\nen.png"));
    }

    private void clearCV() {
        txtMaCV.setText("");
        txtTenCV.setText("");
        rdoCon.setSelected(true);

    }

    private void loadTableCV() {
        ArrayList<ChucVuModel> list = cvs.getAllChucVu();
        dtmCV.setRowCount(0);
        for (ChucVuModel x : list) {
            Object[] rowData = {
                x.getMaCV(), x.getTenCV(), x.getTrangThai() == 0 ? "còn" : "hủy"
            };
            dtmCV.addRow(rowData);
        }
    }

    private ChucVuModel getCVForm() {
        String ma = txtMaCV.getText().trim();
        String ten = txtTenCV.getText().trim();
        int tt = rdoCon.isSelected() == true ? 0 : 1;
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã chức vụ");
            txtMaCV.requestFocus();
            return null;
        }
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên chức vụ");
            txtTenCV.requestFocus();
            return null;
        }
        return new ChucVuModel(ma, ten, tt);
    }

    private NhanVienModel getNVForm() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String ma = txtMaNV.getText().trim();
        String ten = txtTenNV.getText().trim();
        String nsinh = txtNsinh.getDate().toString();
        String gt = rdoNam.isSelected() == true ? "Nam" : "Nữ";
        String dchi = txtDchi.getText().trim();
        String sdt = txtSdt.getText().trim();
        String email = txtEmail.getText().trim();
        String mk = new String(String.valueOf(txtPass.getPassword()));
        ChucVu cv = (ChucVu) cbbCV.getModel().getSelectedItem();
        int tt = rdoDiLam.isSelected() == true ? 1 : 0;
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã nhân viên");
            txtMaNV.requestFocus();
            return null;
        }
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống họ tên nhân viên");
            txtTenNV.requestFocus();
            return null;
        }
        if (nsinh.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày sinh nhân viên");
            txtNsinh.requestFocus();
            return null;
        } else {

            try {
                date = txtNsinh.getDate();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (dchi.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống địa chỉ nhân viên");
            txtDchi.requestFocus();
            return null;
        }
        if (sdt.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống số điện thoại nhân viên");
            txtSdt.requestFocus();
            return null;
        } else {
            try {
                int dienthoai = Integer.parseInt(txtSdt.getText());
                String ktsdt = "0\\d{9}";
                if (txtSdt.getText().matches(ktsdt) == false) {
                    JOptionPane.showMessageDialog(this, "Bạn nhập sai số điện thoại");
                    txtSdt.requestFocus();
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại");
                txtSdt.requestFocus();
                e.printStackTrace();
                return null;
            }
        }
        if (email.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống email nhân viên");
            txtEmail.requestFocus();
            return null;
        } else {
            String ktemail = "\\w+@\\w+(\\.\\w+){1,2}";
            if (email.matches(ktemail) == false) {
                JOptionPane.showMessageDialog(this, "Sai định dạng email");
                txtEmail.requestFocus();
                return null;
            }
        }
        if (mk.length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu");
            txtPass.requestFocus();
            return null;
        }
        if (filename == null) {
            filename = "nen.png";
        }
        NhanVienModel nvm = new NhanVienModel(null, ma, ten, date, gt, dchi, sdt, email, mk, cv, filename, tt);
        return nvm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgroupCV = new javax.swing.ButtonGroup();
        btgroupGT = new javax.swing.ButtonGroup();
        btgroupTT = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtTenNV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDchi = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        rdoNghiLam = new javax.swing.JRadioButton();
        rdoDiLam = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        btnUpAnh = new javax.swing.JButton();
        btnThemNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cbbTimCV = new javax.swing.JComboBox<>();
        txtTimSdt = new javax.swing.JTextField();
        btnTimSdt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNVLam = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNVNghi = new javax.swing.JTable();
        txtNsinh = new com.toedter.calendar.JDateChooser();
        cbbCV = new javax.swing.JComboBox<>();
        btnClearNV = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaCV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTenCV = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        rdoCon = new javax.swing.JRadioButton();
        rdoNghi = new javax.swing.JRadioButton();
        btnThemCV = new javax.swing.JButton();
        btnSuaCV = new javax.swing.JButton();
        btnXoaCV = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChucVu = new javax.swing.JTable();
        btnClearCV = new javax.swing.JButton();

        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel4.setText("SDT");

        jLabel9.setText("Chức vụ");

        jLabel5.setText("Điạ Chỉ");

        jLabel6.setText("Ngày Sinh");

        txtPass.setText("jPasswordField1");

        jLabel1.setText("Mã NV");

        jLabel7.setText("Mật Khẩu");

        jLabel2.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel3.setText("Họ Và Tên");

        jLabel10.setText("Giới Tính");

        btgroupGT.add(rdoNam);
        rdoNam.setText("Nam");

        btgroupGT.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel11.setText("Trạng Thái");

        btgroupTT.add(rdoNghiLam);
        rdoNghiLam.setText("Nghỉ làm");

        btgroupTT.add(rdoDiLam);
        rdoDiLam.setText("Đi Làm");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );

        btnUpAnh.setText("UpLoad");
        btnUpAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpAnhActionPerformed(evt);
            }
        });

        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnSuaNV.setText("Cập Nhật");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnXoaNV.setText("Xóa");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Lọc Theo Chức Vụ");

        cbbTimCV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTimCVItemStateChanged(evt);
            }
        });

        btnTimSdt.setText("Tìm Kiếm SDT");
        btnTimSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSdtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(cbbTimCV, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(txtTimSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimSdt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbbTimCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimSdt))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblNVLam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã NV", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "SDT", "Email", "Mật Khẩu", "Chức Vụ", "Hình ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNVLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVLamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNVLam);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Đang làm", jPanel5);

        tblNVNghi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã NV", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "SDT", "Email", "Mật Khẩu", "Chức Vụ", "Hình ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNVNghi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVNghiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNVNghi);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Đã Nghỉ", jPanel6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );

        txtNsinh.setDateFormatString("yyyy-MM-dd");

        cbbCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCVActionPerformed(evt);
            }
        });

        btnClearNV.setText("Clear");
        btnClearNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpAnh)
                        .addGap(51, 51, 51))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addGap(7, 7, 7))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addGap(8, 8, 8)))))
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenNV)
                                    .addComponent(txtDchi)
                                    .addComponent(txtMaNV)
                                    .addComponent(txtNsinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rdoDiLam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdoNghiLam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(23, 23, 23))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                            .addComponent(cbbCV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(48, 48, 48))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(btnThemNV)
                                .addGap(187, 187, 187)
                                .addComponent(btnSuaNV)
                                .addGap(202, 202, 202)
                                .addComponent(btnXoaNV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClearNV)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearNV, btnSuaNV, btnThemNV, btnXoaNV});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpAnh))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel1)
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtNsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbbCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(rdoNghiLam)
                            .addComponent(rdoDiLam, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemNV)
                            .addComponent(btnSuaNV)
                            .addComponent(btnXoaNV)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearNV)))
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jTabbedPane1.addTab("Quản lý nhân viên", jPanel1);

        jLabel8.setText("Mã chức vụ");

        jLabel13.setText("Tên chức vụ");

        jLabel14.setText("Trạng thái");

        btgroupCV.add(rdoCon);
        rdoCon.setText("Còn");

        btgroupCV.add(rdoNghi);
        rdoNghi.setText("Hủy");

        btnThemCV.setText("Thêm");
        btnThemCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCVActionPerformed(evt);
            }
        });

        btnSuaCV.setText("Sửa");
        btnSuaCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCVActionPerformed(evt);
            }
        });

        btnXoaCV.setText("Xóa");
        btnXoaCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCVActionPerformed(evt);
            }
        });

        tblChucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chức vụ", "Tên chức vụ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChucVuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChucVu);

        btnClearCV.setText("Clear");
        btnClearCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(btnThemCV)))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(rdoCon)
                                .addGap(31, 31, 31)
                                .addComponent(rdoNghi))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnSuaCV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoaCV)
                                .addGap(177, 177, 177)
                                .addComponent(btnClearCV)))
                        .addGap(0, 128, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaCV, btnThemCV, btnXoaCV});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(rdoCon)
                    .addComponent(rdoNghi))
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCV)
                    .addComponent(btnSuaCV)
                    .addComponent(btnXoaCV)
                    .addComponent(btnClearCV))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chức vụ", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cbbCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCVActionPerformed

    private void tblChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChucVuMouseClicked
        int row = tblChucVu.getSelectedRow();
        if (row < 0) {
            return;
        }
        txtMaCV.setText(tblChucVu.getValueAt(row, 0).toString());
        txtTenCV.setText(tblChucVu.getValueAt(row, 1).toString());
        String tt = tblChucVu.getValueAt(row, 2).toString();
        if (tt.equalsIgnoreCase("còn")) {
            rdoCon.setSelected(true);
        } else {
            rdoNghi.setSelected(true);
        }
    }//GEN-LAST:event_tblChucVuMouseClicked

    private void btnThemCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCVActionPerformed
        ChucVuModel cvm = getCVForm();
        if (cvm == null) {
            return;
        }
        if (cvs.insertCV(cvm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTableCV();
            clearCV();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại do trùng mã chức vụ");
        }
    }//GEN-LAST:event_btnThemCVActionPerformed

    private void btnSuaCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCVActionPerformed
        int row = tblChucVu.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        ChucVuModel cvm = getCVForm();
        if (cvm == null) {
            return;
        }
        cvm.setMaCV(tblChucVu.getValueAt(row, 0).toString());
        if (cvs.updateCV(cvm) != null) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadTableCV();
            clearCV();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaCVActionPerformed

    private void btnXoaCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCVActionPerformed
        int row = tblChucVu.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        String ma = tblChucVu.getValueAt(row, 0).toString();
        int xn = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa chức vụ này không?");
        if (xn == JOptionPane.YES_OPTION) {
            if (cvs.deleteCV(ma) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa chức vụ thành công");
                loadTableCV();
                clearCV();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa chức vụ thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaCVActionPerformed

    private void btnClearCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCVActionPerformed
        clearCV();
    }//GEN-LAST:event_btnClearCVActionPerformed

    private void btnClearNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearNVActionPerformed
        clearNV();
    }//GEN-LAST:event_btnClearNVActionPerformed

    private void btnUpAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpAnhActionPerformed
        try {
            JFileChooser f = new JFileChooser("src\\AnhNV");
            f.showOpenDialog(null);
            File file = f.getSelectedFile();
            Image img = ImageIO.read(file);
            filename = file.getName();
            int w = lblHinh.getWidth();
            int h = lblHinh.getHeight();
            lblHinh.setIcon(new ImageIcon(img.getScaledInstance(w, h, Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnUpAnhActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        NhanVienModel nvm = getNVForm();
        if (nvm == null) {
            return;
        }
        if (nvs.insertNV(nvm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại do trùng mã nhân viên");
        }
        loadTableLam();
        loadTableNghi();
        clearNV();
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void tblNVLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVLamMouseClicked
        try {
            int row = tblNVLam.getSelectedRow();
            if (row < 0) {
                return;
            }
            txtMaNV.setText(tblNVLam.getValueAt(row, 1).toString());
            txtTenNV.setText(tblNVLam.getValueAt(row, 2).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tblNVLam.getValueAt(row, 3).toString());
            txtNsinh.setDate(date);
            String gt = tblNVLam.getValueAt(row, 4).toString();
            if (gt.equalsIgnoreCase("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtDchi.setText(tblNVLam.getValueAt(row, 5).toString());
            txtSdt.setText(tblNVLam.getValueAt(row, 6).toString());
            txtEmail.setText(tblNVLam.getValueAt(row, 7).toString());
            txtPass.setText(tblNVLam.getValueAt(row, 8).toString());
            String chucvu = tblNVLam.getValueAt(row, 9).toString();
            cbbCV.getModel().setSelectedItem(getCV(row, chucvu));
            String hinh = tblNVLam.getValueAt(row, 10).toString();
            ImageIcon icon = new ImageIcon(getClass().getResource("/AnhNV/" + hinh));
            Image img = icon.getImage();
            lblHinh.setIcon(new ImageIcon(img.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH)));
            String tt = tblNVLam.getValueAt(row, 11).toString();
            if (tt.equalsIgnoreCase("Đi làm")) {
                rdoDiLam.setSelected(true);
            } else {
                rdoNghiLam.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblNVLamMouseClicked

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        NhanVienModel nvm = getNVForm();
        if (nvm == null) {
            return;
        }
        int row = tblNVLam.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng muốn sửa");
            return;
        }
        String ma = txtMaNV.getText().trim();
        nvm.setMaNV(ma);

        if (nvs.updateNV(nvm) != null) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại do trùng mã nhân viên");
        }
        loadTableLam();
        loadTableNghi();
        clearNV();
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        String ma = txtMaNV.getText().trim();
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên muốn xóa");
            return;
        }
        int xn = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên này không?");
        if (xn == JOptionPane.YES_OPTION) {
            if (nvs.deleteNV(ma) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
        loadTableLam();
        loadTableNghi();
        clearNV();
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void tblNVNghiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVNghiMouseClicked
        try {
            int row = tblNVNghi.getSelectedRow();
            if (row < 0) {
                return;
            }
            txtMaNV.setText(tblNVNghi.getValueAt(row, 1).toString());
            txtTenNV.setText(tblNVNghi.getValueAt(row, 2).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tblNVNghi.getValueAt(row, 3).toString());
            txtNsinh.setDate(date);
            String gt = tblNVNghi.getValueAt(row, 4).toString();
            if (gt.equalsIgnoreCase("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtDchi.setText(tblNVNghi.getValueAt(row, 5).toString());
            txtSdt.setText(tblNVNghi.getValueAt(row, 6).toString());
            txtEmail.setText(tblNVNghi.getValueAt(row, 7).toString());
            txtPass.setText(tblNVNghi.getValueAt(row, 8).toString());
            String chucvu = tblNVNghi.getValueAt(row, 9).toString();
            cbbCV.getModel().setSelectedItem(getCV(row, chucvu));
            String hinh = tblNVNghi.getValueAt(row, 10).toString();
            ImageIcon icon = new ImageIcon(getClass().getResource("/AnhNV/" + hinh));
            Image img = icon.getImage();
            lblHinh.setIcon(new ImageIcon(img.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH)));
            String tt = tblNVNghi.getValueAt(row, 11).toString();
            if (tt.equalsIgnoreCase("Đi làm")) {
                rdoDiLam.setSelected(true);
            } else {
                rdoNghiLam.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblNVNghiMouseClicked

    private void btnTimSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSdtActionPerformed
        String sdt = txtTimSdt.getText().trim();
        if (sdt.length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại của nhân viên muốn tìm");
            txtTimSdt.requestFocus();
            return;
        }

        loadTimLamBySdt( sdt);

        loadTimNghiBySdt( sdt);

    }//GEN-LAST:event_btnTimSdtActionPerformed

    private void cbbTimCVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTimCVItemStateChanged
        String tenCV = cbbTimCV.getSelectedItem().toString();

        loadTimLamByCV(tenCV);

        loadTimNghiByCV(tenCV);
    }//GEN-LAST:event_cbbTimCVItemStateChanged
    private ChucVu getCV(int row, String tenCV) {
        ArrayList<ChucVuModel> cvm = cvs.getAllChucVu();
        for (ChucVuModel cm : cvm) {
            if (cm.getTenCV().equals(tenCV)) {
                return new ChucVu(cm.getIdCV(), cm.getMaCV(), cm.getTenCV(), cm.getTrangThai());
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgroupCV;
    private javax.swing.ButtonGroup btgroupGT;
    private javax.swing.ButtonGroup btgroupTT;
    private javax.swing.JButton btnClearCV;
    private javax.swing.JButton btnClearNV;
    private javax.swing.JButton btnSuaCV;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemCV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnTimSdt;
    private javax.swing.JButton btnUpAnh;
    private javax.swing.JButton btnXoaCV;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JComboBox<String> cbbCV;
    private javax.swing.JComboBox<String> cbbTimCV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoDiLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNghi;
    private javax.swing.JRadioButton rdoNghiLam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblChucVu;
    private javax.swing.JTable tblNVLam;
    private javax.swing.JTable tblNVNghi;
    private javax.swing.JTextField txtDchi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaCV;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNsinh;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenCV;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimSdt;
    // End of variables declaration//GEN-END:variables
}
