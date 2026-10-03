package com.kanako.no658;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int index = n - k;
        while (index > 0) {
            int leftNum = arr[left];
            int rightNum = arr[right];
            if (Math.abs(leftNum - x) <= Math.abs(rightNum - x)) {
                right--;
            } else if (Math.abs(leftNum - x) > Math.abs(rightNum - x)) {
                left++;
            }
            index--;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
