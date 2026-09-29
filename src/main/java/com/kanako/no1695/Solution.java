package com.kanako.no1695;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] hasNum = new boolean[100001];
        int n = nums.length;
        int maxScore = 0;
        int currentScore = 0;
        int left = 0;
        for (int num : nums) {
            currentScore += num;
            while (hasNum[num]) {
                hasNum[nums[left]] = false;
                currentScore -= nums[left++];
            }
            hasNum[num] = true;
            maxScore = Math.max(currentScore, maxScore);
        }
        return maxScore;
    }
}
