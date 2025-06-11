package src.main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Création de l'utilisateur et configuration de ses canaux
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setCanal("email", "email@example.com");
        utilisateur.setCanal("sms", "0123456789");
        utilisateur.setCanal("push", "deviceToken123");
        utilisateur.setCanal("whatsapp", "+33612345678");

        // Création des différents canaux disponibles
        NotificationManager manager = new NotificationManager(
                Arrays.asList(
                        new EmailNotification(),
                        new SmsNotification(),
                        new PushNotification(),
                        new WhatsAppNotification()
                )
        );

        // Envoi de la notification
        manager.envoyerNotification(utilisateur, "Bonjour, ceci est une notification !");
    }
}
