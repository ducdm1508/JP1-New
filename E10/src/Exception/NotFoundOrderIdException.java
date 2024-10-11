package Exception;

public class NotFoundOrderIdException extends Exception {

    public NotFoundOrderIdException() {;}

    public NotFoundOrderIdException(String message) {
        super(message);
    }

    public NotFoundOrderIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
