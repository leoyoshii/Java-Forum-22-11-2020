package com.EarphoneModels;

import java.util.NoSuchElementException;

import com.EarphoneModels.Exception.IdsDiveregentesException;
import com.EarphoneModels.Exception.RegistroDuplicadoException;
import com.EarphoneModels.Exception.RegistroNãoEncontradoException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class, RegistroNãoEncontradoException.class})
    public ResponseEntity<Void> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<Void> handleConflict() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(IdsDiveregentesException.class)
    public ResponseEntity<Void> handleBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
