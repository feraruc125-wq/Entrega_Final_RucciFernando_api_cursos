package com.educacion.api_cursos.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    Map<String, String> errores = new HashMap<>();

    // Recorremos todos los errores que encontró Spring (precio negativo, titulo vacio, etc)
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String campo = ((FieldError) error).getField(); // Ej: "precio"
      String mensaje = error.getDefaultMessage();     // Ej: "El precio no puede ser negativo"
      errores.put(campo, mensaje);
    });

    return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
  }
}