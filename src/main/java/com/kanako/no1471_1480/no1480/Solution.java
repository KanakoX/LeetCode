package com.kanako.no1471_1480.no1480;

public class Solution {
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int[] result = new int[nums.length];
        System.arraycopy(sums, 1, result, 0, nums.length);
        return result;
    }
}
