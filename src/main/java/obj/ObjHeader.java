package obj;

import org.openjdk.jol.info.ClassLayout;

public class ObjHeader {
    public static void main(String[] args) {
        ObjHeader objHeader = new ObjHeader();
        System.out.println(ClassLayout.parseInstance(objHeader).toPrintable());
        synchronized (objHeader) {
            System.out.println(ClassLayout.parseInstance(objHeader).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(objHeader).toPrintable());

    }
}
