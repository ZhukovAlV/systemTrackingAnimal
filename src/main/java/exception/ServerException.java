package exception;

public class ServerException extends Exception{
    private ErrorCode error;
    private String message;

    public ServerException(ErrorCode error) {
        super();
        this.error = error;
        this.message = error.getErrorString();
    }

    public ErrorCode getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}

