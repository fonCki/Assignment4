import mine.Valuable;
import utility.collection.ArrayList;

public interface TreasureRoomDoor {
    public void acquiredRead();
    public void releaseRead();
    public void acquireWrite();
    public void releaseWrite();
    public void add(Runnable character, ArrayList<Valuable> valuableTransportBag);
    public Valuable retrieve(Runnable character);
    public long look(Runnable character);
}
