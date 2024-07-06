package al;




import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

public class Main {
    int min  = Integer.MAX_VALUE;
    int step = 0 ;
    public static void main(String[] args) {
        new Main().wordPattern("abba",  "dog cat cat dog");
        new ConcurrentHashMap<>();
        new DelayQueue<>();

    }
    public boolean wordPattern(String pattern, String s) {
        Map<String , Character> str2ch = new HashMap<>();
        Map<Character , String> ch2str = new HashMap<>();
        String[] ss = s.split(" ");
        for(int i = 0 ; i < pattern.length() ; i++ ){
            char a = pattern.charAt(i);
            String b = ss[i];
            if(str2ch.containsKey(b) && str2ch.get(b) != a) {
                return false;
            }
            if(ch2str.containsKey(a) && !Objects.equals(ch2str.get(a), b)) {
                System.out.println("ch2str.get(a) = " + ch2str.get(a));
                System.out.println("b = " + b);
                return false;
            }
            str2ch.put(b , a) ;
            ch2str.put(a , b);
        }
        return true ;
    }
    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0 ; i < s.length() ; i++ ){
            a[s.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < t.length() ; i++ ){
            b[t.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++ ){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++ ){
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }else {
                map.put(i, nums[i]);
            }
        }
        return false;
    }
}
