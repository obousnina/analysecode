package notifications;

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
        notificationManager.sendNotification(user, "Complete user test message");
    }

    public void testSendNotificationWithoutEmail() {
        User userWithoutEmail = new User(null, "+33612345678", "device-token-123");
        notificationManager.sendNotification(userWithoutEmail, "Test message without email");
    }

    public void testSendNotificationWithoutPhone() {
        User userWithoutPhone = new User("test@example.com", null, "device-token-123");
        notificationManager.sendNotification(userWithoutPhone, "Test message without phone");
    }

    public void testSendNotificationWithoutDeviceToken() {
        User userWithoutToken = new User("test@example.com", "+33612345678", null);
        notificationManager.sendNotification(userWithoutToken, "Test message without token");
    }

    public void testSendNotificationWithEmptyUser() {
        User emptyUser = new User(null, null, null);
        notificationManager.sendNotification(emptyUser, "Test message with empty user");
    }

    public void testSendNotificationWithInvalidEmail() {
        User userWithInvalidEmail = new User("invalid-email", "+33612345678", "device-token-123");
        notificationManager.sendNotification(userWithInvalidEmail, "Test message with invalid email");
    }

    public void testSendNotificationWithInvalidPhone() {
        User userWithInvalidPhone = new User("test@example.com", "123", "device-token-123");
        notificationManager.sendNotification(userWithInvalidPhone, "Test message with invalid phone");
    }

    public void testSendNotificationWithEmptyMessage() {
        notificationManager.sendNotification(user, "");
    }

    public void testSendNotificationWithNullMessage() {
        notificationManager.sendNotification(user, null);
    }

    public void testSendMultipleNotifications() {
        // Test sending multiple consecutive notifications
        for (int i = 0; i < 3; i++) {
            notificationManager.sendNotification(user, "Test message " + (i + 1));
        }
    }

    public void testSendNotificationWithSpecialCharacters() {
        String specialMessage = "Message with special characters: éàçù€$£";
        notificationManager.sendNotification(user, specialMessage);
    }
}