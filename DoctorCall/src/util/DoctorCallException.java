package util;

public class DoctorCallException extends Exception {

    public DoctorCallException(String message) {
        super(message);
    }

    public DoctorCallException(String message, Throwable cause) {
        super(message, cause);
    }

}
