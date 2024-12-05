package io.github.mcengine.api;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * The {@code MCEngineMailApi} class provides functionality to send emails 
 * using different email services (e.g., Gmail, Hotmail).
 * This class handles email configuration and authentication.
 */
public class MCEngineMailApi {
    private final Properties emailProperties;
    private final String username;
    private final String password;

    /**
     * Constructs an instance of {@code MCEngineMailApi}.
     *
     * @param mailType the email service type (e.g., "gmail", "hotmail")
     * @param username the email address to authenticate
     * @param password the password or app-specific password for the email account
     */
    public MCEngineMailApi(String mailType, String username, String password) {
        this.emailProperties = MCEngineMailApiUtil.configureMail(mailType);
        this.username = username;
        this.password = password;
    }

    /**
     * Sends an email to the specified recipient. This operation is performed in a separate thread.
     *
     * @param to      the recipient's email address
     * @param subject the subject of the email
     * @param content the body content of the email
     */
    public void sendEmail(String to, String subject, String content) {
        new Thread(() -> {
            try {
                Session session = Session.getInstance(emailProperties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                message.setSubject(subject);
                message.setText(content);

                Transport.send(message);
                System.out.println("Email sent successfully to " + to);
            } catch (MessagingException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to send email: " + e.getMessage());
            }
        }).start();
    }
}
