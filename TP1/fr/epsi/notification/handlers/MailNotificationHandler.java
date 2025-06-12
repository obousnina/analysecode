package fr.epsi.notification.handlers;

import fr.epsi.notification.exception.NotificationException;
import fr.epsi.user.User;
import org.apache.commons.lang.StringUtils;

public class MailNotificationHandler extends AbstractNotificationHandler {

    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        super.sendNotification(user, message);
        assertUserHasValidInfo(user.getEmail());

        String email = user.getEmail();
        System.out.println("Sending email to " + email + " with message: " + message);
    }

    @Override
    public boolean canSendMessage(User user) {
        return user != null && StringUtils.isNotEmpty(user.getEmail());
    }

}
