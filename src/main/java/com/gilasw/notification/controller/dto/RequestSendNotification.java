package com.gilasw.notification.controller.dto;

import lombok.Data;

@Data
public class RequestSendNotification {

    private String category;
    private String message;
}
