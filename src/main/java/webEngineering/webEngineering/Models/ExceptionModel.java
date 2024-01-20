package webEngineering.webEngineering.Models;

/**
 * The model that stores information about the exception
 */
public class ExceptionModel {
    private Object timestamp;
    private Object status;
    private Object error;
    private Object message;
    private Object path;

    /**
     * The constructor
     * @param timestamp The timestamp of the error
     * @param status The status of the error
     * @param error The error of the error
     * @param message The message of the error
     * @param path The location of the error
     */
    public ExceptionModel(Object timestamp, Object status, Object error, Object message, Object path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getPath() {
        return path;
    }

    public void setPath(Object path) {
        this.path = path;
    }
}
