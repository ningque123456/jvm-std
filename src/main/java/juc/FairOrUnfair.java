package juc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.*;

public class FairOrUnfair {

    public static void main(String[] args) throws InterruptedException {
        // Fair mode BlockingQueue
        BlockingQueue<String> fairQueue = new ArrayBlockingQueue<>(10, true);
        // Unfair mode BlockingQueue
        BlockingQueue<String> unfairQueue = new ArrayBlockingQueue<>(10, false);


        // Create producer and consumer threads for both queues
        for (int i = 0; i < 5; i++) {
            final int index = i;
            Thread producer = new Thread(() -> {
                try {
                    fairQueue.put("Fair task " + index);
                    unfairQueue.put("Unfair task " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            producer.start();

            Thread consumer = new Thread(() -> {
                try {
                    System.out.println("Fair consumer received - " + fairQueue.take());
                    System.out.println("Unfair consumer received - " + unfairQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            consumer.start();
        }

    }

    static void messageToDisk(String fileName, String msg) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(msg);
            writer.newLine(); // 换行
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
