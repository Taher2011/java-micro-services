package com.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.restfulwebservices.bean.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(exception.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(exception.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(ex.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
