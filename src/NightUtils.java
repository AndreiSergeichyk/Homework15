import java.util.Random;

public final class NightUtils {

    private final static Random RANDOM = new Random();

    private NightUtils() {
    }

    public static synchronized boolean nextNight(Dump dump, boolean night) {
        if (night) {
            night = false;
        } else {
            dump.addDetals(RANDOM.nextInt(4) + 1);
            night = true;
        }

        return night;
    }

    public static synchronized Integer counterNight(Integer nightCount, boolean night) {
        if (night) {
            nightCount++;
        }

        return nightCount;
    }
}
