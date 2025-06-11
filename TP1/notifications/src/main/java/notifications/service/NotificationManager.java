package notifications.service;

import java.util.ArrayList;
import java.util.List;

import notifications.channels.EmailChannel;
import notifications.channels.PushChannel;
import notifications.channels.SMSChannel;
import notifications.interfaces.NotificationChannel;
import notifications.model.Utilisateur;

public class NotificationManager {
    private final List<NotificationChannel> canaux;

    public NotificationManager() {
        this.canaux = new ArrayList<>();
        this.canaux.add(new EmailChannel());
        this.canaux.add(new SMSChannel());
        this.canaux.add(new PushChannel());
    }

    public void ajouterCanal(NotificationChannel canal) {
        this.canaux.add(canal);
    }

    public void envoyerNotification(Utilisateur utilisateur, String message) {
        for (NotificationChannel canal : canaux) {
            if (canal instanceof EmailChannel && canal.peutEnvoyer(utilisateur.getEmail())) {
                canal.envoyer(utilisateur.getEmail(), message);
            } else if (canal instanceof SMSChannel && canal.peutEnvoyer(utilisateur.getNumeroTelephone())) {
                canal.envoyer(utilisateur.getNumeroTelephone(), message);
            } else if (canal instanceof PushChannel && canal.peutEnvoyer(utilisateur.getDeviceToken())) {
                canal.envoyer(utilisateur.getDeviceToken(), message);
            }
        }
    }
} 