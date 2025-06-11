package com.analysecode.channel;


import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

public class EmailNotification implements CanalNotification {
    /*
    * This class implements the CanalNotification interface to send email notifications.
    * It checks if the user has a valid email address before sending the message.
    * If the email is valid, it prints a message to the console simulating sending an email.
    */
    @Override
    public void send(User user, String message) {
        System.out.println("Sending email to " + user.getEmail() + " : " + message);
    }

    @Override
    public boolean canSend(User user) {
        return user.getEmail() != null && !user.getEmail().isEmpty();
    }
}