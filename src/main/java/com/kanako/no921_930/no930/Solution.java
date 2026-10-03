package com.kanako.no921_930.no930;

public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum1 = 0, sum2 = 0;
        int left1 = 0, left2 = 0;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums[i];
            sum2 += nums[i];

            while (sum1 == goal && left1 <= i) {
                sum1 -= nums[left1++];
            }
            ans1 += left1;

            while (sum2 == goal + 1) {
                sum2 -= nums[left2++];
            }
            ans2 += left2;
        }
        return ans1 - ans2;
    }
}
