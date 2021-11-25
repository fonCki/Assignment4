import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Archive {
    private static Archive archive;
    private static Lock lock = new ReentrantLock();

    private ArrayList<String> logs = new ArrayList<>();

    private Archive() {
    }

    public static Archive getArchive() {
        if (archive == null) {
            synchronized (lock) {
                if (archive == null) {
                    archive = new Archive();
                }
            }
        }
        return archive;
    }

    public synchronized void log(String log) {
        String finalLog = Thread.currentThread().getName() + ": " + log + " / " + LocalTime.now();
        logs.add(finalLog);
     //   System.out.println(finalLog);
    }
}
