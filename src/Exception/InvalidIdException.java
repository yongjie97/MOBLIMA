package Exception;
/**
 * Class for performing invalid Id exceptions in the application
 */
public class InvalidIdException extends Exception {

    public InvalidIdException() {
        super();
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
