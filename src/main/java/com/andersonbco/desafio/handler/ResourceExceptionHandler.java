package com.andersonbco.desafio.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andersonbco.desafio.domain.ErrorMessage;
import com.andersonbco.desafio.services.exceptions.EmailJaExistenteException;
import com.andersonbco.desafio.services.exceptions.UsuarioNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EmailJaExistenteException.class)
	public ResponseEntity<ErrorMessage> handleEmailJaExistenteException(EmailJaExistenteException e, HttpServletRequest request) {
		
		ErrorMessage message = new ErrorMessage();
		message.setMessage("E-mail já existente");
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
	}

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<ErrorMessage> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e, HttpServletRequest request) {
		
		ErrorMessage message = new ErrorMessage();
		message.setMessage("Usuário não encontrado");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
