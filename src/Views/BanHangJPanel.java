/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChiTietSanPham;
import DomainModels.DanhMuc;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import Services.ChiTietSanPhamService;
import Services.DanhMucService;
import Services.HoaDonChiTieservice;
import Services.KhachHangService;
import Services.NhanVienService;
import Services.SanPhamService;
import Services.hoadonservice;
import ViewModels.ChiTietSanPhamModel;
import ViewModels.DanhMucModel;
import ViewModels.HoaDonViewModel;
import ViewModels.KhachHangModel;
import ViewModels.NhanVienModel;
import ViewModels.hoadonchitietviewmodel;
import java.awt.CardLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import responsitories.HoaDonResponsitory;
import responsitories.KhachHangResponsitory;
import responsitories.KhuyenMaiResbonsitory;
import responsitories.NhanVienResponsitory;

/**
 *
 * @author Phanh
 */
public class BanHangJPanel extends javax.swing.JPanel {

    CardLayout cardlayout;
    private final ChiTietSanPhamService chiTietSanPhamService;
    private final SanPhamService sanPhamService;
    private final KhachHangService khachHangService;
    private final KhachHangResponsitory khachHangrespon;
    private final hoadonservice hoaDonService;
    private final HoaDonResponsitory hoaDonRespon;
    private final NhanVienService nhanVienService;
    private final NhanVienResponsitory nhanVienRespon;
    public static HoaDon hd = null;
    int chon = 0;
    private final HoaDonChiTieservice hoaDonChiTieservice;

//    private HoaDonChiTiet
    DefaultTableModel dtmHD = new DefaultTableModel();
    DefaultTableModel dtmSP = new DefaultTableModel();
    DefaultTableModel dtmGH = new DefaultTableModel();
    DefaultTableModel dtmKH = new DefaultTableModel();
    int stt = 0;
    int slNhap;
    int slGoc;
    int maxMaHD;
//    private hoa hd;
    JTabbedPane pnlTabs;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat df = NumberFormat.getInstance(localeVN);
    DefaultComboBoxModel<DanhMucModel> CBBModelDM;
    DanhMucService danhMucService;
    DefaultComboBoxModel<DanhMuc> dcmDanhMuc = new DefaultComboBoxModel<>();

    /**
     * Creates new form BanHangJPanel
     */
    public BanHangJPanel() {
        initComponents();
        danhMucService = new DanhMucService();
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmKH = (DefaultTableModel) tblKhachHang.getModel();
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        chiTietSanPhamService = new ChiTietSanPhamService();
        khachHangService = new KhachHangService();
        khachHangrespon = new KhachHangResponsitory();
        sanPhamService = new SanPhamService();
        hoaDonChiTieservice = new HoaDonChiTieservice();
        hoaDonService = new hoadonservice();
        hoaDonRespon = new HoaDonResponsitory();
        nhanVienService = new NhanVienService();
        nhanVienRespon = new NhanVienResponsitory();
        CardLayout layout = (CardLayout) pncardgoc.getLayout();
        // cbbDanhMuc.setModel((DefaultComboBoxModel) dcmDanhMuc);
//        this.pnlTabs = pnlTabs;
//        loadTableBanHang(CTSPService.getAllChiTietSanPham());
//        loadTableThongTin();
        loadSanPham();
        loadKhachHang();
        loadhoadon();
        loadComBoDanhMucSP();

    }

    /// Load đang bị sai do SQL insert nhầm tênKH và LoạiKH 
    public void loadKhachHang() {
        ArrayList<KhachHangModel> listKH = khachHangService.getAllKhachHang();
        dtmKH = (DefaultTableModel) tblKhachHang.getModel();
        dtmKH.setRowCount(0);
        for (KhachHangModel kh : listKH) {
            dtmKH.addRow(new Object[]{
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

    public void loadGioHangbyID(String id) {
        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listHDCTNew = new ArrayList<>();
        for (HoaDonChiTiet h : listHDCT) {
            if (h.getIdHD().getIdHD() != null && h.getIdHD().getIdHD().equals(id)) {
                listHDCTNew.add(h);
            }
        }
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmGH.setRowCount(0);
        for (HoaDonChiTiet hd : listHDCTNew) {
            dtmGH.addRow(new Object[]{
                hd.getIdCTSP()== null ?"": hd.getIdCTSP().getIdCTSP(),
                hd.getIdCTSP() == null ? "" : hd.getIdCTSP().getIdSP().getTenSP(),
                hd.getSoLuong(),
                hd.getDonGia(),
                hd.getIdCTSP().getIdKM() == null ? "Nguyên giá" :hd.getIdCTSP().getIdKM().getApDungGiamGia() == null ? hd.getIdCTSP().getGiaBan() : hd.getIdCTSP().getIdKM().getApDungGiamGia().contains("%") == true ? hd.getIdCTSP().getIdKM().getGiaTri() + "%" : hd.getIdCTSP().getIdKM().getGiaTri() + "VND",
                hd.getIdCTSP().getIdKM() == null ? Float.valueOf(hd.getDonGia().toString())*hd.getSoLuong()  : df.format(Float.valueOf(thanhTien(hd.getIdCTSP().getIdKM().getApDungGiamGia(), hd.getIdCTSP().getIdKM().getGiaTri(), hd.getIdCTSP().getIdKM().getGiamToiDa(), hd.getDonGia()).toString()) * hd.getSoLuong())
            });
        }
        tongTien();
    }

    public void loadGioHang() {
        ArrayList<HoaDonChiTiet> listGH = hoaDonChiTieservice.getAllhoadon();
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmGH.setRowCount(0);
        for (HoaDonChiTiet x : listGH) {
            dtmGH.addRow(new Object[]{
                x.getIdCTSP(),
                x.getSoLuong(),
                x.getDonGia(),
                x.getIdCTSP().getIdKM() == null ? "Nguyên giá" : x.getIdCTSP().getIdKM().getTenKM(),
                df.format(Float.valueOf(thanhTien(x.getIdCTSP().getIdKM().getApDungGiamGia(), x.getIdCTSP().getIdKM().getGiaTri(), x.getIdCTSP().getIdKM().getGiamToiDa(), x.getDonGia()).toString()) * x.getSoLuong())
            });
        }
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
                hd.getTrangThai() == 1 ? "Đã thanh toán" : "Chờ thanh toán"
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    private void loadTableBanHang(ArrayList<ChiTietSanPhamModel> list) {
//        modelTable = (DefaultTableModel) tblBanHang.getModel();
//        modelTable.setRowCount(0);
//        for (ChiTietSanPhamModel ctspM : list) {
//            modelTable.addRow(new Object[]{
//                ctspM.getIdCTSP(),
//                ctspM.getIdSP(),
//                ctspM.getGiaBan(),
//                ctspM.getSoLuong(),
//                ctspM.getIdSize(),
//                ctspM.getIdDC(),
//                ctspM.getIdCL(),
//                ctspM.getIdMS(),
//                ctspM.getIdDM(),
//                ctspM.getMota()
//            });
//        }
//    }
    private BigDecimal thanhTien(String loai, BigDecimal giaTri, BigDecimal giaTriMax, BigDecimal donGia) {
        BigDecimal thanhTien_KM = null;
        float gia = 0;
        if (loai.equalsIgnoreCase("giảm theo%")) {
            if (Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString()) > Float.valueOf(giaTriMax.toString())) {
                gia = Float.valueOf(giaTriMax.toString());
            } else {
                gia = Float.valueOf(donGia.toString()) - (Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString()));
            }
        } else {
            gia = Float.valueOf(donGia.toString()) - Float.valueOf(giaTri.toString());
        }
        System.out.println(Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString()));
        thanhTien_KM = BigDecimal.valueOf(gia);
        return thanhTien_KM;
    }

    private void loadSanPham() {
        ArrayList<ChiTietSanPhamModel> list = chiTietSanPhamService.getAllChiTietSanPham();
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        dtmSP.setRowCount(0);
        for (ChiTietSanPhamModel ctspM : list) {
            dtmSP.addRow(new Object[]{
                ctspM.getIdCTSP(),
                ctspM.getIdSP().getTenSP(),
                ctspM.getGiaBan(),
                ctspM.getSoLuong(),
                ctspM.getIdSize().getTenSize(),
                ctspM.getIdDC().getTenDC(),
                ctspM.getIdCL().getTenCL(),
                ctspM.getIdMS().getTenMS(),
                ctspM.getIdDM().getTenDM(),
                ctspM.getIdKM()==null?"Nguyên giá":ctspM.getIdKM().getTenKM(),
                ctspM.getIdKM()==null?df.format(ctspM.getGiaBan()) :df.format(thanhTien(ctspM.getIdKM().getApDungGiamGia(), ctspM.getIdKM().getGiaTri(), ctspM.getIdKM().getGiamToiDa(), ctspM.getGiaBan()))

            });
        }
    }
//
//    private void loadTableThongTin() {
//        ArrayList<HoaDonViewModel> list = hdsv.getAllhoadon();
//        modelTable = (DefaultTableModel) tblhoadon.getModel();
//        modelTable.setRowCount(0);
//        for (HoaDonViewModel HoaDonViewModel : list) {
//            modelTable.addRow(new Object[]{
//                HoaDonViewModel.getMaHD(),
//                HoaDonViewModel.getIdKH(),
//                HoaDonViewModel.getIdNV(),
//                HoaDonViewModel.getNgayMua(),
//                HoaDonViewModel.getTrangThai() == 0 ? "Chờ thanh toán" : "Đã thanh toán"
//            });
//
//        }
//    }
//
//    public void loadGioHang(ArrayList<Hoadonct_SanpCT_Sp> list) {
//        modelTable = (DefaultTableModel) tblGioHang.getModel();
//        modelTable.setRowCount(0);
//        stt = 1;
//        for (Hoadonct_SanpCT_Sp ctsp : list) {
//            modelTable.addRow(new Object[]{
//                stt,
//                ctsp.getTenSP(),
//                ctsp.getSl(),
//                ctsp.getDonGia(),
//                new BigDecimal(ctsp.getSl() * Double.parseDouble(ctsp.getDonGia().toString()))
//            });
//            stt++;
//        }
//
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        btnSanpham = new javax.swing.JButton();
        btnKhBh = new javax.swing.JButton();
        txtTimKiemBH = new javax.swing.JTextField();
        btnTimKiemBH = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnQuetBar = new javax.swing.JButton();
        btnGiaoHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbltongtien = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        btnDatHang = new javax.swing.JButton();
        jpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        lbltenkh = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        pncardgoc = new javax.swing.JPanel();
        Khach = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtKHEmail = new javax.swing.JTextField();
        txtLoaiKH = new javax.swing.JTextField();
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
        Sanpham = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        HoaDon = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        ThanhToan = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1320, 639));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSanpham.setText("Sản Phẩm");
        btnSanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanphamActionPerformed(evt);
            }
        });

        btnKhBh.setText("Khách Hàng");
        btnKhBh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhBhActionPerformed(evt);
            }
        });

        txtTimKiemBH.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemBHCaretUpdate(evt);
            }
        });
        txtTimKiemBH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemBHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemBHFocusLost(evt);
            }
        });

        btnTimKiemBH.setText("Tìm  Kiếm");
        btnTimKiemBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemBHActionPerformed(evt);
            }
        });

        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnQuetBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barcode-scan.png"))); // NOI18N
        btnQuetBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetBarActionPerformed(evt);
            }
        });

        btnGiaoHang.setText("Giao Hàng");
        btnGiaoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhBh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtTimKiemBH, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemBH, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnQuetBar)
                .addGap(35, 35, 35)
                .addComponent(btnGiaoHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHoaDon, btnKhBh, btnSanpham});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhBh, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiemBH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiemBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuetBar)))
                .addGap(16, 16, 16))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHoaDon, btnKhBh, btnSanpham});

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbltongtien.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbltongtien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltongtien.setText("0");

        txtThanhTien.setText("Thành Tiền");
        txtThanhTien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtThanhTienFocusGained(evt);
            }
        });

        jLabel6.setText("-");

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setText("Hóa Đơn Mới");
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jButton13.setText("Xóa Đơn Hàng");
        jButton13.setPreferredSize(new java.awt.Dimension(111, 22));

        btnDatHang.setText("Đặt Hàng");
        btnDatHang.setPreferredSize(new java.awt.Dimension(111, 22));
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IDCTSP", "Sản Phẩm", "Số Lượng ", "Đơn Giá", "CTKM", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGioHang);

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbltenkh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltenkh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltenkh.setText("Khách Lẻ");

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHoaDon.setText("Hóa Đơn Trống");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(lbltenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbltongtien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbltenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(lbltongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTaoHoaDon, jButton13});

        pncardgoc.setLayout(new java.awt.CardLayout());

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Loại KH", "Địa chỉ", "Giới tính", "Email", "SDT", "Ngày sinh", "Ngày tham gia", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Mã khách hàng");

        jLabel2.setText("Tên khách hàng");

        jLabel4.setText("Loại khách hàng");

        jLabel5.setText("Địa chỉ");

        jLabel10.setText("Trạng thái");

        jLabel8.setText("Ngày sinh");

        jLabel7.setText("SDT");

        jLabel16.setText("Email");

        jLabel17.setText("Giới tính");

        txtDiaChiKH.setColumns(20);
        txtDiaChiKH.setRows(5);
        jScrollPane3.setViewportView(txtDiaChiKH);

        buttonGroup1.add(rdoKHNam);
        rdoKHNam.setText("Nam");

        buttonGroup1.add(rdoKHNu);
        rdoKHNu.setText("Nữ");

        txtKHNgaySinh.setDateFormatString("yyyy-MM-dd");

        buttonGroup2.add(rdoKHNgung);
        rdoKHNgung.setText("Ngừng hoạt động");

        buttonGroup2.add(rdoKHCon);
        rdoKHCon.setText("Còn hoạt động");

        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnSuaKH.setText("Sửa");
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtLoaiKH, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtMaKH))
                        .addGap(170, 170, 170)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoKHNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoKHNu))
                            .addComponent(txtKHEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtKHNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtKHSdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoKHCon)
                                .addGap(18, 18, 18)
                                .addComponent(rdoKHNgung))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnThemKH)
                        .addGap(148, 148, 148)
                        .addComponent(btnSuaKH)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGap(312, 312, 312)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17)
                        .addComponent(jLabel16)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel10))
                    .addContainerGap(330, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoKHNam)
                    .addComponent(rdoKHNu)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKHEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKHSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtKHNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoKHCon)
                            .addComponent(rdoKHNgung))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKH)
                    .addComponent(btnSuaKH))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel17))
                    .addGap(22, 22, 22)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel16))
                    .addGap(24, 24, 24)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel10)))
                    .addContainerGap(67, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout KhachLayout = new javax.swing.GroupLayout(Khach);
        Khach.setLayout(KhachLayout);
        KhachLayout.setHorizontalGroup(
            KhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachLayout.createSequentialGroup()
                .addGroup(KhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhachLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        KhachLayout.setVerticalGroup(
            KhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pncardgoc.add(Khach, "khach");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDCTSP", "Tên SP", "Giá Bán", "Số Lượng", "Size", "Độ Cao", "Chất Liệu", "Màu Sắc", "Danh Mục", "CTKM", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        Sanpham.setViewportView(tblSanPham);

        pncardgoc.add(Sanpham, "sanpham");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên NV", "Tên KH", "Ngày tạo", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        HoaDon.setViewportView(tblHoaDon);

        pncardgoc.add(HoaDon, "hoadon");

        javax.swing.GroupLayout ThanhToanLayout = new javax.swing.GroupLayout(ThanhToan);
        ThanhToan.setLayout(ThanhToanLayout);
        ThanhToanLayout.setHorizontalGroup(
            ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        ThanhToanLayout.setVerticalGroup(
            ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        pncardgoc.add(ThanhToan, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pncardgoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pncardgoc, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhBhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhBhActionPerformed
        CardLayout layout = (CardLayout) pncardgoc.getLayout();
        layout.show(pncardgoc, "khach");
        chon = 0;
        changeBackgroud_SP_KH();
        loadKhachHang();
    }//GEN-LAST:event_btnKhBhActionPerformed

    private void btnSanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanphamActionPerformed
        CardLayout layout = (CardLayout) pncardgoc.getLayout();
        layout.show(pncardgoc, "sanpham");
        chon = 1;
        changeBackgroud_SP_KH();
        loadSanPham();
    }//GEN-LAST:event_btnSanphamActionPerformed

    private void txtTimKiemBHCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemBHCaretUpdate
//        if (txtTimKiemBH.getText().equalsIgnoreCase("Tìm Kiếm Khách Hàng") || txtTimKiemBH.getText().equalsIgnoreCase("Tìm Kiếm Sản Phẩm")) {
//            txtTimKiemBH.setText("");
////            txtTimKiemBH.setForeground(Color.BLACK);
//        }
    }//GEN-LAST:event_txtTimKiemBHCaretUpdate

    private void btnTimKiemBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemBHActionPerformed

        switch (chon) {
            case 1 -> {
                if (txtTimKiemBH.getText().equalsIgnoreCase("Tìm Kiếm Sản Phẩm")) {
                    JOptionPane.showMessageDialog(this, "Bạn phải nhập Tên hoặc mã sản phẩm");
                    return;
                }
                String maSP = txtTimKiemBH.getText();
                ArrayList<ChiTietSanPhamModel> listSP = chiTietSanPhamService.getChiTietSanPhamByDanhMuc(maSP);
//            loadTableBanHang(listSP);
            }
            case 0 -> {
                if (txtTimKiemBH.getText().equalsIgnoreCase("Tìm Kiếm Khách Hàng")) {
                    JOptionPane.showMessageDialog(this, "Bạn phải nhập Tên hoặc mã khách hàng");
                    return;
                }
                String makh = txtTimKiemBH.getText();
                KhachHangModel listSP = khachHangService.gettheomakh(makh);
//            loadTableThongTin();
            }
            default -> {
                if (txtTimKiemBH.getText().equalsIgnoreCase("Tìm Kiếm Hóa Đơn")) {
                    JOptionPane.showMessageDialog(this, "Bạn phải nhập mã Hóa Đơn");
                    return;
                }
                String maHD = txtTimKiemBH.getText();
//            HoaDonViewModel listHD = hoaDonService.gettheoidhd(maHD);
            }
        }


    }//GEN-LAST:event_btnTimKiemBHActionPerformed

    private void txtTimKiemBHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemBHFocusLost
        if (txtTimKiemBH.getText().trim().isEmpty()) {
            txtTimKiemBH.setForeground(new Color(255, 0, 0));
            changeBackgroud_SP_KH();
        }
    }//GEN-LAST:event_txtTimKiemBHFocusLost

    private void cbbDanhMucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDanhMucItemStateChanged

    }//GEN-LAST:event_cbbDanhMucItemStateChanged

    private void loadComBoDanhMucSP() {
        ArrayList<DanhMucModel> dmList = danhMucService.getAllDanhMuc();
        for (DanhMucModel danhMucModel : dmList) {
            dcmDanhMuc.addElement(new DanhMuc(danhMucModel.getIdDM(), danhMucModel.getMaDM(), danhMucModel.getTenDM(), danhMucModel.getNgayTao(), danhMucModel.getNgaySua(), danhMucModel.getTrangThai()));
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbbDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDanhMucActionPerformed

    }//GEN-LAST:event_cbbDanhMucActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int row = tblKhachHang.getSelectedRow();
        if (row < 0) {
            return;
        }
        String makh = tblKhachHang.getValueAt(row, 0).toString();
        KhachHang kh = new KhachHang();
        ArrayList<KhachHangModel> listKH = khachHangService.getAllKhachHang();
        for (KhachHangModel x : listKH) {
            if (x.getMaKH() != null && x.getMaKH().equals(makh)) {
                kh.setIdKH(x.getIdKH());
            }
        }
        kh.setMaKH(makh);
        HoaDonViewModel hd = new HoaDonViewModel();
        txtMaKH.setText(makh);
        txtTenKH.setText(tblKhachHang.getValueAt(row, 1).toString());
        txtLoaiKH.setText(tblKhachHang.getValueAt(row, 2).toString());
        txtDiaChiKH.setText(tblKhachHang.getValueAt(row, 3).toString());
        String gt = tblKhachHang.getValueAt(row, 4).toString();
        if (gt.equalsIgnoreCase("Nam")) {
            rdoKHNam.setSelected(true);
        } else {
            rdoKHNu.setSelected(true);
        }
        txtKHEmail.setText(tblKhachHang.getValueAt(row, 5).toString());
        txtKHSdt.setText(tblKhachHang.getValueAt(row, 6).toString());
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(tblKhachHang.getValueAt(row, 7).toString());
            txtKHNgaySinh.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(BanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

//                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tblThongtinKH.getValueAt(row, 8).toString());
        String tt = tblKhachHang.getValueAt(row, 9).toString();
        if (tt.equalsIgnoreCase("Còn hoạt động")) {
            rdoKHCon.setSelected(true);
        } else {
            rdoKHNgung.setSelected(true);
        }
        lbltenkh.setText(tblKhachHang.getValueAt(row, 1).toString());
        if (lblHoaDon.getText().equalsIgnoreCase("Hóa Đơn Trống")) {
            JOptionPane.showMessageDialog(this, "Moi chon hoa don");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Ban co muon them khach hang khong?", "Thong Bao", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        hd.setIdKH(kh);
        hd.setMaHD(lblHoaDon.getText());
        if (hoaDonService.updateHoaDon(hd) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhập thông tin hóa đơn thành công");
            loadhoadon();
        }


    }//GEN-LAST:event_tblKhachHangMouseClicked
    public void loadGioHangbyIDCoKM(String id, double giamGia) {
        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listHDCTNew = new ArrayList<>();
        for (HoaDonChiTiet h : listHDCT) {
            if (h.getIdHD().getIdHD() != null && h.getIdHD().getIdHD().equals(id)) {
                listHDCTNew.add(h);
            }
        }
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmGH.setRowCount(0);
        for (HoaDonChiTiet hd : listHDCTNew) {
            dtmGH.addRow(new Object[]{
                hd.getIdCTSP().getIdSP().getTenSP(),
                hd.getSoLuong(),
                hd.getDonGia(),
                Double.valueOf(hd.getDonGia().toString()) * hd.getSoLuong() * giamGia / 100
            });
        }
    }
    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // lấy ra index của bảng hóa đơn
        String maHD = lblHoaDon.getText();
        if (maHD.trim().equalsIgnoreCase("hóa đơn trống")) {
            JOptionPane.showMessageDialog(this, "Mời bạn chọn hóa đơn !");
            return;
        }

        hoadonchitietviewmodel h = new hoadonchitietviewmodel();
        String soLuong = JOptionPane.showInputDialog(this, "Mời bạn chọn số lượng");
        // lấy ra index của bảng sản phẩm
        int indexSP = tblSanPham.getSelectedRow();
        int slTon = Integer.valueOf(tblSanPham.getValueAt(indexSP, 3).toString());
        if (slTon <= 0) {
            JOptionPane.showMessageDialog(this, "Hết hàng");
            return;
        }
        if (Integer.valueOf(soLuong) > slTon) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn không đủ");
            return;
        }
        String idCTSP = tblSanPham.getValueAt(indexSP, 0).toString();
        String maSP = tblSanPham.getValueAt(indexSP, 1).toString();
        String donGia = tblSanPham.getValueAt(indexSP, 2).toString();
        HoaDon newHD = new HoaDon();
        ArrayList<HoaDonViewModel> listHD = hoaDonService.getAllhoadon();
        for (HoaDonViewModel x : listHD) {
            if (x.getMaHD() != null && x.getMaHD().equals(maHD)) {
                newHD.setIdHD(x.getIdHD());
            }
        }
        h.setDonGia(BigDecimal.valueOf(Integer.valueOf(donGia)));
        h.setIdHD(newHD);

        // lấy ra ID CTSP và thêm vào hóa đơn chi tiết
        ChiTietSanPham ctspNew = new ChiTietSanPham();
        ArrayList<ChiTietSanPhamModel> listCTSP = chiTietSanPhamService.getAllChiTietSanPham();
        for (ChiTietSanPhamModel z : listCTSP) {
            if (z.getIdCTSP() != null && z.getIdCTSP().equals(idCTSP)) {
                ctspNew.setIdCTSP(z.getIdCTSP());
            }
        }

        h.setIdCTSP(ctspNew);

        if (h == null) {
            return;
        }
        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listHDCTNew = new ArrayList<>();
        for (HoaDonChiTiet y : listHDCT) {
            if (y.getIdHD().getIdHD() != null && y.getIdHD().getIdHD().equals(newHD.getIdHD())) {
                listHDCTNew.add(y);
            }
        }
        int dem = 0;
        for (HoaDonChiTiet y1 : listHDCTNew) {

            if (y1.getIdCTSP().getIdCTSP().equals(idCTSP)) {
                if (y1.getSoLuong() == slTon || ((y1.getSoLuong()) + Integer.valueOf(soLuong)) > slTon) {
                    JOptionPane.showMessageDialog(this, "Không thể vượt quá số lượng đang có");
                    return;
                }
                h.setSoLuong(y1.getSoLuong() + Integer.valueOf(soLuong));
                hoaDonChiTieservice.updateHDCT(h);
                loadGioHangbyID(newHD.getIdHD());
                dem++;
//                loadTableBanHang();
            }

        }
        if (dem == 0) {
            h.setSoLuong(Integer.valueOf(soLuong));
            hoaDonChiTieservice.inserthdct(h);
            loadGioHangbyID(newHD.getIdHD());
            tongTien();
        }
        KhuyenMaiResbonsitory kmr = new KhuyenMaiResbonsitory();
        for (KhuyenMai x : kmr.getAllKM()) {
            if (chiTietSanPhamService.getChiTietSanPhamByidkmd(ctspNew.getIdCTSP()).getIdKM().equals(x.getIdKM())) {
                loadGioHangbyIDCoKM(newHD.getIdHD(), Double.valueOf(String.valueOf(x.getGiaTri())));
            }
        }


    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtTimKiemBHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemBHFocusGained

    }//GEN-LAST:event_txtTimKiemBHFocusGained

    private void tblGioHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangMouseEntered

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int indexGH = tblGioHang.getSelectedRow();
        int indexHD = tblHoaDon.getSelectedRow();
        String idHD = "";
        String idCTSP = tblGioHang.getValueAt(indexGH, 0).toString();
        ArrayList<ChiTietSanPhamModel> listCTSP = chiTietSanPhamService.getAllChiTietSanPham();
                ArrayList<ChiTietSanPhamModel> listCTSPNEW = new ArrayList<>();
        for (ChiTietSanPhamModel xy : listCTSP){
            if (xy.getIdCTSP()!=null && xy.getIdCTSP().equals(idCTSP)){
                listCTSPNEW.add(xy);
            }
        }
        ArrayList<HoaDonViewModel> listHD = hoaDonService.getAllhoadon();
        for (HoaDonViewModel h : listHD){
            if (h.getMaHD()!=null && h.getMaHD().equals(tblHoaDon.getValueAt(indexHD, 0).toString())){
                idHD = h.getIdHD();
            }
        }
        String soLuong = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng");
        if (soLuong == null){
            return;
        }
        int sl = Integer.valueOf(soLuong);
        if (sl <0){
            return;
        }
        else if (sl == 0){
            if (hoaDonChiTieservice.deleteHDCT(idHD, idCTSP) > 0){
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadGioHangbyID(idHD);
            }
        }
        else if (sl > listCTSPNEW.get(0).getSoLuong()){
            JOptionPane.showMessageDialog(this, "Số lượng tồn không đủ");
            return;
        } else {
            hoadonchitietviewmodel hdct = new hoadonchitietviewmodel();
            ChiTietSanPham c = new ChiTietSanPham();
            c.setIdCTSP(idCTSP);
            HoaDon x = new HoaDon();
            x.setIdHD(idHD);
            hdct.setSoLuong(sl);
            hdct.setIdCTSP(c);
            hdct.setIdHD(x);
            hoaDonChiTieservice.updateHDCT(hdct);
            loadGioHangbyID(idHD);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        }
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void txtThanhTienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtThanhTienFocusGained
        txtThanhTien.setText("");
    }//GEN-LAST:event_txtThanhTienFocusGained

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        CardLayout layout = (CardLayout) pncardgoc.getLayout();
        layout.show(pncardgoc, "hoadon");

        chon = 2;
        changeBackgroud_SP_KH();
        loadhoadon();
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        HoaDonViewModel hdNew = new HoaDonViewModel();
//        int indexKH = tblKhachHang.getSelectedRow();
//        KhachHang khNew = new KhachHang();
//        ArrayList<KhachHangModel> listKH = khachHangService.getAllKhachHang();
//        for (KhachHangModel k : listKH) {
//            if (k.getMaKH() != null && k.getMaKH().equals(tblKhachHang.getValueAt(indexKH, 0).toString())) {
//                khNew.setIdKH(k.getIdKH());
//            }
//        }
//        khNew.setMaKH(txtMaKH.getText());
//        khNew.setTenKH(txtTenKH.getText());
//        khNew.setDiaChi(txtDiaChi.getText());
//        khNew.setSdt(txtSDT.getText());
        NhanVien nvNew = new NhanVien();
        ArrayList<NhanVienModel> listNV = nhanVienService.getAllNV();
        for (NhanVienModel n : listNV) {
            if (n.getMaNV() != null && n.getMaNV().equals(Views.DangNhap.nv.getMaNV())) {
                nvNew.setIdNV(n.getIdNV());
                nvNew.setMaNV(n.getMaNV());
                nvNew.setHoTen(n.getHoTen());
            }
        }

        hdNew.setIdKH(null);
        hdNew.setIdNV(nvNew);
        hdNew.setTrangThai(0);
        ArrayList<HoaDonViewModel> listHD = hoaDonService.getAllhoadon();
        int so = listHD.size() + 1;
        String maHD = "HD" + so;
        hdNew.setMaHD(maHD);

        if (hdNew == null) {
            return;
        }
        if (hoaDonService.insertHoaDon(hdNew) != null) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
            loadhoadon();
        } else {
            JOptionPane.showMessageDialog(this, "Tạo thất bại");
        }
//       loadhoadon();


    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int indexHD = tblHoaDon.getSelectedRow();
        ArrayList<HoaDonViewModel> listHD = hoaDonService.getAllhoadon();

        String idHD = "";
        for (HoaDonViewModel x : listHD) {
            if (x.getMaHD() != null && x.getMaHD().equals(tblHoaDon.getValueAt(indexHD, 0).toString())) {
                idHD = x.getIdHD();
                hd = hoaDonRespon.gethdByID(idHD);
            }
        }

        lblHoaDon.setText(tblHoaDon.getValueAt(indexHD, 0).toString());
        lbltenkh.setText(tblHoaDon.getValueAt(indexHD, 2).toString());
//        String kh=tblHoaDon.getValueAt(indexHD, 2).toString();
//        if(kh.isEmpty()){
//            lbltenkh.setText("Khách lẻ");
//        }else{
//            lbltenkh.setText(kh);
//        }
        loadGioHangbyID(idHD);
        tongTien();
//        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon();
//        ArrayList<HoaDonChiTiet> listHDCTNew = new ArrayList<>();
//        for (HoaDonChiTiet h : listHDCT) {
//            if (h.getIdHD().getIdHD() != null && h.getIdHD().getIdHD().equals(idHD)) {
//                listHDCTNew.add(h);
//            }
//        }
//        dtmGH = (DefaultTableModel) tblGioHang.getModel();
//        dtmGH.setRowCount(0);
//        for (HoaDonChiTiet hd : listHDCTNew) {
//            dtmGH.addRow(new Object[]{
//                hd.getIdCTSP().getIdSP().getTenSP(),
//                hd.getSoLuong(),
//                hd.getDonGia(),
//                Integer.valueOf(hd.getDonGia().toString()) * hd.getSoLuong()
//            });
//        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnQuetBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetBarActionPerformed
        new QRCode(tblGioHang, tblHoaDon, this).setVisible(true);


    }//GEN-LAST:event_btnQuetBarActionPerformed

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoHoaDonMouseClicked
    public KhachHangModel getMa(String ma) {
        for (KhachHangModel kh : khachHangService.getAllKhachHang()) {
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
    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        KhachHangModel kh = getFormData();
        if (kh == null) {
            return;
        }
        if (getMa(kh.getMaKH()) != null) {
            JOptionPane.showMessageDialog(this, "Đã có mã này");
            return;
        }
        if (khachHangService.insertKhachHang(kh) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadKhachHang();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKHActionPerformed
        int row = tblKhachHang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        KhachHangModel kh = getFormData();
        if (kh == null) {
            return;
        }
        if (khachHangService.updateKhachHang(kh) != null) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadKhachHang();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaKHActionPerformed

    private void btnGiaoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoHangActionPerformed
        new GiaoHang().setVisible(true);
    }//GEN-LAST:event_btnGiaoHangActionPerformed
    private NhanVien getNV(String id) {
        ArrayList<NhanVien> listnv = nhanVienRespon.getNVLam();
        for (NhanVien nhanVien : listnv) {
            if (nhanVien.getIdNV().equals(id)) {
                return nhanVien;
            }
        }
        return null;
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int indexHD = tblHoaDon.getSelectedRow();
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(this, "Mời bạn chọn hóa đơn");
            return;
        }
        ArrayList<ChiTietSanPhamModel> listCTSP = chiTietSanPhamService.getAllChiTietSanPham();
        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listHDCTNew = new ArrayList<>();
        for (HoaDonChiTiet y : listHDCT) {
            if (y.getIdHD().getMaHD() != null && y.getIdHD().getMaHD().equals(tblHoaDon.getValueAt(indexHD, 0).toString())) {
                listHDCTNew.add(y);
            }
        }
        int dem = 0;
        for (HoaDonChiTiet y1 : listHDCTNew) {
            for (ChiTietSanPhamModel y2 : listCTSP) {
                if (y1.getIdCTSP().getIdCTSP().equals(y2.getIdCTSP())) {
                    if (y1.getSoLuong() > y2.getSoLuong() ) {
                        JOptionPane.showMessageDialog(this, y1.getIdCTSP().getIdSP().getTen()+" không thể vượt quá số lượng đang có");
                        return;
                    }
                }
            }
        }

        hd.setMaHD(tblHoaDon.getValueAt(indexHD, 0).toString());
        hd.setThanhTien(BigDecimal.valueOf(Float.valueOf(txtThanhTien.getText())));

        new ThanhToanHoaDonJFrame(this, hd).setVisible(true);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed
       new GiaoHang().setVisible(true);
    }//GEN-LAST:event_btnDatHangActionPerformed

    private void changeBackgroud_SP_KH() {
        switch (chon) {
            case 1 -> {
                btnSanpham.setBackground(new Color(153, 255, 153));
                btnHoaDon.setBackground(null);
                btnKhBh.setBackground(null);
                txtTimKiemBH.setText("Tìm Kiếm Sản Phẩm");
            }
            case 0 -> {
                btnKhBh.setBackground(new Color(153, 255, 153));
                btnSanpham.setBackground(null);
                btnHoaDon.setBackground(null);
                txtTimKiemBH.setText("Tìm Kiếm Khách Hàng");
            }
            default -> {
                btnHoaDon.setBackground(new Color(153, 255, 153));
                btnSanpham.setBackground(null);
                btnKhBh.setBackground(null);
                txtTimKiemBH.setText("Tìm kiếm Hóa Đơn");
            }
        }
    }

    private void tongTien() {
        float tong = 0;
        ArrayList<HoaDonChiTiet> listHDCTM = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listNew = new ArrayList<>();
        for (HoaDonChiTiet x : listHDCTM) {
            if (x.getIdHD() != null && x.getIdHD().getMaHD().equals(lblHoaDon.getText())) {
                listNew.add(x);
            }
        }

        for (HoaDonChiTiet y : listNew) {
            if (y.getIdCTSP().getIdKM()!=null){
            tong += Float.valueOf(thanhTien(y.getIdCTSP().getIdKM().getApDungGiamGia(), y.getIdCTSP().getIdKM().getGiaTri(), y.getIdCTSP().getIdKM().getGiamToiDa(), y.getDonGia()).toString()) * y.getSoLuong();
}
            else {
                tong += (Float.valueOf(y.getDonGia().toString())*y.getSoLuong());
            }
        }
        txtThanhTien.setText(String.valueOf(tong));
        lbltongtien.setText(String.valueOf(tong));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane HoaDon;
    private javax.swing.JPanel Khach;
    private javax.swing.JScrollPane Sanpham;
    private javax.swing.JPanel ThanhToan;
    private javax.swing.JButton btnDatHang;
    private javax.swing.JButton btnGiaoHang;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhBh;
    private javax.swing.JButton btnQuetBar;
    private javax.swing.JButton btnSanpham;
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnTimKiemBH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpanel;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lbltenkh;
    private javax.swing.JLabel lbltongtien;
    private javax.swing.JPanel pncardgoc;
    private javax.swing.JRadioButton rdoKHCon;
    private javax.swing.JRadioButton rdoKHNam;
    private javax.swing.JRadioButton rdoKHNgung;
    private javax.swing.JRadioButton rdoKHNu;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JTextField txtKHEmail;
    private com.toedter.calendar.JDateChooser txtKHNgaySinh;
    private javax.swing.JTextField txtKHSdt;
    private javax.swing.JTextField txtLoaiKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiemBH;
    // End of variables declaration//GEN-END:variables

}
