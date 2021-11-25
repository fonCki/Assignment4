import deposit.BlockingQueue;
import deposit.Deposit;
import mine.Mine;
import mine.Valuable;

public class test {
    public static void main(String[] args) {
        Mine mine = new Mine();
        Deposit deposit = new BlockingQueue(18);
        TreasureRoomDoor treasure = new Guardsman();

        Runnable miner0 = new Miner("Lion-O", deposit, mine);
        Runnable miner1 = new Miner("Snarfer", deposit, mine);
        Runnable miner2 = new Miner("Panthro", deposit, mine);
        Runnable miner3 = new Miner("Bengali", deposit, mine);
        Runnable miner4 = new Miner("Jagara", deposit, mine);

        Runnable valuableTransporter0 = new ValuableTransporter("Mumm-Ra", deposit, treasure);
        Runnable valuableTransporter1 = new ValuableTransporter("Grune", deposit, treasure);
        Runnable valuableTransporter2 = new ValuableTransporter("Safari Joe", deposit, treasure);

        Runnable accountant0 = new Accountant("------------Mon-Star", treasure);
        Runnable accountant1 = new Accountant("------------Cooper-Kidd", treasure);

        Runnable king = new King(treasure);

        new Thread(miner0).start();
        new Thread(miner1).start();
        new Thread(miner2).start();
        new Thread(miner3).start();
        new Thread(miner4).start();

        new Thread(valuableTransporter0).start();
        new Thread(valuableTransporter1).start();
        new Thread(valuableTransporter2).start();

        new Thread(accountant0).start();
        new Thread(accountant1).start();

       new Thread(king).start();

    }
}
