import mine.Mine;
import mine.Valuable;

public class Miner implements Runnable {
    private Deposit deposit;
    private Mine mine;
    private String name;
    private Valuable valuable;

    public Miner(String name, Deposit deposit, Mine mine) {
        this.name = name;
        this.deposit = deposit;
        this.mine = mine;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        Archive archive = Archive.getArchive();
        while (true) {
            archive.log("Start Mining");
            try {
                Thread.sleep(((int) (Math.random() * (10 - 1)) + 1) * 1000);
                valuable = mine.getValuable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            archive.log("End Mining");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            deposit.put(valuable);
            archive.log("Valuable Deposited");
        }
    }
}