package edu.jcourse.city.exception;

public class PersonCheckDAOException extends Exception {

    public PersonCheckDAOException() {
    }

    public PersonCheckDAOException(String message) {
        super(message);
    }

    public PersonCheckDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonCheckDAOException(Throwable cause) {
        super(cause);
    }
}
