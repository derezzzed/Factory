
public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Buyer buyer = new Buyer(warehouse);
        Fabricator fabricator = new Fabricator(warehouse);
        Thread thread1 = new Thread(fabricator);
        Thread thread2 = new Thread(buyer);
        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        thread2.start();
    }
}