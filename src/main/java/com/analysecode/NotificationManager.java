package com.analysecode;


import com.analysecode.channel.EmailNotification;
import com.analysecode.channel.PushNotification;
import com.analysecode.channel.SMSNotification;
import com.analysecode.channel.in.CanalNotification;
import com.analysecode.model.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private final List<CanalNotification> channels = new ArrayList<>();

    public NotificationManager() {
        channels.add(new EmailNotification());
        channels.add(new SMSNotification());
        channels.add(new PushNotification());
    }

    public void addChannel(CanalNotification channel) {
        channels.add(channel);
    }

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