package notifications.channels;

import notifications.interfaces.NotificationChannel;

public class PushChannel implements NotificationChannel {
    @Override
    public void send(String target, String message) {
        System.out.println("Envoi d'une notification push à " + target + " : " + message);
    }

    @Override
    public boolean canSend(String target) {
        return target != null && target.length() > 0;
    }
}