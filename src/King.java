import mine.Valuable;
import utility.collection.ArrayList;

public class King implements Runnable {
    private ArrayList<Valuable> kingsPersonalBagForParty;
    private TreasureRoomDoor treasure;

    public King(TreasureRoomDoor treasure) {
        this.treasure = treasure;
        kingsPersonalBagForParty = new ArrayList<>();
    }

    @Override
    public void run() {
        Archive archive = Archive.getArchive();
        Thread.currentThread().setName("KING");
        while (true) {
            double totalInBag = 0;
            int partyBudget = (int) (Math.random() * (150 - 50 + 1) + 50);
            treasure.acquireWrite();
            do {
                Valuable extraction = treasure.retrieve(this);
                if (extraction != null) {
                    totalInBag += extraction.getValue();
                    kingsPersonalBagForParty.add(extraction);
                } else {
                    treasure.add(this,kingsPersonalBagForParty);
                    totalInBag = 0;
                    archive.log("Party Cancelled, returned everything");
                    try {
                        Thread.sleep(8000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } while (totalInBag < partyBudget && totalInBag != 0);
            treasure.releaseWrite();
            if (totalInBag > 0) {
                archive.log("PAR----TTTTTT--YYYYYY TIME ");
                try {
                    Thread.sleep(((int) (Math.random() * (20 - 10)) + 1) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                kingsPersonalBagForParty = new ArrayList<>();
            }
        }
    }
}
