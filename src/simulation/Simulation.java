package simulation;

import Appearance.TypeofBody;
import character.*;
import policy.Government;
import policy.PoliticalPosition;
import policy.TypeofAction;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {
    static String[] characters = {
            "Чиполлино",
            "Лимон",
            "Помидор",
            "Груша",
            "Капуста",
            "Морковка",
            "Лук",
            "Редиска",
            "Баклажан",
            "Салат",
            "Чеснок",
            "Слива",
            "Клубника",
            "Томат",
            "Зеленый горошек"
    };
    static TypeofBody[] typeofBodies = {TypeofBody.Cherry,
            TypeofBody.Onion,
            TypeofBody.Tomato,
            TypeofBody.Lemon,
            TypeofBody.Apple,
            TypeofBody.Zemlyanichka,
            TypeofBody.Greennes,
            TypeofBody.Peas,
            TypeofBody.Orange};

    static TypeofAction[] typeofActions = {TypeofAction.FOOLOWGOVERNOR,
            TypeofAction.IMPROVEPOLICIES,
            TypeofAction.CARRYORDER,
            TypeofAction.ABSTAINFROMELECTIONS,
            TypeofAction.STARTRUMORSABOUTGOVERNMENT,
            TypeofAction.MURDERPOLICY,
            TypeofAction.PROTEST,
            TypeofAction.SUPPORTGOVERNMENT,
            TypeofAction.WORSEPOLICIES
    };

    private static boolean doAction(CharacterPolitical characterPolitical,Government government){
        characterPolitical.goThrowRoad();
        characterPolitical.thinkAbout();
        Random random = new Random();
        characterPolitical.politicalAction(typeofActions[random.nextInt(typeofActions.length)]);
        if(government.getPowerOfGovernment()>0){
            return true;
        }
        return false;
    }

    private static boolean getMurder(CharacterPolitical characterPolitical){
        Random random = new Random();
        if (random.nextInt(11) > 9){
            characterPolitical.setAlive(false);
            System.out.println(characterPolitical.getName() + " был убит и не модет влиять на государство");
            return true;
        }
        return false;
    }
    public static void runSimulation(int countOfGoodCharacter, int countOfBadCharacter, int countOfNeutralCharacter, int countOfMoves, Government government) {
        Random random = new Random();
        ArrayList<CharacterPolitical> goodCharacter = new ArrayList<>();
        ArrayList<CharacterPolitical> badCharacter = new ArrayList<>();
        ArrayList<MinorCharacter> neutralCharacter = new ArrayList<>();
        Pravitel pravitel = new Pravitel(characters[random.nextInt(15)], TypeofBody.Lemon, government);
        goodCharacter.add(pravitel);
        government.setGovernor(pravitel);
        for (int i = 1; i < countOfGoodCharacter; i++) {
            switch (random.nextInt(2)) {
                case 1:
                    goodCharacter.add(new Knight(characters[random.nextInt(characters.length)], typeofBodies[random.nextInt(typeofBodies.length)], PoliticalPosition.POSITIVE, government, "Круглый стол"));
                    break;
                case 0:
                    goodCharacter.add(new Prince(characters[random.nextInt(characters.length)], typeofBodies[random.nextInt(typeofBodies.length)], PoliticalPosition.POSITIVE, government));
            }
        }
        for (int i = 0; i < countOfBadCharacter; i++) {
            switch (random.nextInt(2)) {
                case 1:
                    badCharacter.add(new Knight(characters[random.nextInt(characters.length)], typeofBodies[random.nextInt(typeofBodies.length)], PoliticalPosition.NEGATIVE, government, "Заговорщики"));
                    break;
                case 0:
                    badCharacter.add(new Prince(characters[random.nextInt(characters.length)], typeofBodies[random.nextInt(typeofBodies.length)], PoliticalPosition.NEGATIVE, government));
            }
        }
        for (int i = 0; i < countOfNeutralCharacter; i++) {
            neutralCharacter.add(new MinorCharacter(characters[random.nextInt(characters.length)], typeofBodies[random.nextInt(typeofBodies.length)], government));
        }
        System.out.println("Количество положительных персонажей: " + goodCharacter.size());
        System.out.println("Количество отрицательных персонажей: " + badCharacter.size());
        System.out.println("Количество нейтральных персонажей: " + neutralCharacter.size());
        System.out.println("Уровень доверия к правительству: " + government.getPowerOfGovernment());
        Boolean governmentIsAlive = true;
        int moves = 0;
        for(int i =0;i < countOfMoves;i++){
            for (int k = 0; k < countOfGoodCharacter; k++) {
                if (random.nextInt(10)>7){
                    goodCharacter.get(k).fellinlove(neutralCharacter.get(random.nextInt(neutralCharacter.size())));
                }
                if(! doAction(goodCharacter.get(k),government)){
                    if(getMurder(goodCharacter.get(k))){
                        goodCharacter.remove(goodCharacter.get(k));
                    }
                    governmentIsAlive = false;
                    break;
                }
            }
            if (! governmentIsAlive){
                break;
            }
            for (int g = 0; g < countOfBadCharacter; g++) {
                if (random.nextInt(10) > 7){
                    badCharacter.get(g).fellinlove(neutralCharacter.get(random.nextInt(neutralCharacter.size())));
                }
                if(! doAction(badCharacter.get(g),government)){
                    if(getMurder(badCharacter.get(g))){
                        goodCharacter.remove(badCharacter.get(g));
                    }
                    governmentIsAlive = false;
                    break;
                }
            }
            if(! governmentIsAlive){
                break;
            }
            for (int g = 0; g < countOfNeutralCharacter; g++) {
                neutralCharacter.get(g).makeaction(typeofActions[random.nextInt(typeofActions.length)]);
            }
            moves = i;
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Количество положительных персонажей: " + goodCharacter.size());
        System.out.println("Количество отрицательных персонажей: " + badCharacter.size());
        System.out.println("Количество нейтральных персонажей: " + neutralCharacter.size());
        System.out.println("Уровень доверия к правительству: " + government.getPowerOfGovernment());
        System.out.println("Правительство продержалось: " + (moves + 1) +  "/" + countOfMoves + " ходов");
    }
}
