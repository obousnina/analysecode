package notifications.interfaces;

/**
 * Interface to implement the send of a message.
 */
public interface NotificationChannel {
    /**
     * @param target  which is a String that define who receive the message.
     * @param message which is a String that is the content of the message.
     */
    void send(String target, String message);

    /**
     * @param target which is a String that define who receive the message.
     * @return a boolean to know if you can send a message to this target.
     */
    boolean canSend(String target);
} 