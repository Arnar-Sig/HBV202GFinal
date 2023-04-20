package is.hi.hbv202g.finalassignment;

/**
 * An exception that is thrown when a user or book does not exist.
 */
public class UserOrBookDoesNotExistException extends Exception {

    /**
     * Constructs UserOrBookDoesNotExistException exception.
     * @param message The message of the exception.
     */
    public UserOrBookDoesNotExistException(String message) {
        super(message);
    }
}

