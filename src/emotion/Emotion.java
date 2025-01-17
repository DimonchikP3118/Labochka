package emotion;

import exception.UnchekedException;

import java.util.ArrayList;
import java.util.Random;

public record Emotion(String description, int power) {
    private static final ArrayList<Emotion> positiveEmotions = new ArrayList<>();
    private static final ArrayList<Emotion> negativeEmotions = new ArrayList<>();
    private static final Random random = new Random();

    static {
        positiveEmotions.add(new Emotion("Радость", 7));
        positiveEmotions.add(new Emotion("Удовлетворение", 8));
        positiveEmotions.add(new Emotion("Восторг", 7));

        negativeEmotions.add(new Emotion("Печаль", 6));
        negativeEmotions.add(new Emotion("Грусть", 8));
        negativeEmotions.add(new Emotion("Злость", 9));
    }

    public static Emotion generateEmotion(Idea idea) {
        if (idea == null) {
            throw new UnchekedException();
        }
        if (idea.isPositive()) {
            return positiveEmotions.get(random.nextInt(positiveEmotions.size()));
        } else {
            return negativeEmotions.get(random.nextInt(negativeEmotions.size()));
        }
    }
}
