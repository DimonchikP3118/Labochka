package Arround;

import java.util.Random;

public record Illumination(String description, int visibility) {
    static Illumination[] illuminations = {
            new Illumination("очень ярко", 100),
            new Illumination("ярко", 75),
            new Illumination("светло", 50),
            new Illumination("тускло", 25),
            new Illumination("темно", 0) };

    private static final Random RANDOM = new Random();

    public static Illumination getRandomIllumination() {
        int randomIndex = RANDOM.nextInt(illuminations.length);
        return illuminations[randomIndex];
    }
}