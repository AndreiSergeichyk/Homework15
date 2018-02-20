import java.util.Optional;

public final class WinnerUtils {

    private WinnerUtils() {
    }

    public static Scientific getWinner(Scientific oneScientific, Scientific twoScientific) {
        if (Integer.compare(getCountRobots(oneScientific), getCountRobots(twoScientific)) > 0) {
            return oneScientific;
        } else {
            return twoScientific;
        }
    }

    public static int getCountRobots(Scientific scientific) {
        Optional<Integer> countRobots = scientific.getRobots().values().stream()
                .min(Integer::compareTo);

        return countRobots.get();
    }
}
