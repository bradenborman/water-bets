package waterbets.exceptions;

public class FailureToRescindWaterBetException extends RuntimeException {

    //Is thrown when a user attempts to rescind a row that is no longer in AcceptanceStatus.NOT_ACKNOWLEDGED state
    public FailureToRescindWaterBetException(String message) {
        super(message);
    }

}
