import Appearance.TypeofBody;
import character.*;
import character.Character;
import emotion.Emotion;
import emotion.Idea;
import interfaces.Goable;
import policy.Government;
import policy.PoliticalPosition;
import policy.TypeofAction;
import simulation.Simulation;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Crowd crowd = new Crowd(PoliticalPosition.POSITIVE,TypeofBody.Cherry,"Овощи");
        Government government = new Government("Луковое государство", "Процветающая страна", "Демократия", 100,crowd);
        Random random = new Random();
        Simulation.runSimulation(random.nextInt(1)+1, random.nextInt(1)+1, random.nextInt(1)+1, random.nextInt(3)+2,government);
    }
}