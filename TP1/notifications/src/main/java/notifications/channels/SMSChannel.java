package notifications.channels;

import notifications.interfaces.NotificationChannel;

public class SMSChannel implements NotificationChannel {
    @Override
    public void send(String target, String message) {
        System.out.println("Envoi d'un SMS à " + target + " : " + message);
    }

    @Override
    public boolean canSend(String target) {
        return target != null && target.matches("\\+?[0-9]{10,}");
    }
}