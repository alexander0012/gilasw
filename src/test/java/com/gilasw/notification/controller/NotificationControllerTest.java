package com.gilasw.notification.controller;

import com.gilasw.notification.controller.dto.RequestSendNotification;
import com.gilasw.notification.exception.MessageEmptyException;
import com.gilasw.notification.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class NotificationControllerTest {

    @InjectMocks
    NotificationController notificationController;

    @Mock
    NotificationService notificationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccessfulSendNotification() throws MessageEmptyException {
        var request = createRequest("Text Message", "Sport");

        notificationController.sendNotification(request);

        verify(notificationService, times(1)).sendNotification(request);
    }

    @Test
    void throwsExceptionMissedInformation() throws MessageEmptyException {
        var request = createRequest(null, null);

        var messageEmptyException = assertThrows(MessageEmptyException.class, () -> {
            notificationController.sendNotification(request);
        });

        assertEquals(messageEmptyException.getMessage(),
                "Message cannot be empty, bad request in the body");
    }

    private RequestSendNotification createRequest(String message, String category) {
        return RequestSendNotification.builder()
                .message(message)
                .category(category)
                .build();
    }
}
