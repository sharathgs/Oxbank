package com.homeloan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.homeloan.dto.HomeLoanDto;

@ControllerAdvice
public class HomeLoanExceptionHandler {
	
	public ResponseEntity<HomeLoanDto> handleException(Exception e)
	{
		return new ResponseEntity<HomeLoanDto>(new HomeLoanDto(e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
	}

}
