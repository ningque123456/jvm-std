package classloader;

public class ClassLoad {
    public static void main(String[] args) {
        ClassLoad cl = new ClassLoad();
        ClassLoader l1 = cl.getClass().getClassLoader();
        System.out.println(l1);
        ClassLoader l2 = l1.getParent();
        System.out.println(l2);
        ClassLoader l3 = l2.getParent();
        System.out.println(l3);

    }
}
