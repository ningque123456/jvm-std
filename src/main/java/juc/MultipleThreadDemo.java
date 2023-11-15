package juc;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class MultipleThreadDemo {

    private static final Object lock = new Object();
    private static volatile boolean cond1 = false;
    private static volatile boolean cond2 = false;


    private static List<String> out = new CopyOnWriteArrayList<>();
//    private static List<String> out = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Thread t1 = new Thread(() -> executeTask(1));
//        Thread t2 = new Thread(() -> executeTask(2));
//        Thread t3 = new Thread(() -> executeTask(3));
        // rewrite using signal
        Thread t1 = new Thread(() -> {
            executeTask(1);
            cond1 = true;
        });
        Thread t2 = new Thread(() -> {
            while (!cond1 && !cond2){

            }
            executeTask(2);
        });
        Thread t3 = new Thread(() -> {
            executeTask(3);
            cond2 = true;
        });
        /* execute random */
//        t1.start();
//        t2.start();
//        t3.start();
//        Thread.sleep(1000);
//        processOutput();

        /*
        *  execute ordered with Thread::join
        *  t1 and t3 execute randomly , but t3 is ordered
        * */
//        t1.start();
//        t1.join();
//        t3.start();
//        t3.join();
//        t2.start();
//        processOutput();
        /* execute ordered with Object::wait */
//        t1.start();
//        t2.start();
//        t3.start();
//        Thread.sleep(1000);
//        processOutput();
        /* execute ordered with volatile signal  */
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        processOutput();
        /* execute ordered with CountDownLatch */
//        CountDownLatch latch = new CountDownLatch(2);
//        Thread t1 = new Thread(() -> {
//            executeTask(1);
//            latch.countDown();
//        });
//        Thread t2 = new Thread(() -> {
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            executeTask(2);
//        });
//        Thread t3 = new Thread(() -> {
//            executeTask(3);
//            latch.countDown();
//        });
//        t1.start();
//        t2.start();
//        t3.start();
//        Thread.sleep(1000);
//        processOutput();
        /* using CompletableFuture */
//        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> executeTask(1));
//        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> executeTask(3));
//        cf1.runAfterBoth(cf3,()->executeTask(2));


//        CompletableFuture.runAsync(() -> executeTask(3))
//                .runAfterBoth(CompletableFuture.runAsync(()->executeTask(1)),()->executeTask(2)).join();
//
//        processOutput();

    }

    private static void executeTask(int id)   {
        String res = "execute task : " + id + " " + new Date().toString();
        out.add(res);
    }

    private static String neverCommitTask() {
        for (;;){
            int r = new Random().nextInt(11);
            try {
                if (r > 9) break;
                Thread.sleep(1000);
                System.out.println("execute task ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "task complete";
    }

    private static void processOutput(){
        String outputFile = "D:\\MyGitHub\\jvm-std\\src\\main\\java\\juc\\output.txt";
        System.out.println(out.size());
        out.add("-------------------------");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile , true))) {
            for (String line : out) {
                writer.write(line);
                writer.newLine(); // 换行
            }
            System.out.println("List content written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Runnable{
    private int id;

    public Task(int id ) {
        this.id = id ;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task " + id + " start to execute");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task2 implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}