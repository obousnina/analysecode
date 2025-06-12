package notifications;

import java.util.Map;

import junit.framework.TestCase;
import notifications.model.User;
import notifications.service.NotificationManager;

public class NotificationManagerTest extends TestCase {
    private NotificationManager notificationManager;
    private User user;

    @Override
    protected void setUp() {
        notificationManager = new NotificationManager();
        user = new User(
                "test@example.com",
                "+33612345678",
                "device-token-123");
    }

    public void testSendNotificationWithCompleteUser() {
        Map<String, Boolean> results = notificationManager.sendNotification(user, "Complete user test message");
        assertTrue(results.get("EmailChannel"));
        assertTrue(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }

    public void testSendNotificationWithoutEmail() {
        User userWithoutEmail = new User(null, "+33612345678", "device-token-123");
        Map<String, Boolean> results = notificationManager.sendNotification(userWithoutEmail,
                "Test message without email");
        assertFalse(results.get("EmailChannel"));
        assertTrue(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }

    public void testSendNotificationWithoutPhone() {
        User userWithoutPhone = new User("test@example.com", null, "device-token-123");
        Map<String, Boolean> results = notificationManager.sendNotification(userWithoutPhone,
                "Test message without phone");
        assertTrue(results.get("EmailChannel"));
        assertFalse(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }

    public void testSendNotificationWithoutDeviceToken() {
        User userWithoutToken = new User("test@example.com", "+33612345678", null);
        Map<String, Boolean> results = notificationManager.sendNotification(userWithoutToken,
                "Test message without token");
        assertTrue(results.get("EmailChannel"));
        assertTrue(results.get("SMSChannel"));
        assertFalse(results.get("PushChannel"));
    }

    public void testSendNotificationWithEmptyUser() {
        User emptyUser = new User(null, null, null);
        Map<String, Boolean> results = notificationManager.sendNotification(emptyUser, "Test message with empty user");
        assertFalse(results.get("EmailChannel"));
        assertFalse(results.get("SMSChannel"));
        assertFalse(results.get("PushChannel"));
    }

    public void testSendNotificationWithInvalidEmail() {
        User userWithInvalidEmail = new User("invalid-email", "+33612345678", "device-token-123");
        Map<String, Boolean> results = notificationManager.sendNotification(userWithInvalidEmail,
                "Test message with invalid email");
        assertFalse(results.get("EmailChannel"));
        assertTrue(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }

    public void testSendNotificationWithInvalidPhone() {
        User userWithInvalidPhone = new User("test@example.com", "123", "device-token-123");
        Map<String, Boolean> results = notificationManager.sendNotification(userWithInvalidPhone,
                "Test message with invalid phone");
        assertTrue(results.get("EmailChannel"));
        assertFalse(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }

    public void testSendNotificationWithEmptyMessage() {
        Map<String, Boolean> results = notificationManager.sendNotification(user, "");
        assertTrue(results.get("EmailChannel"));
        assertTrue(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }

    public void testSendNotificationWithNullMessage() {
        Map<String, Boolean> results = notificationManager.sendNotification(user, null);
        assertTrue(results.get("EmailChannel"));
        assertTrue(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }

    public void testSendMultipleNotifications() {
        for (int i = 0; i < 3; i++) {
            Map<String, Boolean> results = notificationManager.sendNotification(user, "Test message " + (i + 1));
            assertTrue(results.get("EmailChannel"));
            assertTrue(results.get("SMSChannel"));
            assertTrue(results.get("PushChannel"));
        }
    }

    public void testSendNotificationWithSpecialCharacters() {
        String specialMessage = "Message with special characters: éàçù€$£";
        Map<String, Boolean> results = notificationManager.sendNotification(user, specialMessage);
        assertTrue(results.get("EmailChannel"));
        assertTrue(results.get("SMSChannel"));
        assertTrue(results.get("PushChannel"));
    }
}