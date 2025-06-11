package fr.epsi.test.impl;

import fr.epsi.test.IPushNotificationHandler;
import fr.epsi.test.NotificationException;
import fr.epsi.test.user.User;

import java.util.Optional;

public class PushNotificationHandler extends AbstractNotificationHandler implements IPushNotificationHandler {
    public void sendNotification(User user, String message) throws NotificationException {

    }

    public String getDeviceToken(User user) {
        Optional<String> deviceToken = Optional.ofNullable(user.getDeviceToken());
        return deviceToken.orElseThrow(() -> new NotificationException("Device token is required for push notifications"));
    }

}
