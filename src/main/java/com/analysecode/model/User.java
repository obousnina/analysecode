package com.analysecode.model;

public class User {
    private String email;
    private String phoneNumber;
    private String deviceToken;
    private String whatsAppId;

    public User() {
    }

    public User(String email, String phoneNumber, String deviceToken) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deviceToken = deviceToken;
    }

    public String getEmail() {
        return email;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public String getWhatsAppId() {
        return whatsAppId;
    }

    public void setWhatsAppId(String whatsAppId) {
        this.whatsAppId = whatsAppId;
    }
}