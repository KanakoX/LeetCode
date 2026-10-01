package com.kanako.no713;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        long product = 1L;
        int n = nums.length;
        int left = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            while (product >= k) {
                int leftNum = nums[left++];
                product /= leftNum;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
