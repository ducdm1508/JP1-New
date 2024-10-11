package Exception;

public class InvalidProducIdException extends RuntimeException{

    public InvalidProducIdException(){;}

    public InvalidProducIdException(String message){
        super(message);
    }

    public InvalidProducIdException(String message, Throwable cause){
        super(message, cause);
    }
}
