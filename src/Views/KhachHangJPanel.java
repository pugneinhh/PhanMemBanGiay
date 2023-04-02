/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.KhachHang;
import Services.HoaDonChiTietLichSuService;
import Services.KhachHangService;
import ViewModels.GiaoCaModel;
import ViewModels.LichSuGiaoHangModel;
import ViewModels.KhachHangModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HoiVN
 */
public class KhachHangJPanel extends javax.swing.JPanel {

    private final KhachHangService khService;
    DefaultTableModel tableModelThongTin = new DefaultTableModel();
    DefaultTableModel tableLichSu = new DefaultTableModel();
    HoaDonChiTietLichSuService hdctService;

    /**
     * Creates new form KhachHang
     */
    public KhachHangJPanel() {
        initComponents();
        khService = new KhachHangService();
        hdctService = new HoaDonChiTietLichSuService();
        tableModelThongTin = (DefaultTableModel) tblThongtinKH.getModel();
        tableLichSu = (DefaultTableModel) tblLichSuGD.getModel();
        loadTableThongTin();
        loadTableLichSu();
    }

    private void loadTableThongTin() {
        ArrayList<KhachHangModel> list = khService.getAllKhachHang();
        tableModelThongTin.setRowCount(0);
        for (KhachHangModel khachHangViewModel : list) {
            tableModelThongTin.addRow(new Object[]{
                khachHangViewModel.getMaKH(),
                khachHangViewModel.getTenKH(),
                khachHangViewModel.getLoaiKH(),
                khachHangViewModel.getDiaChi(),
                khachHangViewModel.getGioiTinh(),
                khachHangViewModel.getEmail(),
                khachHangViewModel.getSdt(),
                khachHangViewModel.getNgaySinh(),
                khachHangViewModel.getTrangThai() == 1 ? "Còn hoạt động" : "Ngừng hoạt động"
            });
        }
    }

    private void loadTableLichSu() {
        ArrayList<LichSuGiaoHangModel> ghList = hdctService.getAllHoaDonGiaoHang();
        tableLichSu.setRowCount(0);
        for (LichSuGiaoHangModel giaoHangModel : ghList) {
            tableLichSu.addRow(new Object[]{
                giaoHangModel.getMaKH(),
                giaoHangModel.getHoTen(),
                giaoHangModel.getSdt(),
                giaoHangModel.getNgayMua(),
                giaoHangModel.getThanhTien(),
                giaoHangModel.getTrangThaiDon()
            });
        }
    }

    private void clearForm() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtLoaiKH.setText("");
        txtDiaChiKH.setText("");
        txtKHEmail.setText("");
        txtKHSdt.setText("");
        rdoKHCon.setSelected(true);
        rdoKHNam.setSelected(true);
    }

    public KhachHangModel getMa(String ma) {
        for (KhachHangModel kh : khService.getAllKhachHang()) {
            if (kh.getMaKH().equalsIgnoreCase(ma)) {
                return kh;
            }
        }
        return null;
    }

    public KhachHangModel getFormData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String ma = txtMaKH.getText();
        String ten = txtTenKH.getText();
        String loai = txtLoaiKH.getText();
        String diaChi = txtDiaChiKH.getText();
        String gt = rdoKHNam.isSelected() == true ? "Nam" : "Nữ";
        String email = txtKHEmail.getText();
        String sdt = txtKHSdt.getText();
        String nSinh = txtKHNgaySinh.getDate().toString();

        int tt = rdoKHCon.isSelected() == true ? 1 : 0;

        if (ma.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Mã không được trống");
            return null;
        }
        if (ten.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Mã không được trống");
            return null;
        }
        if (loai.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Mã không được trống");
            return null;
        }
        if (diaChi.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Mã không được trống");
            return null;
        }

        if (email.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống email");
            txtKHEmail.requestFocus();
            return null;
        } else {
            String ktemail = "\\w+@\\w+(\\.\\w+){1,2}";
            if (email.matches(ktemail) == false) {
                JOptionPane.showMessageDialog(this, "Sai định dạng email");
                txtKHEmail.requestFocus();
                return null;
            }
        }

        if (sdt.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống số điện thoại");
            txtKHSdt.requestFocus();
            return null;
        } else {
            try {
                int dienthoai = Integer.parseInt(txtKHSdt.getText());
                String ktsdt = "0\\d{9}";
                if (txtKHSdt.getText().matches(ktsdt) == false) {
                    JOptionPane.showMessageDialog(this, "Bạn nhập sai số điện thoại");
                    txtKHSdt.requestFocus();
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại");
                txtKHSdt.requestFocus();
                e.printStackTrace();
                return null;
            }
        }

        if (nSinh.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày sinh");
            txtKHNgaySinh.requestFocus();
            return null;
        } else {

            try {
                date = txtKHNgaySinh.getDate();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        KhachHangModel kh = new KhachHangModel(ma, loai, ten, diaChi, gt, email, sdt, date, null, tt);
        return kh;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLoaiKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChiKH = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        rdoKHNam = new javax.swing.JRadioButton();
        rdoKHNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtKHEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKHSdt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdoKHCon = new javax.swing.JRadioButton();
        rdoKHNgung = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtKHNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThongtinKH = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        lblTimSDT = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbbKHGioitinh = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbbKHTrangThai = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLichSuGD = new javax.swing.JTable();

        setBackground(new java.awt.Color(245, 255, 250));

        jPanel1.setBackground(new java.awt.Color(173, 216, 230));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Mã khách hàng");

        jLabel2.setText("Tên khách hàng");

        jLabel3.setText("Loại khách hàng");

        jLabel4.setText("Địa chỉ");

        txtDiaChiKH.setColumns(20);
        txtDiaChiKH.setRows(5);
        jScrollPane1.setViewportView(txtDiaChiKH);

        jLabel5.setText("Giới tính");

        buttonGroup1.add(rdoKHNam);
        rdoKHNam.setText("Nam");

        buttonGroup1.add(rdoKHNu);
        rdoKHNu.setText("Nữ");

        jLabel6.setText("Email");

        jLabel7.setText("SDT");

        jLabel8.setText("Ngày sinh");

        jLabel10.setText("Trạng thái");

        buttonGroup2.add(rdoKHCon);
        rdoKHCon.setText("Còn hoạt động");

        buttonGroup2.add(rdoKHNgung);
        rdoKHNgung.setText("Ngừng hoạt động");

        jPanel2.setBackground(new java.awt.Color(245, 255, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThem.setBackground(new java.awt.Color(152, 251, 152));
        btnThem.setFont(new java.awt.Font("Barlow Condensed Light", 1, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(152, 251, 152));
        btnSua.setFont(new java.awt.Font("Barlow Condensed Light", 1, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(152, 251, 152));
        btnLamMoi.setFont(new java.awt.Font("Barlow Condensed Light", 1, 14)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi)
                    .addComponent(btnSua)
                    .addComponent(btnThem))
                .addGap(19, 19, 19))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLamMoi, btnSua, btnThem});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi)
                .addGap(20, 20, 20))
        );

        txtKHNgaySinh.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaKH)
                    .addComponent(txtLoaiKH)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(txtTenKH))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoKHNam)
                                        .addGap(42, 42, 42)
                                        .addComponent(rdoKHNu))
                                    .addComponent(txtKHSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKHEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoKHCon)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoKHNgung))
                                    .addComponent(txtKHNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addComponent(rdoKHNam, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(rdoKHNu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(txtKHEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7))
                            .addComponent(txtKHSdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(txtKHNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rdoKHCon)
                                                .addComponent(rdoKHNgung)))))
                                .addGap(38, 38, 38))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(245, 255, 250));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(173, 216, 230));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));

        tblThongtinKH.setBackground(new java.awt.Color(245, 255, 250));
        tblThongtinKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Loại KH", "Địa chỉ", "Giới tính", "Email", "SDT", "Ngày sinh", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongtinKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongtinKHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblThongtinKH);

        jLabel17.setBackground(new java.awt.Color(0, 204, 204));
        jLabel17.setFont(new java.awt.Font("Barlow Condensed Light", 1, 14)); // NOI18N
        jLabel17.setText("Tìm theo SDT");

        lblTimSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblTimSDTActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(245, 255, 250));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel18.setText("Giới tính");

        cbbKHGioitinh.setBackground(new java.awt.Color(152, 251, 152));
        cbbKHGioitinh.setFont(new java.awt.Font("Barlow Condensed Light", 1, 14)); // NOI18N
        cbbKHGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nam", "Nữ" }));
        cbbKHGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKHGioitinhActionPerformed(evt);
            }
        });

        jLabel19.setText("Trạng thái");

        cbbKHTrangThai.setBackground(new java.awt.Color(152, 251, 152));
        cbbKHTrangThai.setFont(new java.awt.Font("Barlow Condensed Light", 1, 14)); // NOI18N
        cbbKHTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngừng hoạt động", "Còn hoạt động", "All" }));
        cbbKHTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKHTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbKHGioitinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbbKHTrangThai, 0, 121, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbKHGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(cbbKHTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(lblTimSDT)))
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jTabbedPane3.addTab("Thông tin khách hàng", jPanel10);

        jPanel12.setBackground(new java.awt.Color(173, 216, 230));

        tblLichSuGD.setBackground(new java.awt.Color(245, 255, 250));
        tblLichSuGD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblLichSuGD.setFont(new java.awt.Font("Barlow Condensed Light", 1, 12)); // NOI18N
        tblLichSuGD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "SDT", "Ngày GD", "Tổng tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblLichSuGD);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jTabbedPane3.addTab("Lịch sử giao dịch", jPanel12);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(394, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblThongtinKH.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        KhachHangModel kh = getFormData();
        if (kh == null) {
            return;
        }
        if (khService.updateKhachHang(kh) != null) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadTableThongTin();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhachHangModel kh = getFormData();
        if (kh == null) {
            return;
        }
        if (getMa(kh.getMaKH()) != null) {
            JOptionPane.showMessageDialog(this, "Đã có mã này");
            return;
        }
        if (khService.insertKhachHang(kh) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTableThongTin();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblThongtinKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongtinKHMouseClicked
        try {
            int row = tblThongtinKH.getSelectedRow();
            if (row < 0) {
                return;
            } else {
                txtMaKH.setText(tblThongtinKH.getValueAt(row, 0).toString());
                txtTenKH.setText(tblThongtinKH.getValueAt(row, 1).toString());
                txtLoaiKH.setText(tblThongtinKH.getValueAt(row, 2).toString());
                txtDiaChiKH.setText(tblThongtinKH.getValueAt(row, 3).toString());
                String gt = tblThongtinKH.getValueAt(row, 4).toString();
                if (gt.equalsIgnoreCase("Nam")) {
                    rdoKHNam.setSelected(true);
                } else {
                    rdoKHNu.setSelected(true);
                }
                txtKHEmail.setText(tblThongtinKH.getValueAt(row, 5).toString());
                txtKHSdt.setText(tblThongtinKH.getValueAt(row, 6).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tblThongtinKH.getValueAt(row, 7).toString());
                txtKHNgaySinh.setDate(date);
//                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tblThongtinKH.getValueAt(row, 8).toString());

                String tt = tblThongtinKH.getValueAt(row, 8).toString();
                if (tt.equalsIgnoreCase("Còn hoạt động")) {
                    rdoKHCon.setSelected(true);
                } else {
                    rdoKHNgung.setSelected(true);
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tblThongtinKHMouseClicked

    private void lblTimSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblTimSDTActionPerformed
        loadTableTimKiem();
    }//GEN-LAST:event_lblTimSDTActionPerformed

    private void cbbKHGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKHGioitinhActionPerformed
        String gioiTinh = cbbKHGioitinh.getSelectedItem().toString();
        if (gioiTinh.equalsIgnoreCase("All")) {
            loadTableThongTin();
        } else {
            loadTableTimGioiTinh(gioiTinh);
        }

    }//GEN-LAST:event_cbbKHGioitinhActionPerformed

    private void cbbKHTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKHTrangThaiActionPerformed
        String tt = cbbKHTrangThai.getSelectedItem().toString();
        if (tt.equalsIgnoreCase("All")) {
            loadTableThongTin();
        } else {
            loadTableTimTrangThai(cbbKHTrangThai.getSelectedIndex());
        }

    }//GEN-LAST:event_cbbKHTrangThaiActionPerformed

    private void loadTableTimKiem() {
        ArrayList<KhachHangModel> list = khService.getKhachHangBysdt(lblTimSDT.getText());
        tableModelThongTin.setRowCount(0);
        for (KhachHangModel khachHangViewModel : list) {
            tableModelThongTin.addRow(new Object[]{
                khachHangViewModel.getMaKH(),
                khachHangViewModel.getTenKH(),
                khachHangViewModel.getLoaiKH(),
                khachHangViewModel.getDiaChi(),
                khachHangViewModel.getGioiTinh(),
                khachHangViewModel.getEmail(),
                khachHangViewModel.getSdt(),
                khachHangViewModel.getNgaySinh(),
                khachHangViewModel.getTrangThai() == 1 ? "Còn hoạt động" : "Ngừng hoạt động"
            });
        }
    }

    private void loadTableTimGioiTinh(String gioiTinh) {
        ArrayList<KhachHangModel> list = khService.getKHByGT(gioiTinh);
        tableModelThongTin.setRowCount(0);
        for (KhachHangModel khachHangViewModel : list) {
            tableModelThongTin.addRow(new Object[]{
                khachHangViewModel.getMaKH(),
                khachHangViewModel.getTenKH(),
                khachHangViewModel.getLoaiKH(),
                khachHangViewModel.getDiaChi(),
                khachHangViewModel.getGioiTinh(),
                khachHangViewModel.getEmail(),
                khachHangViewModel.getSdt(),
                khachHangViewModel.getNgaySinh(),
                khachHangViewModel.getTrangThai() == 1 ? "Còn hoạt động" : "Ngừng hoạt động"
            });
        }
    }

    private void loadTableTimTrangThai(int tt) {
        ArrayList<KhachHangModel> list = khService.getKHByTrangThai(tt);
        tableModelThongTin.setRowCount(0);
        for (KhachHangModel khachHangViewModel : list) {
            tableModelThongTin.addRow(new Object[]{
                khachHangViewModel.getMaKH(),
                khachHangViewModel.getTenKH(),
                khachHangViewModel.getLoaiKH(),
                khachHangViewModel.getDiaChi(),
                khachHangViewModel.getGioiTinh(),
                khachHangViewModel.getEmail(),
                khachHangViewModel.getSdt(),
                khachHangViewModel.getNgaySinh(),
                khachHangViewModel.getTrangThai() == 1 ? "Còn hoạt động" : "Ngừng hoạt động"
            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbKHGioitinh;
    private javax.swing.JComboBox<String> cbbKHTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField lblTimSDT;
    private javax.swing.JRadioButton rdoKHCon;
    private javax.swing.JRadioButton rdoKHNam;
    private javax.swing.JRadioButton rdoKHNgung;
    private javax.swing.JRadioButton rdoKHNu;
    private javax.swing.JTable tblLichSuGD;
    private javax.swing.JTable tblThongtinKH;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JTextField txtKHEmail;
    private com.toedter.calendar.JDateChooser txtKHNgaySinh;
    private javax.swing.JTextField txtKHSdt;
    private javax.swing.JTextField txtLoaiKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables

}
