package com.analysecode.channel;


import com.analysecode.channel.interfaces.CanalNotification;
import com.analysecode.model.User;

public class PushNotification implements CanalNotification {

    /**
     * Sends a push notification message to the user.
     * 
     * @param user    the recipient of the push notification
     * @param message the content to send to the user
     */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending push notification to " + user.getDeviceToken() + ": " + message);
    }

    /**
     * Checks if the user has a valid device token to send push notifications.
     *
     * @param user the user to check
     * @return true if the user has a device token, false otherwise
     */
    @Override
    public boolean canSend(User user) {
        return user.getDeviceToken() != null && !user.getDeviceToken().isEmpty();
    }
}