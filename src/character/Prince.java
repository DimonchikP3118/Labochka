package character;

import Appearance.TypeofBody;
import emotion.Emotion;
import emotion.Idea;
import exception.UnchekedException;
import policy.Government;
import policy.PoliticalPosition;

import java.util.Objects;
import java.util.Random;

public class Prince extends CharacterPolitical{

    public Prince(String name, TypeofBody typeofBody, PoliticalPosition position, Government government) {
        super(name, typeofBody, position, government,50);
    }

    @Override
    public void goThrowRoad() {
        if(getAlive()){
            System.out.println("Принц - " + getName() +  " скачет на коне вдоль дороги");
        }
    }

    private static Idea getRandomIdea() {
        Idea[] ideas = Idea.values();
        Random random = new Random();
        int randomIndex = random.nextInt(ideas.length);
        return ideas[randomIndex];
    }

    @Override
    public void thinkAbout() {
        if(getAlive()){
            Idea idea = getRandomIdea();
            System.out.println(getName() + " размышляет над темой: \n" + idea.getRu());
            try {
                setEmotion(Emotion.generateEmotion(idea));
            } catch (UnchekedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knight)) return false;
        Prince prince = (Prince) o;
        return typeofBody == prince.typeofBody && politicallevel == prince.politicallevel && Objects.equals(name, prince.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeofBody, politicallevel, name);
    }

    @Override
    public String toString() {
        return "Принц по имени " + name + " с " + politicallevel + " политической позицией";
    }
}
