package src.main;

import java.util.List;

public class NotificationManager {
    private List<CanalNotification> canaux;

    public NotificationManager(List<CanalNotification> canaux) {
        this.canaux = canaux;
    }

    public void envoyerNotification(Utilisateur utilisateur, String message) {
        for (CanalNotification canal : canaux) {
            canal.envoyer(utilisateur, message);
        }
    }
}
