package Exception;
/**
 * Class for performing invalid input exceptions in the application
 */
public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
