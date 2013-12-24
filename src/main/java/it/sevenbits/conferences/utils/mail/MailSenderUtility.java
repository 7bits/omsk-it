package it.sevenbits.conferences.utils.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * This class provide tools for working with mail.
 */
@Service("emailService")
public class MailSenderUtility {

    public static final String SERVICE_MAILBOX = "naturalexchangeco@gmail.com";

    public static final String THANKS_FOR_REGISTRATION = "Чтобы подтвердить регистрацию на нашем сайте, пройдите по ссылке: ";

    @Autowired
    private JavaMailSender mailSender;

    private void sendMail(final String to, final String subject, final String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

    public void sendConfirmationToken(String login, String confirmation_token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(login);
        message.setSubject("Подтверждение регистрации");
        String confirmation_url = "http://omsk-it/omsk-it/confirmation?confirmation_token=" + confirmation_token + "&confirmation_login=" + login;
        message.setText(THANKS_FOR_REGISTRATION + confirmation_url);
        mailSender.send(message);
    }
}
