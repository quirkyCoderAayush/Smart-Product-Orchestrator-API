package com.publicissapient.products_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SearchInitializationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SearchInitializationException(String message, Throwable cause) {
		super(message, cause);
	}

}
