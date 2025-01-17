package character;

import Appearance.TypeofBody;
import Arround.Illumination;
import policy.Government;
import policy.PoliticalPosition;

import java.util.Objects;

public class Pravitel extends CharacterPolitical{

    public Pravitel(String name, TypeofBody typeofBody, Government government) {
        super(name, typeofBody, PoliticalPosition.POSITIVE, government, 100);
    }

    @Override
    public void thinkAbout() {
        if(getAlive()){
            System.out.println(name + " думает как сделать жизнь людей лучше");
        }
    }

    @Override
    public void goThrowRoad() {
        if(getAlive()){
            System.out.println("Правитель " + getName() + " перешел дорогу и вошел в дверь" );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knight)) return false;
        Pravitel pravitel = (Pravitel) o;
        return typeofBody == pravitel.typeofBody && politicallevel == pravitel.politicallevel && Objects.equals(name, pravitel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeofBody, politicallevel, name);
    }

    @Override
    public String toString() {
        return "Правитель по имени " + name + " с " + typeofBody + " типом тела";
    }
}

