package com.kanako.no2961_2970.no2962;

import java.util.Arrays;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) maxNum = num;
        }
        int maxNumCnt = 0;
        int left = 0;
        long ans = 0;
        for (int num : nums) {
            if (num == maxNum) maxNumCnt++;
            while (maxNumCnt == k) {
                if (nums[left++] == maxNum) maxNumCnt--;
            }
            ans += left;
        }
        return ans;
    }
}
