import java.util.LinkedList;
import java.util.List;

public class Helper extends Thread {

    public static final int COUNT_DETALS = 4;
    public static final int MAX_NIGHTS = 100;
    private Dump dump;
    private List<RobotParts> basketOfHalper = new LinkedList();
    private Scientific scientific;
    private static boolean night;
    private static int nightCount;

    public Helper(String name, Dump dump, Scientific scientific) {
        super(name);
        this.dump = dump;
        this.scientific = scientific;
    }

    @Override
    public void run() {

        while (nightCount <= MAX_NIGHTS) {
            System.out.println(getName() + " Зашел на свалку");

            while (!(dump.getDetals().isEmpty()) && basketOfHalper.size() < COUNT_DETALS) {
                synchronized (dump.getDetals()) {
                    if (!(dump.getDetals().isEmpty())) {
                        basketOfHalper.add(dump.getDetals().removeLast());
                        System.out.println(getName() + " нашел деталь");
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            scientific.getDetails(basketOfHalper);
            basketOfHalper.clear();
            System.out.println(getName() + " Вернулся и отдал детали " + scientific.getName());

            nextNights();
        }
    }

    private synchronized void nextNights() {
        if (night) {
            dump.addDetals();
            night = false;
            nightCount++;
        } else {
            night = true;
        }
    }
}
