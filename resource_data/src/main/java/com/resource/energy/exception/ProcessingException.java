package com.resource.energy.exception;

/**
 * @author Abdussamad
 */
public class ProcessingException extends RuntimeException {

  public ProcessingException(String message) {
    super(message);
  }

  public ProcessingException(Throwable cause) {
    super(cause);
  }
}
