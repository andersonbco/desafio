package com.andersonbco.desafio.service.exceptions;

public class TokenInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5134017157172145481L;

	public TokenInvalidoException(String message) {
		super(message);
	}

	public TokenInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}
}
