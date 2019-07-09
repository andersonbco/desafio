package com.andersonbco.desafio.service.exceptions;

public class UsuarioInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1032091764225989441L;

	public UsuarioInvalidoException(String message) {
		super(message);
	}

	public UsuarioInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}
}
