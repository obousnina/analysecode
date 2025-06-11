package src.test;

import org.junit.jupiter.api.Test;
import src.main.EmailNotification;
import src.main.Utilisateur;

import static org.junit.jupiter.api.Assertions.*;

public class EmailNotificationTest {

    @Test
    public void testEnvoiAvecEmail() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setCanal("email", "test@example.com");

        EmailNotification emailNotification = new EmailNotification();

        assertDoesNotThrow(() -> emailNotification.envoyer(utilisateur, "Message de test"));
    }

    @Test
    public void testEnvoiSansEmail() {
        Utilisateur utilisateur = new Utilisateur();

        EmailNotification emailNotification = new EmailNotification();

        assertDoesNotThrow(() -> emailNotification.envoyer(utilisateur, "Message de test"));
    }
}
