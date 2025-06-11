package fr.epsi.test.impl;

import fr.epsi.test.IMailNotificationHandler;
import fr.epsi.test.NotificationException;
import fr.epsi.test.user.User;

import java.util.Optional;

public class MailNotificationHandler extends AbstractNotificationHandler implements IMailNotificationHandler {

    public void sendNotification(User user, String message) throws NotificationException {

    }

    public String getEmailAddress(User user) {
        Optional<String> emailAddress = Optional.ofNullable(user.getEmail());
        return emailAddress.orElseThrow(() -> new NotificationException("Email address is required for mail notifications"));
    }

}
