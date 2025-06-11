package notifications;

import junit.framework.TestCase;
import notifications.model.User;
import notifications.service.NotificationManager;

public class NotificationManagerTest extends TestCase {
    private NotificationManager notificationManager;
    private User utilisateur;

    @Override
    protected void setUp() {
        notificationManager = new NotificationManager();
        utilisateur = new User(
                "test@example.com",
                "+33612345678",
                "device-token-123");
    }

    public void testEnvoiNotificationUtilisateurComplet() {
        notificationManager.sendNotification(utilisateur, "Test message complet");
    }

    public void testEnvoiNotificationUtilisateurSansEmail() {
        User utilisateurSansEmail = new User(null, "+33612345678", "device-token-123");
        notificationManager.sendNotification(utilisateurSansEmail, "Test message sans email");
    }

    public void testEnvoiNotificationUtilisateurSansTelephone() {
        User utilisateurSansTel = new User("test@example.com", null, "device-token-123");
        notificationManager.sendNotification(utilisateurSansTel, "Test message sans téléphone");
    }

    public void testEnvoiNotificationUtilisateurSansDeviceToken() {
        User utilisateurSansToken = new User("test@example.com", "+33612345678", null);
        notificationManager.sendNotification(utilisateurSansToken, "Test message sans token");
    }

    public void testEnvoiNotificationUtilisateurVide() {
        User utilisateurVide = new User(null, null, null);
        notificationManager.sendNotification(utilisateurVide, "Test message utilisateur vide");
    }

    public void testEnvoiNotificationEmailInvalide() {
        User utilisateurEmailInvalide = new User("email-invalide", "+33612345678", "device-token-123");
        notificationManager.sendNotification(utilisateurEmailInvalide, "Test message email invalide");
    }

    public void testEnvoiNotificationTelephoneInvalide() {
        User utilisateurTelInvalide = new User("test@example.com", "123", "device-token-123");
        notificationManager.sendNotification(utilisateurTelInvalide, "Test message téléphone invalide");
    }

    public void testEnvoiNotificationMessageVide() {
        notificationManager.sendNotification(utilisateur, "");
    }

    public void testEnvoiNotificationMessageNull() {
        notificationManager.sendNotification(utilisateur, null);
    }

    public void testEnvoiNotificationMultiples() {
        // Test d'envoi de plusieurs notifications consécutives
        for (int i = 0; i < 3; i++) {
            notificationManager.sendNotification(utilisateur, "Message test " + (i + 1));
        }
    }

    public void testEnvoiNotificationCaracteresSpeciaux() {
        String messageSpecial = "Message avec caractères spéciaux : éàçù€$£";
        notificationManager.sendNotification(utilisateur, messageSpecial);
    }
}