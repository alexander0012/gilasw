package com.gilasw.notification.repository;

import com.gilasw.notification.domain.entities.LogNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogNotificationRepository extends JpaRepository<LogNotification, UUID> {
}
