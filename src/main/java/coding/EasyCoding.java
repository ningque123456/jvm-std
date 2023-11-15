package coding;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-18 20:58
 **/
public class EasyCoding {

    public static void main(String[] args) {

        int n = 4;
        String s = "@#";
        int len = s.length();

        for (int i = 1; i <= 2 * n - 1; i++) {
            String line = "";
            int term = i / len;
            int idx = i % len;
            String a = s.substring(0, idx);
            for (int j = 0; j < term; j++) {
                line += s;
            }
            line += a;

            // Adjust the line length to match the desired pattern
            int lineLength = 2 * n - 1;
            while (line.length() < lineLength) {
                line = s + line + s;
            }

            // Trim excess characters
            line = line.substring(0, lineLength);

            System.out.println(line);
        }
    }
}
