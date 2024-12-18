import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        //Define two tasks eith lambda expression

        ExecutorService executorService = null;
        Runnable task1 = () -> {
            System.out.println("task 1 Excuted ..!");
            System.out.println(Thread.currentThread().getName());
        };
        Runnable task2 = () -> {
            System.out.println(" task 2 excuted ..!");
            System.out.println(Thread.currentThread().getName());
        };

        try {
            executorService = Executors.newSingleThreadExecutor();
            executorService.execute(task1);
            executorService.execute(task2);
        }finally {
            if (executorService != null){
                executorService.shutdown();
            }
        }
    }
}
