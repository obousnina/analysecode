package notifications.channels;

import notifications.interfaces.NotificationChannel;

public class SMSChannel implements NotificationChannel {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("Envoi d'un SMS à " + destinataire + " : " + message);
    }

    @Override
    public boolean peutEnvoyer(String destinataire) {
        return destinataire != null && destinataire.matches("\\+?[0-9]{10,}");
    }
} 