package juc;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(() -> {
//            HashSet
//            lock.lock();
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("active interrupt");
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, "t1-thread");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(10000);


    }
}
