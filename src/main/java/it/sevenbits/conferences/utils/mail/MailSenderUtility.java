package it.sevenbits.conferences.utils.mail;

import it.sevenbits.conferences.utils.mail.exception.MailSenderException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class provide tools for working with mail.
 */

@Service("emailService")
public class MailSenderUtility {

    private static final String SERVICE_MAILBOX = "no-reply@omskit.org";

    private static final String REGISTRATION_INFO_TEXT = "Чтобы подтвердить регистрацию на нашем сайте, пройдите по ссылке: ";

    private static final String TEMPORARY_PASSWORD_TEXT = "" +
            "Вам выслан временный пароль. Пройдите, пожалуйста, по указанной ссылке и смените его на новый."
    ;

    private static final String GENERAL_EXCEPTION_TEXT = "General mail's sender error";

    /** Project's logger */
    private final Logger logger = Logger.getLogger(MailSenderUtility.class);

    /** Service's main domain */
    private String domain;

    /** Springfraemwork's mail's sender */
    @Autowired
    private JavaMailSender mailSender;

    public MailSenderUtility() {
        this.domain = getSiteDomain();
    }

    /**
     * Send common message.
     */
    private void sendMail(final String to, final String subject, final String msg) throws MailSenderException{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new MailSenderException(GENERAL_EXCEPTION_TEXT, e);
        }
    }

    /**
     * Send message with link for confirmation account.
     * @param login Users login
     * @param confirmationToken Users confirmation token
     * @throws MailSenderException if mail sender isn't available or other.
     */
    public void sendConfirmationToken(final String login, final String confirmationToken) throws MailSenderException{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(login);
        message.setSubject("Подтверждение регистрации");
        String confirmationUrl = domain + "user/confirmation?confirmation_token=" +
                confirmationToken + "&confirmation_login=" + login
        ;
        message.setText(REGISTRATION_INFO_TEXT + confirmationUrl);
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new MailSenderException(GENERAL_EXCEPTION_TEXT, e);
        }
    }

    /**
     * Send message with link for confirmation account and registration for current conference.
     * @param email Users email
     * @param confirmationToken Users confirmation token
     * @throws MailSenderException if mail sender isn't available or other.
     */
    public void sendConfirmationTokenAndConferenceStatus(final String email, final String confirmationToken) throws MailSenderException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(email);
        message.setSubject("Подтверждение регистрации");
        String confirmationUrl = domain + "user/confirmation?confirmation_token=" +
                confirmationToken + "&confirmation_login=" + email + "&conference_status=1"
        ;
        message.setText(REGISTRATION_INFO_TEXT + confirmationUrl + " Ждем Вас в субботу");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new MailSenderException(GENERAL_EXCEPTION_TEXT, e);
        }
    }

    /**
     * Send message with link for confirmation account and consideration user as reporter.
     * @param email User's email
     * @param confirmationToken Users confirmation token
     * @throws MailSenderException if mail sender isn't available or other.
     */
    public void sendConfirmationTokenAndReportStatus(final String email, final String confirmationToken, final Long reportId) throws MailSenderException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(email);
        message.setSubject("Подтверждение регистрации");
        String confirmationUrl = domain + "user/confirmation?confirmation_token=" +
                confirmationToken + "&confirmation_login=" + email + "&report_status=" + reportId
        ;
        message.setText(REGISTRATION_INFO_TEXT + confirmationUrl + " Ваша заявка на доклад будет рассмотрена.");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new MailSenderException(GENERAL_EXCEPTION_TEXT, e);
        }
    }

    /**
     * Send message with new password
     * @param email User's email
     * @param password User's new password
     * @throws MailSenderException if mail sender isn't available or other.
     */
    public void sendNewPassword(final String email, final String password) throws MailSenderException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SERVICE_MAILBOX);
        message.setTo(email);
        message.setSubject("Восстановление пароля");
        StringBuilder resetPasswordUrl = new StringBuilder(domain);
        resetPasswordUrl.append("user/change-password?email=").append(email).append(TEMPORARY_PASSWORD_TEXT).append(" ").append(password);
        message.setText(resetPasswordUrl.toString());
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new MailSenderException(GENERAL_EXCEPTION_TEXT, e);
        }
    }

    private String getSiteDomain() {
        Properties prop = new Properties();
        try {
            InputStream inStream = getClass().getClassLoader().getResourceAsStream("common.properties");
            prop.load(inStream);
            inStream.close();
        } catch (IOException e) {
            logger.error("Cannot read filesUpload.properties file", e);
        }
        return prop.getProperty("site.domain");
    }
}
