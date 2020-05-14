class Fabricator implements Runnable {
    private Warehouse warehouse;

    Fabricator(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    public void run() {

        while (!Warehouse.chck) {

            warehouse.addStuff();
        }
    }
}