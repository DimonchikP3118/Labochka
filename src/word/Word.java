package word;

import exception.NoWordForLetterException;

public class Word {
    public static String getWordForLetter(char letter) throws NoWordForLetterException {
        if (String.valueOf(letter).equals("ь") || String.valueOf(letter).equals("ъ") || String.valueOf(letter).equals("ы"))
            throw new NoWordForLetterException(letter);
        for (TownsandCountries item: TownsandCountries.values()){
            if(letter == item.getbukva()){
                return item.getRu();
            }
        }
        return "";
    }
}
