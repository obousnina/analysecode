package notifications.channels;

import notifications.interfaces.NotificationChannel;
import notifications.model.User;

public class EmailChannel implements NotificationChannel {
    @Override
    public void send(User user, String message) {
        System.out.println("Envoi d'un email à " + user.getEmail() + " : " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user != null && user.getEmail() != null && user.getEmail().contains("@");
    }
}