package exception;

public class NoWordForLetterException extends Exception {
    public NoWordForLetterException(char letter){
    }
    @Override
    public String getMessage(){
        return "Кажется на эту букву нет слова";
    }
}
