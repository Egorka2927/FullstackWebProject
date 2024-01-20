package webEngineering.webEngineering.Exceptions;

/**
 * Exception for the case when the user wants
 * to add some data in the database
 * and the data already exists
 */
public class DataAlreadyExistsException extends Exception{
    /**
     * The constructor
     * @param message The message string
     */
    public DataAlreadyExistsException(String message) {
        super(message);
    }
}
