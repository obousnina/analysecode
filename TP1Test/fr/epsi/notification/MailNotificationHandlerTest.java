package fr.epsi.notification;

import fr.epsi.notification.impl.MailNotificationHandler;
import fr.epsi.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class MailNotificationHandlerTest {

    @Test
    public void testCanSendMessageWithValidEmail() {
        MailNotificationHandler handler = new MailNotificationHandler();
        User user = new User();
        user.setEmail("test@test.com");

        assertTrue(handler.canSendMessage(user));
    }

    @Test
    public void testCanSendMessageWithInvalidEmail() {
        MailNotificationHandler handler = new MailNotificationHandler();
        User user = new User();
        user.setEmail("");

        assertFalse(handler.canSendMessage(user));
    }

    @Test
    public void testSendNotificationWithValidEmail() {
        MailNotificationHandler handler = new MailNotificationHandler();
        User user = new User();
        user.setEmail("test@test.com");

        try {
            handler.sendNotification(user, "Test message");
        } catch (NotificationException e) {
            fail("NotificationException should not be thrown");
        }
    }

    @Test(expected = NotificationException.class)
    public void testSendNotificationWithInvalidEmail() throws NotificationException {
        MailNotificationHandler handler = new MailNotificationHandler();
        User user = new User();
        user.setEmail("");

        handler.sendNotification(user, "Test message");
    }

}
