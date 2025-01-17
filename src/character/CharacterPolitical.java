package character;

import Appearance.TypeofBody;
import emotion.Emotion;
import emotion.Idea;
import interfaces.Goable;
import policy.Government;
import policy.PoliticalPosition;
import policy.TypeofAction;

import java.util.Random;

public abstract class CharacterPolitical extends Character {
    private PoliticalPosition position;
    private Government government;
    public int politicallevel;

    public CharacterPolitical(String name, TypeofBody typeofBody, PoliticalPosition position, Government government,int politicallevel) {
        super(name, typeofBody);
        this.position = position;
        this.government = government;
        this.politicallevel = politicallevel;
    }

    public void politicalAction(TypeofAction typeofAction) {
        Random random = new Random();
        if (getAlive() && politicallevel >= typeofAction.getPower()){
            if (this.position == typeofAction.getPosition()) {
                if (typeofAction.getPosition() == PoliticalPosition.POSITIVE && random.nextBoolean()) {
                    System.out.println(name + " помог правительству и смог " + typeofAction.getRu());
                    politicallevel += 10;
                    this.setEmotion(Emotion.generateEmotion(Idea.WIN));
                    government.setPowerOfGovernment(government.getPowerOfGovernment() + typeofAction.getPower());
                } else if (typeofAction.getPosition() == PoliticalPosition.POSITIVE) {
                    System.out.println(name + " не смог " + typeofAction.getRu());
                    politicallevel -= 10;
                    this.setEmotion(Emotion.generateEmotion(Idea.LOSE));
                }
                if (typeofAction.getPosition() == PoliticalPosition.NEGATIVE && random.nextBoolean()) {
                    if (typeofAction == TypeofAction.MURDERPOLICY){
                        setAlive(false);
                    }
                    System.out.println(name + " навредил правительству и смог " + typeofAction.getRu());
                    politicallevel += 10;
                    this.setEmotion(Emotion.generateEmotion(Idea.WIN));
                    government.setPowerOfGovernment(government.getPowerOfGovernment() - typeofAction.getPower());
                } else if (typeofAction.getPosition() == PoliticalPosition.NEGATIVE) {
                    System.out.println(name + " не смог " + typeofAction.getRu());
                    politicallevel -= 10;
                    this.setEmotion(Emotion.generateEmotion(Idea.LOSE));
                }
                if (typeofAction.getPosition() == PoliticalPosition.NEUTRAL && random.nextBoolean()) {
                    System.out.println(name + " смог " + typeofAction.getRu());
                    politicallevel += 10;
                    this.setEmotion(Emotion.generateEmotion(Idea.WIN));
                    government.setPowerOfGovernment(government.getPowerOfGovernment() - typeofAction.getPower());
                } else if (typeofAction.getPosition() == PoliticalPosition.NEUTRAL) {
                    System.out.println(name + " не смог " + typeofAction.getRu());
                    politicallevel -= 10;
                    this.setEmotion(Emotion.generateEmotion(Idea.Plague));
                }
            } else {
                System.out.println(position.getRu() + " политическая позиция " + name +  " не позволяет "  + typeofAction.getRu());
            }
        } else if (!getAlive()){
            System.out.println(name + " убит ");
        } else if(politicallevel < typeofAction.getPower()){
            System.out.println(name + " не может " + typeofAction.getRu() + ", так как имеет низкий соц.уровень");
        }
    }
}
