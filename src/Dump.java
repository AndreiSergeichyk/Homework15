import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Dump {

    private Random random = new Random();
    private Deque<RobotParts> detals = new ArrayDeque<>();

    public Dump() {
        addTwentyDetals();
    }

    private void addTwentyDetals() {
        for (int i = 0; i < 20; i++) {
            detals.addFirst(getDetail());
        }
    }

    public void addDetals() {
        for (int i = 0; i < random.nextInt(4); i++) {
            detals.addFirst(getDetail());
        }
    }

    public RobotParts getDetail() {
        RobotParts detail = null;

        switch (random.nextInt(9)) {
            case 0: {
                detail = RobotParts.BODY;
                break;
            }
            case 1: {
                detail = RobotParts.CPU;
                break;
            }
            case 2: {
                detail = RobotParts.HDD;
                break;
            }
            case 3: {
                detail = RobotParts.HEAD;
                break;
            }
            case 4: {
                detail = RobotParts.LEFTLEG;
                break;
            }
            case 5: {
                detail = RobotParts.RIGHTLEG;
                break;
            }
            case 6: {
                detail = RobotParts.RIGHTHAND;
                break;
            }
            case 7: {
                detail = RobotParts.LEFTHAND;
                break;
            }
            case 8: {
                detail = RobotParts.RUM;
                break;
            }
            default: {
                System.out.println("Нету такого типа деталей");
            }
        }

        return detail;
    }

    public Deque<RobotParts> getDetals() {
        return detals;
    }
}
