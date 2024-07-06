package juc;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadLocalDemo {
    // 静态变量
    public static ThreadLocalDemo staticDemo;

    public static void main(String[] args) {
        // 线程实例
        new Thread(()->{
            ThreadLocal<String> reference = new ThreadLocal<>();
            reference.set("values");
            System.out.println(Thread.currentThread().getName() + " " + reference.get());
        }).start();
    }
}
