package com.gilasw.notification.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse extends Exception {

  @Builder.Default private String timestamp = Instant.now().toString();

  private String message;

  @JsonProperty("error_details")
  private String errorDetails;

  private int status;

  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}
