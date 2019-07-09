package com.andersonbco.desafio.service.exceptions;

public class SessaoInvalidaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7423565312201092566L;

	public SessaoInvalidaException(String message) {
		super(message);
	}

	public SessaoInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}
}
