import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorWithScheduledExecutor {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = null;
        //task to send mail
            Runnable email = () -> {
                System.out.println("this is email ..!");
            };
        //task to print current date and time
            Runnable time = () -> {
                System.out.println(LocalDateTime.now());
            };

            //create a scheduled executor with 3 threads
        executorService = Executors.newScheduledThreadPool(3);
            //Scheduled email to sent after 2 seconds
        executorService.schedule(email , 2 , TimeUnit.SECONDS);
        //Scheduled email to sent after 2 seconds and then avery 3 seconds
        executorService.scheduleAtFixedRate(time , 2 , 3 ,TimeUnit.SECONDS );


    }
}
