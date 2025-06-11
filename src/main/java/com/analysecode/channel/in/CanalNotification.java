package com.analysecode.channel.in;


import com.analysecode.model.User;

public interface CanalNotification {
    void send(User user, String message);
    boolean canSend(User user);
}