package fr.epsi.notification;

import fr.epsi.notification.impl.MailNotificationHandler;
import fr.epsi.notification.impl.PushNotificationHandler;
import fr.epsi.notification.impl.SMSNotificationHandler;
import fr.epsi.user.User;

import java.util.Map;
import java.util.logging.Logger;

public class NotificationService {

    private static final Logger LOGGER = Logger.getLogger(NotificationService.class.getName());

    private static final Map<NotificationType, NotificationHandler> handlers = Map.of(
        NotificationType.MAIL, new MailNotificationHandler(),
        NotificationType.SMS, new SMSNotificationHandler(),
        NotificationType.PUSH, new PushNotificationHandler()
    );

    public void sendNotification(User user, String message) {
        if (user == null || message == null || message.isEmpty()) {
            throw new IllegalArgumentException("User and message must not be null or empty");
        }

        for (NotificationHandler handler : handlers.values()) {
            if (handler.canSendMessage(user)) {
                try {
                    handler.sendNotification(user, message);
                } catch (NotificationException | IllegalArgumentException e) {
                    LOGGER.info("Failed to send notification using " + handler.getClass().getSimpleName() + ": " + e.getMessage());
                }
            }
        }
    }

    public void sendNotification(User user, String message, NotificationType type) {
        if (user == null || message == null || message.isEmpty()) {
            throw new IllegalArgumentException("User and message must not be null or empty");
        }

        NotificationHandler handler = handlers.get(type);
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for notification type: " + type);
        }

        if (handler.canSendMessage(user)) {
            try {
                handler.sendNotification(user, message);
            } catch (NotificationException | IllegalArgumentException e) {
                LOGGER.info("Failed to send notification using " + handler.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }

    public enum NotificationType {
        MAIL,
        SMS,
        PUSH
    }

}
