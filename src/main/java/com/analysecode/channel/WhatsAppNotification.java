package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class WhatsAppNotification implements CanalNotification {

    /*
     * This class implements the CanalNotification interface to send WhatsApp notifications.
     * It checks if the user has a valid WhatsApp ID before sending the message.
     * If the WhatsApp ID is valid, it prints a message to the console simulating sending a WhatsApp message.
     */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending WhatsApp message to " + user.getWhatsAppId() + ": " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user.getWhatsAppId() != null && !user.getWhatsAppId().isEmpty();
    }
}