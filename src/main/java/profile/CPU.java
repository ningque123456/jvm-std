package profile;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-20 01:27
 **/
public class CPU {

    public static void main(String[] args) {

        for (int i = 0 ; i < 10 ; i++){
            new Thread(()->{
//                 空转
//                while (true){
//
//                }
                // 复杂正则解析
//                parseRegex();
                // 大量运算
                long r = 0;
                for (long j = 0; j < 100000000000L; j++) {
                    r += j * j;
                }

            }).start();
        }
    }

    static void parseRegex(){
        String badRegex = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)" +
                "(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+$";
        String bugUrl = "http://www.fapiao.com/dddp-web/pdf/download?" +
                "request=6e7JGxxxxx4ILd-kExxxxxxxqJ4-CHLmqVnenXC692m7" +
                "4H38sdfdsazxcUmfcOH2fAfY1Vw__%5EDadIfJgiEf";
        if (bugUrl.matches(badRegex)) {
            System.out.println("match!!");
        } else {
            System.out.println("no match!!");
        }
    }

}
