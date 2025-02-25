package com.BlogApplication.exception;

import java.net.ResponseCache;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.BlogApplication.Dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandle {
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(){
		
		return null;
    	
    }
}
