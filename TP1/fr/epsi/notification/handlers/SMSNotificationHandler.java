package fr.epsi.notification.handlers;

import fr.epsi.notification.exception.NotificationException;
import fr.epsi.user.User;
import org.apache.commons.lang.StringUtils;

public class SMSNotificationHandler extends AbstractNotificationHandler {

    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        super.sendNotification(user, message);
        assertUserHasValidInfo(user.getPhoneNumber());

        String phoneNumber = user.getPhoneNumber();
        System.out.println("Sending SMS to " + phoneNumber + " with message: " + message);
    }

    @Override
    public boolean canSendMessage(User user) {
        return user != null && StringUtils.isNotEmpty(user.getPhoneNumber());
    }

}
