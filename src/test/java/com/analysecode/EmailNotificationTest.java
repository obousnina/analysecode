package com.analysecode;

import com.analysecode.channel.EmailNotification;
import com.analysecode.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Email Notification Channel Tests")
class EmailNotificationTest {

    private EmailNotification emailNotification;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        emailNotification = new EmailNotification();
        
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("GIVEN a user with email WHEN checking can send THEN returns true")
    void givenUserWithEmail_whenCheckingCanSend_thenReturnsTrue() {
        // GIVEN
        User user = new User("test@example.com", null, null);

        // WHEN AND THEN
        assertTrue(emailNotification.canSend(user));
    }
    
    @Test
    @DisplayName("GIVEN a user without email WHEN checking can send THEN returns false")
    void givenUserWithoutEmail_whenCheckingCanSend_thenReturnsFalse() {
        // GIVEN
        User user = new User(null, "0612345678", null);
        
        // WHEN AND THEN
        assertFalse(emailNotification.canSend(user));
    }
    
    @Test
    @DisplayName("GIVEN a user with email WHEN sending message THEN message is sent correctly")
    void givenUserWithEmail_whenSendingMessage_thenMessageIsSentCorrectly() {
        // GIVEN
        User user = new User("recipient@example.com", null, null);
        String message = "Test email message";
        
        // WHEN
        emailNotification.send(user, message);
        
        // THEN
        String output = outputStream.toString();
        assertTrue(output.contains("Sending email to recipient@example.com"));
        assertTrue(output.contains(message));
    }
}