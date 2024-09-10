package com.gilasw.notification.service;

import com.gilasw.notification.controller.dto.RequestSendNotification;
import com.gilasw.notification.domain.entities.Category;
import com.gilasw.notification.domain.entities.Notification;
import com.gilasw.notification.domain.entities.TypeNotification;
import com.gilasw.notification.domain.entities.User;
import com.gilasw.notification.domain.entities.UserCategory;
import com.gilasw.notification.domain.entities.UserTypeNotification;
import com.gilasw.notification.exception.NoSuchCategoryFoundException;
import com.gilasw.notification.repository.NotificationRepository;
import com.gilasw.notification.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NotificationServiceTest {

    @InjectMocks
    NotificationService notificationService;

    @Mock
    NotificationRepository notificationRepository;

    @Mock
    CategoryService categoryService;

    @Mock
    LogNotificationService logNotificationService;

    @Mock
    UserService userService;

    private final String[] valuesCategory = {"Sports", "Finance", "Films"};
    private final String[] valuesTypes = {"SMS", "E-mail", "Push notification"};

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSaveNotificationInTheRepository() {
        var randomInt = new Random();
        var random = new RandomString();

        var nameCategory = valuesCategory[randomInt.nextInt(valuesCategory.length)];
        var category = createCategory(nameCategory);

        var nameTypeNotification = valuesTypes[randomInt.nextInt(valuesTypes.length)];
        var typeNotification = createTypeNotification(nameTypeNotification);

        var message = random.nextString();
        var notification = createNotification(category, message);

        var users = createListUsers(category, typeNotification);

        when(categoryService.findByNameIgnoreCaseCategory(nameCategory)).thenReturn(category);
        when(notificationRepository.save(any())).thenReturn(notification);
        when(userService.findAllUsers()).thenReturn(users);

        notificationService.sendNotification(RequestSendNotification.builder()
                .category(nameCategory)
                .message(message)
                .build());

        verify(logNotificationService, times(users.size())).saveLogNotification(any());
    }

    @Test
    void executeSendNotificationAndThrowsExceptionForInvalidCategory() {
        when(categoryService.findByNameIgnoreCaseCategory("NOT_VALID")).thenReturn(null);

        NoSuchCategoryFoundException exception = assertThrows(NoSuchCategoryFoundException.class, () -> {
            notificationService.sendNotification(RequestSendNotification.builder()
                    .category("NOT_VALID")
                    .build());
        });

        assertEquals(exception.getMessage(), "Category not found NOT_VALID");
    }

    private List<User> createListUsers(Category category, TypeNotification typeNotification) {
        var random = new Random();
        return Stream.generate(() -> createUser(category, typeNotification)).limit(random.nextInt(100)).toList();
    }

    private User createUser(Category category, TypeNotification typeNotification) {
        var random = new RandomString();

        return User.builder()
                .userGuid(UUID.randomUUID())
                .name(random.nextString())
                .email(random.nextString())
                .phone(random.nextString())
                .userCategories(Set.of(UserCategory.builder()
                        .category(category)
                        .build()))
                .userTypeNotifications(Set.of(UserTypeNotification.builder()
                        .typeNotification(typeNotification)
                        .build()))
                .dateTimeCreated(now())
                .build();
    }

    private Notification createNotification(Category category, String message) {
        return Notification.builder()
                .notificationGuid(UUID.randomUUID())
                .message(message)
                .category(category)
                .dateTimeCreated(now())
                .build();
    }

    private Category createCategory(String name) {
        return Category.builder()
                .categoryGuid(UUID.randomUUID())
                .dateTimeCreated(now())
                .name(name)
                .build();
    }

    private TypeNotification createTypeNotification(String name) {
        return TypeNotification.builder()
                .typeNotificationGuid(UUID.randomUUID())
                .dateTimeCreated(now())
                .name(name)
                .build();
    }
}
