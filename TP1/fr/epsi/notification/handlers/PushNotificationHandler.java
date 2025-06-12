package fr.epsi.notification.handlers;

import fr.epsi.notification.exception.NotificationException;
import fr.epsi.user.User;
import org.apache.commons.lang.StringUtils;

public class PushNotificationHandler extends AbstractNotificationHandler {

    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        super.sendNotification(user, message);
        assertUserHasValidInfo(user.getDeviceToken());

        String deviceToken = user.getDeviceToken();
        System.out.println("Sending push notification to device with token " + deviceToken + " with message: " + message);
    }

    @Override
    public boolean canSendMessage(User user) {
        return user != null && StringUtils.isNotEmpty(user.getDeviceToken());
    }

}
