package profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-20 01:39
 **/
public class Memory {

    public static void main(String[] args) throws InterruptedException {
        // 比较简单的模拟OOM即可
        List<byte[]> bytes = new ArrayList<>();
        for (int i = 0 ; i < 10000 ; i++){
            Thread.sleep(100);
            bytes.add(new byte[1024 * 1024]);
        }

    }

}
