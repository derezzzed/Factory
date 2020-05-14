class Buyer implements Runnable {

    private Warehouse warehouse;

    Buyer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    public void run() {
        try {

            for (int i = 0; i < 20; i++) {

                Thread.sleep(500);
                System.out.println("I bougth stuff: " + warehouse.getStuff());
            }
        } catch (InterruptedException e) {
        }
    }
}