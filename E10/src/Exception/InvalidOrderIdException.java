package Exception;

public class InvalidOrderIdException extends RuntimeException {

    public InvalidOrderIdException() {;}

    public InvalidOrderIdException(String message) {
        super(message);
    }

    public InvalidOrderIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
