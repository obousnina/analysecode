package notifications.channels;

import notifications.interfaces.NotificationChannel;

public class PushChannel implements NotificationChannel {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("Envoi d'une notification push à " + destinataire + " : " + message);
    }

    @Override
    public boolean peutEnvoyer(String destinataire) {
        return destinataire != null && destinataire.length() > 0;
    }
} 