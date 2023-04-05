/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Services.ChiTietSanPhamService;
import Services.HoaDonChiTieservice;
import Services.KhachHangService;
import Services.KhuyenMaiService;
import Services.hoadonservice;
import Utilities.DBConnection;
import ViewModels.ChiTietSanPhamModel;
import ViewModels.HoaDonViewModel;
import ViewModels.KhachHangModel;
import ViewModels.KhuyenMaiModel;
import ViewModels.hoadonchitietviewmodel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Asus
 */
public class ThanhToanHoaDonJFrame extends javax.swing.JFrame {

    HoaDonChiTieservice hoaDonChiTieservice = new HoaDonChiTieservice();
    ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    KhachHangService khachHangService = new KhachHangService();
    hoadonservice hoaDonService = new hoadonservice();
    KhuyenMaiService kms = new KhuyenMaiService();
    JPanel banHang;
    HoaDon hd;

    /**
     * Creates new form ThanhToanHoaDonJFrame
     */
    public ThanhToanHoaDonJFrame(JPanel banHang, HoaDon hd) {
        initComponents();
        lblTongtien.setText(hd.getThanhTien().toString());
        this.banHang = banHang;
        this.hd = hd;
        txtDiem.setText(""+hd.getIdKH().getDiemEXP());
        voucher();

    }

    private BigDecimal thanhTien(String loai, BigDecimal giaTri, BigDecimal giaTriMax, BigDecimal donGia) {
        BigDecimal thanhTien_KM = null;
        float gia = 0;
        if (loai.equalsIgnoreCase("giảm theo%")) {
            if ((Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString())) > Float.valueOf(giaTriMax.toString())) {
                gia = Float.valueOf(donGia.toString()) - Float.valueOf(giaTriMax.toString());
                System.out.println("Giảm theo giá trị max");
            } else {
                gia = Float.valueOf(donGia.toString()) - (Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString()));
                System.out.println("Giảm theo giá trị %");
            }
        } else {
            if (Float.valueOf(donGia.toString()) < Float.valueOf(donGia.toString()) - Float.valueOf(giaTri.toString())) {
                gia = 0;
            } else {
                gia = Float.valueOf(donGia.toString()) - Float.valueOf(giaTri.toString());
                System.out.println("Giảm theo giá trị tiền mặt");
            }
        }
        System.out.println(Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString()));
        thanhTien_KM = BigDecimal.valueOf(gia);
        return thanhTien_KM;
    }

    

    private void voucher() {
        if (hd.getIdKM() != null) {
            txtVoucher.setText(hd.getIdKM().getMaKM());
        }
    }

    private KhuyenMaiModel getKhuyenMai(String ma) {
        ArrayList<KhuyenMaiModel> list = kms.getKhuyenMaiAD();
        for (KhuyenMaiModel km : list) {
            if (km.getMaKM().equals(ma)) {
                return km;
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTongtien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGiam = new javax.swing.JTextField();
        txtVoucher = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        txtTienKH = new javax.swing.JTextField();
        txtTienThoi = new javax.swing.JTextField();
        btnApDung = new javax.swing.JButton();
        btnSuDung = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnThanhToanVaIn = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnHuyVoucher = new javax.swing.JButton();
        btnHuyPoint = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbbHinhThucThanhToan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THANH TOÁN HÓA ĐƠN");

        lblTongtien.setFont(new java.awt.Font("Segoe UI", 0, 70)); // NOI18N
        lblTongtien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongtien.setText("200000");

        jLabel3.setText("Giảm Giá");

        jLabel4.setText("Voucher");

        jLabel5.setText("Point");

        jLabel6.setText("Tiền Khách Trả");

        jLabel7.setText("Trả Lại Khách");

        txtGiam.setText("0");
        txtGiam.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtGiam.setEnabled(false);
        txtGiam.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamCaretUpdate(evt);
            }
        });
        txtGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamActionPerformed(evt);
            }
        });

        txtVoucher.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtVoucher.setEnabled(false);
        txtVoucher.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtVoucherCaretUpdate(evt);
            }
        });
        txtVoucher.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtVoucherInputMethodTextChanged(evt);
            }
        });
        txtVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVoucherActionPerformed(evt);
            }
        });

        txtDiem.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtDiem.setEnabled(false);
        txtDiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDiemCaretUpdate(evt);
            }
        });

        txtTienKH.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKHCaretUpdate(evt);
            }
        });

        txtTienThoi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienThoiCaretUpdate(evt);
            }
        });

        btnApDung.setText("Áp Dụng");
        btnApDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApDungActionPerformed(evt);
            }
        });

        btnSuDung.setText("Sử Dụng");
        btnSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnThanhToanVaIn.setText("Thanh Toán + In");
        btnThanhToanVaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanVaInActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnHuyVoucher.setText("Hủy");
        btnHuyVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyVoucherActionPerformed(evt);
            }
        });

        btnHuyPoint.setText("Hủy");
        btnHuyPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPointActionPerformed(evt);
            }
        });

        jLabel8.setText("Hình thức thanh toán");

        cbbHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Thẻ" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnThanhToan)
                .addGap(149, 149, 149)
                .addComponent(btnThanhToanVaIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtVoucher)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnApDung)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnHuyVoucher))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSuDung)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnHuyPoint))))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienThoi, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienKH, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(57, 57, 57))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnApDung, btnHuyPoint, btnHuyVoucher, btnSuDung});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApDung)
                    .addComponent(btnHuyVoucher))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuDung)
                    .addComponent(btnHuyPoint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTienThoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan)
                    .addComponent(btnThanhToanVaIn)
                    .addComponent(btnHuy))
                .addGap(15, 15, 15))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnApDung, btnHuyPoint, btnHuyVoucher, btnSuDung});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamActionPerformed

    private void btnApDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApDungActionPerformed

        new Voucher(this, true).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnApDungActionPerformed

    private void txtVoucherInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtVoucherInputMethodTextChanged
//        txtVoucher.setText(Voucher.voucher);
    }//GEN-LAST:event_txtVoucherInputMethodTextChanged

    private void txtVoucherCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtVoucherCaretUpdate
//        System.out.println(Voucher.voucher);
//        txtVoucher.setText(Voucher.voucher);

        KhuyenMaiModel km = getKhuyenMai(hd.getIdKM().getMaKM());  // lấy khuyến mãi
        BigDecimal gia = hd.getThanhTien(); // tổng tiền
        double giamPoint = Double.valueOf(txtDiem.getText()); // giảm điểm
        if (km == null) {
            return;
        }
        System.out.println(hd.getThanhTien());
        BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hd.getThanhTien());
        double giamGia = hd.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();
        if (txtGiam.getText().equals("0") || txtGiam.getText() == null) {
            txtGiam.setText(String.valueOf(giamGia));
        } else {
            txtGiam.setText(String.valueOf(giamPoint + giamGia));
        }
        if (txtVoucher.getText().equals("0") || txtVoucher.getText() == null) {
            txtGiam.setText(String.valueOf(giamPoint));
        }
//        txtGiam.setText(String.valueOf(Integer.parseInt(lblTongtien.getText()) * Integer.parseInt(txtVoucher.getText()) / 100));
    }//GEN-LAST:event_txtVoucherCaretUpdate

    private void btnSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungActionPerformed
        double giamGia = 0;
        double giamPoint = 0;
        if (hd.getIdKM() != null) {
            KhuyenMaiModel km = getKhuyenMai(hd.getIdKM().getMaKM());  // lấy khuyến mãi            
            BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hd.getThanhTien());
            giamGia = hd.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();

        }
        if (hd.getIdKH() != null) {
            giamPoint = hd.getIdKH().getDiemEXP();
        }
        txtDiem.setText("0");
        KhachHangModel kh = new KhachHangModel();
        if (hd.getIdKH() != null) {
            kh.setMaKH(hd.getIdKH().getMaKH());
//            kh.setDiemEXP((int) Math.round(Double.valueOf(txtDiem.getText())));
            kh.setDiemEXP(Integer.valueOf(lblTongtien.getText())/1000);
            
            khachHangService.updateExp_KhachHang(kh);
        } else {
            kh.setMaKH(null);
        }
        if (!txtVoucher.getText().equals("0")) {
            txtGiam.setText(String.valueOf(giamGia + giamPoint));
        } else
            txtGiam.setText(String.valueOf(giamPoint));
    }//GEN-LAST:event_btnSuDungActionPerformed

    private void btnThanhToanVaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanVaInActionPerformed
        btnThanhToanActionPerformed(evt);
        try {
            Hashtable map = new Hashtable();
            JasperReport rpt;

            rpt = JasperCompileManager.compileReport("src\\Views\\rptHoaDon.jrxml");

            map.put("MaHD", hd.getMaHD());

            JasperPrint p = JasperFillManager.fillReport(rpt, map, DBConnection.getConnection());

            JasperViewer.viewReport(p, false);

        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnThanhToanVaInActionPerformed

    private void txtTienThoiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienThoiCaretUpdate

    }//GEN-LAST:event_txtTienThoiCaretUpdate

    private void txtTienKHCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKHCaretUpdate
        float tienKh = 0;
        float tienThoi = 0;
        if (txtTienKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mời bạn nhập số tiền cần thanh toán");
            return;
        }
        tienKh = Float.valueOf(txtTienKH.getText());
        float tongTien = Float.valueOf(lblTongtien.getText());
        if (tienKh >= tongTien) {
            tienThoi = tienKh - tongTien;
        }
        txtTienThoi.setText(String.valueOf(tienThoi));
    }//GEN-LAST:event_txtTienKHCaretUpdate

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (Float.valueOf(txtTienKH.getText()) < Float.valueOf(lblTongtien.getText())) {
            JOptionPane.showMessageDialog(this, "Chưa đủ điều kiện thanh toán");
            return;
        }
        int hinhThucThanhToan = cbbHinhThucThanhToan.getSelectedIndex();
        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listNewHDCT = new ArrayList<>();
        hoadonchitietviewmodel hdctvm = new hoadonchitietviewmodel();
        ChiTietSanPhamModel ctsp = new ChiTietSanPhamModel();
        KhachHangModel kh = new KhachHangModel();
        HoaDonViewModel h = new HoaDonViewModel();
        BigDecimal thanhTien = new BigDecimal(lblTongtien.getText());
        h.setThanhTien(thanhTien);
        h.setMaHD(hd.getMaHD());
        h.setHinhThucThanhToan(hinhThucThanhToan);
        if (hd.getIdKM() != null) {
            h.setIdKM(hd.getIdKM());
        } else {
            h.setIdKM(null);
        }

//        if (hd.getIdKH() != null) {
//            kh.setMaKH(hd.getIdKH().getMaKH());
////            kh.setDiemEXP((int) Math.round(Double.valueOf(txtDiem.getText())));
//            double soTien = Double.valueOf(lblTongtien.getText());
//            
//        } else {
//            kh.setMaKH(null);
//        }

        if (hoaDonService.updateHoaDon_ThanhToan(h) != null) {
//            khachHangService.updateExp_KhachHang(kh);
            for (HoaDonChiTiet x : listHDCT) {
                if (x.getIdHD() != null && x.getIdHD().getMaHD().equals(hd.getMaHD())) {
                    listNewHDCT.add(x);
                }
            }
            for (HoaDonChiTiet y : listNewHDCT) {
                hdctvm.setIdHD(y.getIdHD());
                ctsp.setIdCTSP(y.getIdCTSP().getIdCTSP());
                ctsp.setSoLuong(y.getSoLuong());
                chiTietSanPhamService.update_ThanhToan(ctsp);
            }
            hoaDonChiTieservice.updateHDCT_ThanhToan(hdctvm);
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            this.dispose();

        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtGiamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamCaretUpdate
        String chuaGiam = lblTongtien.getText();
        if (txtGiam.getText().trim().isEmpty()) {
            lblTongtien.setText(hd.getThanhTien().toString());
        } else {
            float giamGia = Float.valueOf(txtGiam.getText());
            float tongTien = Float.valueOf(hd.getThanhTien().toString());
            String sauGiam = String.valueOf(tongTien - giamGia);
            lblTongtien.setText(sauGiam);
        }

    }//GEN-LAST:event_txtGiamCaretUpdate

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        HoaDonViewModel hdHuy = new HoaDonViewModel();
        hdHuy.setMaHD(hd.getMaHD());
        String lydo = JOptionPane.showInputDialog(this, "Vui lòng nhập lý do hủy?");
        hdHuy.setGhiChu(lydo);
        if (hoaDonService.updateHoaDon_HUY(hdHuy) != null) {
            JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công");
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVoucherActionPerformed
//        if (txtVoucher.getText().equals("0")) {
//            
//            return;
//        }
//        KhuyenMaiModel km = getKhuyenMai(hd.getIdKM().getMaKM());
//        BigDecimal gia = new BigDecimal(lblTongtien.getText());
//        double giamBF = Double.valueOf(txtGiam.getText());
//        if (km==null){
//            return;
//        }
//        System.out.println(hd.getThanhTien());
//        BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hd.getThanhTien());
//        double giamGia =hd.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();
//        if (txtGiam.getText().equals("0") || txtGiam.getText()==null) {
////            txtGiam.setText(String.valueOf(km.getGiaTri().doubleValue() * gia.doubleValue() / 100));
//                txtGiam.setText(String.valueOf(giamGia));
//        } else {
//            txtGiam.setText(String.valueOf(giamBF + giamGia));
//        }
    }//GEN-LAST:event_txtVoucherActionPerformed

    private void btnHuyVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyVoucherActionPerformed
        txtVoucher.setText("0");
        double giamGia = 0;
        double giamPoint = 0;
        if (hd.getIdKM() != null) {
            KhuyenMaiModel km = getKhuyenMai(hd.getIdKM().getMaKM());  // lấy khuyến mãi            
            BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hd.getThanhTien());
            giamGia = hd.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();

        }
        if (hd.getIdKH() != null) {
            giamPoint = hd.getIdKH().getDiemEXP();
        }
        if (!txtDiem.getText().equals("0")) {
            txtGiam.setText(String.valueOf(giamPoint));
        } else
            txtGiam.setText("0");
    }//GEN-LAST:event_btnHuyVoucherActionPerformed

    private void btnHuyPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPointActionPerformed
        txtDiem.setText(""+hd.getIdKH().getDiemEXP());
        double giamGia = 0;
        double giamPoint = 0;
        if (hd.getIdKM() != null) {
            KhuyenMaiModel km = getKhuyenMai(hd.getIdKM().getMaKM());  // lấy khuyến mãi            
            BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hd.getThanhTien());
            giamGia = hd.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();

        }
//        if (hd.getIdKH()!=null){
//            giamPoint = hd.getIdKH().getDiemEXP(); 
//        }
        if (!txtVoucher.getText().equals("0")) {
            txtGiam.setText(String.valueOf(giamGia));
        } else {
            txtGiam.setText("0");
        }

    }//GEN-LAST:event_btnHuyPointActionPerformed

    private void txtDiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDiemCaretUpdate
//        if (hd.getIdKM() != null) {
//            KhuyenMaiModel km = getKhuyenMai(hd.getIdKM().getMaKM());  // lấy khuyến mãi
//
//            BigDecimal gia = hd.getThanhTien(); // tổng tiền
//            double giamPoint = Double.valueOf(txtDiem.getText()); // giảm điểm
//            if (km == null) {
//                return;
//            }
//            System.out.println(hd.getThanhTien());
//            BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hd.getThanhTien());
//            double giamGia = hd.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();
//            if (txtGiam.getText().equals("0") || txtGiam.getText() == null) {
//                txtGiam.setText(String.valueOf(giamPoint));
//            } else {
//                txtGiam.setText(String.valueOf(giamPoint + giamGia));
//            }
//            if (txtDiem.getText().equals("0") || txtDiem.getText() == null) {
//                txtGiam.setText(String.valueOf(giamGia));
//            }
//        } else {
//            if (txtGiam.getText().equals("0") || txtGiam.getText() == null) {
//                txtGiam.setText(txtDiem.getText());
//            } 
//            if (txtDiem.getText().equals("0") || txtDiem.getText() == null) {
//                txtGiam.setText(String.valueOf(0));
//            }
//        }
    }//GEN-LAST:event_txtDiemCaretUpdate

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
//            java.util.logging.Logger.getLogger(ThanhToanHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThanhToanHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThanhToanHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThanhToanHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new ThanhToanHoaDonJFrame().setVisible(true);
////            }
////        });
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new ThanhToanHoaDonJFrame().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApDung;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuyPoint;
    private javax.swing.JButton btnHuyVoucher;
    private javax.swing.JButton btnSuDung;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToanVaIn;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTongtien;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtGiam;
    private javax.swing.JTextField txtTienKH;
    private javax.swing.JTextField txtTienThoi;
    private javax.swing.JTextField txtVoucher;
    // End of variables declaration//GEN-END:variables
}
