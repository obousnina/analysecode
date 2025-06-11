package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class SMSNotification implements CanalNotification {
    @Override
    public void send(User user, String message) {
        System.out.println("Sending SMS to " + user.getphoneNumber() + ": " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user.getphoneNumber() != null && !user.getphoneNumber().isEmpty();
    }
}