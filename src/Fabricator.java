class Fabricator implements Runnable{

    private Warehouse warehouse;
    private int count;

    Fabricator(Warehouse warehouse, int count) {

        this.warehouse = warehouse;
        this.count = count;
    }


    public void run() {

        for (int i = 0; i < count; i++) {

            Character character = (char) (int) (Math.random() * 500);
            System.out.println("I made stuff: " + character);
            warehouse.addStuff(character);
        }
    }
}