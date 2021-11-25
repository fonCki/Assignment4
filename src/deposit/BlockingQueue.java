package deposit;

import mine.Valuable;
import utility.collection.ArrayList;

import java.net.Socket;

public class BlockingQueue implements Deposit{
    private ArrayList<Valuable> queue;
    private int capacity;
    // public Archive archive;


    public BlockingQueue(int capacity) {
        queue = new ArrayList<Valuable>();
        this.capacity = capacity;
    }

    public synchronized void put(Valuable valuable) {
        while (queue.size() >= capacity) {
            try {
          //      System.out.println("Full Capacity, waiting to put more valluables");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(valuable);
        notifyAll();
    }

    public synchronized Valuable take() {
        while (queue.size() <= 0) {
            try {
          //      System.out.println("No many, waiting to take some more");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Valuable removed = queue.remove(0);
        System.out.println("back to life");
        notifyAll();
        return removed;
    }

    @Override
    public synchronized boolean isFull() {
        return (queue.size() >= capacity) ;
    }

    @Override
    public synchronized boolean isEmpty() {
        return (queue.size() <= 0) ;
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }

}
