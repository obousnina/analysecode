package notifications.channels;

import notifications.interfaces.NotificationChannel;

public class EmailChannel implements NotificationChannel {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("Envoi d'un email à " + destinataire + " : " + message);
    }

    @Override
    public boolean peutEnvoyer(String destinataire) {
        return destinataire != null && destinataire.contains("@");
    }
} 