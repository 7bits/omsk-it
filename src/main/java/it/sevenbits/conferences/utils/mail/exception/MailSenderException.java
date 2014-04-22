package it.sevenbits.conferences.utils.mail.exception;

/**
 * General exception of mail sender class.
 */
public class MailSenderException extends Exception {

    /**
     * Exception with message only
     * @param message String message
     */
    public MailSenderException(final String message) {
        super(message);
    }

    /**
     * Exception with message and cause of Exception
     * @param message String message
     * @param e       Exception
     */
    public MailSenderException(final String message, final Exception e) {
        super(message, e);
    }
}
