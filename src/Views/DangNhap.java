/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Phanh
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public DangNhap() {
        initComponents();
        setLocationRelativeTo(null);

        jLabel1.setIcon(new ImageIcon("D:\\ts\\src\\icon\\Video1.gif"));

        jLabel1.setIcon(new ImageIcon("D:\\ts\\src\\icon\\Video1.gif"));

    }

    public boolean check() {
        if (txtPass.getText().trim().length() == 0 && txtPass.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Login failed!", "Message", JOptionPane.ERROR_MESSAGE);
            txtPass.requestFocus();
            return false;
        }
        if (txtPass.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập User name");
            txtPass.requestFocus();
            return false;
        }
        if (txtPass.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Password");
            txtPass.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtUser1 = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnHien = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblQuen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 30, 30));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 230, 10));

        txtUser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser1.setBorder(null);
        getContentPane().add(txtUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 230, 30));

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPass.setText("Pass");
        txtPass.setBorder(null);
        txtPass.setEchoChar('\u25cf');
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 230, 30));

        btnHien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/An.png"))); // NOI18N
        btnHien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHienMouseExited(evt);
            }
        });
        getContentPane().add(btnHien, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 30, 30));

        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Login.png"))); // NOI18N
        btnDangNhap.setBorder(null);
        btnDangNhap.setBorderPainted(false);
        btnDangNhap.setContentAreaFilled(false);
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseEntered(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, 40));

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 230, 10));

        lblQuen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblQuen.setText("Quên mật khẩu?");
        lblQuen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMouseExited(evt);
            }
        });
        getContentPane().add(lblQuen, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnHienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHienMouseEntered

        btnHien.setIcon(new ImageIcon("D:\\ts\\src\\icon\\Hien.png"));

        btnHien.setIcon(new ImageIcon("D:\\ts\\src\\icon\\Hien.png"));

        txtPass.setEchoChar((char) 0);
    }//GEN-LAST:event_btnHienMouseEntered

    private void btnHienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHienMouseExited

        btnHien.setIcon(new ImageIcon("D:\\ts\\src\\icon\\An.png"));

        btnHien.setIcon(new ImageIcon("D:\\ts\\src\\icon\\An.png"));

        txtPass.setEchoChar('\u25cf');
    }//GEN-LAST:event_btnHienMouseExited

    private void btnDangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseEntered

        btnDangNhap.setIcon(new ImageIcon("D:\\ts\\src\\icon\\LoginAn.png"));
    }//GEN-LAST:event_btnDangNhapMouseEntered

    private void lblQuenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMouseClicked
        this.dispose();
        new QuenMK().setVisible(true);
    }//GEN-LAST:event_lblQuenMouseClicked

    private void lblQuenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMouseEntered
        Font font = lblQuen.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblQuen.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblQuenMouseEntered

    private void lblQuenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMouseExited
        Map attributes = lblQuen.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        lblQuen.setFont(lblQuen.getFont().deriveFont(attributes));
    }//GEN-LAST:event_lblQuenMouseExited

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DangNhap().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel btnHien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblQuen;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser1;
    // End of variables declaration//GEN-END:variables
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java3\\src\\icons\\Unknown person.png"));
    }
}
