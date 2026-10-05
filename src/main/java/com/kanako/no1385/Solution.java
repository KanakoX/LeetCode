package com.kanako.no1385;

import java.util.Arrays;

public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        int n = arr2.length;
        for (int curNum : arr1) {
            int index = lowerBound(arr2, curNum);
            if (index < n && Math.abs(curNum - arr2[index]) > d && Math.abs(curNum - arr2[Math.max(index - 1, 0)]) > d) ans++;
            else if (index == n && Math.abs(curNum - arr2[n - 1]) > d) {
                ans++;
            }
        }
        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
