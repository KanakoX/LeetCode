package com.kanako.no2302;

public class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0;
        int left = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum * (i - left + 1) >= k) {
                sum -= nums[left++];
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
