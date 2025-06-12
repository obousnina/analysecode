package notifications.channels;

import notifications.interfaces.NotificationChannel;
import notifications.model.User;

/**
 * Implementation of NotificationChannel for push notifications.
 * This channel sends notifications to user devices using device tokens.
 */
public class PushChannel implements NotificationChannel {
    @Override
    public boolean send(User user, String message) {
        if (user != null && user.getDeviceToken() != null && user.getDeviceToken().length() > 0) {
            System.out.println("Sending push notification to " + user.getDeviceToken() + " : " + message);
            return true;
        }
        return false;
    }
}