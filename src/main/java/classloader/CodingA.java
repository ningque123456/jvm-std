package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: jvm-std
 * @description: 学习Java第一天
 * @author: ningque
 * @create: 2023-09-03 14:29
 **/
public class CodingA {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ArrayList<CodingA> list = new ArrayList<>();
        list.add(new CodingA());
        list.get(0);
//        Method add = list.getClass().getMethod("add", Object.class);
//        add.invoke(list,"abc");


//        for(int i = 0 ; i < list.size() ; i++){
//            printValue(list.get(i));
//        }


    }

     static void printValue(Object o){
        String s = Objects.toString(o);
        System.out.println(s);
    }




    void swap(){
        int a = 5 ;
        int b = 3;
        System.out.println(a + " " + b);
//        int c = 0;
//        c = a ;
//        a = b ;
//        b = c;
//        原地转换
        a = a ^ b ;
        b = a ^ b ;
        a = a ^ b ;

        System.out.println(a + " " + b);

    }

}
class HashC{
    String  name ;
    Integer age  ;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}