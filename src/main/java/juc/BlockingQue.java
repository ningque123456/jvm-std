package juc;

import java.util.HashMap;
import java.util.concurrent.*;

public class BlockingQue {
    public static void main(String[] args) {

        ArrayBlockingQueue<Message> abq = new ArrayBlockingQueue<>(5 , true);
        LinkedBlockingQueue<Message> lbq = new LinkedBlockingQueue<>();
        PriorityBlockingQueue<Message> pbq = new PriorityBlockingQueue<>();
        SynchronousQueue<Message> sq = new SynchronousQueue<>();
//        Executors.newCachedThreadPool().submit();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("a",new int[]{1,2,3});
        int[] a = (int[])map.get("a");
        System.out.println(a[0]);
        Producer p = new Producer(abq);
        Consumer c = new Consumer(abq);
        new Thread(c).start();
        new Thread(p).start();
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        pool.submit(()->{
//            for (int i = 0; i < 100000; i++) {
//                Message m = new Message();
//                m.setMsg(" message : "  + i );
//                System.out.println("Produce " + m.getMsg());
//                try {
//                    abq.put(m);
////                    Thread.sleep();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        pool.submit(()->{
//            while (true){
//                Message message = abq.take();
//                System.out.println("Consume " + message.getMsg());
//                Thread.sleep(100);
//            }
//        });


    }
}
class Message {
    private String msg ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class Producer implements Runnable{
    private BlockingQueue<Message> queue ;
    public Producer(BlockingQueue<Message> q){
        this.queue = q ;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 100 ; i ++){
            Message m = new Message();
            m.setMsg("msg : " + i);
            try {
                queue.put(m);
                System.out.println("Produced msg : " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Message exit = new Message();
        exit.setMsg("exit");
        try {
            queue.put(exit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            while((msg = queue.take()).getMsg() != "exit"){
                Thread.sleep(10);
                System.out.println("--------- Consumed "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}