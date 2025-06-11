package fr.epsi.test.impl;

import fr.epsi.test.ISMSNotificationHandler;
import fr.epsi.test.NotificationException;
import fr.epsi.test.user.User;

import java.util.Optional;

public class SMSNotificationHandler extends AbstractNotificationHandler implements ISMSNotificationHandler {

    public void sendNotification(User user, String message) throws NotificationException {
        String phoneNumber = getPhoneNumber(user);
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }

    public String getPhoneNumber(User user) {
        Optional<String> phoneNumber = Optional.ofNullable(user.getPhoneNumber());
        return phoneNumber.orElseThrow(() -> new NotificationException("Phone number is required for SMS notifications"));
    }
}
