package proxy;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-09 19:36
 **/
public class UserManagerImp implements UserManager{
    @Override
    public void createUser(String name, String pwd) {
        // insert into mysql
        System.out.println("create user success : " + name);
    }

    @Override
    public String getUserInfo(String name) {
        // select from mysql
        return "用户信息 : " + name ;
    }
}
