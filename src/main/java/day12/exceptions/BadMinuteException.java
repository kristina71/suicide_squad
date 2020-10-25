package day12.exceptions;

public class BadMinuteException extends RuntimeException {

  public BadMinuteException() {
    super();
  }

  public BadMinuteException(String message) {
    super(message);
  }

  public BadMinuteException(String message, Throwable cause) {
    super(message, cause);
  }
}
