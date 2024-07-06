package coding;

import java.util.HashMap;
import java.util.HashSet;

public class Main {


    /**
     * 给定一个关键词集合 words 和一个字符串 inputStr，要求将 inputStr 中出现的所有关键词用标签标记：
     *
     * 关键词标签的起始为<b>,结束为</b>。
     * 把可以合并的标签进行合并，即使用最少的标签。合并规则如下：
     * 关键词相邻则进行合并，如 ab、cd为关键词，且在字符串中相邻，则合并为 <b>abcd</b>
     * 关键词相交则进行合并，如 zhi、hid为关键词，且在字符串中相交，则合并为 <b>zhid</b>
     *
     * 输入
     * 第1行一个整数 count，表示 words 中的关键词的个数，取值范围：[1, 64]
     * 第2行 count 个字符串，表示关键字词列表 words，每个关键词仅含英文小写字母，长度范围：[1,16]
     * 第3行一个字符串 inputStr，仅含英文小写字母（无空格），长度范围：[1,512]
     *
     * 输出
     * 一个用最少关键词标签标记的字符串
     * @param args
     */

    public static void main(String[] args) {
        /**
         * 4
         * cd df op qr
         * opqracdfg
         *
         * ans : <b>opqr</b>a<b>cdf</b>g
         *
         * 3
         * abbb def bbg
         * aabbbgz
         * ans : a<b>abbbg</b>z
         */
        int count = 3;
        String[] words = {"cd","df","op","qr"};
        String inputStr = "opqracdfg";
        String[] words2 = {"abbb","def", "bbg"};
        String inputStr2 = "aabbbgz";
        HashSet<String> sets = new HashSet<>();
        for(String word : words2){
            sets.add(word);
        }
        System.out.println(solution(inputStr2, sets));
    }
    public static String solution(String inputStr , HashSet<String> sets){
        int n = inputStr.length();
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = i+1 ; j <= n ; j++){
                if (sets.contains(inputStr.substring(i , j))){
                    for(int k = i ; k < j ; k++){
                        res[k] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < res.length ; i++){
            if(res[i] == 1) {
                sb.append("<b>").append(inputStr.charAt(i)).append("</b>");
            }else {
                sb.append(inputStr.charAt(i));
            }
        }
        String ans = sb.toString();
        ans = ans.replace("</b><b>","");
        return ans;
    }

}
