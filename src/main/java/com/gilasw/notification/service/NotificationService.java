package com.gilasw.notification.service;

import com.gilasw.notification.controller.dto.RequestSendNotification;
import com.gilasw.notification.domain.entities.LogNotification;
import com.gilasw.notification.domain.entities.Notification;
import com.gilasw.notification.exception.NoSuchCategoryFoundException;
import com.gilasw.notification.repository.NotificationRepository;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.text.MessageFormat.format;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    LogNotificationService logNotificationService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void sendNotification(RequestSendNotification notification) {
        var categoryFound = categoryService.findByNameIgnoreCaseCategory(notification.getCategory());

        if (categoryFound == null) {
            throw new NoSuchCategoryFoundException(format("Category not found {0}", notification.getCategory()), new Throwable());
        }

        var notificationSaved = saveNotification(Notification.builder()
                .category(categoryFound)
                .message(notification.getMessage())
                .build());
        var users = userService.findAllUsers();

        users.stream().filter(
                user -> user.getUserCategories().stream()
                        .anyMatch(category -> category.getCategory().getCategoryGuid()
                                .equals(notificationSaved.getCategory().getCategoryGuid())))
                .forEach(
                        user -> user.getUserTypeNotifications().forEach(
                                typeNotification -> {
                                    logNotificationService.saveLogNotification(LogNotification.builder()
                                                    .user(user)
                                                    .typeNotification(typeNotification.getTypeNotification())
                                                    .notification(notificationSaved)
                                            .build());
                                }));

    }
}
