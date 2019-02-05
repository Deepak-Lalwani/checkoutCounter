package com.mediaocean.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@RestController
public class customException {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorResponse> handleUncaughtException(Exception e) {
		ErrorResponse error = new ErrorResponse();
		final int errorCode = 5000;
		error.setErrorCode(errorCode);
		error.setMessage("Application Error");
		error.setErrorMessage("Exception");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

	@ExceptionHandler(MediaOceanException.class)
	public ResponseEntity<ErrorResponse> handleMediaOceanException(MediaOceanException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(ex.getErrorCode());
		error.setMessage(ex.getMessage());
		error.setErrorMessage(ex.getErrorMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	

}
