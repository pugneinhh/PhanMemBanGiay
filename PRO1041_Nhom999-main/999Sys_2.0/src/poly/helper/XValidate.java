/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 98tae
 */
public class XValidate {

    public static boolean isEmpty(JTextField txtValue) {
        String txt = txtValue.getText().trim();
        if (txt.length() == 0) {
            txtValue.setBackground(Color.yellow);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }

    public static boolean isEmpty(JTextArea txtValue) {
        String txt = txtValue.getText().trim();
        if (txt.length() == 0) {
            txtValue.setBackground(Color.yellow);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }

    public static boolean isEmpty(JPasswordField txtValue) {
        String txt = String.valueOf(txtValue.getPassword()).trim();
        if (txt.length() == 0) {
            txtValue.setBackground(Color.yellow);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }

    public static boolean isNotNumber_Double(JTextField txtValue) {
        String Number = String.valueOf(txtValue.getText());
        String pattern = "[0-9]{1,}.{0,1}[0-9]{0,}";
        if (!Number.matches(pattern)) {
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
            return true;
        }
        
        String pattern2 = "^[0-9]{1,}\\.$";
        if (Number.matches(pattern2)) {
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
            return true;
        }
        
        if (Double.parseDouble(Number) < 0) {
            if (!Number.matches(pattern)) {
                txtValue.setBackground(Color.YELLOW);
                txtValue.requestFocus();
                return true;
            }
            txtValue.setBackground(Color.white);
        }
        return false;
    }

    public static boolean isNotNumber(JTextField txtValue) {
        String Number = String.valueOf(txtValue.getText());
        String pattern = "[0-9]{1,}";
        if (!Number.matches(pattern)) {
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }
    
    public static boolean isNotEmail(JTextField txtValue) {
        String Gmail = String.valueOf(txtValue.getText());
        String pattern = "^[a-zA-Z]\\w{2,}@\\w{2,}(\\.\\w{2,3}){1,2}$";
        if (!Gmail.matches(pattern)) {
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }
    
    public static boolean isNotVNName(JTextField txtValue) {
        String name = String.valueOf(txtValue.getText());
        String pattern = "^[\\p{L} .'-]+$";
        if (!name.matches(pattern)) {
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }
    public static boolean isNotPhoneNumber(JTextField txtValue) {
        String phoneNumber = String.valueOf(txtValue.getText());
        String pattern = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (!phoneNumber.matches(pattern)) {
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }

    public static boolean focus_Errol(boolean boo, JTextField txtValue) {
        if (!boo) {
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
            return true;
        }
        txtValue.setBackground(Color.white);
        return false;
    }

    public static boolean IsNotDate(JTextField textdate) {
        String date = textdate.getText();
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);
        try {
            Date javaDate = sdfrmt.parse(date);
        } catch (ParseException e) {
            textdate.setBackground(Color.YELLOW);
            textdate.requestFocus();
            return true;
        }
        return false;
    }
    
   

}
