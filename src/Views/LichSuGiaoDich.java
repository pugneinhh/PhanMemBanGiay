/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.GiaoHang;
import Services.HoaDonChiTietLichSuService;
import Services.hoadonservice;
import ViewModels.LichSuGiaoHangModel;
import ViewModels.HoaDonChiTiet_CTSanPham;
import ViewModels.HoaDonViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class LichSuGiaoDich extends javax.swing.JPanel {

    private HoaDonChiTietLichSuService hdCTSPs;
    private final hoadonservice hoaDonService;
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private DefaultTableModel dtmD = new DefaultTableModel();
    private DefaultTableModel dtmT = new DefaultTableModel();
    private DefaultComboBoxModel dcm = new DefaultComboBoxModel();
    int stt = 0;

    public LichSuGiaoDich() {
        initComponents();
        hdCTSPs = new HoaDonChiTietLichSuService();
        hoaDonService = new hoadonservice();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmD = (DefaultTableModel) tblHoaDon_CTSP.getModel();
        dtmT = (DefaultTableModel) tblGiaoHang.getModel();
        cbbTrangThaiGH.setModel((DefaultComboBoxModel) dcm);
        //loadTableHdCTSP();
        loadTableHdGiaoDich();
        loadCombo();
        loadhoadon();
        LichSuGiaoHangPn.setVisible(false);
        HoaDonPn.setVisible(true);
    }

    public void loadhoadon() {
        ArrayList<HoaDonViewModel> list = hoaDonService.getAllhoadon();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmHD.setRowCount(0);
        for (HoaDonViewModel hd : list) {
            dtmHD.addRow(new Object[]{
                hd.getMaHD(),
                hd.getIdNV(),
                hd.getIdKH() == null ? "Khách lẻ" : "" + hd.getIdKH(),
                hd.getNgaytao(),
                hd.getTrangThai() == 0 ? "Chờ thanh toán" : "Đã thanh toán"
            });
        }
    }

    private void loadCombo() {
        for (LichSuGiaoHangModel list : hdCTSPs.getAllHoaDonGiaoHang()) {
            cbbTrangThaiGH.addItem(list.getTrangThaiDon());
        }
    }

    private void loadTableHdGiaoDich() {
        ArrayList<LichSuGiaoHangModel> list = hdCTSPs.getAllHoaDonGiaoHang();
        dtmT.setRowCount(0);
        for (LichSuGiaoHangModel giaoHangModel : list) {
            dtmT.addRow(new Object[]{
                giaoHangModel.getMaHD(),
                giaoHangModel.getMaNV(),
                giaoHangModel.getMaKH(),
                giaoHangModel.getHoTen(),
                giaoHangModel.getSdt(),
                giaoHangModel.getDiaChi(),
                giaoHangModel.getNgayMua(),
                giaoHangModel.getNgayGiao(),
                giaoHangModel.getTienShip(),
                giaoHangModel.getThanhTien(),
                giaoHangModel.getTrangThaiDon()
            });
        }
//        System.out.println(list);
    }

    private void loadTableHdCTSP(ArrayList<HoaDonChiTiet_CTSanPham> list) {
        dtmD.setRowCount(0);
        for (HoaDonChiTiet_CTSanPham hoaDonChiTiet_CTSanPham : list) {
            dtmD.addRow(new Object[]{
                hoaDonChiTiet_CTSanPham.getMaHD(),
                hoaDonChiTiet_CTSanPham.getTenSP(),
                hoaDonChiTiet_CTSanPham.getGiaBan(),
                hoaDonChiTiet_CTSanPham.getSoLuong(),
                hoaDonChiTiet_CTSanPham.getSize(),
                hoaDonChiTiet_CTSanPham.getMauSac(),
                hoaDonChiTiet_CTSanPham.getChatLieu(),
                hoaDonChiTiet_CTSanPham.getDanhMuc(),
                hoaDonChiTiet_CTSanPham.getDoCao()
            });
            stt++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGiaoHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon_CTSP = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        LichSuGiaoHangPn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbbTrangThaiGH = new javax.swing.JComboBox<>();
        txtMaHD = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtTienShip = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        txtNgayGiaoHang = new com.toedter.calendar.JDateChooser();
        txtNgayMua = new com.toedter.calendar.JDateChooser();
        HoaDonPn = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbbTrangThaiHoaDon = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LỊCH SỬ GIAO DỊCH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));

        tblGiaoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Họ tên", "SDT", "Địa chỉ", "Ngày mua", "Ngày giao", "Tiền ship", "Thành tiền ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGiaoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiaoHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGiaoHang);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");

        tblHoaDon_CTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên SP", "Giá bán", "Số lượng", "Size", "Màu sắc", "Chất liệu", "Danh mục", "Độ cao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHoaDon_CTSP);
        if (tblHoaDon_CTSP.getColumnModel().getColumnCount() > 0) {
            tblHoaDon_CTSP.getColumnModel().getColumn(4).setHeaderValue("Size");
            tblHoaDon_CTSP.getColumnModel().getColumn(5).setHeaderValue("Màu sắc");
            tblHoaDon_CTSP.getColumnModel().getColumn(6).setHeaderValue("Chất liệu");
            tblHoaDon_CTSP.getColumnModel().getColumn(7).setHeaderValue("Danh mục");
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("LỊCH SỬ GIAO HÀNG");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã nhân viên", "Tên khách hàng", "Ngày tạo", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(247, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addGap(331, 331, 331)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(233, 233, 233)
                    .addComponent(jLabel14)
                    .addContainerGap(423, Short.MAX_VALUE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));
        jPanel5.setPreferredSize(new java.awt.Dimension(454, 542));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FORM HÓA ĐƠN");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        LichSuGiaoHangPn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Trạng thái");

        jLabel5.setText("Mã hóa đơn");

        jLabel6.setText("Mã nhân viên");

        jLabel7.setText("Mã khách hàng");

        jLabel8.setText("Ngày mua");

        jLabel10.setText("Ngày giao hàng");

        jLabel11.setText("Tiền  ship");

        jLabel12.setText("Thành tiền");

        jLabel13.setText("Ghi chú");

        cbbTrangThaiGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chờ thanh toán", "Đã hủy" }));

        javax.swing.GroupLayout LichSuGiaoHangPnLayout = new javax.swing.GroupLayout(LichSuGiaoHangPn);
        LichSuGiaoHangPn.setLayout(LichSuGiaoHangPnLayout);
        LichSuGiaoHangPnLayout.setHorizontalGroup(
            LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LichSuGiaoHangPnLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(37, 37, 37)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbTrangThaiGH, 0, 383, Short.MAX_VALUE)
                    .addComponent(txtMaHD)
                    .addComponent(txtMaNV)
                    .addComponent(txtMaKH)
                    .addComponent(txtTienShip)
                    .addComponent(txtThanhTien)
                    .addComponent(txtGhiChu)
                    .addComponent(txtNgayGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayMua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LichSuGiaoHangPnLayout.setVerticalGroup(
            LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LichSuGiaoHangPnLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbTrangThaiGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtNgayGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LichSuGiaoHangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        HoaDonPn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setText("Trạng thái");

        cbbTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chờ thanh toán", "Đã hủy" }));

        jLabel16.setText("Mã hóa đơn");

        jLabel17.setText("Mã nhân viên");

        jLabel18.setText("Tên khách hàng");

        jLabel19.setText("Ngày tạo");

        javax.swing.GroupLayout HoaDonPnLayout = new javax.swing.GroupLayout(HoaDonPn);
        HoaDonPn.setLayout(HoaDonPnLayout);
        HoaDonPnLayout.setHorizontalGroup(
            HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonPnLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HoaDonPnLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(46, 46, 46)
                        .addComponent(cbbTrangThaiHoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(HoaDonPnLayout.createSequentialGroup()
                        .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HoaDonPnLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonPnLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        HoaDonPnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMaHoaDon, txtMaNhanVien});

        HoaDonPnLayout.setVerticalGroup(
            HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonPnLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(HoaDonPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(43, 43, 43))
        );

        jLayeredPane1.setLayer(LichSuGiaoHangPn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(HoaDonPn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HoaDonPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LichSuGiaoHangPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HoaDonPn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LichSuGiaoHangPn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLayeredPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblGiaoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiaoHangMouseClicked
        try {
            int row = tblGiaoHang.getSelectedRow();
            if (row < 0) {
                return;
            } else {
                LichSuGiaoHangPn.setVisible(true);
                HoaDonPn.setVisible(false);
                txtMaHD.setText(tblGiaoHang.getValueAt(row, 0).toString());
                txtMaNV.setText(tblGiaoHang.getValueAt(row, 1).toString());
                txtMaKH.setText(tblGiaoHang.getValueAt(row, 2).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tblGiaoHang.getValueAt(row, 6).toString());
                txtNgayMua.setDate(date);
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tblGiaoHang.getValueAt(row, 7).toString());
                txtNgayGiaoHang.setDate(date1);
                txtTienShip.setText(tblGiaoHang.getValueAt(row, 8).toString());
                txtThanhTien.setText(tblGiaoHang.getValueAt(row, 9).toString());
                cbbTrangThaiGH.setSelectedItem(tblGiaoHang.getValueAt(row, 10));
                ArrayList<HoaDonChiTiet_CTSanPham> li = hdCTSPs.getAllHoaDon_HoaDonChiTiet_ChiTietSP_theoMahd(tblGiaoHang.getValueAt(row, 0).toString());
                loadTableHdCTSP(li);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblGiaoHangMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
            int row1 = tblHoaDon.getSelectedRow();
            if (row1 < 0) {               
            }else{
                HoaDonPn.setVisible(true);
                LichSuGiaoHangPn.setVisible(false);
                txtMaHoaDon.setText(tblHoaDon.getValueAt(row1, 0).toString());
                txtMaNhanVien.setText(tblHoaDon.getValueAt(row1, 1).toString());
                txtTenKhachHang.setText(tblHoaDon.getValueAt(row1, 2).toString());
                Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(tblHoaDon.getValueAt(row1, 3).toString());
                txtNgayTao.setDate(date3);
                cbbTrangThaiHoaDon.setSelectedItem(tblHoaDon.getValueAt(row1, 4));
                ArrayList<HoaDonChiTiet_CTSanPham> li = hdCTSPs.getAllHoaDon_HoaDonChiTiet_ChiTietSP_theoMahd(tblHoaDon.getValueAt(row1, 0).toString());
                loadTableHdCTSP(li);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoaDonPn;
    private javax.swing.JPanel LichSuGiaoHangPn;
    private javax.swing.JComboBox<String> cbbTrangThaiGH;
    private javax.swing.JComboBox<String> cbbTrangThaiHoaDon;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblGiaoHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDon_CTSP;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNhanVien;
    private com.toedter.calendar.JDateChooser txtNgayGiaoHang;
    private com.toedter.calendar.JDateChooser txtNgayMua;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienShip;
    // End of variables declaration//GEN-END:variables
}
