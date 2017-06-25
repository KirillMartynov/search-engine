package engine.server.exception;

public class InvalidQueryException extends RuntimeException {
    public InvalidQueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidQueryException(String message) {
        super(message);
    }
}
