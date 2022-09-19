package sin2cos2.currencyExchange.exceptions;

public class IllegalTransactionException extends RuntimeException {

    public IllegalTransactionException() {
    }

    public IllegalTransactionException(String message) {
        super(message);
    }

    public IllegalTransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTransactionException(Throwable cause) {
        super(cause);
    }
}
