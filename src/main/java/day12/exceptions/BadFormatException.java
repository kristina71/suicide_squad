package day12.exceptions;

public class BadFormatException extends RuntimeException {

  public BadFormatException() {
    super();
  }

  public BadFormatException(String message) {
    super(message);
  }

  public BadFormatException(String message, Throwable cause) {
    super(message, cause);
  }
}
