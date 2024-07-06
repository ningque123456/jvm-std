package io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringConvert {
    public static void main(String[] args) {
        System.out.println(convert("HELLOWORLD", 3));
    }
    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int len = s.length();
        char[][] prt = new char[numRows][len];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                prt[i][j] = ' ';
            }
        }
        int r = 0, c = 0 ;
        boolean flag = true;

        for (char ch : s.toCharArray()) {
            prt[r][c] = ch;
            if (r == numRows - 1) {
                flag = false;
            } else if (r == 0) {
                flag = true;
            }
            if (flag) {
                r++;
            } else {
                r--;
                c++;
            }
        }

        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < len; l++) {
                System.out.print(prt[k][l]);
            }
            System.out.println();
        }


        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

}
