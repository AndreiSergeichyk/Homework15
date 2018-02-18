import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scientific {

    private String name;
    private Map<RobotParts, Integer> robots = new HashMap<>();

    public Scientific(String name) {
        this.name = name;
    }

    public void getDetails(List<RobotParts> list) {
        for (RobotParts detail : list) {
            robots.merge(detail, 1, (a, b) -> a + b);
        }
    }

    public String getName() {
        return name;
    }

    public Map<RobotParts, Integer> getRobots() {
        return robots;
    }
}
