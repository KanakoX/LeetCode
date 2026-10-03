package com.kanako.no28;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int purchasePlans(int[] nums, int target) {
        long mod = (long) 1e9 + 7;
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n - 1;
        long count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) count += right - left;
            if (sum > target) right--;
            else left++;
        }
        return (int) (count % mod);
    }
}
