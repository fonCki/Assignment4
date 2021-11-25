import mine.Valuable;
import utility.collection.ArrayList;

public class TreasureRoom implements TreasureRoomDoor{
    private ArrayList<Valuable> treasure;
    private int totalTreasure;

    public TreasureRoom() {
        treasure = new ArrayList<Valuable>();
        totalTreasure = 0;
    }

    @Override
    public synchronized void acquiredRead() {
    }

    @Override
    public synchronized void releaseRead() {
    }

    @Override
    public synchronized void acquireWrite() {
    }

    @Override
    public synchronized void releaseWrite() {
    }

    @Override
    public synchronized void add(Runnable character, ArrayList<Valuable> valuableTransportBag) {
        for(int i=0; i< valuableTransportBag.size(); i++) {
            treasure.add(valuableTransportBag.get(i));
            totalTreasure += valuableTransportBag.get(i).getValue();
        }
    }

    @Override
    public synchronized Valuable retrieve(Runnable character) {
        if (treasure.isEmpty()) {
            return null;
        }
            totalTreasure -= treasure.get(0).getValue();
            return (treasure.remove(0));
    }

    @Override
    public long look(Runnable character) {
        return totalTreasure;
    }
}
