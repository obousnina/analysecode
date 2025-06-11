package notifications.interfaces;

import notifications.model.User;

/**
 * Interface to implement the send of a message.
 */
public interface NotificationChannel {
    /**
     * @param user    which is a User that define who receive the message.
     * @param message which is a String that is the content of the message.
     */
    void send(User user, String message);

    /**
     * @param user which is a User that define who receive the message.
     * @return a boolean to know if you can send a message to this target.
     */
    boolean canSend(User user);
}