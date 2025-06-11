package notifications.channels;

import notifications.interfaces.NotificationChannel;
import notifications.model.User;

public class SMSChannel implements NotificationChannel {
    @Override
    public void send(User user, String message) {
        System.out.println("Envoi d'un SMS à " + user.getPhoneNumber() + " : " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user != null && user.getPhoneNumber() != null && user.getPhoneNumber().matches("\\+?[0-9]{10,}");
    }
}