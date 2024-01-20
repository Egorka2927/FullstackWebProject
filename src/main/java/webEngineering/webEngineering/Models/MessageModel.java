package webEngineering.webEngineering.Models;

/**
 * The model that stores the message
 */
public class MessageModel {
    private String message;

    /**
     * The constructor
     * @param message The message string
     */
    public MessageModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
