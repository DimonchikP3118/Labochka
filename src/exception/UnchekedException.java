package exception;

public class UnchekedException extends RuntimeException {
    public UnchekedException() {
    }
    @Override
    public String getMessage(){
        return "Эмоция не может быть null";
    }
}
