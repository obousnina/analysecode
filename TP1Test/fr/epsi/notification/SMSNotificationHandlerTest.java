package fr.epsi.notification;

import fr.epsi.notification.impl.SMSNotificationHandler;
import fr.epsi.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class SMSNotificationHandlerTest {

    @Test
    public void testCanSendMessageWithValidPhoneNumber() {
        SMSNotificationHandler handler = new SMSNotificationHandler();
        User user = new User();
        user.setPhoneNumber("1234567890");

        assertTrue(handler.canSendMessage(user));
    }

    @Test
    public void testCanSendMessageWithInvalidPhoneNumber() {
        SMSNotificationHandler handler = new SMSNotificationHandler();
        User user = new User();
        user.setPhoneNumber("");

        assertFalse(handler.canSendMessage(user));
    }

    @Test
    public void testSendNotificationWithValidPhoneNumber() {
        SMSNotificationHandler handler = new SMSNotificationHandler();
        User user = new User();
        user.setPhoneNumber("1234567890");

        try {
            handler.sendNotification(user, "Test message");
        } catch (NotificationException e) {
            fail("NotificationException should not be thrown");
        }
    }

    @Test(expected = NotificationException.class)
    public void testSendNotificationWithInvalidPhoneNumber() throws NotificationException {
        SMSNotificationHandler handler = new SMSNotificationHandler();
        User user = new User();
        user.setPhoneNumber("");

        handler.sendNotification(user, "Test message");
    }
}