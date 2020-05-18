import java.util.ArrayDeque;

class Warehouse{

    private ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
    private final int MAX_SIZE = 5;
    private final int MIN_SIZE = 1;

    synchronized void addStuff(Character character) {

        while (arrayDeque.size() >= MAX_SIZE) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notify();
        arrayDeque.addLast(character);

    }


    synchronized Character getStuff() {

        while (arrayDeque.size() < MIN_SIZE) {

            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return arrayDeque.pollFirst();
    }
}
