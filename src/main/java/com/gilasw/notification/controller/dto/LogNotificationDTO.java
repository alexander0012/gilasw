package com.gilasw.notification.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogNotificationDTO {

    @JsonProperty("logNotificationGuid")
    private String logNotificationGuid;

    @JsonProperty("message")
    private String message;

    @JsonProperty("category")
    private String category;

    @JsonProperty("typeNotification")
    private String typeNotification;

    @JsonProperty("user")
    private UserNotificationDTO user;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserNotificationDTO {

        @JsonProperty("name")
        private String name;

        @JsonProperty("email")
        private String email;

        @JsonProperty("phone")
        private String phone;}
}
