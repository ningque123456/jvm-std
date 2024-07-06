package juc;

import desginpattern.Singleton;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-09-21 21:13
 **/
public class DeathLock {

    static final String lock1 = "l1";
    static final String lock2 = "l2";

    public static void main(String[] args) {

        Singleton.getInstance();
        new Thread(() -> {
            synchronized (lock1){
                System.out.println("thread A get lock 1");
                try {
                    Thread.sleep(3000);

                    synchronized (lock2){
                        System.out.println("thread A get lock 2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2){
                System.out.println("threadB get lock 2");
                synchronized (lock1) {
                    System.out.println("threadB get lock 1");
                }
            }
        }).start();
    }
}
