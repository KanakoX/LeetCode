package com.kanako.no3791_3800.no3795;

public class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        int[] numCnt = new int[100001];
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int currentNum = nums[i];
            numCnt[currentNum]++;
            if (numCnt[currentNum] <= 1) {
                sum += currentNum;
            }
            while (sum >= k) {
                minLen = Math.min(minLen, i - left + 1);
                int leftNum = nums[left++];
                if (numCnt[leftNum] <= 1) {
                    sum -= leftNum;
                }
                numCnt[leftNum]--;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
