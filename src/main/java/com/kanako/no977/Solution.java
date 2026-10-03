package com.kanako.no977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while (index >= 0) {
            int num1 = nums[left] * nums[left];
            int num2 = nums[right] * nums[right];
            if (num1 > num2) {
                ans[index--] = num1;
                left++;
            } else {
                ans[index--] = num2;
                right--;
            }
        }
        return ans;
    }
}
