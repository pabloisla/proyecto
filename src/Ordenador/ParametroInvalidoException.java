package Ordenador;

public class ParametroInvalidoException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 3549725005393324000L;

    public ParametroInvalidoException() {
    }

    public ParametroInvalidoException(String message) {
        super(message);

    }

    public ParametroInvalidoException(Throwable cause) {
        super(cause);
    }

    public ParametroInvalidoException(String message, Throwable cause) {
        super(message, cause);

    }

    public ParametroInvalidoException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

}
