package com.chainbox.safaricom.careerstest.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "You have an interview scheduled at that time")
public class JobConflictException extends RuntimeException {
}
