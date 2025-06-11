package fr.epsi.notification;

import fr.epsi.user.User;

public interface NotificationHandler {

    void sendNotification(User user, String message) throws NotificationException;

    boolean canSendMessage(User user);

}
