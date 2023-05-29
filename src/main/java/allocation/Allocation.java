package allocation;

public class Allocation {
    /**
     * [DefNew:  5679K   ->   856K     (9216K), 0.0031449 secs]   5679K         ->      4952K        (19456K), 0.0054950 secs]
     *  GC类型   Y before    Y after    Y total          time       heap before          heap after   heap total
     */
    final static int _1MB = 1024 * 1024 ;

    // -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
    public static void main(String[] args) {
//        testAllocation();
//        testPretenureSizeThreshold();
        testTenuringThreshold();
//        testTenuringThreshold2();
    }
//    young区 10M [8000k , 1000k ]， old区 10M ， young区真正能放的 9000k
    static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
//        6000k

        allocation4 = new byte[4 * _1MB]; // ?
    }

    //  -XX:PretenureSizeThreshold=3145728
    static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[5 * 1024 * 1024]; // ?
    }
    //  -XX:MaxTenuringThreshold=1 ：设置晋升阈值
    static void testTenuringThreshold(){
        byte[] a1, a2, a3 , a4 , a5, a6, a7, a8 , a9, a10;
        a1 = new byte[_1MB / 4];
        a2 = new byte[_1MB / 4];
        a3 = new byte[2 * _1MB];
        a4 = new byte[2 * _1MB];
        a5 = new byte[2 * _1MB];
        a6 = new byte[2 * _1MB];
        a6 = null;
        a6 = new byte[2 * _1MB];
        a7 = new byte[2 * _1MB];
        a8 = new byte[2 * _1MB];
        a9 = new byte[2 * _1MB];
        a10 = new byte[2 * _1MB];
        a3 = null;
        a3 = new byte[4 * _1MB];
    }
    // 动态年龄判定：Survivor区所有对象大小超过空间的1/2
    static void testTenuringThreshold2(){
        byte[] a1, a2, a3, a4;
        a1 = new byte[_1MB / 4];
        a2 = new byte[_1MB / 4];
        a3 = new byte[4 * _1MB];
        a4 = new byte[4 * _1MB];
        a4 = null;
        a4 = new byte[4 * _1MB];
    }
}
