package allocation;

public class Allocation {
    /**
     * [DefNew:  5679K   ->   856K     (9216K), 0.0031449 secs]   5679K         ->      4952K        (19456K), 0.0054950 secs]
     *  GC类型   Y before    Y after    Y total          time       heap before          heap after   heap total
     */
    final static int _1MB = 1024 * 1024 ;

    // -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
    public static void main(String[] args) {
        testAllocation();
        testPretenureSizeThreshold();
        testTenuringThreshold();
        testTenuringThreshold2();
    }

    static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * 1024 * 1024];
        allocation2 = new byte[2 * 1024 * 1024];
        allocation3 = new byte[2 * 1024 * 1024];
        allocation4 = new byte[4 * 1024 * 1024]; // 出现一次 Minor GC
    }
    //  -XX:PretenureSizeThreshold=3145728
    static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * 1024 * 1024]; //直接分配在老年代中
    }
    //  -XX:MaxTenuringThreshold=1 ：设置晋升阈值
    static void testTenuringThreshold(){
        byte[] a1, a2, a3;
        a1 = new byte[_1MB / 4];
        a2 = new byte[4 * _1MB];
        a3 = new byte[4 * _1MB];
        a3 = null;
        a3 = new byte[4 * _1MB];
    }
    // 动态年龄判定：Survivor区所有对象大小超过空间的1/2
    static void testTenuringThreshold2(){
        byte[] a1, a2, a3, a4;
        a1 = new byte[_1MB / 2];
        a2 = new byte[_1MB / 2];
        a3 = new byte[4 * _1MB];
        a4 = new byte[4 * _1MB];
        a4 = null;
        a4 = new byte[4 * _1MB];
    }
}
