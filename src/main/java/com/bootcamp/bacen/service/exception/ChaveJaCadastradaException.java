package com.bootcamp.bacen.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ChaveJaCadastradaException extends RuntimeException {

    public ChaveJaCadastradaException(String message) {
        super(message);
    }
}
