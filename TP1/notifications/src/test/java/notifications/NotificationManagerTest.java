package notifications;

import junit.framework.TestCase;
import notifications.model.Utilisateur;
import notifications.service.NotificationManager;

public class NotificationManagerTest extends TestCase {
    private NotificationManager notificationManager;
    private Utilisateur utilisateur;

    @Override
    protected void setUp() {
        notificationManager = new NotificationManager();
        utilisateur = new Utilisateur(
            "test@example.com",
            "+33612345678",
            "device-token-123"
        );
    }

    public void testEnvoiNotificationUtilisateurComplet() {
        notificationManager.envoyerNotification(utilisateur, "Test message complet");
    }

    public void testEnvoiNotificationUtilisateurSansEmail() {
        Utilisateur utilisateurSansEmail = new Utilisateur(null, "+33612345678", "device-token-123");
        notificationManager.envoyerNotification(utilisateurSansEmail, "Test message sans email");
    }

    public void testEnvoiNotificationUtilisateurSansTelephone() {
        Utilisateur utilisateurSansTel = new Utilisateur("test@example.com", null, "device-token-123");
        notificationManager.envoyerNotification(utilisateurSansTel, "Test message sans téléphone");
    }

    public void testEnvoiNotificationUtilisateurSansDeviceToken() {
        Utilisateur utilisateurSansToken = new Utilisateur("test@example.com", "+33612345678", null);
        notificationManager.envoyerNotification(utilisateurSansToken, "Test message sans token");
    }

    public void testEnvoiNotificationUtilisateurVide() {
        Utilisateur utilisateurVide = new Utilisateur(null, null, null);
        notificationManager.envoyerNotification(utilisateurVide, "Test message utilisateur vide");
    }

    public void testEnvoiNotificationEmailInvalide() {
        Utilisateur utilisateurEmailInvalide = new Utilisateur("email-invalide", "+33612345678", "device-token-123");
        notificationManager.envoyerNotification(utilisateurEmailInvalide, "Test message email invalide");
    }

    public void testEnvoiNotificationTelephoneInvalide() {
        Utilisateur utilisateurTelInvalide = new Utilisateur("test@example.com", "123", "device-token-123");
        notificationManager.envoyerNotification(utilisateurTelInvalide, "Test message téléphone invalide");
    }

    public void testEnvoiNotificationMessageVide() {
        notificationManager.envoyerNotification(utilisateur, "");
    }

    public void testEnvoiNotificationMessageNull() {
        notificationManager.envoyerNotification(utilisateur, null);
    }

    public void testEnvoiNotificationMultiples() {
        // Test d'envoi de plusieurs notifications consécutives
        for (int i = 0; i < 3; i++) {
            notificationManager.envoyerNotification(utilisateur, "Message test " + (i + 1));
        }
    }

    public void testEnvoiNotificationCaracteresSpeciaux() {
        String messageSpecial = "Message avec caractères spéciaux : éàçù€$£";
        notificationManager.envoyerNotification(utilisateur, messageSpecial);
    }
} 