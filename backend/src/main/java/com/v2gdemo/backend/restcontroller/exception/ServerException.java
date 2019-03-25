package com.v2gdemo.backend.restcontroller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)

public class ServerException extends RuntimeException {
    public ServerException(String message){
        super(message);
    }
}
