package util;

public class PlayerException extends RuntimeException {

    public PlayerException(String message){
        super(message);
    }

    public PlayerException(String message, Throwable t){
        super(message, t);
    }

}
