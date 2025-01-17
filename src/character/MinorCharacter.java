package character;

import Appearance.TypeofBody;
import interfaces.Actions;
import policy.Government;
import policy.PoliticalPosition;
import policy.TypeofAction;

public class MinorCharacter implements Actions {
    private String name;
    public TypeofBody typeofBody;
    private Boolean isAlive;
    private Government government;

    public MinorCharacter(String name, TypeofBody typeofBody, Government government) {
        this.name = name;
        this.typeofBody = typeofBody;
        this.isAlive = true;
        this.government = government;
    }

    @Override
    public void sayphrase(String phrase) {
        System.out.println(name + ": " + phrase);
    }
    @Override
    public void makeaction(TypeofAction typeofAction) {
        if (isAlive){
            if(typeofAction.getPosition() == PoliticalPosition.POSITIVE && typeofAction.getPower() <= 25){
                System.out.println(getName() + " смог " + typeofAction.getRu());
                government.setPowerOfGovernment(government.getPowerOfGovernment() + typeofAction.getPower());
            } else if(typeofAction.getPosition() == PoliticalPosition.NEGATIVE && typeofAction.getPower() <= 25){
                System.out.println(getName() + " смог " + typeofAction.getRu());
                government.setPowerOfGovernment(government.getPowerOfGovernment() - typeofAction.getPower());
            }
        } else {
            System.out.println(getName() + " убит");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MinorCharacter minorCharacter = (MinorCharacter) obj;
        return name.equals(minorCharacter.name) &&
                typeofBody.equals(minorCharacter.typeofBody) &&
                isAlive.equals(minorCharacter.isAlive) &&
                government.equals(minorCharacter.government);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + typeofBody.hashCode();
        result = 31 * result + isAlive.hashCode();
        result = 31 * result + government.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Второстепенный персонаж по имени " + name + " с " + typeofBody + " типом тела и в государстве под названием " + government.getName();
    }
}
