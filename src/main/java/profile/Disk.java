package profile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-20 01:47
 **/
public class Disk {
    public static void main(String[] args) {
        // 模拟写入数据
        int fileSizeInMB = 1;

        try {
            writeLargeFile(fileSizeInMB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLargeFile(int sizeInMB) throws IOException {
        String fileName = "largefile.txt";
        byte[] data = new byte[1024 * 1024 * 1024] ;

        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            for (int i = 0; i < sizeInMB; i++) {
                fos.write(data);
            }
        }
    }
}
