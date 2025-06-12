package com.analysecode;

import com.analysecode.channel.PushNotification;
import com.analysecode.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Push Notification Channel Tests")
class PushNotificationTest {

    private PushNotification pushNotification;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        pushNotification = new PushNotification();
        
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("GIVEN a user with device token WHEN checking can send THEN returns true")
    void givenUserWithDeviceToken_whenCheckingCanSend_thenReturnsTrue() {
        // GIVEN
        User user = new User(null, null, "device_token_123");
        
        // WHEN AND THEN
        assertTrue(pushNotification.canSend(user));
    }
    
    @Test
    @DisplayName("GIVEN a user without device token WHEN checking can send THEN returns false")
    void givenUserWithoutDeviceToken_whenCheckingCanSend_thenReturnsFalse() {
        // GIVEN
        User user = new User("test@example.com", "0612345678", null);
        
        // WHEN AND THEN
        assertFalse(pushNotification.canSend(user));
    }
    
    @Test
    @DisplayName("GIVEN a user with device token WHEN sending message THEN message is sent correctly")
    void givenUserWithDeviceToken_whenSendingMessage_thenMessageIsSentCorrectly() {
        // GIVEN
        User user = new User(null, null, "device_token_123");
        String message = "Test push notification";
        
        // WHEN
        pushNotification.send(user, message);
        
        // THEN
        String output = outputStream.toString();
        assertTrue(output.contains("Sending push notification to device_token_123"));
        assertTrue(output.contains(message));
    }
}