
package com.andersonbco.desafio.exceptions;

public class EmailJaExistenteException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -5377409233914155231L;

  public EmailJaExistenteException(String message) {
    super(message);
  }

  public EmailJaExistenteException(String message, Throwable cause) {
    super(message, cause);
  }
}
