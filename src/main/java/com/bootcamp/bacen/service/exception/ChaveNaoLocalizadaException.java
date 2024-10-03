package com.bootcamp.bacen.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChaveNaoLocalizadaException extends RuntimeException {

    public ChaveNaoLocalizadaException(String message) {
        super(message);
    }
}
