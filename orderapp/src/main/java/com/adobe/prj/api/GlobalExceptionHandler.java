package com.adobe.prj.api;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adobe.prj.service.EntityNotFoundException;

// this will be used when exceptions are thrown from controller
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getMessage());
		body.put("STATUS", HttpStatus.NOT_FOUND);
		body.put("Timestamp", new Date());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
