import mine.Mine;
import mine.Valuable;
import utility.collection.ArrayList;

public class ValuableTransporter implements Runnable {
    private Deposit deposit;
    private String name;
    private ArrayList<Valuable> transporterBag;
    private Valuable valuable;
    private int totalTransporterBag;
    private TreasureRoomDoor treasure;

    public ValuableTransporter(String name, Deposit deposit, TreasureRoomDoor treasure) {
        this.name = name;
        this.deposit = deposit;
        this.treasure = treasure;
        transporterBag = new ArrayList<>();
        totalTransporterBag = 0;
    }

    @Override
    public void run() {
        int target = (int) (Math.random() * (200 - 50 + 1) + 50);
        System.out.println(target);

        Thread.currentThread().setName(name);
        Archive archive = Archive.getArchive();
        while (true) {
            while (totalTransporterBag < target) {
                archive.log("Take value");
                try {
                    Thread.sleep(((int) (Math.random() * (3 - 1)) + 1) * 1000);
                    valuable = deposit.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                archive.log("Value Took");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                transporterBag.add(valuable);
                archive.log("Valuable Deposited");
                totalTransporterBag += valuable.getValue();
                archive.log("Total in the bag " + totalTransporterBag);

            }

            archive.log("--> adding into the the treasure " + totalTransporterBag + "/ " + transporterBag.size());
            treasure.acquireWrite();
            treasure.add(this,transporterBag);
            treasure.releaseWrite();
            archive.log("--> added complete, ready to start again");


            //clean the bag
            totalTransporterBag = 0;
            transporterBag = new ArrayList<>();

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
