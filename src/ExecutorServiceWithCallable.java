import java.sql.SQLOutput;
import java.util.concurrent.*;

public class ExecutorServiceWithCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = null;

        Callable<Double> task3 =  () -> {
            return Math.random();
        };

        try {
            executorService = Executors.newFixedThreadPool(3);

            Future<Double> result = executorService.submit(task3);

            System.out.println(result.get());

        }finally {
            if (executorService != null){
                executorService.shutdown();
            }
        }
    }


}
