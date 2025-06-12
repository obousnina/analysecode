package com.analysecode.channel.interfaces;


import com.analysecode.model.User;

public interface CanalNotification {

    /**
     * Sends a notification message to the specified user through this channel.
     *
     * @param user    the recipient of the notification
     * @param message the content to be delivered to the user
     */
    void send(User user, String message);

    /**
     * Checks if this notification channel can be used to send messages to the specified user.
     * This might verify if the user has the necessary contact information for this channel
     * (email address, phone number, device token, etc.) or has enabled notifications
     * for this specific channel.
     *
     * @param user the user to check
     * @return true if this channel can be used to send notifications to the user, false otherwise
     */
    boolean canSend(User user);
}