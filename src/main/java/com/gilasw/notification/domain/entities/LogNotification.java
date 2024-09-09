package com.gilasw.notification.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "log_notification", schema = "public")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogNotification {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "UUID", type = org.hibernate.id.uuid.UuidGenerator.class)
    @Column(name = "log_notification_guid", updatable = false, nullable = false)
    private UUID logNotificationGuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_guid", referencedColumnName = "notification_guid")
    private Notification notification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_guid", referencedColumnName = "user_guid")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_notification_guid", referencedColumnName = "type_notification_guid")
    private TypeNotification typeNotification;

    @Column(name = "date_time_created")
    @CreationTimestamp
    private LocalDateTime dateTimeCreated;
}
