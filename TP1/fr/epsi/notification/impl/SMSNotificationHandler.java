package fr.epsi.notification.impl;

import fr.epsi.notification.ISMSNotificationHandler;
import fr.epsi.notification.NotificationException;
import fr.epsi.user.User;

import java.util.Optional;

public class SMSNotificationHandler extends AbstractNotificationHandler implements ISMSNotificationHandler {

    public void sendNotification(User user, String message) throws NotificationException {
        super.sendNotification(user, message);

        String phoneNumber = getPhoneNumber(user);
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }

    public String getPhoneNumber(User user) {
        Optional<String> phoneNumber = Optional.ofNullable(user.getPhoneNumber());
        return phoneNumber.orElseThrow(() -> new NotificationException("Phone number is required for SMS notifications"));
    }
}
