package Exception;

public class EmptyListException extends Exception {

    public EmptyListException() {
        super();
    }

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
