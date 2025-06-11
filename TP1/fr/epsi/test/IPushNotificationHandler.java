package fr.epsi.test;

import fr.epsi.test.user.User;

public interface IPushNotificationHandler {

    String getDeviceToken(User user);

}
