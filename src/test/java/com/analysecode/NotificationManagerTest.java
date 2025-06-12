package com.analysecode;

import com.analysecode.channel.WhatsAppNotification;
import com.analysecode.channel.interfaces.CanalNotification;
import com.analysecode.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationManagerTest {

    private NotificationManager notificationManager;

    @Mock
    private CanalNotification mockChannel;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        notificationManager = new NotificationManager();
    }

    @Test
    void givenManagerWithMockChannel_whenAddChannel_thenChannelIsUsed() {
        // Given
        when(mockChannel.canSend(any(User.class))).thenReturn(true);

        // When
        notificationManager.addChannel(mockChannel);
        User user = new User("test@test.com", null, null);
        notificationManager.sendNotification(user, "test message");

        // Then
        verify(mockChannel).canSend(user);
        verify(mockChannel).send(user, "test message");
    }

    @Test
    void givenUserWithEmail_whenSendNotification_thenEmailNotificationIsSent() {
        // Given
        User user = new User("user@test.com", null, null);

        // When
        notificationManager.sendNotification(user, "Hello");

        // Then
        assertTrue(outputStream.toString().contains("Sending email to user@test.com : Hello"));
    }

    @Test
    void givenUserWithNoChannels_whenSendNotification_thenErrorMessageIsShown() {
        // Given
        User user = new User(null, null, null);

        // When
        notificationManager.sendNotification(user, "Hello");

        // Then
        assertTrue(outputStream.toString().contains("No available channel for this user"));
    }

    @Test
    void givenUserWithAllChannels_whenSendNotification_thenAllChannelsAreUsed() {
        // Given
        User user = new User("test@test.com", "0612345678", "token123");
        user.setWhatsAppId("user1");
        notificationManager.addChannel(new WhatsAppNotification());

        // When
        notificationManager.sendNotification(user, "Hello world");

        // Then
        String output = outputStream.toString();
        assertTrue(output.contains("Sending email"));
        assertTrue(output.contains("Sending SMS"));
        assertTrue(output.contains("Sending push notification"));
        assertTrue(output.contains("Sending WhatsApp message"));
    }
}