package classloader;

/**
 * @program: study
 * @description:
 * @author: ningque
 * @create: 2023-05-18 20:38
 **/
public class ShowStackFrame {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();



//        {
//            byte[] placeholder = new byte[64 * 1024 * 1024];
//        }
//        int a = 0 ;
//        System.gc();

        //        classloder.ShowStackFrame s = new classloder.ShowStackFrame() ;
//        s.showExceptionTable();
    }

    /**
     * 局部变量表是可重用的
     */
    void showLocalVariableTables(){

        int i = 5; // 1 slot
        long j = 10L ; // 2 slots
        float f = 5.5f; // 1 slot
        double d = 6.66; // 2 slots
    }

    /**
     * 当一个方法刚刚开始执行的时候，这个方法的操作数栈是空的，在方法的执行过程
     * 中，会有各种字节码指令往操作数栈中写入和提取内容，也就是出栈和入栈操作。
     */
    void showOperandStack(){
        Object o = new Object();
        int i = 1;
        float f = 5.5f;
        int j = 2;
        int k = i + j ;
    }
    void showExceptionTable(){
        int i = 0;
        try {
            int j = 5 / i;
        }catch (Exception e){
            System.out.println("exception happen ");
        }

    }
}
