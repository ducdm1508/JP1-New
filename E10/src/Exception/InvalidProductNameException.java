package Exception;

public class InvalidProductNameException extends Exception {

    public InvalidProductNameException() {;}

    public InvalidProductNameException(String message) {
        super(message);
    }

    public InvalidProductNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
