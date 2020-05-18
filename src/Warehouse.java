import java.util.ArrayDeque;

class Warehouse{

    private ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
    private boolean isFull = false;

    synchronized void addStuff(Character character) {

        if (isFull) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        arrayDeque.addLast(character);
        isFull = true;
        notify();
    }


    synchronized Character getStuff() {

        if (!isFull) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isFull = false;
        notify();
        return arrayDeque.pollFirst();
    }
}
