import mine.Valuable;
import utility.collection.ArrayList;

import java.net.Socket;

public class Deposit{
    private ArrayList<Valuable> queue;
    private int capacity;
    public Archive archive = Archive.getArchive();


    public Deposit(int capacity) {
        queue = new ArrayList<Valuable>();
        this.capacity = capacity;
    }

    public synchronized void put(Valuable valuable) {
        while (isFull()) {
            try {
                archive.log("Full Capacity, waiting to put more valuables");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(valuable);
        notifyAll();
    }

    public synchronized Valuable take() {
        while (isEmpty()) {
            try {
                archive.log("No many, waiting to take some more");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Valuable removed = queue.remove(0);
        archive.log("Finally, I can take more Valuables");
        notifyAll();
        return removed;
    }

    public synchronized boolean isFull() {
        return (queue.size() >= capacity) ;
    }

    public synchronized boolean isEmpty() {
        return (queue.size() <= 0) ;
    }

    public synchronized int size() {
        return queue.size();
    }

}
