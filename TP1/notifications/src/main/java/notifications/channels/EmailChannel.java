package notifications.channels;

import notifications.interfaces.NotificationChannel;
import notifications.model.User;

/**
 * Implementation of NotificationChannel for email notifications.
 * This channel sends notifications via email to users.
 */
public class EmailChannel implements NotificationChannel {
    @Override
    public boolean send(User user, String message) {
        if (user != null && user.getEmail() != null && user.getEmail().contains("@")) {
            System.out.println("Sending email to " + user.getEmail() + " : " + message);
            return true;
        }
        return false;
    }
}