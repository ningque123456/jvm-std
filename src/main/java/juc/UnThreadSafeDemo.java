package juc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class UnThreadSafeDemo {
    public static void main(String[] args) {
        final Map<Integer, String> map = new HashMap<>();

        Vector<Object> objects = new Vector<>();
//        objects.get()
//        objects.add()

//        Collections.synchronizedList().add()
//        Collections.synchronizedMap();
//        LongAdder;
        AtomicInteger atomicInteger = new AtomicInteger();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();

        CopyOnWriteArrayList<Object> cp = new CopyOnWriteArrayList<>();
        final Integer targetKey = 0b1111_1111_1111_1111; // 65 535
        final String targetValue = "v";
        map.put(targetKey, targetValue);
        System.out.println("----"+map.get(targetKey));

        new Thread(() -> {
            IntStream.range(0, targetKey).forEach(key -> map.put(key, "someValue"));
        }).start();



        while (true) {
            String v = map.get(targetKey);
            if (!targetValue.equals(v)) {
                System.out.println(v);
                throw new RuntimeException("HashMap is not thread safe.");
            }
        }
    }
}
