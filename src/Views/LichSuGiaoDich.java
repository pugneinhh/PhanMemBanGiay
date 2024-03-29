/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;


import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import Services.ChiTietSanPhamService;
import Services.HoaDonChiTietLichSuService;
import Services.hoadonservice;
import Utilities.JDBCHelper;
import ViewModels.ChiTietSanPhamModel;
import ViewModels.HoaDonChiTiet_CTSanPham;
import ViewModels.HoaDonViewModel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import responsitories.HoaDonCTResbonsitory;
import responsitories.KhachHangResponsitory;
import responsitories.KhuyenMaiResbonsitory;
import responsitories.NhanVienResponsitory;

/**
 *
 * @author HP
 */
public class LichSuGiaoDich extends javax.swing.JPanel {

    private HoaDonChiTietLichSuService hdCTSPs;
    private  hoadonservice hoaDonSS;
    HoaDonCTResbonsitory hdcts=new HoaDonCTResbonsitory();
    ChiTietSanPhamService ctsps=new ChiTietSanPhamService();
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private DefaultTableModel dtmD = new DefaultTableModel();
    NhanVienResponsitory nv = new NhanVienResponsitory();
    KhachHangResponsitory kh = new KhachHangResponsitory();
    KhuyenMaiResbonsitory km = new KhuyenMaiResbonsitory();
    int stt = 0;
    long count, soTrang, Trang = 1;

    public LichSuGiaoDich() {
        initComponents();
        hdCTSPs = new HoaDonChiTietLichSuService();
        hoaDonSS = new hoadonservice();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmD = (DefaultTableModel) tblHoaDon_CTSP.getModel();
        tblHoaDon.getTableHeader().setBackground(Color.pink);
        tblHoaDon_CTSP.getTableHeader().setBackground(Color.pink);
        //loadTableHdCTSP();
        countAllHD();
        if (count % 6 == 0) {
            soTrang = count / 6;
        } else {
            soTrang = count / 6 + 1;
        }

        lblpage.setText("1/" + soTrang);
        loadTBHoaDonAll(1);

    }

    public void countAllHD() {
        try {
            String sql = "SELECT count(*) From HOADON WHERE TRANGTHAI=1 OR TRANGTHAI=2";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                count = rs.getLong(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void countHDThanhToan() {
        try {
            String sql = "SELECT count(*) From HOADON WHERE TRANGTHAI=1 ";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                count = rs.getLong(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void countHDHuy() {
        try {
            String sql = "SELECT count(*) From HOADON WHERE TRANGTHAI=2 ";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                count = rs.getLong(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HoaDonViewModel> getAllHoaDon() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT TOP 6 * FROM HOADON where MAHD not in (SELECT TOP " + (Trang * 6 - 6) + "MAHD FROM HOADON ORDER BY NGAYTAO DESC) AND (TRANGTHAI=1 OR TRANGTHAI=2) ORDER BY NGAYTAO DESC ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(10), rs.getDate(9), rs.getInt(11),rs.getInt(12)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDonViewModel> getHoaDonTT() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT TOP 6 * FROM HOADON where MAHD not in (SELECT TOP " + (Trang * 6 - 6) + "MAHD FROM HOADON ORDER BY NGAYTAO DESC) AND TRANGTHAI=1 ORDER BY NGAYTAO DESC ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(10), rs.getDate(9), rs.getInt(11),rs.getInt(12)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDonViewModel> getHoaDonBH() {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String sql = "SELECT TOP 6 * FROM HOADON where MAHD not in (SELECT TOP " + (Trang * 6 - 6) + "MAHD FROM HOADON ORDER BY NGAYTAO DESC) AND  TRANGTHAI=2 ORDER BY NGAYTAO DESC ";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                NhanVien nv1 = nv.getNVByID(rs.getString(3));
                KhachHang kh1 = kh.getKhachHangByidkmd(rs.getString(4));
                KhuyenMai km1 = km.getKMByID(rs.getString(7));

                list.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), nv1, kh1, rs.getDate(5), rs.getBigDecimal(6), km1, rs.getString(8), rs.getDate(10), rs.getDate(9), rs.getInt(11),rs.getInt(12)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void loadTBHoaDonAll(long Trang) {
        ArrayList<HoaDonViewModel> list = getAllHoaDon();
        dtmHD.setRowCount(0);
        Collections.sort(list, Comparator.comparing(HoaDonViewModel -> HoaDonViewModel.getNgaytao()));
        Collections.reverse(list);
        for (HoaDonViewModel hd : list) {
            dtmHD.addRow(new Object[]{
                hd.getMaHD(),
                hd.getIdNV(),
                hd.getIdKH() == null ? "Khách lẻ" : "" + hd.getIdKH(),
                hd.getNgaytao(),
                hd.getThanhTien(),
                hd.getHinhThucThanhToan()==0?"Tiền mặt":"Thẻ",
                hd.trangthai(),
                hd.getGhiChu()==null?"":hd.getGhiChu()
            });

        }

    }

    public void loadTBHoaDonTT(long Trang) {
        ArrayList<HoaDonViewModel> list = getHoaDonTT();
        dtmHD.setRowCount(0);
//        Collections.sort(list, Comparator.comparing(HoaDonViewModel -> HoaDonViewModel.getMaHD()));
        for (HoaDonViewModel hd : list) {
            dtmHD.addRow(new Object[]{
                hd.getMaHD(),
                hd.getIdNV(),
                hd.getIdKH() == null ? "Khách lẻ" : "" + hd.getIdKH(),
                hd.getNgaytao(),
                hd.getThanhTien(),
                hd.getHinhThucThanhToan()==0?"Tiền mặt":"Thẻ",
                hd.trangthai(),
                hd.getGhiChu()==null?"":hd.getGhiChu()
            });

        }

    }

    public void loadTBHoaDonBH(long Trang) {
        ArrayList<HoaDonViewModel> list = getHoaDonBH();
        dtmHD.setRowCount(0);
//        Collections.sort(list, Comparator.comparing(HoaDonViewModel -> HoaDonViewModel.getMaHD()));
        for (HoaDonViewModel hd : list) {
            dtmHD.addRow(new Object[]{
                hd.getMaHD(),
                hd.getIdNV(),
                hd.getIdKH() == null ? "Khách lẻ" : "" + hd.getIdKH(),
                hd.getNgaytao(),
                hd.getThanhTien(),
                hd.getHinhThucThanhToan()==0?"Tiền mặt":"Thẻ",
                hd.trangthai(),
                hd.getGhiChu()==null?"":hd.getGhiChu()
            });

        }

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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon_CTSP = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        cbbLocTrangThai = new javax.swing.JComboBox<>();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblpage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbbTrangThaiHoaDon = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cbbHTTT = new javax.swing.JComboBox<>();
        btnHuyHoaDon = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");

        tblHoaDon_CTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblHoaDon_CTSP.setRowHeight(25);
        jScrollPane2.setViewportView(tblHoaDon_CTSP);

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã nhân viên", "Tên khách hàng", "Ngày tạo", "Thành tiền", "Hình thức TT", "Trạng thái", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(25);
        tblHoaDon.setSelectionBackground(new java.awt.Color(153, 255, 153));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("HÓA ĐƠN");

        cbbLocTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Đã thanh toán", "Đã hủy" }));
        cbbLocTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLocTrangThaiItemStateChanged(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next2T.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nextT.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nextP.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next2P.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblpage.setText("0/0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbbLocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnFirst)
                        .addGap(59, 59, 59)
                        .addComponent(btnPre)
                        .addGap(70, 70, 70)
                        .addComponent(lblpage)
                        .addGap(75, 75, 75)
                        .addComponent(btnNext)
                        .addGap(53, 53, 53)
                        .addComponent(btnLast))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cbbLocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblpage))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPre)
                            .addComponent(btnFirst)
                            .addComponent(btnNext)
                            .addComponent(btnLast))))
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));
        jPanel5.setPreferredSize(new java.awt.Dimension(454, 542));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FORM HÓA ĐƠN");

        cbbTrangThaiHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chờ thanh toán", "Đã hủy" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Trạng thái");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Mã hóa đơn");

        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Mã nhân viên");

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Tên khách hàng");

        txtTenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Ngày tạo");

        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Hình thức thanh toán");

        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Thành tiền");

        cbbHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Thẻ" }));

        btnHuyHoaDon.setBackground(new java.awt.Color(255, 255, 102));
        btnHuyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuyHoaDon.setForeground(new java.awt.Color(255, 51, 51));
        btnHuyHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconDelete.png"))); // NOI18N
        btnHuyHoaDon.setText("Hủy Hóa Đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtThanhTien)
                                    .addComponent(txtMaNhanVien)
                                    .addComponent(txtTenKhachHang)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(cbbHTTT, 0, 332, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuyHoaDon)
                .addGap(168, 168, 168))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbHTTT, cbbTrangThaiHoaDon, txtMaHoaDon, txtMaNhanVien, txtNgayTao, txtTenKhachHang, txtThanhTien});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbHTTT, cbbTrangThaiHoaDon, txtMaHoaDon, txtMaNhanVien, txtNgayTao, txtTenKhachHang, txtThanhTien});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
            int row1 = tblHoaDon.getSelectedRow();
            if (row1 < 0) {
                return;
            } else {
                txtMaHoaDon.setText(tblHoaDon.getValueAt(row1, 0).toString());
                txtMaNhanVien.setText(tblHoaDon.getValueAt(row1, 1).toString());
                txtTenKhachHang.setText(tblHoaDon.getValueAt(row1, 2).toString());
                Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(tblHoaDon.getValueAt(row1, 3).toString());
                txtNgayTao.setDate(date3);
                String ht=tblHoaDon.getValueAt(row1, 5).toString();
                if(ht.equalsIgnoreCase("Tiền mặt")){
                    cbbHTTT.setSelectedIndex(0);
                }else{
                    cbbHTTT.setSelectedIndex(1);
                }
                cbbTrangThaiHoaDon.setSelectedItem(tblHoaDon.getValueAt(row1, 6).toString());
                
                ArrayList<HoaDonChiTiet_CTSanPham> li = hdCTSPs.getAllHoaDon_HoaDonChiTiet_ChiTietSP_theoMahd(tblHoaDon.getValueAt(row1, 0).toString());
                txtThanhTien.setText(tblHoaDon.getValueAt(row1, 4).toString());
                if(tblHoaDon.getValueAt(row1, 7).toString().trim().length()>0){
                 txtGhiChu.setText(tblHoaDon.getValueAt(row1, 7).toString());   
                }else{
                    txtGhiChu.setText("");
                }
                
                loadTableHdCTSP(li);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void cbbLocTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLocTrangThaiItemStateChanged
        String tt = cbbLocTrangThai.getSelectedItem().toString();
        if (tt.equalsIgnoreCase("All")) {
            countAllHD();
            if (count % 6 == 0) {
                soTrang = count / 6;
            } else {
                soTrang = count / 6 + 1;
            }

            lblpage.setText("1/" + soTrang);
            loadTBHoaDonAll(1);
        } else if (tt.equalsIgnoreCase("Đã thanh toán")) {
            countHDThanhToan();
            if (count % 6 == 0) {
                soTrang = count / 6;
            } else {
                soTrang = count / 6 + 1;
            }

            lblpage.setText("1/" + soTrang);
            loadTBHoaDonTT(1);
        } else if (tt.equalsIgnoreCase("Đã hủy")) {
            countHDHuy();
            if (count % 6 == 0) {
                soTrang = count / 6;
            } else {
                soTrang = count / 6 + 1;
            }

            lblpage.setText("1/" + soTrang);
            loadTBHoaDonBH(1);

        }
    }//GEN-LAST:event_cbbLocTrangThaiItemStateChanged

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        Trang = 1;
         String tt = cbbLocTrangThai.getSelectedItem().toString();
         if (tt.equalsIgnoreCase("All")) {
        loadTBHoaDonAll(Trang);
        }else if (tt.equalsIgnoreCase("Đã thanh toán")) {
        loadTBHoaDonTT(Trang);
        }else if (tt.equalsIgnoreCase("Đã hủy")) {
        loadTBHoaDonBH(Trang);
        }
        lblpage.setText(Trang + "/" + soTrang);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        if (Trang > 1) {
            Trang--;
            String tt = cbbLocTrangThai.getSelectedItem().toString();
         if (tt.equalsIgnoreCase("All")) {
        loadTBHoaDonAll(Trang);
        }else if (tt.equalsIgnoreCase("Đã thanh toán")) {
        loadTBHoaDonTT(Trang);
        }else if (tt.equalsIgnoreCase("Đã hủy")) {
        loadTBHoaDonBH(Trang);
        }
            lblpage.setText(Trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (Trang < soTrang) {
            Trang++;
           String tt = cbbLocTrangThai.getSelectedItem().toString();
         if (tt.equalsIgnoreCase("All")) {
        loadTBHoaDonAll(Trang);
        }else if (tt.equalsIgnoreCase("Đã thanh toán")) {
        loadTBHoaDonTT(Trang);
        }else if (tt.equalsIgnoreCase("Đã hủy")) {
        loadTBHoaDonBH(Trang);
        }
            lblpage.setText(Trang + "/" + soTrang);

        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        Trang = soTrang;
        String tt = cbbLocTrangThai.getSelectedItem().toString();
         if (tt.equalsIgnoreCase("All")) {
        loadTBHoaDonAll(Trang);
        }else if (tt.equalsIgnoreCase("Đã thanh toán")) {
        loadTBHoaDonTT(Trang);
        }else if (tt.equalsIgnoreCase("Đã hủy")) {
        loadTBHoaDonBH(Trang);
        }
        lblpage.setText(Trang + "/" + soTrang);
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        HoaDonViewModel hdHuy = new HoaDonViewModel();
        hdHuy.setMaHD(txtMaHoaDon.getText());
        if(txtMaHoaDon.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn hủy");
        }
        String lydo = JOptionPane.showInputDialog(null, "Vui lòng nhập lý do hủy?");
        if (lydo.isEmpty()) {
            return;
        }
        hdHuy.setGhiChu(lydo);
        HoaDon h=hdcts.getIDHoaDon(txtMaHoaDon.getText());
        ArrayList<HoaDonChiTiet> listhdct=hdcts.getAllhoadonct_byMa(h.getIdHD());
        ChiTietSanPhamModel ctspM=new ChiTietSanPhamModel();
        if (hoaDonSS.updateHoaDon_HUY(hdHuy) != null) {
            for (HoaDonChiTiet x : listhdct) {
                ctspM.setIdCTSP(x.getIdCTSP().getIdCTSP());
                ctspM.setSoLuong(x.getSoLuong());
                ctsps.update_huyThanhToan(ctspM);
                hdcts.updateHDCT_huyThanhToan(x);
            }
            JOptionPane.showMessageDialog(null, "Hủy hóa đơn thành công");
            
        }
        loadTBHoaDonAll(1);
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JComboBox<String> cbbHTTT;
    private javax.swing.JComboBox<String> cbbLocTrangThai;
    private javax.swing.JComboBox<String> cbbTrangThaiHoaDon;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblpage;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDon_CTSP;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaNhanVien;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
