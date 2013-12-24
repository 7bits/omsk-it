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

    private static final String SERVICE_MAILBOX = "naturalexchangeco@gmail.com";

    private static final String THANKS_FOR_REGISTRATION = "Чтобы подтвердить регистрацию на нашем сайте, пройдите по ссылке: ";

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Send common message.
     */
    private void sendMail(final String to, final String subject, final String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

    /**
     * Send message with link for confirmation account.
     * @param login Users login
     * @param confirmation_token Users confirmation token
     */
    public void sendConfirmationToken(String login, String confirmation_token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(login);
        message.setSubject("Подтверждение регистрации");
        String confirmation_url = "http://omsk-it/omsk-it/user/confirmation?confirmation_token=" + confirmation_token + "&confirmation_login=" + login;
        message.setText(THANKS_FOR_REGISTRATION + confirmation_url);
        mailSender.send(message);
    }
}
