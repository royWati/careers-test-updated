package com.chainbox.safaricom.careerstest.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "you have reached the limit of applying 3 jobs")
public class MaximumJobsAppliedExeption extends RuntimeException {
}
