package desginpattern;

public class Singleton2 {
    private Singleton2() {
    }

    private static volatile Singleton2 instance = null;

    public static Singleton2 getInstance() {
        // t1 和 t2
        if (null == instance) {
            return new Singleton2();
        }
        return instance;

    }




















    public synchronized static  Singleton2 getInstance2() {
        if (null == instance) {
            return new Singleton2();
        }
        return instance;

    }

    public static Singleton2 getInstance3() {
        if (null == instance) {
            synchronized (Singleton2.class) {
                if (null == instance) {
                    return new Singleton2();
                }
            }
        }
        return instance;
    }

    private static class InnerClass {
        private static Singleton2 instance = new Singleton2();
    }
    public static Singleton2 getInstance4() {
        return InnerClass.instance;
    }
}
