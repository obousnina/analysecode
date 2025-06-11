package fr.epsi.notification.impl;

import fr.epsi.notification.IMailNotificationHandler;
import fr.epsi.notification.NotificationException;
import fr.epsi.user.User;

import java.util.Optional;

public class MailNotificationHandler extends AbstractNotificationHandler implements IMailNotificationHandler {

    public void sendNotification(User user, String message) throws NotificationException {
        super.sendNotification(user, message);

        String emailAddress = getEmailAddress(user);
        System.out.println("Sending email to " + emailAddress + ": " + message);
    }

    public String getEmailAddress(User user) {
        Optional<String> emailAddress = Optional.ofNullable(user.getEmail());
        return emailAddress.orElseThrow(() -> new NotificationException("Email address is required for mail notifications"));
    }

}
