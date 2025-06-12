package fr.epsi.notification.handlers;

import fr.epsi.notification.exception.NotificationException;
import fr.epsi.user.User;

public interface NotificationHandler {

    void sendNotification(User user, String message) throws NotificationException;

    boolean canSendMessage(User user);

}
