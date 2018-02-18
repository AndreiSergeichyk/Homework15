public class Main {

    public static void main(String[] args) {
        Dump dump = new Dump();
        Scientific oneScientific = new Scientific("Вася");
        Scientific twoScientific = new Scientific("Петя");
        Helper helper = new Helper("helper1", dump, oneScientific);
        Helper helper2 = new Helper("helper2", dump, twoScientific);

        helper.start();
        helper2.start();

        try {
            helper.join();
            helper2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Победитель - " + Utils.getWinner(oneScientific, twoScientific).getName());
    }
}
