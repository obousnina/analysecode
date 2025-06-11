package notifications.interfaces;

public interface NotificationChannel {
    void envoyer(String destinataire, String message);
    boolean peutEnvoyer(String destinataire);
} 