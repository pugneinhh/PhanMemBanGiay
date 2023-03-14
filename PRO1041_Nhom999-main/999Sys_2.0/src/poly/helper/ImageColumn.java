/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author XUÂN THÀNH
 */
public class ImageColumn implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            return (Component) value;
        } catch (Exception e) {
        }
        return null;
    }

}
