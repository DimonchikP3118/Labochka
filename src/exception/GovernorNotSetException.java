package exception;

public class GovernorNotSetException extends Exception {
    public GovernorNotSetException(String message) {
        super(message);
    }
    @Override
    public String getMessage(){
        return "Правитель не установлен";
    }
}