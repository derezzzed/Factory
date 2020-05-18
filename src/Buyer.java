class Buyer implements Runnable {

    private Warehouse warehouse;
    private int count;

    Buyer(Warehouse warehouse, int count) {

        this.warehouse = warehouse;
        this.count = count;
    }


    public void run() {

        try {
            for (int i = 0; i < count; i++) {

                Thread.sleep(50);
                System.out.println("I bougth stuff: " + warehouse.getStuff());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}