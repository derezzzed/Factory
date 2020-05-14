import java.util.ArrayDeque;

class Warehouse {

    private ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
    static volatile boolean chck;

    synchronized void addStuff() {

        chck = true;

        for (int i = 0; i < 10; i++) {

            Character character = (char) (int) (Math.random() * 500);
            System.out.println("I made stuff: " + character);
            arrayDeque.addLast(character);
        }

        notify();

        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    synchronized Character getStuff() {

        if (arrayDeque.size() == 1) {

            chck = false;
            notify();

            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        return arrayDeque.pollFirst();
    }
}