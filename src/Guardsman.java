import mine.Valuable;
import utility.collection.ArrayList;

public class Guardsman implements TreasureRoomDoor{

    private boolean activeWriter;
    private int waitingWriters;
    private int activeReaders;
    private Archive archive = Archive.getArchive();

    private TreasureRoom treasureRoom;

    public Guardsman() {
        this.treasureRoom = new TreasureRoom();
    }

    @Override
    public synchronized void acquiredRead() {
        while(activeWriter && waitingWriters > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activeReaders++;
    }

    @Override
    public synchronized void releaseRead() {
        activeReaders--;
        if (activeReaders == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized void acquireWrite() {
        waitingWriters++;
        while (activeWriter && activeReaders > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitingWriters--;
            activeWriter = true;
        }

    }

    @Override
    public synchronized void releaseWrite() {
        activeWriter = false;
        notifyAll();
    }

    @Override
    public synchronized void add(Runnable character, ArrayList<Valuable> valuableTransportBag) {
        if (character instanceof King || character instanceof ValuableTransporter) {
            treasureRoom.add(character,valuableTransportBag);
        } else {
            archive.log("You have no authorization to do this operation");
        }
    }

    @Override
    public synchronized Valuable retrieve(Runnable character) {
        if (character instanceof King) {
            return treasureRoom.retrieve(character);
        } else {
            archive.log("You're not the fkig King MATE!!");
        }
        return null;
    }

    @Override
    public synchronized long look(Runnable character) {
        if (character instanceof King || character instanceof ValuableTransporter || character instanceof Accountant) {
            return treasureRoom.look(character);
        } else {
            archive.log("Not sure who you are, but you have no access to be here...");
        }
        return -1;
    }
}
