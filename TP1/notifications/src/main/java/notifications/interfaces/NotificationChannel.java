package notifications.interfaces;

import notifications.model.User;

/**
 * Interface to implement the send of a message.
 */
public interface NotificationChannel {
    /**
     * @param user    which is a User that define who receive the message.
     * @param message which is a String that is the content of the message.
     * @return true if the message is sent successfully, false otherwise.
     */
    boolean send(User user, String message);
}