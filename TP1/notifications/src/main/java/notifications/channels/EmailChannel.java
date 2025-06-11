package notifications.channels;

import notifications.interfaces.NotificationChannel;

public class EmailChannel implements NotificationChannel {
    @Override
    public void send(String target, String message) {
        System.out.println("Envoi d'un email à " + target + " : " + message);
    }

    @Override
    public boolean canSend(String target) {
        return target != null && target.contains("@");
    }
}