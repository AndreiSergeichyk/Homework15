import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Dump {

    public static final int START_COUNT_DETALS = 20;
    private Random random = new Random();
    private Deque<RobotParts> detals = new ArrayDeque<>();

    public Dump() {
        addDetals(START_COUNT_DETALS);
    }

    public void addDetals(int count) {
        for (int i = 0; i < count; i++) {
            detals.addFirst(getDetail());
        }
    }

    public RobotParts getDetail() {
        RobotParts detail = null;

        switch (random.nextInt(9)) {
            case 0:
                detail = RobotParts.BODY;
                break;

            case 1:
                detail = RobotParts.CPU;
                break;

            case 2:
                detail = RobotParts.HDD;
                break;

            case 3:
                detail = RobotParts.HEAD;
                break;

            case 4:
                detail = RobotParts.LEFTLEG;
                break;

            case 5:
                detail = RobotParts.RIGHTLEG;
                break;

            case 6:
                detail = RobotParts.RIGHTHAND;
                break;

            case 7:
                detail = RobotParts.LEFTHAND;
                break;

            case 8:
                detail = RobotParts.RUM;
                break;

            default:
                System.out.println("Нету такого типа деталей");

        }

        return detail;
    }

    public Deque<RobotParts> getDetals() {
        return detals;
    }
}
