package com.bootcamp.bacen.service.config;

import com.bootcamp.bacen.service.exception.ChaveJaCadastradaException;
import com.bootcamp.bacen.service.exception.ChaveNaoLocalizadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ChaveJaCadastradaException.class)
    private ProblemDetail handlerChaveJaCadastrada(ChaveJaCadastradaException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("Chave duplicada");
        problemDetail.setType(URI.create("http://localhost/9001/document/conta-nao-existe"));
        return problemDetail;
    }

    @ExceptionHandler(ChaveNaoLocalizadaException.class)
    private ProblemDetail handlerChaveNaoLocalizada(ChaveNaoLocalizadaException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Chave não localizada");
        problemDetail.setType(URI.create("http://localhost/9001/document/conta-nao-existe"));
        return problemDetail;
    }

}
