//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // from Extends thread
        Worker worker = new Worker();
        worker.start();

        // from Runnable interface

//        Person person = new Person();
//        Thread thread = new
//                Thread(person);
//        thread.start();


        // this is  Lambda expression of Thread ..!!

        Runnable person =  () -> {
            System.out.println(" this is Lambda thread expression ..!");
        };
        new Thread(person).start();

        }
    }
