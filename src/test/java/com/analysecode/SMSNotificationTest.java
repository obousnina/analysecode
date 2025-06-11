package com.analysecode.channel;

import com.analysecode.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("SMS Notification Channel Tests")
class SMSNotificationTest {

    private SMSNotification smsNotification;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    @BeforeEach
    void setUp() {
        smsNotification = new SMSNotification();
        
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("GIVEN a user with phone number WHEN checking can send THEN returns true")
    void givenUserWithPhoneNumber_whenCheckingCanSend_thenReturnsTrue() {
        // GIVEN
        User user = new User(null, "0612345678", null);
        
        // WHEN
        boolean canSend = smsNotification.canSend(user);
        
        // THEN
        assertTrue(canSend);
    }
    
    @Test
    @DisplayName("GIVEN a user without phone number WHEN checking can send THEN returns false")
    void givenUserWithoutPhoneNumber_whenCheckingCanSend_thenReturnsFalse() {
        // GIVEN
        User user = new User("test@example.com", null, null);
        
        // WHEN
        boolean canSend = smsNotification.canSend(user);
        
        // THEN
        assertFalse(canSend);
    }
    
    @Test
    @DisplayName("GIVEN a user with phone number WHEN sending message THEN message is sent correctly")
    void givenUserWithPhoneNumber_whenSendingMessage_thenMessageIsSentCorrectly() {
        // GIVEN
        User user = new User(null, "0612345678", null);
        String message = "Test SMS message";
        
        // WHEN
        smsNotification.send(user, message);
        
        // THEN
        String output = outputStream.toString();
        assertTrue(output.contains("Sending SMS to 0612345678"));
        assertTrue(output.contains(message));
    }
}