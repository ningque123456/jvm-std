package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-21 20:27
 **/
public class ThreadPoolDemo {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(15), new ThreadPoolExecutor.AbortPolicy());
        System.out.println(Thread.activeCount() + " actvice count ");
        for (int i = 0 ; i < 20 ; i++){
            executor.execute(new Task(i));
            System.out.println(Thread.activeCount() + " actvice count ");
        }
    }
}
