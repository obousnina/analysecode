package fr.epsi.notification.impl;

import fr.epsi.notification.NotificationException;
import fr.epsi.notification.NotificationHandler;
import fr.epsi.user.User;
import org.apache.commons.lang.StringUtils;

public abstract class AbstractNotificationHandler implements NotificationHandler {

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
