/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author NTV
 */
public class XInternal {
    public static void uncorated(JInternalFrame internal) {
        BasicInternalFrameUI bi = (BasicInternalFrameUI) internal.getUI();
        bi.setNorthPane(null);
    }
}
