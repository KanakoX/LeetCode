package com.kanako.wc522;

public class Solution {
    public int minRotations(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int lastNum = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentNum = chars[i] - '0';
            int diff = Math.abs(currentNum - lastNum);
            ans += Math.min(diff, 10 - diff);
            lastNum = currentNum;
        }
        return ans;
    }
}
