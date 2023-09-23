/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import Services.ChiTietSanPhamService;
import Services.HoaDonChiTieservice;
import Services.KhachHangService;
import Services.KhuyenMaiService;
import Services.NhanVienService;
import Services.SanPhamService;
import Services.hoadonservice;
import Utilities.DBConnection;
import ViewModels.ChiTietSanPhamModel;
import ViewModels.HoaDonViewModel;
import ViewModels.KhachHangModel;
import ViewModels.KhuyenMaiModel;
import ViewModels.hoadonchitietviewmodel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.math.BigDecimal;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.BreakIterator;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import responsitories.ChiTietSanPhamResponsitory;
import responsitories.HoaDonResponsitory;
import responsitories.KhachHangResponsitory;
import responsitories.NhanVienResponsitory;

/**
 *
 * @author duong
 */
public class BanHangPanel extends javax.swing.JPanel {

    private DefaultTableModel dtmSP = new DefaultTableModel();
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private final ChiTietSanPhamService chiTietSanPhamService;
    private final ChiTietSanPhamResponsitory ctspr;
    private final SanPhamService sanPhamService;
    private final KhachHangService khachHangService;
    private final KhachHangResponsitory khachHangrespon;
    private final hoadonservice hoaDonService;
    private final HoaDonResponsitory hoaDonRespon;
    private final NhanVienService nhanVienService;
    private final NhanVienResponsitory nhanVienRespon;
    private final KhuyenMaiService khuyenMaiService;
    private final HoaDonChiTieservice hoaDonChiTieservice;
    public static HoaDonViewModel hoadon = null;
    public static String tienKhach;
    public static String tienTra;
    public static String tongTien;
    public static String tienGiam;
    public static String diemKH="0";
    
    
    
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat df = NumberFormat.getInstance(localeVN);

    /**
     * Creates new form BanHangJpanel1
     */
    public BanHangPanel() {
        initComponents();
        chiTietSanPhamService = new ChiTietSanPhamService();
        ctspr = new ChiTietSanPhamResponsitory();
        khachHangService = new KhachHangService();
        khachHangrespon = new KhachHangResponsitory();
        sanPhamService = new SanPhamService();
        hoaDonChiTieservice = new HoaDonChiTieservice();
        hoaDonService = new hoadonservice();
        hoaDonRespon = new HoaDonResponsitory();
        nhanVienService = new NhanVienService();
        nhanVienRespon = new NhanVienResponsitory();
        khuyenMaiService = new KhuyenMaiService();
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        btnHuyKH.setEnabled(false);
        btnChonKH.setEnabled(false);
        load();
        loadHDCho();
        loadSP();
        
        tblHoaDon.getTableHeader().setBackground(Color.pink);
        tblGioHang.getTableHeader().setBackground(Color.pink);
        tblSanPham.getTableHeader().setBackground(Color.pink);
        tblSanPham.getColumnModel().getColumn(1).setCellRenderer(new MyCellRenderer());
        tblGioHang.getColumnModel().getColumn(1).setCellRenderer(new MyCellRenderer());
    }
     public class MyCellRenderer extends JTextArea implements TableCellRenderer {

        public MyCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
            setBorder(new EmptyBorder(8, 10, 8, 10));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            setText(value.toString());//or something in value, like value.getNote()...
            setSize(table.getColumnModel().getColumn(column).getWidth(),
                    getPreferredSize().height);
            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            
            if (isSelected) {
                
                setBackground(table.getSelectionBackground());
            } else {
                
                setBackground(table.getBackground());
            }

            return this;

        }
    }

  

    public void loadhoadon() {
        ArrayList<HoaDonViewModel> list = hoaDonService.gethoadonCho();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmHD.setRowCount(0);
        Collections.sort(list, Comparator.comparing(HoaDonModel -> HoaDonModel.getMaHD()));
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

    private float giamGia(String hinhThuc, float giaTien) {
        float gia = 0;
        if (hinhThuc.contains("%")) {
            gia = giaTien - (Float.valueOf(hinhThuc.trim().substring(0, hinhThuc.length() - 1)) / 100 * giaTien);

        } else {
            gia = giaTien - Integer.valueOf(hinhThuc);
        }
        return gia;
    }



    private void tongTien() {
        int tong = 0;
        ArrayList<HoaDonChiTiet> listHDCTM = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listNew = new ArrayList<>();
        for (HoaDonChiTiet x : listHDCTM) {
            if (x.getIdHD() != null && x.getIdHD().getMaHD().equals(txtMaHD.getText())) {
                listNew.add(x);
            }
        }
        
        for (HoaDonChiTiet y : listNew) {
            tong += (Integer.valueOf(y.getDonGia().toString()));

        }
        
        txtTongTien.setText(String.valueOf(tong));
        hoadon.setThanhTien(BigDecimal.valueOf(tong));
        tongTien=String.valueOf(tong);
    }

    public void loadGioHang() {
        int row = tblHoaDon.getSelectedRow();
        String ma = tblHoaDon.getValueAt(row, 0).toString();
        String id = "";
        ArrayList<HoaDonViewModel> listHD = hoaDonService.getAllhoadon();
        for (HoaDonViewModel hdm : listHD) {
            if (hdm.getMaHD().equals(ma)) {
                id = hdm.getIdHD();

            }
        }

        ArrayList<HoaDonChiTiet> listGH = hoaDonChiTieservice.getAllhoadon_byMa(id);
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmGH.setRowCount(0);
        for (HoaDonChiTiet x : listGH) {
            dtmGH.addRow(new Object[]{
                x.getIdCTSP(),
                x.getIdCTSP().getIdSP().getTen() + "," + x.getIdCTSP().getIdSize().getTenSize() + ", " + x.getIdCTSP().getIdDC().getTenDC() + ", " + x.getIdCTSP().getIdMS().getTenMS() + ", " + x.getIdCTSP().getIdDM().getTenDM() + ", " + x.getIdCTSP().getIdCL().getTenCL(),
                x.getDonGia(),
                x.getSoLuong(),
                x.getIdCTSP().getIdKM() == null ? "Nguyên giá" : checkKM(x.getIdCTSP().getIdKM()),
                x.getDonGia()
        });
    }
    }

    public ChiTietSanPhamModel getCTSP(String id) {
        return chiTietSanPhamService.getChiTietSanPhamByid(id).get(0);
    }

    private BigDecimal thanhTien(String loai, BigDecimal giaTri, BigDecimal giaTriMax, BigDecimal donGia) {
        BigDecimal thanhTien_KM = null;
        float gia = 0;

        if (loai.contains("%")) {
            if ((Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString())) > Float.valueOf(giaTriMax.toString())) {
                gia = Float.valueOf(donGia.toString()) - Float.valueOf(giaTriMax.toString());

            } else {
                gia = Float.valueOf(donGia.toString()) - (Float.valueOf(giaTri.toString()) / 100 * Float.valueOf(donGia.toString()));

            }
        } else {
            gia = Float.valueOf(donGia.toString()) - Float.valueOf(giaTri.toString());

        }

        thanhTien_KM = BigDecimal.valueOf(gia);
        return thanhTien_KM;
    }

    public void loadSP() {
        ArrayList<ChiTietSanPhamModel> list = chiTietSanPhamService.getChiTietSanPhamBan();
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        dtmSP.setRowCount(0);

        Collections.sort(list, Comparator.comparing(ChiTietSanPhamModel -> ChiTietSanPhamModel.getMaQR()));
        for (ChiTietSanPhamModel ctspM : list) {
            dtmSP.addRow(new Object[]{
                ctspM.getMaQR(),
                ctspM.getIdSP().getTenSP() + ",\n " + ctspM.getIdSize().getTenSize() + ", " + ctspM.getIdDC().getTenDC() + ", " + ctspM.getIdMS().getTenMS() + ", " + ctspM.getIdDM().getTenDM() + ", " + ctspM.getIdCL().getTenCL(),
                ctspM.getGiaBan(),
                ctspM.getSoLuong(),
                ctspM.getIdKM() == null ? "Nguyên giá" : checkKM(ctspM.getIdKM()),
                ctspM.getIdKM() == null ? df.format(ctspM.getGiaBan()) : checkGiaKM(ctspM.getIdKM(), ctspM)

            });
        }
    }

    public String checkKM(KhuyenMai k) {
        Date now = new Date();
        if (k.getNgayBatDau().after(now)) {
            return "Nguyên giá";
        } else {
            return k.getTenKM();
        }
    }

    public String checkGiaKM(KhuyenMai k, ChiTietSanPhamModel ctspM) {
        Date now = new Date();
        if (k.getNgayBatDau().after(now)) {
            return String.valueOf(df.format(ctspM.getGiaBan()));
        } else {
            return String.valueOf(df.format(thanhTien(ctspM.getIdKM().getHinhThucApDung(), ctspM.getIdKM().getGiaTri(), ctspM.getIdKM().getGiamToiDa(), ctspM.getGiaBan())));
        }
    }

    public void loadHDCho() {
        ArrayList<HoaDonViewModel> list = hoaDonService.gethoadonCho();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmHD.setRowCount(0);
        Collections.sort(list, Comparator.comparing(HoaDonModel -> HoaDonModel.getMaHD()));
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

    public void voucher() {
        if (hoadon.getIdKM() != null) {
            txtMaCoupon.setText(hoadon.getIdKM().getMaKM());
        } else {
            txtMaCoupon.setText("0");
        }
    }

    public void loadThanhToan() {
        
        txtSDT.setText("");
        txtTenKH.setText("");
        txtMaHD.setText("");
        txtTienKH.setText("");
        txtTongTien.setText("");
        txtTienThua.setText("");
        txtNhanVien.setText("");
        txtGhiChu.setText("");
        txtGiamGia.setText("");
        txtMaCoupon.setText("");
        txtDiem.setText("");
        cbbHinhThucTT.setSelectedIndex(0);
        dtmGH.setRowCount(0);
        
        loadSP();
        loadHDCho();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBanHang = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSP = new javax.swing.JButton();
        btnQuet = new javax.swing.JButton();
        btnXoaGH = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemSP = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        btnChonKH = new javax.swing.JButton();
        btnHuyKH = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtTienKH = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtMaCoupon = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cbbHinhThucTT = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        btnHuyVoucher = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        txtNhanVien = new javax.swing.JTextField();
        btnTTvaIn = new javax.swing.JButton();
        btnVoucher = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        btnSuDungDiem = new javax.swing.JButton();
        btnHuyDiem = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHD = new javax.swing.JButton();
        btnHuyHD = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        JBanHang.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BarCode", "Tên sản phẩm", "Đơn giá", "SL", "CTKM", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.setRowHeight(25);
        tblGioHang.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane4.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        btnXoaSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoaSP.png"))); // NOI18N
        btnXoaSP.setText("Xóa");
        btnXoaSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnQuet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barcode-scan.png"))); // NOI18N
        btnQuet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetActionPerformed(evt);
            }
        });

        btnXoaGH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoaGH1.png"))); // NOI18N
        btnXoaGH.setText("Xóa giỏ hàng");
        btnXoaGH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnQuet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaGH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnQuet, btnXoaGH, btnXoaSP});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaGH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(btnQuet, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnXoaGH, btnXoaSP});

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BarCode", "Tên sản phẩm", "Gía bán", "SL", "CTKM", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setRowHeight(25);
        tblSanPham.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(35);
            tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(350);
            tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jLabel1.setText("Tìm kiếm ");

        txtTimKiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn hàng"));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setOpaque(false);

        jLabel30.setText("Số điện thoại");

        txtSDT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSDT.setEnabled(false);

        jLabel31.setText("Tên KH");

        txtTenKH.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTenKH.setEnabled(false);

        btnChonKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-user.png"))); // NOI18N
        btnChonKH.setText("Chọn");
        btnChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKHActionPerformed(evt);
            }
        });

        btnHuyKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        btnHuyKH.setText("Hủy");
        btnHuyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHuyKH)
                    .addComponent(btnChonKH))
                .addGap(16, 16, 16))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtSDT, txtTenKH});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnChonKH, btnHuyKH});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyKH))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtSDT, txtTenKH});

        jLabel32.setText("Mã HĐ");

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaHD.setForeground(new java.awt.Color(255, 0, 0));
        txtMaHD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaHD.setEnabled(false);

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(255, 0, 0));
        txtTongTien.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTongTien.setEnabled(false);

        jLabel33.setText("Tổng tiền");

        txtTienKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKH.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKHCaretUpdate(evt);
            }
        });

        jLabel34.setText("Tiền khách đưa");

        txtTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienThua.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTienThua.setEnabled(false);

        jLabel35.setText("Tiền thừa");

        jLabel36.setText("Phương thức thanh toán");

        txtMaCoupon.setEditable(false);
        txtMaCoupon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaCoupon.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaCoupon.setEnabled(false);
        txtMaCoupon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMaCouponCaretUpdate(evt);
            }
        });

        jLabel37.setText("Voucher");

        jLabel39.setText("Giảm giá");

        cbbHinhThucTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbHinhThucTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Thẻ" }));

        jLabel40.setText("Nhân Viên");

        jLabel41.setText("Ghi chú");

        btnHuyVoucher.setText("Hủy");
        btnHuyVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyVoucherActionPerformed(evt);
            }
        });

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel38.setText("VND");

        jLabel42.setText("VND");

        jLabel43.setText("VND");

        jLabel44.setText("VND");

        txtGiamGia.setEditable(false);
        txtGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiamGia.setText("0");
        txtGiamGia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtGiamGia.setEnabled(false);
        txtGiamGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamGiaCaretUpdate(evt);
            }
        });

        txtNhanVien.setEditable(false);
        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNhanVien.setForeground(new java.awt.Color(255, 51, 51));
        txtNhanVien.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNhanVien.setEnabled(false);

        btnTTvaIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer.png"))); // NOI18N
        btnTTvaIn.setText("Thanh Toán + In");
        btnTTvaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTvaInActionPerformed(evt);
            }
        });

        btnVoucher.setText("Sử dụng");
        btnVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoucherActionPerformed(evt);
            }
        });

        jLabel45.setText("Điểm EXP");

        txtDiem.setEditable(false);
        txtDiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDiem.setEnabled(false);

        btnSuDungDiem.setText("Sử dụng");
        btnSuDungDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungDiemActionPerformed(evt);
            }
        });

        btnHuyDiem.setText("Hủy");
        btnHuyDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbHinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTienKH, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtMaCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnVoucher)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHuyVoucher))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSuDungDiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHuyDiem))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(btnTTvaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbHinhThucTT, txtDiem, txtGiamGia, txtMaCoupon, txtMaHD, txtTienKH, txtTienThua, txtTongTien});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnTTvaIn, btnThanhToan});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtTienKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(cbbHinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtMaCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoucher)
                    .addComponent(btnHuyVoucher))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(btnSuDungDiem)
                    .addComponent(btnHuyDiem)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTTvaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan))
                .addGap(25, 25, 25))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbHinhThucTT, txtDiem, txtGiamGia, txtMaCoupon, txtMaHD, txtNhanVien, txtTienThua, txtTongTien});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTTvaIn, btnThanhToan});

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Tên nhân viên", "Tên khách hàng", "Ngày tạo", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        btnTaoHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/themGH.png"))); // NOI18N
        btnTaoHD.setText("Tạo hóa đơn");
        btnTaoHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnHuyHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconDelete.png"))); // NOI18N
        btnHuyHD.setText("Hủy hóa đơn");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoHD)
                            .addComponent(btnHuyHD)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuyHD, btnTaoHD});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnTaoHD)
                        .addGap(23, 23, 23)
                        .addComponent(btnHuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuyHD, btnTaoHD});

        javax.swing.GroupLayout JBanHangLayout = new javax.swing.GroupLayout(JBanHang);
        JBanHang.setLayout(JBanHangLayout);
        JBanHangLayout.setHorizontalGroup(
            JBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JBanHangLayout.createSequentialGroup()
                .addGroup(JBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JBanHangLayout.setVerticalGroup(
            JBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JBanHangLayout.createSequentialGroup()
                .addGroup(JBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JBanHangLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JBanHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyVoucherActionPerformed
        txtMaCoupon.setText("0");
        double giamGia = 0;
        double giamPoint = 0;
        if (hoadon.getIdKM() != null) {
            KhuyenMaiModel km = getKhuyenMai(hoadon.getIdKM().getMaKM());  // lấy khuyến mãi            
            BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hoadon.getThanhTien());
            giamGia = hoadon.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();

        }
        if (hoadon.getIdKH() != null) {
            giamPoint = hoadon.getIdKH().getDiemEXP();
        }
        if (txtDiem.getText().equals("0")) {
            txtGiamGia.setText(String.valueOf(giamPoint));
        } else {
            txtGiamGia.setText("0");
        }
    }//GEN-LAST:event_btnHuyVoucherActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        String tienThua = txtTienThua.getText();
        String tongTien = txtTongTien.getText();
        float tong = Float.valueOf(tongTien);
        float tienKH = Float.valueOf(txtTienKH.getText());
        int tienThua_number = 0;
        if (tienThua != null) {
            tienThua_number = Integer.valueOf(tienThua);
        }
        if (tienKH < tong) {
            JOptionPane.showMessageDialog(null, "Chưa đủ điều kiện thanh toán");
            return;
        }

        int hinhThucThanhToan = cbbHinhThucTT.getSelectedIndex();
        String ghichu=txtGhiChu.getText();
        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon();
        ArrayList<HoaDonChiTiet> listNewHDCT = new ArrayList<>();
        hoadonchitietviewmodel hdctvm = new hoadonchitietviewmodel();
        ChiTietSanPhamModel ctsp = new ChiTietSanPhamModel();
        HoaDonViewModel h = new HoaDonViewModel();
        BigDecimal thanhTien = new BigDecimal(tongTien);
        h.setThanhTien(thanhTien);
        h.setMaHD(hoadon.getMaHD());
        h.setHinhThucThanhToan(hinhThucThanhToan);
        h.setGhiChu(ghichu);
        KhuyenMai kmn = new KhuyenMai();
        if (hoadon.getIdKM() != null) {
            h.setIdKM(hoadon.getIdKM());
        } else {
            h.setIdKM(kmn);
        }

        if (hoaDonService.updateHoaDon_ThanhToan(h) != null) {

            for (HoaDonChiTiet x : listHDCT) {
                if (x.getIdHD() != null && x.getIdHD().getMaHD().equals(txtMaHD.getText())) {
                    listNewHDCT.add(x);
                }
            }
            for (HoaDonChiTiet y : listNewHDCT) {
                hdctvm.setIdHDCT(y.getIdHDCT());
                ctsp.setIdCTSP(y.getIdCTSP().getIdCTSP());
                ctsp.setSoLuong(y.getSoLuong());
                chiTietSanPhamService.update_ThanhToan(ctsp);
                hoaDonChiTieservice.updateHDCT_ThanhToan(hdctvm);
            }
            
            tienKhach=txtTienKH.getText();
            tienTra=txtTienThua.getText();
            tienGiam=txtGiamGia.getText();
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
        }
        loadThanhToan();
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnQuetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetActionPerformed
        new QRCode(tblGioHang, tblHoaDon, this).setVisible(true);
    }//GEN-LAST:event_btnQuetActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        HoaDonViewModel hdHuy = new HoaDonViewModel();
        hdHuy.setMaHD(txtMaHD.getText());
        String lydo = JOptionPane.showInputDialog(null, "Vui lòng nhập lý do hủy?");
        if (lydo.isEmpty()) {
            return;
        }
        hdHuy.setGhiChu(lydo);
        if (hoaDonService.updateHoaDon_HUY(hdHuy) != null) {
            JOptionPane.showMessageDialog(null, "Hủy hóa đơn thành công");
            loadThanhToan();
        }
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void btnHuyDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDiemActionPerformed
        txtDiem.setText("" + hoadon.getIdKH().getDiemEXP());
        double giamGia = 0;
        double giamPoint = 0;
        if (hoadon.getIdKM() != null) {
            KhuyenMaiModel km = getKhuyenMai(hoadon.getIdKM().getMaKM());  // lấy khuyến mãi            
            BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hoadon.getThanhTien());
            giamGia = hoadon.getThanhTien().doubleValue() - giaSauGiamVoucher.doubleValue();

        }
        KhachHangModel kh = new KhachHangModel();
        if (hoadon.getIdKH() != null) {
            kh.setMaKH(hoadon.getIdKH().getMaKH());
//            kh.setDiemEXP((int) Math.round(Double.valueOf(txtDiem.getText())));
//            kh.setDiemEXP((int) (Double.valueOf(txtTongTien.getText()) / 1000));
                kh.setDiemEXP(hoadon.getIdKH().getDiemEXP());
            khachHangService.updateExp_KhachHang(kh);
        } else {
            kh.setMaKH(null);
        }
        diemKH="0";
        if (!txtMaCoupon.getText().equals("0")) {
            txtGiamGia.setText(String.valueOf(giamGia));
        } else {
            txtGiamGia.setText("0");
        }
    }//GEN-LAST:event_btnHuyDiemActionPerformed

    private void btnHuyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyKHActionPerformed

        int indexHD = tblHoaDon.getSelectedRow();
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn");
            return;
        }
        String maHD = tblHoaDon.getValueAt(indexHD, 0).toString();
        HoaDonViewModel hd = new HoaDonViewModel();
        hd.setMaHD(maHD);
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy chọn khách hàng hiện tại", "Thông báo", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        if (hoaDonService.updateHoaDon_HuyKH(hd) != null) {
            txtTenKH.setText("Khách lẻ");
            txtSDT.setText("");
            JOptionPane.showMessageDialog(null, "Hủy chọn thành công");
            loadHDCho();
        }


    }//GEN-LAST:event_btnHuyKHActionPerformed

    private void btnTTvaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTvaInActionPerformed
        btnThanhToanActionPerformed(evt);
        System.out.println(hoadon.getMaHD());
        try {
            Hashtable map = new Hashtable();
            JasperReport rpt;

            rpt = JasperCompileManager.compileReport("src\\Views\\rptHoaDon.jrxml");

            map.put("MaHD", hoadon.getMaHD());
            map.put("TienKhachTra", tienKhach);
            map.put("tienThoi", tienTra);
            map.put("tongTien", tongTien);
            map.put("tienGiam", tienGiam);
            map.put("diemKH", diemKH);
            JasperPrint p = JasperFillManager.fillReport(rpt, map, DBConnection.getConnection());

            JasperViewer.viewReport(p, false);

        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnTTvaInActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        HoaDonViewModel hdNew = new HoaDonViewModel();
        NhanVien nvNew = nhanVienRespon.getNVByID(DangNhap.nv.getIdNV());

        hdNew.setIdNV(nvNew);
        hdNew.setTrangThai(0);
        ArrayList<HoaDonViewModel> listHD = hoaDonService.getAllhoadon();
        int so = listHD.size() + 1;
        String maHD = "HD" + so;
        hdNew.setMaHD(maHD);

        if (hdNew == null) {
            return;
        }
        ArrayList<HoaDonViewModel> listCho=hoaDonService.gethoadonCho();
        if(listCho.size()>=10){
            JOptionPane.showMessageDialog(null, "Đã đạt tối đa 10 hóa đơn. Vui lòng thanh toán hóa đơn chờ");
            return;
        }
        if (hoaDonService.insertHoaDon(hdNew) != null) {
            JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công");
            loadhoadon();
        } else {
            JOptionPane.showMessageDialog(null, "Tạo thất bại");
        }
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        if (index >= 0) {
            btnChonKH.setEnabled(true);
            btnHuyKH.setEnabled(true);
        }
        KhachHang kh = new KhachHang();
        ArrayList<HoaDonViewModel> listHD = hoaDonService.getAllhoadon();
        String maHD = tblHoaDon.getValueAt(index, 0).toString();

        int hinhThucTT = 0;
        for (HoaDonViewModel x : listHD) {
            if (x.getMaHD() != null && x.getMaHD().equals(maHD)) {
                hinhThucTT = x.getHinhThucThanhToan();
                kh = x.getIdKH();
                hoadon = x;
            }
        }
        if (kh != null) {
            hoadon.setIdKH(kh);
            txtSDT.setText(kh.getSdt());
            txtDiem.setText(kh.getDiemEXP() + "");
        } else {
            txtSDT.setText("");
            txtDiem.setText("0");
        }
        cbbHinhThucTT.setSelectedIndex(hinhThucTT);
        txtMaHD.setText(tblHoaDon.getValueAt(index, 0).toString());
        txtTenKH.setText(tblHoaDon.getValueAt(index, 2).toString());
        txtNhanVien.setText(tblHoaDon.getValueAt(index, 1).toString());
        loadGioHang();
        tongTien();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTienKHCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKHCaretUpdate
        try {
            String tienKH = "";
            int tienThanhToan = 0;
            if (!txtTienKH.getText().trim().isEmpty()) {
                tienKH = txtTienKH.getText();
                tienThanhToan = Integer.valueOf(tienKH);
            }
            int tong = Integer.valueOf(txtTongTien.getText());
            if (tienThanhToan >= tong) {
                txtTienThua.setText(String.valueOf(tienThanhToan - tong));
            } else {
                txtTienThua.setText("0");

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtTienKHCaretUpdate
    public void loadChonKH(String ten, String sdt) {
        txtTenKH.setText(ten);
        txtSDT.setText(sdt);
    }    public void getSPTheoMa(){
        String timKiem = txtTimKiemSP.getText();
        String thongTinSP = "";
        ArrayList<ChiTietSanPhamModel> listSP = chiTietSanPhamService.getChiTietSanPhamByQR(timKiem);
        ArrayList<ChiTietSanPhamModel> listSPNew = new ArrayList<>();
        
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        dtmSP.setRowCount(0);
        Collections.sort(listSPNew, Comparator.comparing(ChiTietSanPhamModel -> ChiTietSanPhamModel.getIdSP().getTen()));
        for (ChiTietSanPhamModel ctspM : listSP) {

            dtmSP.addRow(new Object[]{
                ctspM.getMaQR(),
                ctspM.getIdSP().getTenSP() + ", " + ctspM.getIdSize().getTenSize() + ", " + ctspM.getIdDC().getTenDC() + ", " + ctspM.getIdMS().getTenMS(),
                ctspM.getGiaBan(),
                ctspM.getSoLuong(),
                ctspM.getIdKM() == null ? "Nguyên giá" : ctspM.getIdKM().getTenKM(),
                ctspM.getIdKM() == null ? df.format(ctspM.getGiaBan()) : df.format(thanhTien(ctspM.getIdKM().getApDungGiamGia(), ctspM.getIdKM().getGiaTri(), ctspM.getIdKM().getGiamToiDa(), ctspM.getGiaBan()))

            });
        }
    }
    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        int indexGH = tblGioHang.getSelectedRow();
        if (indexGH < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xóa");
            return;
        }
        int indexHD = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(indexHD, 0).toString();
        String maSP = tblGioHang.getValueAt(indexGH, 0).toString();

        String idHD = "";
        String idCTSP = "";
        HoaDon hd = hoaDonRespon.gethdBymaHD(maHD);
        idHD = hd.getIdHD();
        ChiTietSanPhamModel c = chiTietSanPhamService.getChiTietSanPhamByQR(maSP).get(0);

        idCTSP = c.getIdCTSP();

        int xn = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sản phẩm khỏi giỏ hàng không?");
        if (xn == JOptionPane.YES_OPTION) {
            if (hoaDonChiTieservice.deleteHDCT(idHD, idCTSP) > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                loadGioHang();
            }
        }
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKHActionPerformed

        new KhachHang_BanHang(this, tblGioHang, tblHoaDon).setVisible(true);
    }//GEN-LAST:event_btnChonKHActionPerformed

    private void btnVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoucherActionPerformed

        new Voucher(this).setVisible(true);
    }//GEN-LAST:event_btnVoucherActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // lấy ra index của bảng hóa đơn
        int indexHD = tblHoaDon.getSelectedRow();
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(null, "Mời bạn chọn hóa đơn !");
            return;
        }
        String maHD = tblHoaDon.getValueAt(indexHD, 0).toString();
        hoadonchitietviewmodel h = new hoadonchitietviewmodel();
        String soLuong = JOptionPane.showInputDialog(this, "Mời bạn chọn số lượng");
        if (soLuong.isEmpty()){
            return;
        }
        // lấy ra index của bảng sản phẩm
        int indexSP = tblSanPham.getSelectedRow();
        int slTon = Integer.valueOf(tblSanPham.getValueAt(indexSP, 3).toString());
        if (slTon <= 0) {
            JOptionPane.showMessageDialog(null, "Hết hàng");
            return;
        }
        if (Integer.valueOf(soLuong) > slTon) {
            JOptionPane.showMessageDialog(null, "Số lượng tồn không đủ");
            return;
        }
        String idCTSP = "";
        String maSP = tblSanPham.getValueAt(indexSP, 0).toString();
        String donGia = tblSanPham.getValueAt(indexSP, 5).toString();
        HoaDon newHD = hoaDonRespon.gethdBymaHD(maHD);

        h.setDonGia(BigDecimal.valueOf(Integer.valueOf(donGia.replace(".", "")) * Integer.valueOf(soLuong)));
        h.setIdHD(newHD);

        // lấy ra ID CTSP và thêm vào hóa đơn chi tiết
        ChiTietSanPham ctspNew = ctspr.getChiTietSanPhamByMaQR(Integer.valueOf(maSP));
        idCTSP = ctspNew.getIdCTSP();
        h.setIdCTSP(ctspNew);

        if (h == null) {
            return;
        }
        ArrayList<HoaDonChiTiet> listHDCT =  hoaDonChiTieservice.getAllhoadon_byMa(newHD.getIdHD());
        
        
        int dem = 0;
        if (listHDCT.size() > 0) {
           
            
            for (HoaDonChiTiet y1 : listHDCT) {
                if (y1.getIdCTSP().getIdCTSP().equals(idCTSP)) {
                if (y1.getSoLuong() == slTon || ((y1.getSoLuong()) + Integer.valueOf(soLuong)) > slTon) {
                    JOptionPane.showMessageDialog(null, "Không thể vượt quá số lượng đang có");
                    return;
                }
                h.setSoLuong(y1.getSoLuong() + Integer.valueOf(soLuong));
                h.setDonGia(BigDecimal.valueOf(Integer.valueOf(donGia.replace(".", "")) * (y1.getSoLuong() + Integer.valueOf(soLuong))));
                hoaDonChiTieservice.updateHDCT(h);
                loadGioHang();
                dem++;
            }
            }
        }

        if (dem == 0) {
            h.setSoLuong(Integer.valueOf(soLuong));
            hoaDonChiTieservice.inserthdct(h);
            loadGioHang();
            tongTien();
        }


    }//GEN-LAST:event_tblSanPhamMouseClicked
    private KhuyenMaiModel getKhuyenMai(String ma) {
        ArrayList<KhuyenMaiModel> list = khuyenMaiService.getKhuyenMaiAD();
        for (KhuyenMaiModel km : list) {
            if (km.getMaKM().equals(ma)) {
                return km;
            }
        }
        return null;
    }
    private void txtMaCouponCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMaCouponCaretUpdate

        KhuyenMaiModel km = getKhuyenMai(hoadon.getIdKM().getMaKM());  // lấy khuyến mãi
        BigDecimal gia = hoadon.getThanhTien(); // tổng tiền
        int giamPoint = 0; // giảm điểm

        if (hoadon.getIdKH() != null) {
            if (txtDiem.getText().equals(0)) {
                giamPoint = hoadon.getIdKH().getDiemEXP();
            }
        }

        if (km == null) {
            return;
        }

        BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hoadon.getThanhTien());
        int giamGia = (int) (hoadon.getThanhTien().doubleValue() - giaSauGiamVoucher.intValue());
        if (txtGiamGia.getText().equals("0") || txtGiamGia.getText() == null) {
            txtGiamGia.setText(String.valueOf(giamGia));
        } else {
            txtGiamGia.setText(String.valueOf(giamPoint + giamGia));
        }
        if (txtMaCoupon.getText().equals("0") || txtMaCoupon.getText() == null) {
            txtGiamGia.setText(String.valueOf(giamPoint));
        }
    }//GEN-LAST:event_txtMaCouponCaretUpdate

    private void btnSuDungDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungDiemActionPerformed
        int giamGia = 0;
        int giamPoint = 0;
        if (hoadon.getIdKM() != null) {
            KhuyenMaiModel km = getKhuyenMai(hoadon.getIdKM().getMaKM());  // lấy khuyến mãi            
            BigDecimal giaSauGiamVoucher = thanhTien(km.getHinhThucApDung(), km.getGiaTri(), km.getGiamToiDa(), hoadon.getThanhTien());
            giamGia = hoadon.getThanhTien().intValue() - giaSauGiamVoucher.intValue();

        }
        if (hoadon.getIdKH() != null) {
            giamPoint = hoadon.getIdKH().getDiemEXP();
            diemKH=String.valueOf(hoadon.getIdKH().getDiemEXP());
        }
        
        txtDiem.setText("0");
        KhachHangModel kh = new KhachHangModel();
        if (hoadon.getIdKH() != null) {
            kh.setMaKH(hoadon.getIdKH().getMaKH());
//            kh.setDiemEXP((int) Math.round(Double.valueOf(txtDiem.getText())));
//            kh.setDiemEXP((int) (Double.valueOf(txtTongTien.getText()) / 1000));
                kh.setDiemEXP(0);
            khachHangService.updateExp_KhachHang(kh);
        } else {
            kh.setMaKH(null);
        }
        if (!txtMaCoupon.getText().equals("0") || txtMaCoupon.getText() != null) {
            txtGiamGia.setText(String.valueOf(giamGia + giamPoint));
        } else {
            txtGiamGia.setText(String.valueOf(giamPoint));
        }
    }//GEN-LAST:event_btnSuDungDiemActionPerformed

    private void txtGiamGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamGiaCaretUpdate
        String chuaGiam = txtTongTien.getText();
        if (txtGiamGia.getText().trim().isEmpty()) {
            txtTongTien.setText(hoadon.getThanhTien().toString());
        } else {
            int giamGia = Integer.valueOf(txtGiamGia.getText());
            int tongTien = Integer.valueOf(hoadon.getThanhTien().toString());
            String sauGiam = String.valueOf(tongTien - giamGia);
            txtTongTien.setText(sauGiam);
        }
    }//GEN-LAST:event_txtGiamGiaCaretUpdate

    private void btnXoaGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGHActionPerformed
        ArrayList<HoaDonViewModel> listHD = hoaDonService.gethoadonCho();
        String id = "";
        int index = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(index, 0).toString();
        for (HoaDonViewModel h : listHD) {
            if (h.getMaHD() != null && h.getMaHD().equals(maHD)) {
                id = h.getIdHD();
            }
        }

        ArrayList<HoaDonChiTiet> listHDCT = hoaDonChiTieservice.getAllhoadon_byMa(id);

        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa hết sản phẩm trong đơn hàng không?", "Thông báo", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        for (HoaDonChiTiet c : listHDCT) {

            hoaDonChiTieservice.deleteHDCT(id, c.getIdCTSP().getIdCTSP());
        }
        loadGioHang();
    }//GEN-LAST:event_btnXoaGHActionPerformed

    private void txtTimKiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSPActionPerformed
        String timKiem = txtTimKiemSP.getText();
        String thongTinSP = "";
        ArrayList<ChiTietSanPhamModel> listSP = chiTietSanPhamService.getChiTietSanPhamByQR(timKiem);
       
        dtmSP = (DefaultTableModel) tblSanPham.getModel();
        dtmSP.setRowCount(0);
        Collections.sort(listSP, Comparator.comparing(ChiTietSanPhamModel -> ChiTietSanPhamModel.getIdSP().getTen()));
        for (ChiTietSanPhamModel ctspM : listSP) {

            dtmSP.addRow(new Object[]{
                ctspM.getMaQR(),
                ctspM.getIdSP().getTenSP() + ", " + ctspM.getIdSize().getTenSize() + ", " + ctspM.getIdDC().getTenDC() + ", " + ctspM.getIdMS().getTenMS(),
                ctspM.getGiaBan(),
                ctspM.getSoLuong(),
                ctspM.getIdKM() == null ? "Nguyên giá" : checkKM(ctspM.getIdKM()),
                ctspM.getIdKM() == null ? df.format(ctspM.getGiaBan()) : checkGiaKM(ctspM.getIdKM(), ctspM)

            });
        }
    }//GEN-LAST:event_txtTimKiemSPActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        loadHDCho();
        loadSP();
        load();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JBanHang;
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnHuyDiem;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnHuyKH;
    private javax.swing.JButton btnHuyVoucher;
    private javax.swing.JButton btnQuet;
    private javax.swing.JButton btnSuDungDiem;
    private javax.swing.JButton btnTTvaIn;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnVoucher;
    private javax.swing.JButton btnXoaGH;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> cbbHinhThucTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaCoupon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienKH;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiemSP;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
  private void load() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<KhuyenMaiModel> listkm = khuyenMaiService.getAllKhuyenMai();
                ArrayList<ChiTietSanPhamModel> listsp = chiTietSanPhamService.getAllChiTietSanPham();
                Date htai = new Date();
                for (KhuyenMaiModel k : listkm) {
                    if (htai.after(k.getNgayKetThuc())) {

                        khuyenMaiService.updateChuyenTT(k);
                        for (ChiTietSanPhamModel c : listsp) {

                            if (c.getIdKM() != null && c.getIdKM().getIdKM().equals(k.getIdKM())) {

                                c.setIdKM(null);
                                chiTietSanPhamService.updateKM_hethan(c);
                                loadSP();
                            }
                        }
                    }
                }
                loadHDCho();
                loadSP();
                
            }

        }).start();
    }
}
