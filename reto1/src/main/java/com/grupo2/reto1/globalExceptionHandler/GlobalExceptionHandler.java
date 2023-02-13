package com.grupo2.reto1.globalExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// sobreescribimos el metodo de gestionar el error 400
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		// creamos una lista de objetos con los atributos enviados que dan error
		// informando del objeto que da error (objectName), el campo que da error (field), 
		// el mensaje por defecto que definimos en la anotacion de la clase (defaultMessage)
		// y el valor que se ha rechazado, el enviado por el usuario (rejectedValue)
        List<ErrorMessageDto> validationErrorDetails = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ErrorMessageDto(error.getObjectName(),error.getField(),error.getDefaultMessage(),error.getRejectedValue().toString()))
                .collect(Collectors.toList());
        
        // Devolvemos un objeto personalizado, añadiendo el nombre del error (BAD_REQUEST) y el código del error (400)
        ErrorResponse response = new ErrorResponse(status.name(), status.value(), validationErrorDetails);
        return new ResponseEntity<>(response, status);

    }

}
