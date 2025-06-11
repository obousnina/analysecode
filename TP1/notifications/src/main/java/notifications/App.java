package notifications;

import notifications.model.User;
import notifications.service.NotificationManager;

public class App {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        User utilisateur = new User(
                "utilisateur@example.com",
                "+33612345678",
                "device-token-123");

        manager.sendNotification(utilisateur, "Test de notification");
    }
}