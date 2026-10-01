package com.kanako.no1201_1210.no1208;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int currentCost = 0;
        int maxLength = 0;
        int left = 0;
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
            currentCost += cost[i];
            while (currentCost > maxCost) {
                int leftCost = cost[left++];
                currentCost -= leftCost;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
