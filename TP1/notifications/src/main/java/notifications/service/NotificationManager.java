package notifications.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import notifications.channels.EmailChannel;
import notifications.channels.PushChannel;
import notifications.channels.SMSChannel;
import notifications.interfaces.NotificationChannel;
import notifications.model.User;

/**
 * Class to manage the send of notifications.
 */
public class NotificationManager {
    private final List<NotificationChannel> channels;

    public NotificationManager() {
        this.channels = new ArrayList<>();
        this.channels.add(new EmailChannel());
        this.channels.add(new SMSChannel());
        this.channels.add(new PushChannel());
    }

    /**
     * Add a the channel to the notification manager.
     *
     * @param channel is a NotificationChannel which correspond to a channel like
     *                email, sms or push notification.
     */
    public void addChannel(NotificationChannel channel) {
        this.channels.add(channel);
    }

    /**
     * Send a notification to the user. The content of the notification is the
     * content of the message.
     *
     * @param user    is a User who will receive the message
     * @param message is a String which correspond to the content of the
     *                notification to send.
     * @return a map with the channel class name as key and the result (true/false)
     *         as value
     */
    public Map<String, Boolean> sendNotification(User user, String message) {
        Map<String, Boolean> results = new HashMap<>();
        for (NotificationChannel channel : channels) {
            String channelName = channel.getClass().getSimpleName();
            boolean result = channel.send(user, message);
            results.put(channelName, result);
        }
        return results;
    }
}