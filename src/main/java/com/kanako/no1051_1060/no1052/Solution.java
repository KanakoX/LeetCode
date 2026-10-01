package com.kanako.no1051_1060.no1052;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;
        int maxSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) satisfied += customers[i];
        }
        for (int i = 0; i < n; i++) {
            int customerCnt = customers[i];
            boolean ifGrumpy = grumpy[i] == 1;
            if (ifGrumpy) satisfied += customerCnt;
            int left = i - minutes + 1;
            if (left < 0) continue;
            maxSatisfied = Math.max(maxSatisfied, satisfied);
            boolean leftIfGrumpy = grumpy[left] == 1;
            if (leftIfGrumpy) satisfied -= customers[left];
        }
        return maxSatisfied;
    }
}
