/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class ResetPassByEmail {

    public static int resetPass(String mailAddress) {
        int codeSMS = (int) (Math.random() * (999999 - 111110 + 1) + 111110);
        final String iDMail = "sendmail.fpttext@gmail.com";
        final String passMail = "sendmail.fpttext10";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(iDMail, passMail);
            }
        });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sendmail.fpttext@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mailAddress)
            );
            message.setSubject("Hệ Thống Bán Hàng");
            message.setText("Xin chào các thanh niên Orange Team \n"
                    + "Mã xác nhận của bạn là: " + codeSMS);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return codeSMS;
    }
}
