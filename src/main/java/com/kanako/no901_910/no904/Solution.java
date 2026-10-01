package com.kanako.no901_910.no904;

public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] type = new int[100001];
        int typeCnt = 0;
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (type[fruits[i]]++ == 0) typeCnt++;
            while (typeCnt > 2) {
                if (--type[fruits[left++]] == 0) typeCnt--;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
