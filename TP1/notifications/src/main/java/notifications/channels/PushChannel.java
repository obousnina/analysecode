package notifications.channels;

import notifications.interfaces.NotificationChannel;
import notifications.model.User;

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