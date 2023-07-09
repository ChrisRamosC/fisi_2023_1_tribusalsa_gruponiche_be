package com.usuario.servicio.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new MessageDto(HttpStatus.NOT_FOUND.value(),e.getMessage()));
	}
	
	@ExceptionHandler(AttributeException.class)
	public ResponseEntity<MessageDto> throwAttributeException(AttributeException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new MessageDto(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageDto> validationException(MethodArgumentNotValidException e){
		List<String> mensajes=new ArrayList<>();
		e.getBindingResult().getAllErrors().forEach((err)->{
			mensajes.add(err.getDefaultMessage());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new MessageDto(HttpStatus.BAD_REQUEST.value(),Operations.trimBrackets(mensajes.toString())));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageDto> generalException(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
	}
}
