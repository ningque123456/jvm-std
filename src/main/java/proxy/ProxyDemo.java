package proxy;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-09 19:34
 **/
public class ProxyDemo {

}

interface UserManager{
    void createUser(String name , String pwd);
    String getUserInfo(String name);
}
