package deposit;

import mine.Valuable;

public interface Deposit {
    void put(Valuable valuable);
    Valuable take();
    boolean isFull();
    boolean isEmpty();
    int size();
}
