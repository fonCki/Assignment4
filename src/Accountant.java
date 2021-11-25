public class Accountant implements Runnable{

    private TreasureRoomDoor treasure;
    private String name;

    public Accountant(String name,TreasureRoomDoor treasure) {
        this.name = name;
        this.treasure = treasure;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        Archive archive = Archive.getArchive();
        while (true) {
            treasure.acquiredRead();
            archive.log("Counting total");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            archive.log("Total amount in the Treasure: " + treasure.look(this));
            treasure.releaseRead();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
