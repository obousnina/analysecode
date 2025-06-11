package fr.epsi.test;

import fr.epsi.test.user.User;

public interface NotificationHandler {

    void sendNotification(User user, String message) throws NotificationException;

}
