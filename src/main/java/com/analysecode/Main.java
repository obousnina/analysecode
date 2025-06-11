package com.analysecode;


import com.analysecode.channel.WhatsAppNotification;
import com.analysecode.model.User;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.addChannel(new WhatsAppNotification());

        User user = new User("user@gmail.com", "0612345678", null);
        user.setWhatsAppId("user1");

        manager.sendNotification(user, "Hello world !");
    }
}