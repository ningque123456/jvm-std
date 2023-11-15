package obj;

import juc.DefaultTest;
import juc.DefaultTestImpl;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class ObjHeader {
    public static void main(String[] args) {
        ObjHeader objHeader = new ObjHeader();
        System.out.println(ClassLayout.parseInstance(objHeader).toPrintable());
        synchronized (objHeader) {
            System.out.println(ClassLayout.parseInstance(objHeader).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(objHeader).toPrintable());
        System.out.println(objHeader.getClass().getSuperclass());
        Integer a = new Integer(5);
        System.out.println(a.getClass().getSuperclass());

        StringBuilder s = new StringBuilder();
        s.reverse();
        String  aa = "a" ;

        DefaultTest defaultTest = new DefaultTestImpl();
        defaultTest.m();


    }
}
