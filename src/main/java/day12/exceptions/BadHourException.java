package day12.exceptions;

public class BadHourException extends RuntimeException {

  public BadHourException() {
    super();
  }

  public BadHourException(String message) {
    super(message);
  }

  public BadHourException(String message, Throwable cause) {
    super(message, cause);
  }
}
