package com.chainbox.safaricom.careerstest.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad request passed.")
public class BadRequestException extends RuntimeException {
}
