
public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Fabricator fabricator = new Fabricator(warehouse, 100);
        Buyer buyer = new Buyer(warehouse, 100);

        Thread thread1 = new Thread(fabricator);
        Thread thread2 = new Thread(buyer);

        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}