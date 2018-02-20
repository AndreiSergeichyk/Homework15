import java.util.LinkedList;
import java.util.List;

public class Helper extends Thread {

    public static final int COUNT_DETALS = 4;
    public static final int MAX_NIGHTS = 100;
    private List<RobotParts> basketOfHalper = new LinkedList();
    private Dump dump;
    private Scientific scientific;
    private static Integer nightCount = 0;
    private static boolean night;

    public Helper(String name, Dump dump, Scientific scientific) {
        super(name);
        this.dump = dump;
        this.scientific = scientific;
    }

    @Override
    public void run() {
        while (nightCount <= MAX_NIGHTS) {
            System.out.println(getName() + " Зашел на свалку");
            synchronized (dump.getDetals()) {
                while (!dump.getDetals().isEmpty() && basketOfHalper.size() < COUNT_DETALS) {
                    basketOfHalper.add(dump.getDetals().removeLast());
                    System.out.println(getName() + " нашел деталь");
                    dump.getDetals().notify();
                    try {
                        dump.getDetals().wait(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            scientific.getDetails(basketOfHalper);
            basketOfHalper.clear();
            System.out.println(getName() + " Вернулся и отдал детали " + scientific.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            night = NightUtils.nextNight(dump, night);
            nightCount = NightUtils.counterNight(nightCount, night);
        }
    }
}
