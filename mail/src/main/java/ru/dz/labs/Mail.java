package ru.dz.labs;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    String username = "dearthings@yandex.ru";
    String password = "Qaz266264";

    public void sendMessage(String subject, String text, String to) throws MessagingException {
        Message message = new MimeMessage(getSession());
        message.setFrom(new InternetAddress("dearthings@yandex.ru"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(text);
        Transport.send(message);
    }

    public Session getSession() {
        return Session.getInstance(getProps(),
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public Properties getProps() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        return props;
    }
}