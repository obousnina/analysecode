package fr.epsi.notification;

import fr.epsi.notification.service.NotificationService;
import fr.epsi.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotificationServiceTest {

    @Test
    public void testSendNotificationWithValidUser() {
        NotificationService service = new NotificationService();
        User user = new User();
        user.setEmail("test@test.com");
        user.setPhoneNumber("1234567890");
        user.setDeviceToken("validToken");

        try {
            service.sendNotification(user, "Test message");
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendNotificationWithNullUser() {
        NotificationService service = new NotificationService();
        service.sendNotification(null, "Test message");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendNotificationWithEmptyMessage() {
        NotificationService service = new NotificationService();
        User user = new User();
        user.setEmail("test@test.com");

        service.sendNotification(user, "");
    }
}
