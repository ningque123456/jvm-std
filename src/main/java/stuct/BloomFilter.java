package stuct;

import java.util.BitSet;
import java.util.concurrent.ConcurrentHashMap;

public class BloomFilter {


    private int[] bitMap ;
    public static void main(String[] args) {
    }

    public static BitSet hashFunction(String value){
        BitSet bitSet = new BitSet();
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;
        bitSet.set(hash1);
        bitSet.set(hash2);
        return bitSet;
    }
}
