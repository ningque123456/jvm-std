package classloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-05-26 18:49
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();

        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.size());
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.size());

        System.out.println(map.get(1));
        System.out.println(map.containsKey(2));
        System.out.println(map.containsKey(3));

        AtomicReference<Integer> i = new AtomicReference<>(1);
        AtomicInteger  ii = new AtomicInteger(1);
        map.forEach((k,v)-> {
            i.getAndSet(i.get() + 1);
            ii.getAndIncrement();
            System.out.println(k + " " + v);
        });
        map.clear();
        System.out.println(map.size());
        String  a = "irhyakf";
        System.out.println(a.hashCode());
//        ScheduledThreadPoolExecutor
        SynchronousQueue<Integer> integers = new SynchronousQueue<>();
        integers.put(1);
        Thread.sleep(1000);
        new Thread(()->{
            try {
                System.out.println(integers.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        

//        System.out.println(poll);

    }
}
