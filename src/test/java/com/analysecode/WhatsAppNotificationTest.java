package com.analysecode.channel;

import com.analysecode.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("WhatsApp Notification Channel Tests")
class WhatsAppNotificationTest {

    private WhatsAppNotification whatsAppNotification;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    @BeforeEach
    void setUp() {
        whatsAppNotification = new WhatsAppNotification();
        
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("GIVEN a user with WhatsApp ID WHEN checking can send THEN returns true")
    void givenUserWithWhatsAppId_whenCheckingCanSend_thenReturnsTrue() {
        // GIVEN
        User user = new User();
        user.setWhatsAppId("whatsapp_user_123");
        
        // WHEN
        boolean canSend = whatsAppNotification.canSend(user);
        
        // THEN
        assertTrue(canSend);
    }
    
    @Test
    @DisplayName("GIVEN a user without WhatsApp ID WHEN checking can send THEN returns false")
    void givenUserWithoutWhatsAppId_whenCheckingCanSend_thenReturnsFalse() {
        // GIVEN
        User user = new User("test@example.com", "0612345678", "device123");
        
        // WHEN
        boolean canSend = whatsAppNotification.canSend(user);
        
        // THEN
        assertFalse(canSend);
    }
    
    @Test
    @DisplayName("GIVEN a user with WhatsApp ID WHEN sending message THEN message is sent correctly")
    void givenUserWithWhatsAppId_whenSendingMessage_thenMessageIsSentCorrectly() {
        // GIVEN
        User user = new User();
        user.setWhatsAppId("whatsapp_user_123");
        String message = "Test WhatsApp message";
        
        // WHEN
        whatsAppNotification.send(user, message);
        
        // THEN
        String output = outputStream.toString();
        assertTrue(output.contains("Sending WhatsApp message to whatsapp_user_123"));
        assertTrue(output.contains(message));
    }
}