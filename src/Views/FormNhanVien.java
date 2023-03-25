/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import ViewModels.NhanVienModel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Phanh
 */
public class FormNhanVien extends javax.swing.JFrame {

    CardLayout cardlayout;
    int index = 0;
    private String[] images = {"giayhome.png", "giayhome1.png", "giayhome2.png", "giayhome3.png"};

    /**
     * Creates new form FormNhanVien
     */
    public FormNhanVien() {
        initComponents();

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        Insets scrmax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int taskBar = scrmax.bottom;
        this.setSize(xsize, ysize - taskBar);
        getContentPane().setBackground(Color.white);
        cardlayout = (CardLayout) pncardgoc.getLayout();
        loadtrangchu(index);
<<<<<<< HEAD
//        loadDangNhap();
=======

//        loadDangNhap();
         
        

//        loadDangNhap();

        loadDangNhap();
>>>>>>> 1f95eb57ed2f075285b8faf652ab924e20354735

    }

    private void loadDangNhap() {
        NhanVienModel nv = new NhanVienModel();
        if (DangNhap.nv.getIdCV().getTenCV().equalsIgnoreCase("Nhân viên")) {
            btnNhanVien.setEnabled(false);
            btnNhanVien.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent e) {
            e.consume();
         }

                @Override
                public void mousePressed(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            });
        }
        ImageIcon ii = new ImageIcon("src\\AnhNV\\" + DangNhap.nv.getHinh());
        Image img = ii.getImage().getScaledInstance(lblAnhNVlogin.getWidth(), lblAnhNVlogin.getHeight(), Image.SCALE_SMOOTH);
        ii = new ImageIcon(img);
        lblAnhNVlogin.setIcon(ii);
    }

    private void resetbtn() {
        btnBanHang.setBackground(Color.white);
        btnNhanVien.setBackground(Color.white);
        btnKhachHang.setBackground(Color.white);
        btnKhuyenMai.setBackground(Color.white);
        btnHoaDon.setBackground(Color.white);
        btnSanPham.setBackground(Color.white);
        btnTrangchu.setBackground(Color.white);
        btnThongKe.setBackground(Color.white);
    }

    private void loadtrangchu(int i) {

        String image = images[i];
        ImageIcon ii = new ImageIcon("src\\icon\\" + image);
        Image img = ii.getImage().getScaledInstance(lbltrangchu.getWidth(), lbltrangchu.getHeight(), Image.SCALE_SMOOTH);
        ii = new ImageIcon(img);
        lbltrangchu.setIcon(ii);
        btnTrangchu.setBackground(Color.pink);
        btnTrangchu.setOpaque(true);

    }
    //Width=190;
    //Height=641;
    int width = 190;
    int height = 676;

    private void hienMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    Menu.setSize(width, height);

                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    private void dongMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    Menu.setSize(0, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
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
        jLabel2 = new javax.swing.JLabel();
        JMain = new javax.swing.JPanel();
        pncardgoc = new javax.swing.JPanel();
        JHome = new javax.swing.JPanel();
        lbltrangchu = new javax.swing.JLabel();
        btnPre = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        JKhuyenMai = new javax.swing.JPanel();
        JSanPham = new javax.swing.JPanel();
        JThongKe = new javax.swing.JPanel();
        JNhanVien = new javax.swing.JPanel();
        JHoaDon = new javax.swing.JPanel();
        JBanHang = new javax.swing.JPanel();
        JKhachHang = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        btnTrangchu = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBanHang = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnHoaDon = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnSanPham = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnKhuyenMai = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btnNhanVien = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btnKhachHang = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        btnThongKe = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        btnThoat = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        lblAnhNVlogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(214, 214));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(239, 185, 169));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        JMain.setBackground(new java.awt.Color(255, 255, 255));

        pncardgoc.setLayout(new java.awt.CardLayout());

        JHome.setBackground(new java.awt.Color(255, 255, 255));
        JHome.setLayout(new java.awt.BorderLayout());
        JHome.add(lbltrangchu, java.awt.BorderLayout.CENTER);

        btnPre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPre.setText("<");
        btnPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreMouseClicked(evt);
            }
        });
        JHome.add(btnPre, java.awt.BorderLayout.WEST);

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNext.setText(">");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        JHome.add(btnNext, java.awt.BorderLayout.EAST);

        pncardgoc.add(JHome, "cardhome");

        javax.swing.GroupLayout JKhuyenMaiLayout = new javax.swing.GroupLayout(JKhuyenMai);
        JKhuyenMai.setLayout(JKhuyenMaiLayout);
        JKhuyenMaiLayout.setHorizontalGroup(
            JKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1211, Short.MAX_VALUE)
        );
        JKhuyenMaiLayout.setVerticalGroup(
            JKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        pncardgoc.add(JKhuyenMai, "cardkm");

        javax.swing.GroupLayout JSanPhamLayout = new javax.swing.GroupLayout(JSanPham);
        JSanPham.setLayout(JSanPhamLayout);
        JSanPhamLayout.setHorizontalGroup(
            JSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1211, Short.MAX_VALUE)
        );
        JSanPhamLayout.setVerticalGroup(
            JSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        pncardgoc.add(JSanPham, "cardsp");

        javax.swing.GroupLayout JThongKeLayout = new javax.swing.GroupLayout(JThongKe);
        JThongKe.setLayout(JThongKeLayout);
        JThongKeLayout.setHorizontalGroup(
            JThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JThongKeLayout.setVerticalGroup(
            JThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pncardgoc.add(JThongKe, "cardtk");

        javax.swing.GroupLayout JNhanVienLayout = new javax.swing.GroupLayout(JNhanVien);
        JNhanVien.setLayout(JNhanVienLayout);
        JNhanVienLayout.setHorizontalGroup(
            JNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JNhanVienLayout.setVerticalGroup(
            JNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pncardgoc.add(JNhanVien, "cardnv");

        javax.swing.GroupLayout JHoaDonLayout = new javax.swing.GroupLayout(JHoaDon);
        JHoaDon.setLayout(JHoaDonLayout);
        JHoaDonLayout.setHorizontalGroup(
            JHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JHoaDonLayout.setVerticalGroup(
            JHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pncardgoc.add(JHoaDon, "cardhd");

        javax.swing.GroupLayout JBanHangLayout = new javax.swing.GroupLayout(JBanHang);
        JBanHang.setLayout(JBanHangLayout);
        JBanHangLayout.setHorizontalGroup(
            JBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JBanHangLayout.setVerticalGroup(
            JBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pncardgoc.add(JBanHang, "cardbh");

        JKhachHang.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JKhachHangLayout = new javax.swing.GroupLayout(JKhachHang);
        JKhachHang.setLayout(JKhachHangLayout);
        JKhachHangLayout.setHorizontalGroup(
            JKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1211, Short.MAX_VALUE)
        );
        JKhachHangLayout.setVerticalGroup(
            JKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        pncardgoc.add(JKhachHang, "cardkh");

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setPreferredSize(new java.awt.Dimension(190, 641));

        btnTrangchu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnTrangchu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTrangchu.setText("Trang chủ");
        btnTrangchu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrangchu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangchuMouseClicked(evt);
            }
        });

        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBanHang.setText("Bán hàng");
        btnBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBanHang.setMaximumSize(new java.awt.Dimension(94, 27));
        btnBanHang.setMinimumSize(new java.awt.Dimension(94, 27));
        btnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHangMouseClicked(evt);
            }
        });

        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHoaDon.setText("Hóa đơn");
        btnHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHoaDonMouseClicked(evt);
            }
        });

        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSanPham.setText("Sản phẩm");
        btnSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseClicked(evt);
            }
        });

        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnKhuyenMai.setText("Khuyến mãi");
        btnKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhuyenMaiMouseClicked(evt);
            }
        });

        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhanVienMouseClicked(evt);
            }
        });

        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseClicked(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThongKe.setText("Thống kê");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat.setText("Thoát");
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });

        lblAnhNVlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhNVloginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnTrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAnhNVlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        MenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBanHang, btnHoaDon, btnKhachHang, btnKhuyenMai, btnNhanVien, btnSanPham, btnTrangchu, jSeparator1, jSeparator2, jSeparator3, jSeparator4, jSeparator5, jSeparator6});

        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addComponent(lblAnhNVlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        MenuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBanHang, btnHoaDon, btnKhachHang, btnKhuyenMai, btnNhanVien, btnSanPham});

        javax.swing.GroupLayout JMainLayout = new javax.swing.GroupLayout(JMain);
        JMain.setLayout(JMainLayout);
        JMainLayout.setHorizontalGroup(
            JMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JMainLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pncardgoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JMainLayout.setVerticalGroup(
            JMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(JMainLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
            .addComponent(pncardgoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pncardgoc.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnPreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreMouseClicked
        index--;
        if (index < 0) {
            index = images.length - 1;
        }
        loadtrangchu(index);
    }//GEN-LAST:event_btnPreMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        index++;
        if (index >= images.length) {
            index = 0;
        }
        loadtrangchu(index);
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        System.exit(0);
        new DangNhap().setVisible(true);
    }//GEN-LAST:event_btnThoatMouseClicked

    private void btnSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseClicked
        SanPhamJPanel spl = new SanPhamJPanel();
        spl.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        JSanPham.add(spl, BorderLayout.CENTER);
        cardlayout.show(pncardgoc, "cardsp");
        resetbtn();
        btnSanPham.setBackground(Color.pink);
        btnSanPham.setOpaque(true);

    }//GEN-LAST:event_btnSanPhamMouseClicked

    private void btnKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMouseClicked
        KhuyenMaiJPanel kml = new KhuyenMaiJPanel();
        kml.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        JKhuyenMai.add(kml, BorderLayout.CENTER);
        cardlayout.show(pncardgoc, "cardkm");
        resetbtn();
        btnKhuyenMai.setBackground(Color.pink);
        btnKhuyenMai.setOpaque(true);

    }//GEN-LAST:event_btnKhuyenMaiMouseClicked

    private void btnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseClicked
        KhachHangJPanel khl = new KhachHangJPanel();
        khl.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        JKhachHang.add(khl, BorderLayout.CENTER);
        cardlayout.show(pncardgoc, "cardkh");
        resetbtn();
        btnKhachHang.setBackground(Color.pink);
        btnKhachHang.setOpaque(true);
    }//GEN-LAST:event_btnKhachHangMouseClicked

    private void btnBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseClicked
        BanHangJPanel bhl = new BanHangJPanel();
        bhl.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        JBanHang.add(bhl, BorderLayout.CENTER);
        cardlayout.show(pncardgoc, "cardbh");
        resetbtn();
        btnBanHang.setBackground(Color.pink);
        btnBanHang.setOpaque(true);
    }//GEN-LAST:event_btnBanHangMouseClicked

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
        ThongKeJPanel tkl = new ThongKeJPanel();
        tkl.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        JThongKe.add(tkl, BorderLayout.CENTER);
        cardlayout.show(pncardgoc, "cardtk");
        resetbtn();
        btnThongKe.setBackground(Color.pink);
        btnThongKe.setOpaque(true);
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnTrangchuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangchuMouseClicked

        JHome.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        cardlayout.show(pncardgoc, "cardhome");
        resetbtn();
        btnTrangchu.setBackground(Color.pink);
        btnTrangchu.setOpaque(true);
    }//GEN-LAST:event_btnTrangchuMouseClicked

    private void btnNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienMouseClicked
        NhanVienJPanel nvl = new NhanVienJPanel();
        nvl.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        JNhanVien.add(nvl, BorderLayout.CENTER);
        cardlayout.show(pncardgoc, "cardnv");
        resetbtn();
        btnNhanVien.setBackground(Color.pink);
        btnNhanVien.setOpaque(true);
    }//GEN-LAST:event_btnNhanVienMouseClicked

    private void btnHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDonMouseClicked
        LichSuGiaoDich lsl = new LichSuGiaoDich();
        lsl.setSize(pncardgoc.getWidth(), pncardgoc.getHeight());
        JHoaDon.add(lsl, BorderLayout.CENTER);
        cardlayout.show(pncardgoc, "cardhd");
        resetbtn();
        btnHoaDon.setBackground(Color.pink);
        btnHoaDon.setOpaque(true);
    }//GEN-LAST:event_btnHoaDonMouseClicked

    private void lblAnhNVloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhNVloginMouseClicked
        new ThongTinNhanVien().setVisible(true);
    }//GEN-LAST:event_lblAnhNVloginMouseClicked

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
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JBanHang;
    private javax.swing.JPanel JHoaDon;
    private javax.swing.JPanel JHome;
    private javax.swing.JPanel JKhachHang;
    private javax.swing.JPanel JKhuyenMai;
    private javax.swing.JPanel JMain;
    private javax.swing.JPanel JNhanVien;
    private javax.swing.JPanel JSanPham;
    private javax.swing.JPanel JThongKe;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel btnBanHang;
    private javax.swing.JLabel btnHoaDon;
    private javax.swing.JLabel btnKhachHang;
    private javax.swing.JLabel btnKhuyenMai;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnNhanVien;
    private javax.swing.JLabel btnPre;
    private javax.swing.JLabel btnSanPham;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnThongKe;
    private javax.swing.JLabel btnTrangchu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblAnhNVlogin;
    private javax.swing.JLabel lbltrangchu;
    private javax.swing.JPanel pncardgoc;
    // End of variables declaration//GEN-END:variables
}
