package com.analysecode;


import com.analysecode.channel.EmailNotification;
import com.analysecode.channel.PushNotification;
import com.analysecode.channel.SMSNotification;
import com.analysecode.channel.interfaces.CanalNotification;
import com.analysecode.model.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private final List<CanalNotification> channels = new ArrayList<>();

    /**
     * Default constructor.
     * Initializes the manager with standard channels (email, SMS, push notifications).
     */
    public NotificationManager() {
        channels.add(new EmailNotification());
        channels.add(new SMSNotification());
        channels.add(new PushNotification());
    }

    /**
     * Adds a new notification channel to the manager.
     *
     * @param channel the notification channel to add
     */
    public void addChannel(CanalNotification channel) {
        channels.add(channel);
    }

    /**
     * Sends a notification to a user through all available channels for that user.
     * If no channel is available, a message is displayed in the console.
     *
     * @param user    the recipient user of the notification
     * @param message the content of the message to send
     */
    public void sendNotification(User user, String message) {
        boolean notificationSent = false;

        for (CanalNotification channel : channels) {
            if (channel.canSend(user)) {
                channel.send(user, message);
                notificationSent = true;
            }
        }

        if (!notificationSent) {
            System.out.println("No available channel for this user");
        }
    }
}