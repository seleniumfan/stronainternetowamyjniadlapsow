package com.ti.stronainternetowamyjnadlapsow;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderRecipient;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Mail mail) {
        LOGGER.debug("Wysyłka maila");
        try {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setFrom(senderRecipient);
        helper.setTo(senderRecipient);
        helper.setReplyTo(mail.getEmail());
        helper.setSubject("Wiadomość od: " + mail.getEmail());
        helper.setText(mail.getContent());
        javaMailSender.send(mimeMessage);
        LOGGER.debug("Mail wysłany poprawnie");
        } catch (MessagingException e) {
            e.printStackTrace();
            LOGGER.warn("Błąd podczas wysyłania wiadomości", e);
        }
    }

    public void sendConfirmation(Mail mail) {
        LOGGER.debug("Wysyłka potwierdzenia otrzymania maila");
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(senderRecipient);
            helper.setTo(mail.getEmail());
            helper.setSubject("Potwierdzenie otrzymania wiadomości");
            helper.setText("Dziękujemy za Twoją wiadomość " + mail.getSender());
            javaMailSender.send(mimeMessage);
            LOGGER.debug("Mail wysłany poprawnie");
        } catch (MessagingException e) {
            e.printStackTrace();
            LOGGER.warn("Błąd podczas wysyłania potwierdzenia", e);
        }
    }
}
