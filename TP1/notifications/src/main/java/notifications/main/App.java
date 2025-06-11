package notifications.main;

import notifications.model.Utilisateur;
import notifications.service.NotificationManager;

public class App {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        Utilisateur utilisateur = new Utilisateur(
            "utilisateur@example.com",
            "+33612345678",
            "device-token-123"
        );
        
        manager.envoyerNotification(utilisateur, "Test de notification");
    }
} 