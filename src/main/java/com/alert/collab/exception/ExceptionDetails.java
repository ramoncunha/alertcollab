package com.alert.collab.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {

    protected String detail;
    protected LocalDateTime timestamp;
    protected String developerMessage;
}
