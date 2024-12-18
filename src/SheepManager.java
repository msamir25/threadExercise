import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
    // AtomicInteger for thread-safe counting of sheep
    private static AtomicInteger sheepCount1 = new AtomicInteger(0);
    // Regular int for counting sheep, not thread-safe
    private static int sheepCount2 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null; // Declare ExecutorService
        try {
            // Create a single-thread executor for executing tasks sequentially
            service = Executors.newSingleThreadExecutor(); // Change to newFixedThreadPool(3) for comparison
            // Submit 100 tasks to the executor
            for (int i = 0; i < 100; i++) {
                service.execute(() -> {
                    // Increment the atomic sheep count safely
                    sheepCount1.getAndIncrement();
                    // Increment the regular sheep count (not thread-safe)
                    sheepCount2++;
                });
            }
            // Pause the main thread briefly to allow tasks to complete
            Thread.sleep(100);
            // Print the results: atomic count and regular count
            System.out.println(sheepCount1 + " " + sheepCount2);
        } finally {
            // Shutdown the executor to release resources
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
