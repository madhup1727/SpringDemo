package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductNotFound.class)
	public ResponseEntity<Object> exception (ProductNotFound ex) {
		return new ResponseEntity<> ("Product Not Found", HttpStatus.NOT_FOUND);
	}
}
