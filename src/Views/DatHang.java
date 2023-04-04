/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Views;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import Services.GiaoHangService;
import ViewModels.GiaoCaModel;
import ViewModels.GiaoHangModel;
import ViewModels.HoaDonViewModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import responsitories.HoaDonResponsitory;
import responsitories.HoaDonresbonsitory;
import responsitories.KhachHangResponsitory;

/**
 *
 * @author Phanh
 */
public class DatHang extends javax.swing.JDialog {
private  HoaDonResponsitory hdr = new HoaDonResponsitory();
private KhachHangResponsitory khr=new KhachHangResponsitory();
private  GiaoHangService ghs = new GiaoHangService();
    /**
     * Creates new form DatHang
     */
    JPanel banHang;
    HoaDon hd;
    public DatHang(JPanel banHang, HoaDon hd) {
         this.banHang = banHang;
        this.hd = hd;
        initComponents();
        txtTenKhachHang.setText(hd.getIdKH().getTenKH());
        txtSDT.setText(hd.getIdKH().getSdt());
        txtDiaChi.setText(hd.getIdKH().getDiaChi());
        txtPoint.setText(hd.getIdKH().getDiemEXP()+"");
        
        txtTienHang.setText(hd.getThanhTien().toString());
        
    }
    public GiaoHangModel getformData(){
        String ten= txtTenKhachHang.getText().trim();
        String sdt= txtSDT.getText().trim();
        String  diachi= txtDiaChi.getText().trim();
        String tienhang= txtTienHang.getText().trim();
        String tienship= txtTienShip.getText().trim();
        String tongtien=txtTongTien.getText().trim();
        String giam=txtGiamGia.getText().trim();
        String ghichu=txtGhiChu.getText();
        BigDecimal tHang=null;
        BigDecimal tShip=null;
        BigDecimal tTongTien=null;
        if(ten.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
            txtTenKhachHang.requestFocus();
            return null;
        }
        if(sdt.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống sdt");
            txtSDT.requestFocus();
            return null;
        }
        if(ten.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
            txtTenKhachHang.requestFocus();
            return null;
        }
        if(diachi.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để trống diachi");
            txtDiaChi.requestFocus();
            return null;
        }
        if(tienhang.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để tiền hàng");
            txtTienHang.requestFocus();
            return null;
        }else{
            tHang=BigDecimal.valueOf(Float.valueOf(tienhang));
        }
        if(tienship.length()==0){
            JOptionPane.showMessageDialog(this, "Không được để tiền ship");
            txtTienShip.requestFocus();
            return null;
        }else{
            tShip=BigDecimal.valueOf(Float.valueOf(tienship));
        }
        tTongTien=BigDecimal.valueOf(Float.valueOf(tongtien));
        ArrayList<HoaDonViewModel> list = hdr.getAllhoadon();
        
        HoaDon hoaDon=new HoaDon();
        for (HoaDonViewModel h : list) {
            if(h.getMaHD().equals(hd.getMaHD())){
                hoaDon=hdr.gethdByID(h.getIdHD());
            }
        }
        KhachHang kh=hd.getIdKH();
        return new GiaoHangModel(null, hd, kh, sdt, diachi, tHang, tShip, tTongTien, null, null, null, null, 0,ghichu);
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
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTienHang = new javax.swing.JTextField();
        txtTienShip = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btnSuDung = new javax.swing.JButton();
        txtPoint = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btnAPDung = new javax.swing.JButton();
        txtVoucher = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnGiaoHang = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 15, 15, 15, new java.awt.Color(0, 153, 153)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("XÁC NHẬN ĐƠN HÀNG");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(536, 100));
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel7.setLayout(new java.awt.GridLayout(0, 1, 10, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tên Khách Hàng:");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Số điện thoại:");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Địa chỉ:");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tiền hàng:");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tiền ship:");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tổng tiền:");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel7);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Giảm giá:");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel9.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel7.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Point:");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel10.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel7.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Voucher:");
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel11.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel7.add(jLabel11);

        jPanel2.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 10, 0, new java.awt.Color(0, 153, 153)));
        jPanel8.setPreferredSize(new java.awt.Dimension(100, 120));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Ghi chú:");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel8.setPreferredSize(new java.awt.Dimension(200, 16));
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel8.add(jLabel8, java.awt.BorderLayout.LINE_START);

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));
        jPanel9.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        txtTenKhachHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtTenKhachHang);

        txtSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtSDT);

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtDiaChi);

        txtTienHang.setEditable(false);
        txtTienHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTienHang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienHangCaretUpdate(evt);
            }
        });
        jPanel9.add(txtTienHang);

        txtTienShip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTienShip.setText("0");
        txtTienShip.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienShipCaretUpdate(evt);
            }
        });
        jPanel9.add(txtTienShip);

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTongTien.setEnabled(false);
        jPanel9.add(txtTongTien);

        txtGiamGia.setEditable(false);
        txtGiamGia.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtGiamGia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGiamGia.setText("0");
        txtGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(240, 240, 240)));
        txtGiamGia.setEnabled(false);
        txtGiamGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamGiaCaretUpdate(evt);
            }
        });
        jPanel9.add(txtGiamGia);

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setLayout(new java.awt.BorderLayout());

        btnSuDung.setBackground(new java.awt.Color(255, 102, 51));
        btnSuDung.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSuDung.setForeground(new java.awt.Color(255, 255, 255));
        btnSuDung.setText("Sử Dụng");
        btnSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungActionPerformed(evt);
            }
        });
        jPanel13.add(btnSuDung, java.awt.BorderLayout.LINE_END);

        txtPoint.setEditable(false);
        txtPoint.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel13.add(txtPoint, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setLayout(new java.awt.BorderLayout());

        btnAPDung.setBackground(new java.awt.Color(255, 102, 51));
        btnAPDung.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAPDung.setForeground(new java.awt.Color(255, 255, 255));
        btnAPDung.setText("Áp Dụng");
        btnAPDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPDungActionPerformed(evt);
            }
        });
        jPanel14.add(btnAPDung, java.awt.BorderLayout.LINE_END);

        txtVoucher.setEditable(false);
        txtVoucher.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel14.add(txtVoucher, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel14);

        jPanel2.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 153, 153)));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new java.awt.BorderLayout());

        btnHuy.setBackground(new java.awt.Color(255, 51, 51));
        btnHuy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 0));
        btnHuy.setText("Hủy");
        btnHuy.setPreferredSize(new java.awt.Dimension(79, 25));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel4.add(btnHuy, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnGiaoHang.setBackground(new java.awt.Color(102, 255, 102));
        btnGiaoHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGiaoHang.setText("Giao Hàng");
        btnGiaoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoHangActionPerformed(evt);
            }
        });
        jPanel5.add(btnGiaoHang);

        jPanel3.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungActionPerformed
        float diem = Float.valueOf(txtPoint.getText());
        txtGiamGia.setText(String.valueOf( Float.valueOf(txtPoint.getText()) + Float.valueOf(txtGiamGia.getText())) );
        System.out.println(String.valueOf(diem + Float.valueOf(txtGiamGia.getText())));
        txtPoint.setText("0");
        
    }//GEN-LAST:event_btnSuDungActionPerformed

    private void btnAPDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPDungActionPerformed
       
    }//GEN-LAST:event_btnAPDungActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnGiaoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoHangActionPerformed
        GiaoHangModel gc = getformData();
        if(gc==null){
            return;
        }
        
        if(ghs.insertGH(gc)!= null){
            JOptionPane.showMessageDialog(this, "Đặt hàng thành công");
         this.setVisible(false);
        }
    }//GEN-LAST:event_btnGiaoHangActionPerformed

    private void txtTienHangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienHangCaretUpdate
        try {
             txtTongTien.setText(String.valueOf(Float.valueOf(txtTienHang.getText())+Float.valueOf(txtTienShip.getText())));
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_txtTienHangCaretUpdate

    private void txtTienShipCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienShipCaretUpdate
txtTongTien.setText(String.valueOf(Float.valueOf(txtTienHang.getText())+Float.valueOf(txtTienShip.getText())));
            
    }//GEN-LAST:event_txtTienShipCaretUpdate

    private void txtGiamGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamGiaCaretUpdate
        
            float giamGia = Float.valueOf(txtGiamGia.getText());
            float tongTien = Float.valueOf(txtTienHang.getText())+Float.valueOf(txtTienShip.getText());
            String sauGiam = String.valueOf(tongTien - giamGia);
            txtTongTien.setText(sauGiam);
        
    }//GEN-LAST:event_txtGiamGiaCaretUpdate

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
            java.util.logging.Logger.getLogger(DatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DatHang dialog = new DatHang();
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAPDung;
    private javax.swing.JButton btnGiaoHang;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSuDung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtPoint;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienHang;
    private javax.swing.JTextField txtTienShip;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtVoucher;
    // End of variables declaration//GEN-END:variables
}
