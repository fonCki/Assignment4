import mine.Valuable;
import utility.collection.ArrayList;

public class Guardsman implements TreasureRoomDoor{

    private boolean activeWriter;
    private int waitingWriters;
    private int activeReaders;

    private TreasureRoom treasureRoom;

    public Guardsman() {
        this.treasureRoom = new TreasureRoom();
    }

    @Override
    public synchronized void acquiredRead() {
        while(activeWriter && waitingWriters > 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "Waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Done waiting");
        activeReaders++;
    }

    @Override
    public synchronized void releaseRead() {
        System.out.println(Thread.currentThread().getName() + " Realese readers");
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
                System.out.println(Thread.currentThread().getName() + " Waiting2");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Done writing2");
            waitingWriters--;
            activeWriter = true;
        }

    }

    @Override
    public synchronized void releaseWrite() {
       // System.out.println(Thread.currentThread().getName() + " Realese writers");
        activeWriter = false;
        notifyAll();
    }

    @Override
    public synchronized void add(Runnable character, ArrayList<Valuable> valuableTransportBag) {
        if (character instanceof King || character instanceof ValuableTransporter) {
            treasureRoom.add(character,valuableTransportBag);
        } else {
            System.out.println("access denied"); //CHABGE THIS TO LOG
        }
    }

    @Override
    public synchronized Valuable retrieve(Runnable character) {
        if (character instanceof King) {
            return treasureRoom.retrieve(character);
        } else {
            System.out.println("access denied"); //CHABGE THIS TO LOG
        }
        return null;
    }

    @Override
    public synchronized long look(Runnable character) {
        if (character instanceof King || character instanceof ValuableTransporter || character instanceof Accountant) {
            return treasureRoom.look(character);
        } else {
            System.out.println("access denied"); //CHABGE THIS TO LOG
        }
        return -1;
    }
}
