package notifications.service;

import java.util.ArrayList;
import java.util.List;

import notifications.channels.EmailChannel;
import notifications.channels.PushChannel;
import notifications.channels.SMSChannel;
import notifications.interfaces.NotificationChannel;
import notifications.model.User;

public class NotificationManager {
    private final List<NotificationChannel> channels;

    public NotificationManager() {
        this.channels = new ArrayList<>();
        this.channels.add(new EmailChannel());
        this.channels.add(new SMSChannel());
        this.channels.add(new PushChannel());
    }

    public void addChannel(NotificationChannel channel) {
        this.channels.add(channel);
    }

    public void sendNotification(User user, String message) {
        for (NotificationChannel channel : channels) {
            channel.send(user, message); 
        }
    }
}