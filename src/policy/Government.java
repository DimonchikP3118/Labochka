package policy;

import character.CharacterPolitical;
import character.Crowd;
import character.MinorCharacter;
import exception.GovernorNotSetException;

import java.util.Random;


public class Government {
    private String name;
    private String description;
    private String policalRezhim;
    private int powerOfGovernment;
    private CharacterPolitical governor;
    public Crowd crowd;


    public Government(String name, String description, String policalRezhim, int powerOfGovernment,Crowd crowd ) {
        this.name = name;
        this.description = description;
        this.policalRezhim = policalRezhim;
        this.powerOfGovernment = powerOfGovernment;
        this.crowd = crowd;
    }

    public void setGovernor(CharacterPolitical governor){
        if(governor.getAlive()){
            this.governor = governor;
            governor.politicallevel += 20;
            System.out.println(governor.getName() + " встал на правление " + this.name + " '" + this.description + "'");
            System.out.println(name + " будет продолжать политический режим: " + policalRezhim);
            System.out.println("Доверие к правительству: " + powerOfGovernment);
        } else {
            System.out.println("Мертвый не может властвовать");
        }
    }

    public int getPowerOfGovernment() {
        return powerOfGovernment;
    }
    public String getName() {
        return name;
    }

    public void trytodorevolution() {
        try {
            if (governor == null) {
                throw new GovernorNotSetException("Правитель не установлен. Невозможно провести революцию.");
            }
            Random random = new Random();
            int randomNumber = random.nextInt(101);
            if (crowd.getMajoritytypeofbody() == governor.typeofBody) {
                randomNumber -= 10;
            }
            if (crowd.getAttitudetogovernment() == PoliticalPosition.POSITIVE) {
                randomNumber -= 10;
            }
            if (crowd.getAttitudetogovernment() == PoliticalPosition.NEUTRAL) {
                randomNumber -= 5;
            }
            System.out.println("Народ " + crowd.getName() + " не доволен правительством и намеревает революцию");
            if (randomNumber > 75) {
                governor.setAlive(false);
                System.out.println("В ходе восстания народ " + crowd.getName() + " смог свергнуть и убить правителя");
            } else {
                System.out.println("Восстание подавлено, революция не удалась");
            }
        } catch (GovernorNotSetException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    public void setPowerOfGovernment(int powerOfGovernment) {
        try {
            if (governor == null) {
                throw new GovernorNotSetException("Правитель не установлен. Невозможно изменить власть.");
            }
            if (powerOfGovernment > this.powerOfGovernment) {
                crowd.showattitude(this.powerOfGovernment, crowd.getName());
                System.out.println("Народ " + crowd.getName() + " укрепляет доверие к правителю " + governor.getName() + ": " + powerOfGovernment);
            } else {
                if (powerOfGovernment <= 0) {
                    System.out.println(governor.getName() + " был свержен и убит");
                    governor.setAlive(false);
                } else if (powerOfGovernment <= 20) {
                    crowd.showattitude(this.powerOfGovernment, crowd.getName());
                    trytodorevolution();
                } else {
                    crowd.showattitude(this.powerOfGovernment, crowd.getName());
                    System.out.println("Народ " + crowd.getName() + " теряет доверие к правителю " + governor.getName() + ": " + powerOfGovernment);
                }
            }
            this.powerOfGovernment = powerOfGovernment;
        } catch (GovernorNotSetException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Government government = (Government) obj;
        return name.equals(government.name) &&
                policalRezhim.equals(government.policalRezhim) &&
                powerOfGovernment == (government.powerOfGovernment) &&
                governor.equals(government.governor);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 52 * result + policalRezhim.hashCode();
        result = 52 * result + description.hashCode();
        result = 52 * result + governor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Государство (" + name + ") c политическим режимом: " + policalRezhim + " и с правителем по имени " + governor.getName();
    }
}
