package io.github.mcengine.api;

import java.util.Properties;

/**
 * The {@code MCEngineMailApiUtil} class provides utility methods 
 * to configure email settings for different email providers.
 */
public class MCEngineMailApiUtil {

    /**
     * Configures email properties based on the email service type.
     *
     * @param mailType the type of email service (e.g., "gmail", "hotmail")
     * @return the configured {@code Properties} object
     * @throws IllegalArgumentException if the specified mail type is unsupported
     */
    public static Properties configureMail(String mailType) {
        Properties emailProperties = new Properties();
        switch (mailType.toLowerCase()) {
            case "hotmail":
                emailProperties.put("mail.smtp.host", "smtp.live.com");
                break;
            case "gmail":
                emailProperties.put("mail.smtp.host", "smtp.gmail.com");
                break;
            default:
                throw new IllegalArgumentException("Unsupported mail type: " + mailType);
        }
        emailProperties.put("mail.smtp.port", "587");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

        return emailProperties;
    }
}
