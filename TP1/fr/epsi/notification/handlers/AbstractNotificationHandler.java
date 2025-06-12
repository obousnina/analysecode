package fr.epsi.notification.handlers;

import fr.epsi.notification.exception.NotificationException;
import fr.epsi.user.User;
import org.apache.commons.lang.StringUtils;

public abstract class AbstractNotificationHandler implements NotificationHandler {

    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        assertUserIsNotNull(user);
        assertMessageIsNotEmpty(message);
    }

    void assertUserIsNotNull(User user) {
        if (user == null) {
            throw new NotificationException("User cannot be null");
        }
    }

    void assertMessageIsNotEmpty(String message) {
        if (message == null || StringUtils.isEmpty(message) || StringUtils.isBlank(message)) {
            throw new NotificationException("Message cannot be null or empty");
        }
    }

    void assertUserHasValidInfo(String information) {
        if (information == null || StringUtils.isEmpty(information) || StringUtils.isBlank(information)) {
            throw new NotificationException("User information cannot be null or empty");
        }
    }

}
