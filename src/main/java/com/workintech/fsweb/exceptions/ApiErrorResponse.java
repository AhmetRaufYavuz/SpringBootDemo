package com.workintech.fsweb.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ApiErrorResponse {
    private int status;
    private String message;
    private LocalDateTime currentTime;
}
