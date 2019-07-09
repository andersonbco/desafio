package com.andersonbco.desafio.service.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3593782019377638182L;
	
	public UsuarioNaoEncontradoException(String message) {
		super(message);
	}

	public UsuarioNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}
}
