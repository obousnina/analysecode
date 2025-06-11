package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class SMSNotification implements CanalNotification {

    /*
     * This class implements the CanalNotification interface to send SMS notifications.
     * It checks if the user has a valid phone number before sending the message.
     * If the phone number is valid, it prints a message to the console simulating sending an SMS.
     */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending SMS to " + user.getphoneNumber() + ": " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user.getphoneNumber() != null && !user.getphoneNumber().isEmpty();
    }
}