package com.kanako.no3541_3550.no3550;

public class Solution {
    public int smallestIndex(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int num = nums[i];
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
                if (sum > i) break;
            }
            if (sum == i) {
                result = i;
                break;
            }
        }
        return result;
    }
}
