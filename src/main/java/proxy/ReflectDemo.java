package proxy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReflectDemo {


    public static void main(String[] args) throws Exception {
        C c = new C()   ;
        c.setId(1);

        Class<?> clz = Class.forName("proxy.C");

        Object o = clz.getConstructor().newInstance();
        clz.getMethod("setId", int.class).invoke(o, 1);

        // 使用反射破坏泛型
        List<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add("abc");
        list.getClass().getMethod("add", Object.class).invoke(list, "accc");
        System.out.println(list);
    }
}

class C {
    private int id ;

    public C() {
    }
    public void setId(int id) {
        System.out.println("set id " + id);
        this.id = id;
    }
}
