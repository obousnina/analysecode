package com.analysecode.channel;


import com.analysecode.channel.interfaces.CanalNotification;
import com.analysecode.model.User;

public class EmailNotification implements CanalNotification {
    
    /**
     * Sends an email message to the user.
     *
     * @param user    the recipient of the email
     * @param message the content to send to the user
     */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending email to " + user.getEmail() + " : " + message);
    }

    /**
     * Checks if the user has a valid email address to send notifications.
     *
     * @param user the user to check
     * @return true if the user has an email address, false otherwise
     */
    @Override
    public boolean canSend(User user) {
        return user.getEmail() != null && !user.getEmail().isEmpty();
    }
}