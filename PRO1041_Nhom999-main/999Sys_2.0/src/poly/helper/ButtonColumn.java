package poly.helper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.*;

/**
 * The ButtonColumn class provides a renderer and an editor that looks like a
 * JButton. The renderer and editor will then be used for a specified column in
 * the table. The TableModel will contain the String to be displayed on the
 * button.
 *
 * The button can be invoked by a mouse click or by pressing the space bar when
 * the cell has focus. Optionally a mnemonic can be set to invoke the button.
 * When the button is invoked the provided Action is invoked. The source of the
 * Action will be the table. The action command will contain the model row
 * number of the button that was clicked.
 *
 */
public class ButtonColumn extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener {

    private ImageIcon icon;
    private String name;
    private JTable table;
    private Action action;
    private int mnemonic;
    private Border originalBorder;
    private Border focusBorder;

    private JButton renderButton;
    private JButton editButton;
    private Object editorValue;
    private boolean isButtonColumnEditor;

    /**
     * Create the ButtonColumn to be used as a renderer and editor. The renderer
     * and editor will automatically be installed on the TableColumn of the
     * specified column.
     *
     * @param table the table containing the button renderer/editor
     * @param action the Action to be invoked when the button is invoked
     * @param column the column to which the button renderer/editor is added
     */
    public ButtonColumn(JTable table, Action action, int column, String name, ImageIcon icon) {
        this.icon = icon;
        this.name = name;
        this.table = table;
        this.action = action;

        renderButton = new JButton();
        renderButton.setToolTipText(name);
        renderButton.setBackground(Color.WHITE);
//        renderButton.setUI(new BasicButtonUI());
        editButton = new JButton();
        editButton.setBackground(Color.WHITE);
//        editButton.setUI(new BasicButtonUI());
        editButton.setToolTipText(name);
        editButton.setFocusPainted(false);
        editButton.addActionListener(this);
        mouseHover();
        originalBorder = editButton.getBorder();
        setFocusBorder(new LineBorder(Color.BLUE));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
        table.addMouseListener(this);
    }

    public void mouseHover() {
        //Hiệu ứng di chuột vào các button menu
        JButton[] btns = {editButton, renderButton};
        for (JButton btn : btns) {

            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(Color.WHITE);
                    btn.setHorizontalAlignment(SwingConstants.CENTER);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(21, 25, 28));
                    btn.setHorizontalAlignment(SwingConstants.LEFT);
                }
            });
        }
    }

    /**
     * Get foreground color of the button when the cell has focus
     *
     * @return the foreground color
     */
    public Border getFocusBorder() {
        return focusBorder;
    }

    /**
     * The foreground color of the button when the cell has focus
     *
     * @param focusBorder the foreground color
     */
    public void setFocusBorder(Border focusBorder) {
        this.focusBorder = focusBorder;
        editButton.setBorder(focusBorder);
    }

    public int getMnemonic() {
        return mnemonic;
    }

    /**
     * The mnemonic to activate the button when the cell has focus
     *
     * @param mnemonic the mnemonic
     */
    public void setMnemonic(int mnemonic) {
        this.mnemonic = mnemonic;
        renderButton.setMnemonic(mnemonic);
        editButton.setMnemonic(mnemonic);
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            editButton.setToolTipText(name);
            editButton.setIcon(icon);
        } else if (value instanceof Icon) {
            editButton.setToolTipText(name);
            editButton.setIcon(icon);
        } else {
            editButton.setToolTipText(value.toString());
            editButton.setIcon(icon);
        }

        this.editorValue = value;
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
    }

//
//  Implement TableCellRenderer interface
//
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//		if (isSelected)
//		{
//			renderButton.setForeground(table.getSelectionForeground());
//	 		renderButton.setBackground(table.getSelectionBackground());
//		}
//		else
//		{
//			renderButton.setForeground(table.getForeground());
//			renderButton.setBackground(UIManager.getColor("Button.background"));
//		}
//
        renderButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                renderButton.setBackground(Color.WHITE);
                renderButton.setHorizontalAlignment(SwingConstants.CENTER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                renderButton.setBackground(new Color(21, 25, 28));
                renderButton.setHorizontalAlignment(SwingConstants.LEFT);
            }
        });
        if (hasFocus) {
            renderButton.setBorder(focusBorder);
        } else {
            renderButton.setBorder(originalBorder);
        }

//		renderButton.setText( (value == null) ? "" : value.toString() );
        if (value == null) {
            renderButton.setToolTipText(name);
            renderButton.setIcon(icon);
        } else if (value instanceof Icon) {
            renderButton.setToolTipText(name);
            renderButton.setIcon(icon);
        } else {
            renderButton.setToolTipText(value.toString());
            renderButton.setIcon(icon);
        }

        return renderButton;
    }

//
//  Implement ActionListener interface
//
    /*
	 *	The button has been pressed. Stop editing and invoke the custom Action
     */
    public void actionPerformed(ActionEvent e) {
        int row = table.convertRowIndexToModel(table.getEditingRow());
        fireEditingStopped();

        //  Invoke the Action
        ActionEvent event = new ActionEvent(
                table,
                ActionEvent.ACTION_PERFORMED,
                "" + row);
        action.actionPerformed(event);
    }

//
//  Implement MouseListener interface
//
    /*
	 *  When the mouse is pressed the editor is invoked. If you then then drag
	 *  the mouse to another cell before releasing it, the editor is still
	 *  active. Make sure editing is stopped when the mouse is released.
     */
    public void mousePressed(MouseEvent e) {
        if (table.isEditing()
                && table.getCellEditor() == this) {
            isButtonColumnEditor = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (isButtonColumnEditor
                && table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }

        isButtonColumnEditor = false;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
