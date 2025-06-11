package notifications.channels;

import notifications.interfaces.NotificationChannel;
import notifications.model.User;

/**
 * Implementation of NotificationChannel for push notifications.
 * This channel sends notifications to user devices using device tokens.
 */
public class PushChannel implements NotificationChannel {
    @Override
    public void send(User user, String message) {
        System.out.println("Envoi d'une notification push à " + user.getDeviceToken() + " : " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user != null && user.getDeviceToken() != null && user.getDeviceToken().length() > 0;
    }
}