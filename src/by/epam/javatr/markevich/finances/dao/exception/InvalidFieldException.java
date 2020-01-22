package by.epam.javatr.markevich.finances.dao.exception;

public class InvalidFieldException extends Exception {
    public InvalidFieldException(String message) {
        super(message);
    }

    public InvalidFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
