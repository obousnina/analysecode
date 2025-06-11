package fr.epsi.notification.impl;

import fr.epsi.notification.IPushNotificationHandler;
import fr.epsi.notification.NotificationException;
import fr.epsi.user.User;

import java.util.Optional;

public class PushNotificationHandler extends AbstractNotificationHandler implements IPushNotificationHandler {

    public void sendNotification(User user, String message) throws NotificationException {
        super.sendNotification(user, message);

        String deviceToken = getDeviceToken(user);
        System.out.println("Sending push notification to device token " + deviceToken + ": " + message);
    }

    public String getDeviceToken(User user) {
        Optional<String> deviceToken = Optional.ofNullable(user.getDeviceToken());
        return deviceToken.orElseThrow(() -> new NotificationException("Device token is required for push notifications"));
    }

}
