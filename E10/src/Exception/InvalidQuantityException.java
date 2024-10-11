package Exception;

public class InvalidQuantityException extends RuntimeException {

    public InvalidQuantityException() {
        super();
    }

    public InvalidQuantityException(String message) {
        super(message);
    }

    public InvalidQuantityException(String message, Throwable cause) {
        super(message, cause);
    }
}
