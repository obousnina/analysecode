package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class PushNotification implements CanalNotification {
    @Override
    public void send(User user, String message) {
        System.out.println("Sending push notification to " + user.getDeviceToken() + ": " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user.getDeviceToken() != null && !user.getDeviceToken().isEmpty();
    }
}