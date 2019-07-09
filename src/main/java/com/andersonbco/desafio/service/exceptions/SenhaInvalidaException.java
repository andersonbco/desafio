package com.andersonbco.desafio.service.exceptions;

public class SenhaInvalidaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9105703505480875288L;

	public SenhaInvalidaException(String message) {
		super(message);
	}

	public SenhaInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}
}
