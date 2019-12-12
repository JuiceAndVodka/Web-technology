package dao;

public class ExceptionDAO extends Exception {

    public ExceptionDAO() {
        super();
    }

    public ExceptionDAO(String message) {
        super(message);
    }

    public ExceptionDAO(Exception e) {
        super(e);
    }

    public ExceptionDAO(String message, Exception e) {
        super(message, e);
    }
}
