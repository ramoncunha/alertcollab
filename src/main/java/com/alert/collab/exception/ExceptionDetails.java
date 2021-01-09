package com.alert.collab.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {

    private String detail;
    private LocalDateTime timestamp;
    private String developerMessage;
}
