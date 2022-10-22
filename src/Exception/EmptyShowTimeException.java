package Exception;

public class EmptyShowTimeException extends Exception {

    public EmptyShowTimeException() {
        super();
    }

    public EmptyShowTimeException(String message) {
        super(message);
    }

    public EmptyShowTimeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
