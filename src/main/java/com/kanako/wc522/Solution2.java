package com.kanako.wc522;

public class Solution2 {
    public int minRotations(int n, String s) {
        int minTotal = totalCost(s);
        for (int k = 0; k < n; k++) {
            String prefix = s.substring(0, k);
            String suffix = s.substring(k);
            StringBuilder sb = new StringBuilder(suffix);
            String reversedSuffix = sb.reverse().toString();
            String newS = prefix + reversedSuffix;
            int cost = totalCost(newS);
            if (cost < minTotal) {
                minTotal = cost;
            }
        }
        return minTotal;
    }

    private int step(int num1, int num2) {
        int diff = Math.abs(num1 - num2);
        return Math.min(diff, 10 - diff);
    }

    private int totalCost(String s) {
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
