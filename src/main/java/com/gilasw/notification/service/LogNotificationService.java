package com.gilasw.notification.service;

import com.gilasw.notification.domain.entities.LogNotification;
import com.gilasw.notification.repository.LogNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogNotificationService {

    @Autowired
    LogNotificationRepository logNotificationRepository;

    public LogNotification saveLogNotification(LogNotification logNotification) {
        return logNotificationRepository.save(logNotification);
    }

    public List<LogNotification> getAllLogNotifications() {
        return logNotificationRepository.findAll();
    }
}
