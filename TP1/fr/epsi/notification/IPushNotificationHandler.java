package fr.epsi.notification;

import fr.epsi.user.User;

public interface IPushNotificationHandler {

    String getDeviceToken(User user);

}
