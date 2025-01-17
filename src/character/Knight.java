package character;

import Appearance.TypeofBody;
import emotion.Emotion;
import emotion.Idea;
import exception.UnchekedException;
import policy.Government;
import policy.PoliticalPosition;

import java.util.Objects;
import java.util.Random;

public class Knight extends CharacterPolitical{
    private String order;

    public Knight (String name, TypeofBody typeofBody, PoliticalPosition position, Government government, String order) {
        super(name, typeofBody, position, government,75);
        this.order = order;
    }

    @Override
    public void goThrowRoad() {
        if(getAlive()){
            System.out.println("Рыцарь " +  getName() + " ордена " + order + " идет в доспехах после боя вдоль проселочной дороги");
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
            System.out.println(getName() + " думает над темой: \n" + idea.getRu() + "!!!");
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
        Knight knight = (Knight) o;
        return typeofBody == knight.typeofBody && politicallevel == knight.politicallevel && Objects.equals(name, knight.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeofBody, politicallevel, name);
    }

    @Override
    public String toString() {
        return "Рыцарь ордена " + order + " по имени " + name + " с " + typeofBody + " типом тела";
    }
}
