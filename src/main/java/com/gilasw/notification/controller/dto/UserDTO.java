package com.gilasw.notification.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    
    @JsonProperty("userGuid")
    private String userGuid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("categories")
    private Set<CategoryDTO> categories;

    @JsonProperty("typeNotifications")
    private Set<TypeNotificationDTO> typeNotifications;
}
