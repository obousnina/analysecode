package com.analysecode;

import com.analysecode.channel.WhatsAppNotification;
import com.analysecode.model.User;

public class Main {
    /**
     * Creates a notification manager, adds a WhatsApp channel to the default channels,
     * creates a sample user with contact information, and sends a test notification.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        // Add custom notification channel
        manager.addChannel(new WhatsAppNotification());

        // Create a user with email and phone number
        User user = new User("user@gmail.com", "0612345678", null);
        user.setWhatsAppId("user1");

        // Send a test notification through all available channels
        manager.sendNotification(user, "Hello world !");
    }
}