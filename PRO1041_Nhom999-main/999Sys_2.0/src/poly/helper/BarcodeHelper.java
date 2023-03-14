/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XUÂN THÀNH
 */
public class BarcodeHelper {

    public static void createEAN13BarcodeImage(String barcodeText) throws Exception {
        EAN13Writer barcodeWriter = new EAN13Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);

        // Write to file image
        String outputFile = ".\\MaVach\\test.png";
        Path path = FileSystems.getDefault().getPath(outputFile);
        try {
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            createEAN13BarcodeImage("1234567688239");
        } catch (Exception ex) {
            Logger.getLogger(BarcodeHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
