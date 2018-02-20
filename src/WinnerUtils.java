import java.util.Optional;

public final class WinnerUtils {

    private WinnerUtils() {
    }

    public static Scientific getWinner(Scientific oneScientific, Scientific twoScientific) {
        Scientific winnerScientific = null;
        if (Integer.compare(getCountRobots(oneScientific), getCountRobots(twoScientific)) > 0) {
            winnerScientific = oneScientific;
        } else {
            winnerScientific = twoScientific;
        }

        return winnerScientific;
    }

    public static int getCountRobots(Scientific scientific) {
        Optional<Integer> countRobots = scientific.getRobots().values().stream()
                .min(Integer::compareTo);

        return countRobots.get();
    }
}
