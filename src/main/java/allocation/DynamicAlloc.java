package allocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicAlloc {
    public static final int _1GB = 1024 * 1024 * 1024;
    // -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
    public static void main(String[] args) throws InterruptedException {
        byte[] a1 , a2 , a3 , a4 ,a5;
        a1 = new byte[_1GB ];

        Thread.sleep(10000000);
    }
}
