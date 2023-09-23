/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.KhachHang;
import Services.KhachHangService;
import Services.hoadonservice;
import ViewModels.HoaDonViewModel;
import ViewModels.KhachHangModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import responsitories.KhachHangResponsitory;

/**
 *
 * @author duong
 */
public class KhachHang_BanHang extends javax.swing.JFrame {

    private KhachHangService khs = new KhachHangService();
    private KhachHangResponsitory khr=new KhachHangResponsitory();
    public static KhachHang khach;
    private  hoadonservice hds=new hoadonservice();
    DefaultTableModel dtm = new DefaultTableModel();
    BanHangPanel banHangfr;
    JTable tblGioHang;
    JTable tblHoaDon;
    
    /**
     * Creates new form KhachHang_BanHang
     */
    public KhachHang_BanHang(BanHangPanel banHangfr,JTable tblGioHang, JTable tblHoaDon) {
        initComponents();
        setLocationRelativeTo(this);
        this.tblGioHang = tblGioHang;
        this.tblHoaDon = tblHoaDon;
        this.banHangfr=banHangfr;
        
        dtm = (DefaultTableModel) tblBang.getModel();
        loadTable();
    }

    public void loadTable() {
        ArrayList<KhachHangModel> list = khs.getAllKhachHang();
        dtm.setRowCount(0);
        Collections.sort(list, Comparator.comparing(KhachHang -> KhachHang.getMaKH()));
        for (KhachHangModel kh : list) {
            dtm.addRow(new Object[]{
                kh.getMaKH(),
                kh.getTenKH(),
                kh.getLoaiKH(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getTichDiem(),
                kh.getDiemEXP(),
                kh.getNgayThamGia(),
                kh.getTrangThai() == 1 ? "Còn hoạt động" : "Không hoạt động"
            
            });

        }
    }

public void loadTableTim(String sdt) {
        ArrayList<KhachHangModel> list = khs.getKhachHangBysdt(sdt);
        dtm.setRowCount(0);
            Collections.sort(list, Comparator.comparing(KhachHang -> KhachHang.getMaKH()));
        for (KhachHangModel kh : list) {
            dtm.addRow(new Object[]{
                kh.getMaKH(),
                kh.getTenKH(),
                kh.getLoaiKH(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getEmail(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getNgayThamGia(),
                kh.getTrangThai() == 1 ? "Còn hoạt động" : "Không hoạt động"
            });

        }
    }

    public void clearForm() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtKHSdt.setText("");
        txtDiaChiKH.setText("");
        txtKHEmail.setText("");
        txtKHNgaySinh.setDate(null);
        rdoKHNam.setSelected(true);
        rdoKHCon.setSelected(true);
    }

    public KhachHangModel getFormData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        ArrayList<KhachHangModel> listKH=khs.getAllKhachHang();
        String ma = "KH"+(listKH.size()+1);
        String ten = txtTenKH.getText();
        String diaChi = txtDiaChiKH.getText();
        String gt = rdoKHNam.isSelected() == true ? "Nam" : "Nữ";
        String email = txtKHEmail.getText();
        String sdt = txtKHSdt.getText();
        String nSinh = txtKHNgaySinh.getDate().toString();

        int tt = rdoKHCon.isSelected() == true ? 1 : 0;

        if (ten.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Tên không được trống");
            txtTenKH.requestFocus();
            return null;
        }
        
        if (diaChi.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được trống");
            txtDiaChiKH.requestFocus();
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

        KhachHangModel khm = new KhachHangModel(ma, null, ten, diaChi, gt, email, sdt, date, null, tt);

        return khm;
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
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimSDT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtKHEmail = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiaChiKH = new javax.swing.JTextArea();
        rdoKHNam = new javax.swing.JRadioButton();
        rdoKHNu = new javax.swing.JRadioButton();
        txtMaKH = new javax.swing.JTextField();
        txtKHSdt = new javax.swing.JTextField();
        txtKHNgaySinh = new com.toedter.calendar.JDateChooser();
        rdoKHNgung = new javax.swing.JRadioButton();
        rdoKHCon = new javax.swing.JRadioButton();
        btnThemKH = new javax.swing.JButton();
        btnSuaKH = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tìm kiếm ");

        txtTimSDT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimSDTCaretUpdate(evt);
            }
        });

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Loại KH", "Địa chỉ", "Giới tính", "Email", "SDT", "Ngày sinh", "Tích điểm", "Điểm EXP", "Ngày tham gia", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBang.setSelectionBackground(new java.awt.Color(102, 255, 102));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(txtTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Danh sách khách hàng", jPanel1);

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel5.setText("Địa chỉ");

        jLabel10.setText("Trạng thái");

        jLabel8.setText("Ngày sinh");

        jLabel7.setText("SDT");

        jLabel16.setText("Email");

        jLabel17.setText("Giới tính");

        txtDiaChiKH.setColumns(20);
        txtDiaChiKH.setRows(5);
        jScrollPane3.setViewportView(txtDiaChiKH);

        rdoKHNam.setText("Nam");

        rdoKHNu.setText("Nữ");

        txtMaKH.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaKH.setEnabled(false);

        txtKHNgaySinh.setDateFormatString("yyyy-MM-dd");

        rdoKHNgung.setText("Ngừng hoạt động");

        rdoKHCon.setText("Còn hoạt động");

        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnSuaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconUpload.png"))); // NOI18N
        btnSuaKH.setText("Sửa");
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cleaning.png"))); // NOI18N
        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKH)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtMaKH))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnThemKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(btnSuaKH)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoKHNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoKHNu))
                            .addComponent(txtKHEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtKHNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(txtKHSdt, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoKHCon)
                                .addGap(18, 18, 18)
                                .addComponent(rdoKHNgung))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnClear)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(404, 404, 404)
                    .addComponent(jLabel17)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClear, btnSuaKH, btnThemKH});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoKHNam)
                    .addComponent(rdoKHNu)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKHEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKHSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(txtKHNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rdoKHCon)
                            .addComponent(rdoKHNgung)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3))
                .addGap(79, 79, 79)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKH)
                    .addComponent(btnSuaKH)
                    .addComponent(btnClear))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel17)
                    .addContainerGap(404, Short.MAX_VALUE)))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClear, btnSuaKH, btnThemKH});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Câp nhật thông tin khách hàng", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimSDTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimSDTCaretUpdate
        String sdt = txtTimSDT.getText().trim();

        if (khs.getKhachHangBysdt(sdt).size()>0) {

        } else {
            JOptionPane.showMessageDialog(this, "tìm thất bại");
        }
        loadTableTim(sdt);


    }//GEN-LAST:event_txtTimSDTCaretUpdate

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        int row = tblBang.getSelectedRow();
        if (row < 0) {
            return;
        }
        String makh = tblBang.getValueAt(row, 0).toString();
        String idKH="";
        ArrayList<KhachHang> listKH = khr.getAllKhachHang();
        for (KhachHang x : listKH) {
            if (x.getMaKH() != null && x.getMaKH().equals(makh)) {
                khach=x;
            }
        }
        int indexHD=tblHoaDon.getSelectedRow();
        String maHD=tblHoaDon.getValueAt(indexHD, 0).toString();
        
        HoaDonViewModel hd=new HoaDonViewModel();
        if (JOptionPane.showConfirmDialog(this, "Ban co muon them khach hang khong?", "Thong Bao", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        hd.setIdKH(khach);
        hd.setMaHD(maHD);
        banHangfr.hoadon.setIdKH(khach);
        if (hds.updateHoaDon(hd) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhập thông tin hóa đơn thành công");
            banHangfr.loadChonKH(khach.getTenKH(), khach.getSdt());
            banHangfr.loadHDCho();
        }
        this.dispose();
    }//GEN-LAST:event_tblBangMouseClicked
     public KhachHangModel getMa(String ma) {
        for (KhachHangModel kh : khs.getAllKhachHang()) {
            if (kh.getMaKH().equalsIgnoreCase(ma)) {
                return kh;
            }
        }
        return null;
    }
    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        KhachHangModel khm = getFormData();
        if (khm == null) {
            return;
        }
        if (getMa(khm.getMaKH()) != null) {
            JOptionPane.showMessageDialog(this, "Đã có mã này");
            return;
        }
        if (khs.insertKhachHang(khm) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKHActionPerformed
            String ma=txtMaKH.getText().trim();
            if(ma.length()==0){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng cần sửa");
                return;
            }
            KhachHangModel khm=getMa(ma);
            if(khm==null){
                JOptionPane.showMessageDialog(this, "Không có mã khách hàng này");
                return;
            }
            KhachHangModel k=getFormData();
            if(khs.updateKhachHang(k)!=null){
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loadTable();
            }else{
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
                clearForm();
            }
    }//GEN-LAST:event_btnSuaKHActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(KhachHang_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KhachHang_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KhachHang_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KhachHang_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new KhachHang_BanHang().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JButton btnThemKH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JRadioButton rdoKHCon;
    private javax.swing.JRadioButton rdoKHNam;
    private javax.swing.JRadioButton rdoKHNgung;
    private javax.swing.JRadioButton rdoKHNu;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JTextField txtKHEmail;
    private com.toedter.calendar.JDateChooser txtKHNgaySinh;
    private javax.swing.JTextField txtKHSdt;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimSDT;
    // End of variables declaration//GEN-END:variables

}
