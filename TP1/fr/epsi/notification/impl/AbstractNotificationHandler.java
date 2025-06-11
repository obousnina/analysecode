package fr.epsi.notification.impl;

import fr.epsi.notification.NotificationException;
import fr.epsi.notification.NotificationHandler;
import fr.epsi.user.User;

public abstract class AbstractNotificationHandler implements NotificationHandler {

    public void sendNotification(User user, String message) throws NotificationException {
        if (user == null || message == null || message.isEmpty()) {
            throw new NotificationException("User and message must not be null or empty");
        }
    }

}
