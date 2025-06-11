package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class SMSNotification implements CanalNotification {

    /**
     * Sends an SMS message to the user.
     *
     * @param user    the recipient of the SMS message
     * @param message the content to send to the user
     */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending SMS to " + user.getphoneNumber() + ": " + message);
    }
    
    /**
     * Checks if the user has a valid phone number to send SMS notifications.
     *
     * @param user the user to check
     * @return true if the user has a phone number, false otherwise
     */
    @Override
    public boolean canSend(User user) {
        return user.getphoneNumber() != null && !user.getphoneNumber().isEmpty();
    }
}