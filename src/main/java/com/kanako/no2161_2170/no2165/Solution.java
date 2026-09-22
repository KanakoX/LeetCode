package com.kanako.no2161_2170.no2165;

import java.util.Arrays;

public class Solution {
    public long smallestNumber(long num) {
        boolean flag = num >= 0;
        String str = Long.toString(num);
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        if (flag) {
            boolean isChange = false;
            for (char aChar : chars) {
                if (!isChange && aChar != '0') {
                    sb.insert(0, aChar);
                    isChange = true;
                    continue;
                }
                sb.append(aChar);
            }
            return Long.parseLong(sb.toString());
        } else {
            for (int i = chars.length - 1; i >= 0; i--) {
                if (i == 0) {
                    sb.insert(0, chars[i]);
                    continue;
                }
                sb.append(chars[i]);
            }
            return Long.parseLong(sb.toString());
        }
    }
}
