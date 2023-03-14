package poly.newgui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import poly.dao.SanPhamDao;
import poly.entity.SanPham;
import poly.helper.Messeger;

public class Code_Reader extends javax.swing.JFrame implements Runnable, ThreadFactory {

    Locale localeVN = new Locale("vi", "VN");
    NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    public static SanPham sp;
    SanPhamDao sp_dao;
    JTable tblHoaDon;
    HoaDonFrm hdFrm;

    public Code_Reader(JTable tblHoaDon, HoaDonFrm hdFrm) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initWebcam();
        setLocationRelativeTo(null);
        sp_dao = new SanPhamDao();
        sp = new SanPham();
        this.tblHoaDon = tblHoaDon;
        this.hdFrm = hdFrm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        webcam.close();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        System.out.println(MASP_QUETQR);
    }//GEN-LAST:event_formWindowOpened

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new Code_Reader(new JTable(), new HoaDonFrm(parent, null)).setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 355));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                sp = sp_dao.getSanPhamByMaVach(result.getText());
                if (sp != null & sp.getMaSP() != 0) {
                    hdFrm.setSlGoc(sp.getSoLuong());
                    int maSP = sp.getMaSP();
                    if (Messeger.confirm(this, "Đã tìm thấy Sản Phẩm: " + sp.getTenSanPham() + "-- Giá Bán: " + df.format(sp.getGiaBan()) +"\nxác nhận thêm sản phẩm này vào hóa đơn?")){
                        if (checkNhapSL(maSP)) return;
                    }
                }
            }
        } while (true);
    }

    public boolean checkNhapSL(int maSP) throws NumberFormatException {
        if (!hdFrm.nhapSl()) {
            boolean c = true;
            for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
                int masphd = Integer.parseInt(tblHoaDon.getValueAt(i, 8) + "");
                int sl = Integer.parseInt(tblHoaDon.getValueAt(i, 2) + "");
                double dg = df.parse(tblHoaDon.getValueAt(i, 5) + "", new ParsePosition(0)).doubleValue();
                if (maSP == masphd) {
                    int soLuongSP = hdFrm.getSlGoc() - hdFrm.getSlNhap();
                    int soLuongCTHD = hdFrm.getSlNhap() + sl;
                    tblHoaDon.setValueAt(soLuongCTHD, i, 2);
                    tblHoaDon.setValueAt(df.format(soLuongCTHD * dg), i, 7);
                    hdFrm.tongTien();
                    hdFrm.suaCTHD(maSP, soLuongSP, soLuongCTHD, 0);
                    hdFrm.reloadTableSP();
                    this.dispose();
                    webcam.close();
                    return true;
                }
            }
            double thanhTien = sp.getGiaBan() * hdFrm.getSlNhap();
            Object[] data = null;
            try {
                data = new Object[]{
                    null,
                    hdFrm.daoSP.selectById(maSP).getTenSanPham(),
                    hdFrm.getSlNhap(),
                    null,
                    null,
                    df.format(sp.getGiaBan()),
                    null,
                    df.format(thanhTien),
                    maSP
                };
            } catch (Exception ex) {
                Logger.getLogger(HoaDonFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
            hdFrm.dtmHoaDon.addRow(data);
            SanPham sp = new SanPham();
            sp.setMaSP(maSP);
            sp.setSoLuong(hdFrm.getSlGoc() - hdFrm.getSlNhap());
            try {
                hdFrm.daoSP.updateSP(sp);
            } catch (Exception ex) {
                Logger.getLogger(HoaDonFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
            hdFrm.tongTien();
            if (hdFrm.getLblHoaDon().getText().equalsIgnoreCase("Hóa đơn trống")) {
                hdFrm.taoHoaDon();
            }
            hdFrm.taoHDCT(maSP, hdFrm.getSlNhap());
            hdFrm.reloadTableSP();
            this.dispose();
            webcam.close();
        } else {
//            checkNhapSL(maSP);
        }
        return false;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
