package com.analysecode.model;

public class User {
    /**
     * The user's email address for email notifications.
     */
    private String email;
    
    /**
     * The user's phone number for SMS notifications.
     */
    private String phoneNumber;
    
    /**
     * The user's device token for push notifications.
     */
    private String deviceToken;
    
    /**
     * The user's WhatsApp identifier for WhatsApp notifications.
     */
    private String whatsAppId;

    /**
     * Default constructor that creates an empty user.
     */
    public User() {
    }

    /**
     * Creates a user with the specified contact information.
     *
     * @param email       the user's email address
     * @param phoneNumber the user's phone number
     * @param deviceToken the user's device token for push notifications
     */
    public User(String email, String phoneNumber, String deviceToken) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deviceToken = deviceToken;
    }

    /**
     * Gets the user's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's phone number.
     *
     * @return the phone number
     */
    public String getphoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the user's device token for push notifications.
     *
     * @return the device token
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    /**
     * Gets the user's WhatsApp identifier.
     *
     * @return the WhatsApp ID
     */
    public String getWhatsAppId() {
        return whatsAppId;
    }

    /**
     * Sets the user's WhatsApp identifier.
     *
     * @param whatsAppId the WhatsApp ID to set
     */
    public void setWhatsAppId(String whatsAppId) {
        this.whatsAppId = whatsAppId;
    }
}