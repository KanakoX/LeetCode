package com.kanako.no991_1000.no992;

public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left1 = 0, left2 = 0;
        int[] cnt1 = new int[n + 1];
        int diff1 = 0;
        int[] cnt2 = new int[n + 1];
        int diff2 = 0;
        for (int num : nums) {
            if (cnt1[num]++ == 0) {
                diff1++;
            }
            while (diff1 >= k) {
                if (--cnt1[nums[left1++]] <= 0) {
                    diff1--;
                }
            }
            ans += left1;

            if (cnt2[num]++ == 0) {
                diff2++;
            }
            while (diff2 > k) {
                if (--cnt2[nums[left2++]] <= 0) {
                    diff2--;
                }
            }
            ans -= left2;
        }
        return ans;
    }
}
