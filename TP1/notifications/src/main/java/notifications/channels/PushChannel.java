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
        boolean result = false;
        if (user != null && user.getDeviceToken() != null && user.getDeviceToken().length() > 0) {
            System.out.println("Envoi d'une push notification à " + user.getDeviceToken() + " : " + message);
            result = true;
        }
        return result;
    }
}