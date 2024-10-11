package Exception;

public class NotEnoughInventoryNumberException extends Exception {

    public NotEnoughInventoryNumberException() {;}

    public NotEnoughInventoryNumberException(String message) {
        super(message);
    }

    public NotEnoughInventoryNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
