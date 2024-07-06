package juc;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.submit(()->{
                for (int j = 0; j < 100; j++) {
                    list.add(new Random().nextInt());
                }
            });
        }
        Thread.sleep(2000);
        System.out.println(list.size());
        list.wait();
    }
}
