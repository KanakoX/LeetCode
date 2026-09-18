package com.kanako.no301_310.no303;

public class Solution {
    class NumArray {
        int[] arr;
        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    class NumArray2 {
        int[] sum;
        public NumArray2(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }
}
