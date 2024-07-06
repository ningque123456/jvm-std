package juc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Check {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        Check check = new Check();
        check.CatchError();
        ReentrantLock lock = new ReentrantLock();
//        new ThreadPoolExecutor()
        Object o = new Object();
        LockSupport.park();
        lock.lock();
        lock.unlock();
        CountDownLatch latch = new CountDownLatch(1);
        latch.countDown();
        latch.await();
        HashMap<String, String> map = new HashMap<>();


        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> list1 = new ArrayList<>();
        list.retainAll(list1); //list中保留list1中的元素

        list.removeAll(list1) ; //list中去除list1中的元素

        list.addAll(list1);
        list.removeAll(list1);



        CyclicBarrier barrier = new CyclicBarrier(1);
        barrier.await();

        /**
         * //acquire操作如下：
         * while(同步状态申请获取失败){
         *     if(当前线程未进入等待队列){
         *         当前线程放入等待队列;
         *     }
         *     尝试阻塞当前线程;
         * }
         * 当前线程移出等待队列
         *
         * //release操作如下：
         * 更新同步状态
         * if(同步状态足够允许一个阻塞的线程申请获取){
         *     解除一个或者多个等待队列中的线程的阻塞状态;
         * }
         *
         *
         */

    }

    String CatchError(){
        try {
            System.out.println("try");
            int a = 5 / 0 ;
        } catch (Exception e) {
            System.out.println("catch");
            return "catch";
        } finally {
            System.out.println("finally");
        }
        return "end";
    }
}

