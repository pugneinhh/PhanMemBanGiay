/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 98tae
 */
public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            formater.setLenient(false); //kiểm tra tháng từ 1-12, ngày từ 1-31
            return formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    //Bổ sung số ngày
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
}
