package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class PushNotification implements CanalNotification {

    /*
     * This class implements the CanalNotification interface to send push notifications.
     * It checks if the user has a valid device token before sending the message.
     * If the device token is valid, it prints a message to the console simulating sending a push notification.
     */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending push notification to " + user.getDeviceToken() + ": " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user.getDeviceToken() != null && !user.getDeviceToken().isEmpty();
    }
}