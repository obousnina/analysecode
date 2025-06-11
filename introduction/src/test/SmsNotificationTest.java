package src.test;

import org.junit.jupiter.api.Test;
import src.main.SmsNotification;
import src.main.Utilisateur;

import static org.junit.jupiter.api.Assertions.*;

public class SmsNotificationTest {

    @Test
    public void testEnvoiAvecSMS() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setCanal("sms", "0123456789");

        SmsNotification smsNotification = new SmsNotification();

        assertDoesNotThrow(() -> smsNotification.envoyer(utilisateur, "Message de test"));
    }

    @Test
    public void testEnvoiSansSMS() {
        Utilisateur utilisateur = new Utilisateur();

        SmsNotification smsNotification = new SmsNotification();

        assertDoesNotThrow(() -> smsNotification.envoyer(utilisateur, "Message de test"));
    }
}

