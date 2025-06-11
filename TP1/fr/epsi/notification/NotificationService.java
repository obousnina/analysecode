package fr.epsi.notification;

import fr.epsi.notification.impl.MailNotificationHandler;
import fr.epsi.notification.impl.PushNotificationHandler;
import fr.epsi.notification.impl.SMSNotificationHandler;

import java.util.Map;

public class NotificationService {

    private static final Map<NotificationType, NotificationHandler> handlers = Map.of(
        NotificationType.MAIL, new MailNotificationHandler(),
        NotificationType.SMS, new SMSNotificationHandler(),
        NotificationType.PUSH, new PushNotificationHandler()
    );

    public enum NotificationType {
        MAIL,
        SMS,
        PUSH
    }

}
