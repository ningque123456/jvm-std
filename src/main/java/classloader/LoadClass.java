package classloader;

import org.openjdk.jol.info.ClassLayout;

public class LoadClass {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(ClassLayout.parseInstance(c).toPrintable());
    }
}
class P{
    private int pa ;

}
class C extends P{
    private String ca ;
}