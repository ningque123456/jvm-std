package allocation;

import javassist.*;
import sun.misc.Unsafe;


import java.lang.reflect.Field;
import java.util.ArrayList;

public class OOMTest {

    // -XX:MaxMetaspaceSize=64m -Xms20m -Xmx20m -Xss128k -XX:MaxDirectMemorySize=10M
    static ClassPool cp = ClassPool.getDefault();
    public static void main(String[] args)  {
//        heapOOMTest();
//        stackOverFlowTest();
//        main(new String[]{"1"});
//        metaSpaceOOM();
//        try {
//            directMemoryOOMTest();
//        } catch (IllegalAccessException e) {
//            System.out.println(e);
//        }

    }
    static void metaSpaceOOM(){
        for (int i = 0 ;; i++){
            try {
                Class c = cp.makeClass("ComplexObj" + i ).toClass();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }
    }

    static void heapOOMTest(){
        ArrayList<Object> list = new ArrayList<>();
        for (;;){
            byte[] b = new byte[1024*1024] ;
            list.add(b);
        }

    }

    static void stackOverFlowTest(){
        stackOverFlowTest();
    }
    static void directMemoryOOMTest() throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(1024*1024);
        }
    }



}
