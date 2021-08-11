package com.nisum.cms.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CartManagementException extends Exception {

	private final ErrorCode code;
    private final HttpStatus status;
    private final String debugMessage;
	public CartManagementException(String string, String string2, Long id) {
		super();
		this.code = string;
		this.status = string2;
		this.debugMessage = id;
	}


	
}
