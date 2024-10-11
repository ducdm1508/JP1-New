package Exception;

public class NotFoundProductIdException extends Exception {

    public NotFoundProductIdException() {;}

    public NotFoundProductIdException(String message) {
        super(message);
    }

    public NotFoundProductIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
