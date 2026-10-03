package com.kanako.no1471;

import java.util.Arrays;

public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        int n = arr.length;
        int mid = (n - 1) >>> 1;
        int midNum = arr[mid];
        int index = 0;
        int left = 0, right = n - 1;
        while (index < k) {
            int leftNum = arr[left];
            int rightNum = arr[right];
            if (Math.abs(leftNum - midNum) <= Math.abs(rightNum - midNum)) {
                ans[index] = rightNum;
                right--;
            } else {
                ans[index] = leftNum;
                left++;
            }
            index++;
        }
        return ans;
    }
}

// 1 2 3 4 5
