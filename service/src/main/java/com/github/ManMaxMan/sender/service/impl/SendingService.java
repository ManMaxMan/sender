package com.github.ManMaxMan.sender.service.impl;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.service.api.ISendingService;
import com.github.ManMaxMan.sender.service.api.exceptions.FailMessageSendException;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendingService implements ISendingService {

    private static final String SMTP_SERVER = "outlook.live.com";
    private static final String USERNAME = "******";
    private static final String PASSWORD = "******";
    private static final String EMAIL_FROM = "maxmaxmaxmaxmax123321@outlook.com";
    private static final String EMAIL_TO_CC = "";

    @Override
    public void send(MessageEntity message) throws FailMessageSendException {

        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587"); // default port 25
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);


        try {
            msg.setFrom(new InternetAddress(EMAIL_FROM));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(message.getRecipient(), false));
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, false));
            msg.setSubject(message.getSubject());
            msg.setText(message.getBody());
            msg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
            t.sendMessage(msg, msg.getAllRecipients());

            //System.out.println("Response: " + t.getLastServerResponse());

            t.close();
        }catch (MessagingException e){
            throw new FailMessageSendException(e);
        }

    }
}
