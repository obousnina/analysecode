package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class WhatsAppNotification implements CanalNotification {

    /**
     * Sends a WhatsApp message to the user.
     * 
     * @param user the recipient of the WhatsApp message
     * @param message the content to send to the user
     */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending WhatsApp message to " + user.getWhatsAppId() + ": " + message);
    }

    /**
     * Checks if the user has a valid WhatsApp ID to send notifications.
     *
     * @param user the user to check
     * @return true if the user has a WhatsApp ID, false otherwise
     */
    @Override
    public boolean canSend(User user) {
        return user.getWhatsAppId() != null && !user.getWhatsAppId().isEmpty();
    }
}