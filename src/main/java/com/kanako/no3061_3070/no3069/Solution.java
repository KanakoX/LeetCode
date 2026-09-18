package com.kanako.no3061_3070.no3069;

public class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int i1 = 0, i2 = 0;
        arr1[i1++] = nums[0];
        arr2[i2++] = nums[1];
        for (int i = 2; i < n; i++) {
            if (arr1[i1 - 1] > arr2[i2 - 1]) {
                arr1[i1++] = nums[i];
            } else {
                arr2[i2++] = nums[i];
            }
        }
        int[] ans = new int[n];
        System.arraycopy(arr1, 0, ans, 0, i1);
        System.arraycopy(arr2, 0, ans, i1, i2);
        return ans;
    }
}
