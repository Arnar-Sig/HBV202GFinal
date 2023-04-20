package is.hi.hbv202g.finalassignment;

/**
 * An exception that is thrown when an author list is empty.
 */
public class EmptyAuthorListException extends Exception {

    /**
     * Constructs an EmptyAuthorListException exception.
     * @param message The message of the exception.
     */
    public EmptyAuthorListException(String message) {
        super(message);
    }
}

