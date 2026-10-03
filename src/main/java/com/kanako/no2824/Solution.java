package com.kanako.no2824;

import java.util.Collections;
import java.util.List;

public class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int left = 0, right = n - 1;
        int count = 0;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += right - left;
                left++;
            } else right--;
        }
        return count;
    }
}
