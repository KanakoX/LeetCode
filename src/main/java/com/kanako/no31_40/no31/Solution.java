package com.kanako.no31_40.no31;

/*
2 6 4 1 3 5

*/

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1,3,7,6,5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
