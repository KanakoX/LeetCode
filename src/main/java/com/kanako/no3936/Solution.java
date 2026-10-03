package com.kanako.no3936;

public class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int cnt = 0;
        while (left < right) {
            while (left < right && nums[left] != 0) left++;
            while (left < right && nums[right] == 0) right--;
            if (left >= right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            cnt++;
            left++;
            right--;
        }
        return cnt;
    }
}
