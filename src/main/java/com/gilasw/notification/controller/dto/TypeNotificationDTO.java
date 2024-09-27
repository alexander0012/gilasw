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
public class TypeNotificationDTO {

    @JsonProperty("typeNotificationGuid")
    private String typeNotificationGuid;

    @JsonProperty("name")
    private String name;
}
