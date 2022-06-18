package waterbets.exceptions;

public class FailedNewUserInsertException extends RuntimeException {

    public FailedNewUserInsertException(String message) {
        super(message);
    }
}
