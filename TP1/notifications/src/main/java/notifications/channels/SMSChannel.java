package notifications.channels;

import notifications.interfaces.NotificationChannel;
import notifications.model.User;

/**
 * Implementation of NotificationChannel for SMS notifications.
 * This channel sends notifications via SMS to user phone numbers.
 */
public class SMSChannel implements NotificationChannel {
    @Override
    public boolean send(User user, String message) {
        if (user != null && user.getPhoneNumber() != null && user.getPhoneNumber().matches("\\+?[0-9]{10,}")) {
            System.out.println("Sending SMS to " + user.getPhoneNumber() + " : " + message);
            return true;
        }
        return false;
    }
}