package service;

public class ExceptionService extends Exception {

    public ExceptionService() {
        super();
    }

    public ExceptionService(String message) {
        super(message);
    }

    public ExceptionService(Exception e) {
        super(e);
    }

    public ExceptionService(String message, Exception e) {
        super(message, e);
    }
}
