package character;

import Appearance.TypeofBody;
import Arround.Illumination;
import emotion.Emotion;
import emotion.Idea;
import exception.NoWordForLetterException;
import interfaces.Goable;
import word.Word;

public abstract class Character implements Goable {
    protected String name;
    public Emotion emotion;
    public TypeofBody typeofBody;
    private Boolean isAlive;

    public Character(String name, TypeofBody typeofBody) {
        this.name = name;
        this.typeofBody = typeofBody;
        this.isAlive = true;
    }

    public abstract void thinkAbout();

    public String getName() {
        return name;
    }

    public Boolean getAlive() {
        return isAlive;
    }
    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public void fellinlove(MinorCharacter character) {
        Illumination ilum = Illumination.getRandomIllumination();
        if (ilum.visibility() >= 50){
            if (this.typeofBody == character.typeofBody) {
                System.out.println("Так как в этом месте " + ilum.description() + "," + getName() + " видит и влюбляется в " + character.getName());
                character.sayphrase("Я влюблен(а)");
                setEmotion(Emotion.generateEmotion(Idea.WIN));
            } else {
                System.out.println(getName() + " не испытвает чувств к " + character.getName());
                character.sayphrase("Какой красивый человек меня не заметил");
            }
        } else {
            System.out.println("В этом месте " + ilum.description() + " и не кого не видно");
            character.sayphrase("Сделайте светлее");
        }
    }

    public void setEmotion(Emotion emotion) {
        if (getAlive()){
            this.emotion = emotion;
            if (emotion.power() > 5){
                System.out.println(name + " испытывает сильное: \n" + emotion.description());
                for (int i=0; i<emotion.description().length(); i++){
                    char letter = emotion.description().charAt(i);
                    try {
                        System.out.println(letter + " - " + Word.getWordForLetter(letter));
                    } catch (NoWordForLetterException e){
                        System.out.println(letter + " - " + e.getMessage());
                    }
                }
            } else {
                System.out.println(name + " испытывает: \n" + emotion.description());
            }
        }
    }
}
