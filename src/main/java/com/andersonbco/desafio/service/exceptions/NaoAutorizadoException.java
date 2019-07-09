package com.andersonbco.desafio.service.exceptions;

public class NaoAutorizadoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2635563909908834588L;

	public NaoAutorizadoException(String message) {
		super(message);
	}

	public NaoAutorizadoException(String message, Throwable cause) {
		super(message, cause);
	}
}
