package fr.epsi.notification;

import fr.epsi.notification.impl.PushNotificationHandler;
import fr.epsi.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class PushNotificationHandlerTest {

    @Test
    public void testCanSendMessageWithValidDeviceToken() {
        PushNotificationHandler handler = new PushNotificationHandler();
        User user = new User();
        user.setDeviceToken("validToken");

        assertTrue(handler.canSendMessage(user));
    }

    @Test
    public void testCanSendMessageWithInvalidDeviceToken() {
        PushNotificationHandler handler = new PushNotificationHandler();
        User user = new User();
        user.setDeviceToken("");

        assertFalse(handler.canSendMessage(user));
    }

    @Test
    public void testSendNotificationWithValidDeviceToken() {
        PushNotificationHandler handler = new PushNotificationHandler();
        User user = new User();
        user.setDeviceToken("validToken");

        try {
            handler.sendNotification(user, "Test message");
        } catch (NotificationException e) {
            fail("NotificationException should not be thrown");
        }
    }

    @Test(expected = NotificationException.class)
    public void testSendNotificationWithInvalidDeviceToken() throws NotificationException {
        PushNotificationHandler handler = new PushNotificationHandler();
        User user = new User();
        user.setDeviceToken("");

        handler.sendNotification(user, "Test message");
    }
}
