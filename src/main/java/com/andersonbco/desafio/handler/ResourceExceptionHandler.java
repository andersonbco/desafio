package com.andersonbco.desafio.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andersonbco.desafio.domain.ErrorMessage;
import com.andersonbco.desafio.services.exceptions.EmailJaExistenteException;
import com.andersonbco.desafio.services.exceptions.NaoAutorizadoException;
import com.andersonbco.desafio.services.exceptions.SenhaInvalidaException;
import com.andersonbco.desafio.services.exceptions.TokenInvalidoException;
import com.andersonbco.desafio.services.exceptions.UsuarioInvalidoException;
import com.andersonbco.desafio.services.exceptions.UsuarioNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EmailJaExistenteException.class)
	public ResponseEntity<ErrorMessage> handleEmailJaExistenteException(EmailJaExistenteException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("E-mail já existente");
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagem);
	}

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<ErrorMessage> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("Usuário não encontrado");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
	}
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorMessage> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("Esta API aceita somente o formato JSON");
		
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(mensagem);
	}

	@ExceptionHandler(NaoAutorizadoException.class)
	public ResponseEntity<ErrorMessage> handleNaoAutorizadoException(NaoAutorizadoException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("Não autorizado");
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mensagem);
	}

	@ExceptionHandler(TokenInvalidoException.class)
	public ResponseEntity<ErrorMessage> handleTokenInvalidoException(TokenInvalidoException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("Token inválido");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
	}

	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<ErrorMessage> handleServletRequestBindingException(ServletRequestBindingException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("Token não informado");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
	}

	@ExceptionHandler(UsuarioInvalidoException.class)
	public ResponseEntity<ErrorMessage> handleUsuarioInvalidoException(UsuarioInvalidoException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("Usuário e/ou senha inválidos");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
	}

	@ExceptionHandler(SenhaInvalidaException.class)
	public ResponseEntity<ErrorMessage> handleSenhaInvalidaException(SenhaInvalidaException e, HttpServletRequest request) {
		
		ErrorMessage mensagem = new ErrorMessage();
		mensagem.setMensagem("Usuário e/ou senha inválidos");
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mensagem);
	}
}
