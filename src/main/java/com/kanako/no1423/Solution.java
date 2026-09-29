package com.kanako.no1423;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        for (int num : cardPoints) {
            totalSum += num;
        }
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int n = cardPoints.length;
        if (k == n) return totalSum;
        int window = n - k;
        for (int i = 0; i < n; i++) {
            int curNum = cardPoints[i];
            sum += curNum;
            int left = i - window + 1;
            if (left < 0) continue;
            minSum = Math.min(sum, minSum);
            sum -= cardPoints[left];
        }
        return totalSum - minSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }
}
