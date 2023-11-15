package juc;

public class WaitOrNotify {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        o.wait();
        o.notify();
    }
}
