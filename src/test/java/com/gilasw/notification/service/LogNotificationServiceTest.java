package com.gilasw.notification.service;

import com.gilasw.notification.domain.entities.Category;
import com.gilasw.notification.domain.entities.LogNotification;
import com.gilasw.notification.domain.entities.Notification;
import com.gilasw.notification.domain.entities.TypeNotification;
import com.gilasw.notification.domain.entities.User;
import com.gilasw.notification.repository.CategoryRepository;
import com.gilasw.notification.repository.LogNotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LogNotificationServiceTest {

    @InjectMocks
    LogNotificationService logNotificationService;

    @Mock
    LogNotificationRepository logNotificationRepository;

    private final String[] valuesTypes = {"SMS", "E-mail", "Push notification"};

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSaveLogNotificationInTheRepository() {
        var logNotification = createLogNotification();

        when(logNotificationRepository.save(logNotification)).thenReturn(logNotification);

        var logNotificationSaved = logNotificationService.saveLogNotification(logNotification);

        verify(logNotificationRepository, times(1)).save(logNotification);
        assertEquals(logNotification.getLogNotificationGuid(), logNotificationSaved.getLogNotificationGuid());
    }

    private LogNotification createLogNotification() {
        var random  = new Random();

        return LogNotification.builder()
                .logNotificationGuid(UUID.randomUUID())
                .typeNotification(TypeNotification.builder()
                        .typeNotificationGuid(UUID.randomUUID())
                        .name(valuesTypes[random.nextInt(valuesTypes.length)])
                        .dateTimeCreated(now())
                        .build())
                .user(User.builder().build())
                .notification(Notification.builder().build())
                .dateTimeCreated(now())
                .build();
    }
}
