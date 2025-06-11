package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class WhatsAppNotification implements CanalNotification {
    @Override
    public void send(User user, String message) {
        System.out.println("Sending WhatsApp message to " + user.getWhatsAppId() + ": " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user.getWhatsAppId() != null && !user.getWhatsAppId().isEmpty();
    }
}