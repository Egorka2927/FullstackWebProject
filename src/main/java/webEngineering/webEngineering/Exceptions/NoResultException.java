package webEngineering.webEngineering.Exceptions;

/**
 * Exception for the case when the user
 * wants to get access to the data that
 * does not exist
 */
public class NoResultException extends Exception{
    /**
     * The constructor
     * @param message The message string
     */
    public NoResultException(String message) {
        super(message);
    }
}
