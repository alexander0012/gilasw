package com.gilasw.notification.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSendNotification {

    private String category;
    private String message;
}
