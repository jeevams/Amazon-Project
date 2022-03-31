package com.example.amazon.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(value = BusinessException.class)

	public ResponseEntity<CustomErrorResponse> BusinessException(BusinessException e) {

		CustomErrorResponse error = new CustomErrorResponse(e.getCode(),e.getMessage());

		error.setTimestamp(LocalDateTime.now());

		error.setStatus((HttpStatus.NOT_FOUND.value()));

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


	}
}

	