/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.DanhMuc;
import DomainModels.KhuyenMai;
import Services.ChiTietSanPhamService;
import Services.DanhMucService;
import Services.KhuyenMaiService;
import Services.SanPhamService;
import ViewModels.ChiTietSanPhamModel;
import ViewModels.DanhMucModel;
import ViewModels.KhuyenMaiModel;
import ViewModels.SanPhamModel;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import responsitories.DanhMucResponsitory;
import responsitories.KhuyenMaiResbonsitory;

public class KhuyenMaiJPanel extends javax.swing.JPanel {

    private KhuyenMaiService kms = new KhuyenMaiService();
    private KhuyenMaiResbonsitory kmr = new KhuyenMaiResbonsitory();
    private SanPhamService sps = new SanPhamService();
    private DanhMucService dms = new DanhMucService();
    private DanhMucResponsitory dmr = new DanhMucResponsitory();
    private ChiTietSanPhamService ctsps = new ChiTietSanPhamService();
    DefaultTableModel dtmKM;
    DefaultTableModel dtmSP;

    public KhuyenMaiJPanel() {
        initComponents();
        dtmKM = new DefaultTableModel();
        dtmSP = new DefaultTableModel();
        dtmKM = (DefaultTableModel) tblKhuyenMai.getModel();
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        pnSanPham.setVisible(false);
        pnLoaiKhuyenMai.setVisible(false);
        loadTableKM();
        PanelaLL.setPreferredSize(new Dimension(750, 590));
        load();
    }

    private void load() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<KhuyenMaiModel> listkm = kms.getAllKhuyenMai();
                ArrayList<ChiTietSanPhamModel> listsp = ctsps.getAllChiTietSanPham();
                Date htai = new Date();
                for (KhuyenMaiModel k : listkm) {
                    if (htai.after(k.getNgayKetThuc())) {

                        kms.updateChuyenTT(k);
                    }
                }
            }

        }).start();
    }

    public void loadTableKM() {
        ArrayList<KhuyenMaiModel> list = kms.getAllKhuyenMai();
        dtmKM.setRowCount(0);
        for (KhuyenMaiModel x : list) {
            Object[] rowdata = {
                x.getMaKM(),
                x.getTenKM(),
                x.getApDungGiamGia(),
                x.getHinhThucApDung(),
                x.getGiaTri(),
                x.getGiamToiDa(),
                x.getNgayBatDau(),
                x.getNgayKetThuc(),
                x.getTrangThai() == 0 ? "Đang Chạy" : "Đã Kết Thúc"
            };
            dtmKM.addRow(rowdata);
        }
    }
    public void loadKMHD() {
        ArrayList<KhuyenMaiModel> list = kms.getKhuyenMaiHD();
        dtmKM.setRowCount(0);
        for (KhuyenMaiModel x : list) {
            Object[] rowdata = {
                x.getMaKM(),
                x.getTenKM(),
                x.getApDungGiamGia(),
                x.getHinhThucApDung(),
                x.getGiaTri(),
                x.getGiamToiDa(),
                x.getNgayBatDau(),
                x.getNgayKetThuc(),
                x.getTrangThai() == 0 ? "Đang Chạy" : "Đã Kết Thúc"
            };
            dtmKM.addRow(rowdata);
        }
    }
    public void loadKMSP() {
        ArrayList<KhuyenMaiModel> list = kms.getKhuyenMaiSP();
        dtmKM.setRowCount(0);
        for (KhuyenMaiModel x : list) {
            Object[] rowdata = {
                x.getMaKM(),
                x.getTenKM(),
                x.getApDungGiamGia(),
                x.getHinhThucApDung(),
                x.getGiaTri(),
                x.getGiamToiDa(),
                x.getNgayBatDau(),
                x.getNgayKetThuc(),
                x.getTrangThai() == 0 ? "Đang Chạy" : "Đã Kết Thúc"
            };
            dtmKM.addRow(rowdata);
        }
    }

    public void LoadSP() {
        ArrayList<SanPhamModel> list = sps.getAllSanPham();
        dtmSP.setRowCount(0);
        for (int i = 0; i < list.size(); ++i) {
            dtmSP.addRow(new Object[]{
                false,
                list.get(i).getMaSP(),
                list.get(i).getTenSP(),});
        }
    }

    public void loadDanhMuc() {
        ArrayList<DanhMucModel> list = dms.getAllDanhMuc();
        dtmSP.setRowCount(0);
        for (int i = 0; i < list.size(); ++i) {
            dtmSP.addRow(new Object[]{
                false,
                list.get(i).getMaDM(),
                list.get(i).getTenDM(),});
        }
    }

//    public void loadALL(){
//        String loaigiamgia = rdoSanPham.isSelected()==true?"Sản Phẩm" :"Danh Mục";
//        if(loaigiamgia.equalsIgnoreCase("Sản Phẩm")){
//            LoadSP();
//        }else{
//            loadDanhMuc();
//        }
//    }
    public void lammoi() {
        txtMaKhuyenMai.setText("");
        txtTenKhuyenMai.setText("");
        txtBD.setDate(null);
        txtKetThuc.setDate(null);
        txtGiaTri.setText("");
        cbbHinhThucGiamGia.setSelectedIndex(0);
    }

    private KhuyenMaiModel getformdata() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String makm = txtMaKhuyenMai.getText().trim();
        String tenkm = txtTenKhuyenMai.getText().trim();
        String hinhthuc = cbbHinhThucGiamGia.getSelectedIndex() == 0 ? "Giảm theo%" : "Giảm Theo Tiền";
        String hinhthuckmai = rdoHoaDon.isSelected() == true ? "Hóa đơn" : "Sản Phẩm";
        String loaikmai = rdoDanhMuc.isSelected() == true ? "Danh mục" : "Sản phẩm";
        BigDecimal giatri = null;
        BigDecimal giamtoida = null;
        String ngayBD = txtBD.getDate().toString();
        String ngayKT = txtKetThuc.getDate().toString();
        Date NgayBatDau;
        Date NgayKetThuc;
        int trangthai = 0;
        if (makm.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã Khuyến Mại");
            return null;
        }
        if (tenkm.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên Khuyến Mại");
            return null;
        }
        if (txtGiaTri.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống giá trị");
            return null;
        } else {
            try {
                giatri = BigDecimal.valueOf(Double.parseDouble(txtGiaTri.getText()));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "sai định dạng giá trị");
                e.printStackTrace();
            }
        }

        if (txtGiamToiDa.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống giảm tối đa");
            return null;
        } else {
            try {
                giamtoida = BigDecimal.valueOf(Double.parseDouble(txtGiamToiDa.getText()));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "sai định dạng giảm tối đa");
                e.printStackTrace();
            }
        }

        if (ngayBD == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày bắt đầu");
            txtBD.requestFocus();
            return null;
        } else {

            NgayBatDau = txtBD.getDate();
        }
        if (ngayKT == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày kết thúc");
            txtKetThuc.requestFocus();
            return null;
        } else {

            NgayKetThuc = txtKetThuc.getDate();
        }

        int compare = NgayBatDau.compareTo(NgayKetThuc);

        if (compare > 0) {
            JOptionPane.showMessageDialog(this, "ngày kết thúc phải sau ngày bắt đầu");
            return null;
        } else if (compare == 0) {
            JOptionPane.showMessageDialog(this, "ngày kết thúc phải sau ngày bắt đầu");
            return null;
        } else {

            NgayBatDau = txtBD.getDate();
            NgayKetThuc = txtKetThuc.getDate();

        }
        Date currentDate = new Date();
        
        if (currentDate.before(NgayKetThuc)) {
            trangthai = 0;
        } else if (currentDate.after(NgayKetThuc)) {
            trangthai = 1;
        }
        KhuyenMaiModel km = new KhuyenMaiModel(makm, tenkm, giatri, giamtoida, NgayBatDau, NgayKetThuc, hinhthuc, hinhthuckmai, loaikmai, trangthai);
        return km;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        PanelaLL = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenKhuyenMai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbHinhThucGiamGia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        pnLoaiKhuyenMai = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        rdoSanPham = new javax.swing.JRadioButton();
        rdoDanhMuc = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rdoHoaDon = new javax.swing.JRadioButton();
        rdosanpham2 = new javax.swing.JRadioButton();
        pnSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtGiamToiDa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBD = new com.toedter.calendar.JDateChooser();
        txtKetThuc = new com.toedter.calendar.JDateChooser();
        cbbLocKM = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMOi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chương trình khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        PanelaLL.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        jLabel1.setText("Tạo mã khuyến mại");

        jLabel2.setText("Tạo chương trình khuyến mãi");

        jLabel3.setText("Hình thức giảm giá");

        cbbHinhThucGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm theo%", "Giảm Theo Tiền" }));
        cbbHinhThucGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHinhThucGiamGiaActionPerformed(evt);
            }
        });

        jLabel4.setText("Giá Trị");

        txtGiaTri.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiaTriCaretUpdate(evt);
            }
        });

        pnLoaiKhuyenMai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Loại Khuyễn Mại");

        buttonGroup1.add(rdoSanPham);
        rdoSanPham.setText("Sản Phẩm");
        rdoSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSanPhamMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoDanhMuc);
        rdoDanhMuc.setText("Danh Mục");
        rdoDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLoaiKhuyenMaiLayout = new javax.swing.GroupLayout(pnLoaiKhuyenMai);
        pnLoaiKhuyenMai.setLayout(pnLoaiKhuyenMaiLayout);
        pnLoaiKhuyenMaiLayout.setHorizontalGroup(
            pnLoaiKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoaiKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(rdoDanhMuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoSanPham)
                .addGap(61, 61, 61))
            .addGroup(pnLoaiKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnLoaiKhuyenMaiLayout.setVerticalGroup(
            pnLoaiKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoaiKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(16, 16, 16)
                .addGroup(pnLoaiKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoSanPham)
                    .addComponent(rdoDanhMuc))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Hình thức khuyến mại");

        buttonGroup2.add(rdoHoaDon);
        rdoHoaDon.setText("Hóa Đơn");
        rdoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoHoaDonMouseClicked(evt);
            }
        });
        rdoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHoaDonActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdosanpham2);
        rdosanpham2.setText("Sản Phẩm");
        rdosanpham2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdosanpham2MouseClicked(evt);
            }
        });
        rdosanpham2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdosanpham2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(rdoHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdosanpham2)
                        .addGap(65, 65, 65))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHoaDon)
                    .addComponent(rdosanpham2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnSanPham.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Mã ", "Tên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout pnSanPhamLayout = new javax.swing.GroupLayout(pnSanPham);
        pnSanPham.setLayout(pnSanPhamLayout);
        pnSanPhamLayout.setHorizontalGroup(
            pnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnSanPhamLayout.setVerticalGroup(
            pnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel10.setText("Giảm tối đa");

        txtGiamToiDa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamToiDaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout PanelaLLLayout = new javax.swing.GroupLayout(PanelaLL);
        PanelaLL.setLayout(PanelaLLLayout);
        PanelaLLLayout.setHorizontalGroup(
            PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelaLLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelaLLLayout.createSequentialGroup()
                        .addComponent(pnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PanelaLLLayout.createSequentialGroup()
                        .addGroup(PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelaLLLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelaLLLayout.createSequentialGroup()
                        .addGroup(PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelaLLLayout.createSequentialGroup()
                                .addComponent(cbbHinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGiamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelaLLLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnLoaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))))
        );
        PanelaLLLayout.setVerticalGroup(
            PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelaLLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelaLLLayout.createSequentialGroup()
                        .addGroup(PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelaLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbHinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnLoaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(232, 238, 238), null));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thời gian sử dụng");

        jLabel6.setText("Thời gian bắt đầu giảm giá");

        jLabel7.setText("Thời gian kết thúc giảm giá");

        txtBD.setDateFormatString("yyyy-MM-dd");

        txtKetThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(txtBD, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                            .addComponent(txtKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        cbbLocKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Hóa Đơn", "Sản Phẩm" }));
        cbbLocKM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLocKMItemStateChanged(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMOi.setText("Làm mới");
        btnLamMOi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMOiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelaLL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnLamMOi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbLocKM, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLamMOi, btnLuu, btnSua});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLamMOi)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbLocKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelaLL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLamMOi, btnLuu, btnSua});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khuyến mại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mại", "Tên chương trình", "Áp dụng", "Hình thức giảm giá", "Giá Trị", "Giảm tối đa", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhuyenMai);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1105, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách khuyến mại", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm khuyến mại", jPanel5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbHinhThucGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHinhThucGiamGiaActionPerformed
       if (cbbHinhThucGiamGia.getSelectedIndex()==1){
           txtGiamToiDa.setEditable(false);
       } else txtGiamToiDa.setEditable(true);
    }//GEN-LAST:event_cbbHinhThucGiamGiaActionPerformed
    private DanhMuc getdanhmuc(String id) {
        ArrayList<DanhMuc> dm = dmr.getAllDanhMuc();
//    DanhMuc dm = dmr.getAllDanhMuc();
        for (DanhMuc danhMuc : dm) {
            if (danhMuc.getIdDM().equals(id)) {
                return danhMuc;
            }

        }
        return null;

    }

    private KhuyenMai getkhuyenmai(String id) {
        ArrayList<KhuyenMai> km = kmr.getAllKM();

        for (KhuyenMai khuyenMai : km) {
            if (khuyenMai.getIdKM().equals(id)) {
                return khuyenMai;
            }

        }
        return null;

    }
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        ArrayList<SanPhamModel> listsp = sps.getAllSanPham();
        ArrayList<KhuyenMaiModel> listKM = kms.getAllKhuyenMai();
        ArrayList<DanhMucModel> danhmucsp = dms.getAllDanhMuc();
        ArrayList<ChiTietSanPhamModel> listctsp = ctsps.getAllChiTietSanPham();
        DanhMucModel dmm = new DanhMucModel();
        SanPhamModel spm = new SanPhamModel();
        ChiTietSanPhamModel ctspm = new ChiTietSanPhamModel();
        int demHD = 0;
        if (rdoHoaDon.isSelected()){
            demHD = 1;
        }
        // Thêm khuyến mại
        KhuyenMaiModel km = getformdata();
        if(km.getNgayKetThuc().before(new Date())){
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày hiện tại");
            return;
        }
        if (kms.insertKM(km) != null) {
            loadTableKM();
        }
        KhuyenMai k = new KhuyenMai();
        
        // set IDKM vào CTSP
        ctspm.setIdKM(getkhuyenmai(kms.getIDByMa(km.getMaKM()).get(0).getIdKM()));
        int dem = 0;
        // Danh mục được chọn
        if (rdoDanhMuc.isSelected() == true) {
            // tìm những checkbox được check
            for (int i = 0; i < danhmucsp.size(); i++) {
                boolean check = (boolean) tblSanPham.getValueAt(i, 0);
                if (check == true) {
                    dmm = danhmucsp.get(i);
                    ArrayList<ChiTietSanPhamModel> listID = new ArrayList<>();
                    for (ChiTietSanPhamModel c : listctsp) {
                        if (c.getIdDM().getIdDM() != null && c.getIdDM().getIdDM().equals(dmm.getIdDM())) {
                            listID.add(c);
                        }
                    }
                    // thêm chương trình vào từng IDCTSP
                    for (ChiTietSanPhamModel ct : listID) {
                        
                        ctspm.setIdCTSP(ct.getIdCTSP());
                        
                        if (ctsps.updateByID1(ctspm) != null) {
                            dem++;
                        }
                    }
                }
            }
        }
        // Lấy ra IDCTSP có trong danh mục
        if (rdoSanPham.isSelected() == true) {
            //tìm những checkbox được check
            for (int i = 0; i < listsp.size(); i++) {
                boolean check = (boolean) tblSanPham.getValueAt(i, 0);
                if (check == true) {
                    spm = listsp.get(i);
                    ArrayList<ChiTietSanPhamModel> listID = new ArrayList<>();
                    for (ChiTietSanPhamModel ctm : listctsp) {
                        if (ctm.getIdSP().getIdSP() != null && ctm.getIdSP().getIdSP().equals(spm.getIdSP())) {
                            listID.add(ctm);
                        }
                    }
                    for (ChiTietSanPhamModel ct : listID) {
                        ctspm.setIdCTSP(ct.getIdCTSP());
                        
                        if (ctsps.updateByID1(ctspm) != null) {
                            dem++;
                        }
                    }
                }

            }
        }

        if (dem > 0 || demHD > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            LoadSP();

        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");

        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnLamMOiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMOiActionPerformed
        lammoi();
    }//GEN-LAST:event_btnLamMOiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        ArrayList<SanPhamModel> listsp = sps.getAllSanPham();
        ArrayList<KhuyenMaiModel> listKM = kms.getAllKhuyenMai();
        ArrayList<DanhMucModel> danhmucsp = dms.getAllDanhMuc();
        ArrayList<ChiTietSanPhamModel> listctsp = ctsps.getAllChiTietSanPham();
        DanhMucModel dmm = new DanhMucModel();
        SanPhamModel spm = new SanPhamModel();
        ChiTietSanPhamModel ctspm = new ChiTietSanPhamModel();
        int row = tblKhuyenMai.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        KhuyenMaiModel km = getformdata();
        if (km == null) {
            return;
        }
        String ma = txtMaKhuyenMai.getText().trim();
        km.setMaKM(ma);
        KhuyenMai k = new KhuyenMai();

        // set IDKM vào CTSP
        ctspm.setIdKM(getkhuyenmai(kms.getIDByMa(km.getMaKM()).get(0).getIdKM()));
        int dem = 0;
        // Danh mục được chọn
        if (rdoDanhMuc.isSelected() == true) {
            // tìm những checkbox được check
            for (int i = 0; i < danhmucsp.size(); i++) {
                boolean check = (boolean) tblSanPham.getValueAt(i, 0);
                if (check == true) {
                    dmm = danhmucsp.get(i);
                    ArrayList<ChiTietSanPhamModel> listID = new ArrayList<>();
                    for (ChiTietSanPhamModel c : listctsp) {
                        if (c.getIdDM().getIdDM() != null && c.getIdDM().getIdDM().equals(dmm.getIdDM())) {
                            listID.add(c);
                        }
                    }
                    // thêm chương trình vào từng IDCTSP
                    for (ChiTietSanPhamModel ct : listID) {

                        if (ctsps.updateByID1(ctspm) != null) {
                            dem++;
                        }
                    }
                }
            }
        }
        // Lấy ra IDCTSP có trong danh mục
        if (rdoSanPham.isSelected() == true) {
            //tìm những checkbox được check
            for (int i = 0; i < listsp.size(); i++) {
                boolean check = (boolean) tblSanPham.getValueAt(i, 0);
                if (check == true) {
                    spm = listsp.get(i);
                    ArrayList<ChiTietSanPhamModel> listID = new ArrayList<>();
                    for (ChiTietSanPhamModel ctm : listctsp) {
                        if (ctm.getIdSP().getIdSP() != null && ctm.getIdSP().getIdSP().equals(spm.getIdSP())) {
                            listID.add(ctm);
                        }
                    }
                    for (ChiTietSanPhamModel ct : listID) {
                        ctspm.setIdCTSP(ct.getIdCTSP());
                        if (ctsps.updateByID1(ctspm) != null) {
                            dem++;
                        }
                    }
                }

            }
        }

        if (kms.updateKM(km) != null) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
        loadTableKM();
        lammoi();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int row = tblKhuyenMai.getSelectedRow();
        if (row < 0) {

            return;
        }
        txtMaKhuyenMai.setText(tblKhuyenMai.getValueAt(row, 0).toString());
        txtTenKhuyenMai.setText(tblKhuyenMai.getValueAt(row, 1).toString());

        try {
            String ngaybd = tblKhuyenMai.getValueAt(row, 6).toString();
            String ngaykt = tblKhuyenMai.getValueAt(row, 7).toString();

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngaybd);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ngaykt);
            txtBD.setDate(date);
            txtKetThuc.setDate(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtGiaTri.setText(tblKhuyenMai.getValueAt(row, 4).toString());
        txtGiamToiDa.setText(tblKhuyenMai.getValueAt(row, 5).toString());
        cbbHinhThucGiamGia.setSelectedItem(tblKhuyenMai.getValueAt(row, 3).toString());
        ArrayList<KhuyenMaiModel> k = kms.getAllKhuyenMai();
        String apDung = "";
        String loai = "";
        String idKM = "";
        for (KhuyenMaiModel x : k) {
            if (x.getMaKM() != null && x.getMaKM().equals(tblKhuyenMai.getValueAt(row, 0).toString())) {
                apDung = x.getApDungGiamGia();
                loai = x.getLoaiGiamGia();
                idKM = x.getIdKM();

            }
        }
        if (apDung.equals(rdoHoaDon.getText())) {
            rdoHoaDon.setSelected(true);
            pnSanPham.setVisible(false);
            pnLoaiKhuyenMai.setVisible(false);
        } else if (apDung.equals(rdosanpham2.getText())) {
            rdosanpham2.setSelected(true);
            pnSanPham.setVisible(true);
            pnLoaiKhuyenMai.setVisible(true);
        }
        if (loai.equalsIgnoreCase(rdoDanhMuc.getText())) {
            rdoDanhMuc.setSelected(true);
            ArrayList<ChiTietSanPhamModel> listCTSP = ctsps.getAllChiTietSanPham();
            ArrayList<ChiTietSanPhamModel> listCTSPNew = new ArrayList<>();
            for (ChiTietSanPhamModel ct : listCTSP) {
                if (ct.getIdKM()!=null &&  ct.getIdKM().getIdKM().equals(idKM)) {
                    listCTSPNew.add(ct);
                }
            }

            ArrayList<DanhMucModel> list = dms.getAllDanhMuc();
            dtmSP.setRowCount(0);
            boolean check = false;
            for (int i = 0; i < list.size(); ++i) {
                for (ChiTietSanPhamModel cts : listCTSPNew) {
                    if (cts.getIdDM().getIdDM().equals(list.get(i).getIdDM())) {
                        check = true;
                    } else {
                        check = false;
                    }
                }
                dtmSP.addRow(new Object[]{
                    check,
                    list.get(i).getMaDM(),
                    list.get(i).getTenDM()
                });
           
            }

        } else if (loai.equalsIgnoreCase(rdoSanPham.getText())) {
            rdoSanPham.setSelected(true);
            ArrayList<ChiTietSanPhamModel> listCTSP = ctsps.getAllChiTietSanPham();
            ArrayList<ChiTietSanPhamModel> listCTSPNew = new ArrayList<>();
            for (ChiTietSanPhamModel ct : listCTSP) {
                if (ct.getIdKM()!=null && ct.getIdKM().getIdKM().equals(idKM)) {
                    listCTSPNew.add(ct);
                }
            }
            ArrayList<SanPhamModel> list = sps.getAllSanPham();
            boolean check = false;
            dtmSP.setRowCount(0);
            for (int i = 0; i < list.size(); ++i) {
                for (int z = 0; z < listCTSPNew.size(); ++z) {
                    if (listCTSPNew.get(z).getIdSP().getMaSP().equals(list.get(i).getMaSP())) {
                       
                        check = true;
                    } else {
                        check = false;
                    }
                }
                dtmSP.addRow(new Object[]{
                    check,
                    list.get(i).getMaSP(),
                    list.get(i).getTenSP(),});
              

            }
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void rdoDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDanhMucActionPerformed
        loadDanhMuc();
    }//GEN-LAST:event_rdoDanhMucActionPerformed

    private void rdosanpham2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdosanpham2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdosanpham2ActionPerformed

    private void rdoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoHoaDonMouseClicked
        pnSanPham.setVisible(false);
        pnLoaiKhuyenMai.setVisible(false);
    }//GEN-LAST:event_rdoHoaDonMouseClicked

    private void rdosanpham2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdosanpham2MouseClicked
        pnSanPham.setVisible(true);
        pnLoaiKhuyenMai.setVisible(true);
    }//GEN-LAST:event_rdosanpham2MouseClicked

    private void rdoSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSanPhamMouseClicked
        LoadSP();
    }//GEN-LAST:event_rdoSanPhamMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
//           int row = tblSanPham.getSelectedRow();
//        if (row < 0) {
//          
//            return;
//        }


    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void rdoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoHoaDonActionPerformed

    private void txtGiamToiDaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamToiDaCaretUpdate

    }//GEN-LAST:event_txtGiamToiDaCaretUpdate

    private void txtGiaTriCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiaTriCaretUpdate
       if (cbbHinhThucGiamGia.getSelectedIndex()==1){
           txtGiamToiDa.setText(txtGiaTri.getText());
       }       
    }//GEN-LAST:event_txtGiaTriCaretUpdate

    private void cbbLocKMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLocKMItemStateChanged
        if(cbbLocKM.getSelectedIndex()==0){
            loadTableKM();
        }else if(cbbLocKM.getSelectedIndex()==1){
            loadKMHD();
        }else{
            loadKMSP();
        }
    }//GEN-LAST:event_cbbLocKMItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelaLL;
    private javax.swing.JButton btnLamMOi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbHinhThucGiamGia;
    private javax.swing.JComboBox<String> cbbLocKM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnLoaiKhuyenMai;
    private javax.swing.JPanel pnSanPham;
    private javax.swing.JRadioButton rdoDanhMuc;
    private javax.swing.JRadioButton rdoHoaDon;
    private javax.swing.JRadioButton rdoSanPham;
    private javax.swing.JRadioButton rdosanpham2;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblSanPham;
    private com.toedter.calendar.JDateChooser txtBD;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtGiamToiDa;
    private com.toedter.calendar.JDateChooser txtKetThuc;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtTenKhuyenMai;
    // End of variables declaration//GEN-END:variables
}
