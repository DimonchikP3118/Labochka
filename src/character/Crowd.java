package character;

import Appearance.TypeofBody;
import policy.PoliticalPosition;

import java.util.Objects;
import java.util.Random;


public class Crowd {
    PoliticalPosition attitudetogovernment;
    TypeofBody majoritytypeofbody;
    String name;

    public Crowd(PoliticalPosition attitudetogovernment, TypeofBody majoritytypeofbody, String name) {
        this.attitudetogovernment = attitudetogovernment;
        this.majoritytypeofbody = majoritytypeofbody;
        this.name = name;
    }

    public void showattitude(int powerofGovernment, String nameofcrowd){
        Random random = new Random();
        if(random.nextBoolean() && powerofGovernment >= 90){
            System.out.println("Народ " + nameofcrowd + " устраивает его правительство");
        }
        else if (random.nextBoolean() && powerofGovernment < 30){
            System.out.println("Народу " + nameofcrowd + " не нравится текущее правителство");
        }else {
            System.out.println("Народ " + nameofcrowd + " не выражает мнение о государстве");
        }
    }

    public PoliticalPosition getAttitudetogovernment() {
        return attitudetogovernment;
    }

    public TypeofBody getMajoritytypeofbody() {
        return majoritytypeofbody;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crowd)) return false;
        Crowd crowd = (Crowd) o;
        return majoritytypeofbody == crowd.majoritytypeofbody && Objects.equals(name, crowd.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attitudetogovernment, majoritytypeofbody, name);
    }

    @Override
    public String toString() {
        return  "Народ под названием " + name + ", с большинством людей с типом тела " + majoritytypeofbody;
    }
}
