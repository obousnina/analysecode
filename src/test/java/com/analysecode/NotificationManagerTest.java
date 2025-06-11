package com.analysecode;

import com.analysecode.channel.EmailNotification;
import com.analysecode.channel.SMSNotification;
import com.analysecode.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationManagerTest {

    private NotificationManager notificationManager;

    @Mock
    private EmailNotification emailMock;

    @Mock
    private SMSNotification smsMock;

    @BeforeEach
    void setUp() {
        notificationManager = new NotificationManager();

        notificationManager.addChannel(emailMock);
        notificationManager.addChannel(smsMock);
    }

    @Test
    void testSendEmailOnly() {
        User user = new User("test@example.com", null, null);

        when(emailMock.canSend(user)).thenReturn(true);
        when(smsMock.canSend(user)).thenReturn(false);

        notificationManager.sendNotification(user, "Test");

        verify(emailMock, times(1)).send(user, "Test");
        verify(smsMock, never()).send(any(User.class), anyString());
    }
}