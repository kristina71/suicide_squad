package day12.exceptions;

public class BadNumberException extends RuntimeException {
  public BadNumberException() {
    super();
  }

  public BadNumberException(String message) {
    super(message);
  }

  public BadNumberException(String message, Throwable cause) {
    super(message, cause);
  }
}
