package com.example.email.SendEmail;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class send01 {

    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.host","smtp.qq.com");
        Session session=Session.getInstance(properties);

        MimeMessage message=new MimeMessage(session);

        message.setFrom(new InternetAddress("3242498120@qq.com"));
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress("3242498120@qq.com"));
        message.setSubject("XXX");
        message.setSentDate(new Date());
        message.setText("come on 666");
        message.saveChanges();
        Transport transport = session.getTransport();
        transport.connect("3242498120@qq.com","wzpnumxshqkodaaf");
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
        System.out.println("完成");
        System.out.println("123");

    }
}
