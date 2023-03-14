/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.util.Calendar;

/**
 *
 * @author XUÂN THÀNH
 */
public class RandomID {
    public static String randomIDKhachHang(String name){
        Calendar now = Calendar.getInstance();
        String time = now.get(Calendar.YEAR)+""+now.get(Calendar.MONTH)+""+now.get(Calendar.DATE)+""+now.get(Calendar.HOUR)+""+now.get(Calendar.MINUTE)+""+now.get(Calendar.SECOND);
        String nameCustom = "KH_" + VNCharacterUtils.removeAccent(name.charAt(0) + name.substring(name.indexOf(" ") + 1, name.indexOf(" ") + 2) + name.substring(name.lastIndexOf(" ") + 1, name.lastIndexOf(" ") + 2)) + time;
        return nameCustom;
    }
}
