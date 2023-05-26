package classloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        /**
         * JDK提供的Driver是一个通用接口，各大数据库厂商需要自己实现这个接口
         * 比如MySql实现了com.mysql.cj.jdbc.Driver
         * 而具体的实现，本质上是厂商自己开发的，因此需要通过Application加载器去加载
         * 但根据双亲委派模型，DriverManager是会提交到BootStrap加载器中加载的，
         * 而再DriverManager中，会执行Driver的加载，此时如果不打破双亲委派模型，
         * 会导致MySQL的Driver无法被加载。
         */
        java.sql.Driver jqd ;
        com.mysql.cj.jdbc.Driver cmcjd;

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

    }
}
