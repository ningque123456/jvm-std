package coding;

import java.util.Scanner;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-18 20:55
 **/
public class PrintSome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "@#";
        int len = s.length();
        for (int i = 1; i <= (n << 1) - 1; i++){
            String  line = "";
            int term;
            int idx;
            if ( i > n) {
                term = ((n << 1) - i) / len;
            }else{
                term = i / len ;
            }
            idx = i % len  ;
            String a = s.substring(0,idx);
            for (int j = 0 ; j < term ; j++ ){
                line += s;
            }
            line += a ;
            System.out.println(line);
        }
    }
}
