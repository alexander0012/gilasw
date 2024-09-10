package com.gilasw.notification.service;

import com.gilasw.notification.domain.entities.Category;
import com.gilasw.notification.domain.entities.User;
import com.gilasw.notification.domain.entities.UserCategory;
import com.gilasw.notification.domain.entities.UserTypeNotification;
import com.gilasw.notification.repository.CategoryRepository;
import com.gilasw.notification.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSearchAllUsersInTheRepository() {
        var users = createListUsers();

        when(userRepository.findAll()).thenReturn(users);

        var usersReturned = userService.findAllUsers();

        assertEquals(users.size(), usersReturned.size());
    }

    private List<User> createListUsers() {
        var random = new Random();
        return Stream.generate(this::createUser).limit(random.nextInt(100)).toList();
    }

    private User createUser() {
        var random = new RandomString();

        return User.builder()
                .userGuid(UUID.randomUUID())
                .name(random.nextString())
                .email(random.nextString())
                .phone(random.nextString())
                .userCategories(Set.of(UserCategory.builder().build(), UserCategory.builder().build()))
                .userTypeNotifications(Set.of(UserTypeNotification.builder().build(), UserTypeNotification.builder().build()))
                .dateTimeCreated(now())
                .build();
    }
}
