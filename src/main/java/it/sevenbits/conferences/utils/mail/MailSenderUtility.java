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

    private static final String REGISTRATION_INFO_TEXT = "Чтобы подтвердить регистрацию на нашем сайте, пройдите по ссылке: ";

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
     * @param confirmationToken Users confirmation token
     */
    public void sendConfirmationToken(String login, String confirmationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(login);
        message.setSubject("Подтверждение регистрации");
        String confirmationUrl = "http://omskit.local/omsk-it/user/confirmation?confirmation_token=" + confirmationToken + "&confirmation_login=" + login;
        message.setText(REGISTRATION_INFO_TEXT + confirmationUrl);
        mailSender.send(message);
    }

    /**
     * Send message with link for confirmation account and registration for current conference.
     * @param login Users login
     * @param confirmationToken Users confirmation token
     */
    public void sendConfirmationTokenAndConferenceStatus(String email, String confirmationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(email);
        message.setSubject("Подтверждение регистрации");
        String confirmationUrl = "http://omskit.local/omsk-it/user/confirmation?confirmation_token=" +
                confirmationToken + "&confirmation_login=" + email + "&conference_status=1"
        ;
        message.setText(REGISTRATION_INFO_TEXT + confirmationUrl + " Ждем вас в субботу");
        mailSender.send(message);
    }

    /**
     * Send message with link for confirmation account and consideration user as reporter.
     * @param login Users login
     * @param confirmationToken Users confirmation token
     */
    public void sendConfirmationTokenAndReportStatus(String email, String confirmationToken, Long reportId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(email);
        message.setSubject("Подтверждение регистрации");
        String confirmationUrl = "http://omskit.local/omsk-it/user/confirmation?confirmation_token=" +
                confirmationToken + "&confirmation_login=" + email + "&report_status=" + reportId
        ;
        message.setText(REGISTRATION_INFO_TEXT + confirmationUrl + " Ваша заявка на доклад будет рассмотрена.");
        mailSender.send(message);
    }
}
