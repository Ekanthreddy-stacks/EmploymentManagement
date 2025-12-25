package com.example.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainController {

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
//		Map<String, Object> errors = new HashMap<>();
//		ex.getBindingResult().getFieldErrors()
//				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
//		return ResponseHandler.response(errors, "Validation failed", false);

//	}
}
