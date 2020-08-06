package com.telstra.codechallenge.handler;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

	public NotFoundException(HttpStatus notFound) {
		// TODO Auto-generated constructor stub
		super(notFound.toString());
	}
	
	

}
