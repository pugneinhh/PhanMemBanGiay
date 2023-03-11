/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Phanh
 */
public class FormNhanVien extends javax.swing.JFrame {
    
    
    private String[] images={"giayhome.png","giayhome1.png","giayhome2.png","giayhome3.png"};
    /**
     * Creates new form FormNhanVien
     */
    public FormNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        loadtrangchu();
    }
    
    private void loadtrangchu(){
        Timer timer=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n=(int) Math.floor(Math.random()*4);
                String image=images[n];
                ImageIcon ii=new ImageIcon("src\\icon\\"+image);
                Image img=ii.getImage().getScaledInstance(lbltrangchu.getWidth(), lbltrangchu.getHeight(), Image.SCALE_SMOOTH);
                ii=new ImageIcon(img);
                lbltrangchu.setIcon(ii);
            }
        });
        timer.start();
    }
    //Width=190;
    //Height=641;
    int width=190;
    int height=641;
    private void hienMenu(){
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
    private void dongMenu(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i >0; i--) {
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
        btnMenu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JHome = new javax.swing.JPanel();
        lbltrangchu = new javax.swing.JLabel();
        JKhuyenMai = new javax.swing.JPanel();
        JSanPham = new javax.swing.JPanel();
        JThongKe = new javax.swing.JPanel();
        JHoaDon = new javax.swing.JPanel();
        JNhanVien = new javax.swing.JPanel();
        JBanHang = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        JMain.setBackground(new java.awt.Color(255, 255, 255));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Menu.png"))); // NOI18N
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });

        jPanel2.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout JHomeLayout = new javax.swing.GroupLayout(JHome);
        JHome.setLayout(JHomeLayout);
        JHomeLayout.setHorizontalGroup(
            JHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltrangchu, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
        );
        JHomeLayout.setVerticalGroup(
            JHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltrangchu, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        jPanel2.add(JHome, "card2");

        javax.swing.GroupLayout JKhuyenMaiLayout = new javax.swing.GroupLayout(JKhuyenMai);
        JKhuyenMai.setLayout(JKhuyenMaiLayout);
        JKhuyenMaiLayout.setHorizontalGroup(
            JKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        JKhuyenMaiLayout.setVerticalGroup(
            JKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jPanel2.add(JKhuyenMai, "card2");

        javax.swing.GroupLayout JSanPhamLayout = new javax.swing.GroupLayout(JSanPham);
        JSanPham.setLayout(JSanPhamLayout);
        JSanPhamLayout.setHorizontalGroup(
            JSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JSanPhamLayout.setVerticalGroup(
            JSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(JSanPham, "card2");

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

        jPanel2.add(JThongKe, "card2");

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

        jPanel2.add(JHoaDon, "card2");

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

        jPanel2.add(JNhanVien, "card2");

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

        jPanel2.add(JBanHang, "card2");

        Menu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Trang chủ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Thoat.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(105, 105, 105)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(482, 482, 482))
        );

        javax.swing.GroupLayout JMainLayout = new javax.swing.GroupLayout(JMain);
        JMain.setLayout(JMainLayout);
        JMainLayout.setHorizontalGroup(
            JMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JMainLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(JMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JMainLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        JMainLayout.setVerticalGroup(
            JMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JMainLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(JMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JMainLayout.createSequentialGroup()
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

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
                .addComponent(JMain, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
       hienMenu();
    }//GEN-LAST:event_btnMenuMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        dongMenu();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

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
    private javax.swing.JPanel JKhuyenMai;
    private javax.swing.JPanel JMain;
    private javax.swing.JPanel JNhanVien;
    private javax.swing.JPanel JSanPham;
    private javax.swing.JPanel JThongKe;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbltrangchu;
    // End of variables declaration//GEN-END:variables
}
