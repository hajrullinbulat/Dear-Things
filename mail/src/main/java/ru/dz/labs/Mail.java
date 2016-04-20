package ru.dz.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class Mail {
    @Autowired
    private Environment env;

    //// TODO: 15.04.2016 устранить причину не работы через property
    String username = "dearthings@yandex.ru";
//    String username = env.getProperty("mail.username");
    String password = "Qaz266264";
//    String password = env.getProperty("mail.pass");

    public void sendMessage(String subject, String text, String to) throws MessagingException {
        MimeMessage message = new MimeMessage(getSession());
        message.setFrom(new InternetAddress("dearthings@yandex.ru"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(text, "utf-8", "html");
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

    public void sendHelloMessage(String userName, String key, String userEmail) throws MessagingException {
        sendMessage("Здравствуйте, " + userName + "!",
                "Перейдите по <a href=http://localhost:8080/signup/key?key=" + key + "> ссылке</a>  для активации аккаунта: ",
                userEmail);
    }

    public void sendForgotMessage(String name, String newPass, String email) throws MessagingException {
        sendMessage("Восстановление пароля", "Здравствуйте, " + name + "! <br> А вот и Ваш новенький пароль : " + newPass + "<br> Поменять его можете в личном кабинете.", email);
    }

    public void sendActivation(String name, String key, String email) throws MessagingException {
        sendMessage("Здравствуйте, " + name + "!",
                "Перейдите по <a href=http://localhost:8080/signup/key?key=" + key + "> ссылке</a>  для активации аккаунта: ",
                email);
    }
}