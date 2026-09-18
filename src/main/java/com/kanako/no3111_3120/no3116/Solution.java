package com.kanako.no3111_3120.no3116;

import java.util.Arrays;

public class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int[] count = new int[coins.length];
        int nextNum = 0;
        for (int i = 0; i < k;) {
            int minNumIndex = 0;
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] * (count[j] + 1) < minNum) {
                    minNum = coins[j] * (count[j] + 1);
                    minNumIndex = j;
                }
            }
            int currentNum = coins[minNumIndex] * (count[minNumIndex]++ + 1);
            if (nextNum == currentNum) continue;
            nextNum = currentNum;
            i++;
        }
        return nextNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthSmallest(new int[]{3,6,9}, 3));
    }
}
