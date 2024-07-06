package serialize;

import java.io.*;

public class JavaSeri extends ClassLoader implements Serializable  {
    private static final long serialVersionUID = 2L;
    private String name;
    private int age;

    private int id ;

    private int aa ;

    public JavaSeri(String name, int age , int id  ) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/main/java/serialize/JavaSeri.txt");
//        JavaSeri js = new JavaSeri("John", 25 ,11);
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//        oos.writeObject(js);
//        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        JavaSeri js1 = (JavaSeri) ois.readObject();
        System.out.println(js1.name + " " + js1.age  + " " + js1.id);

    }
}
