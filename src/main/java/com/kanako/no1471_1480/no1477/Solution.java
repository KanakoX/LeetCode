package com.kanako.no1471_1480.no1477;

import java.util.Arrays;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLeft = new int[n];
        Arrays.fill(minLeft, Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < n; end++) {
            sum += arr[end];
            while (sum > target) {
                sum -= arr[start++];
            }
            if (sum == target) {
                int len = end - start + 1;
                if (start > 0 && minLeft[start - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, minLeft[start - 1] + len);
                }
                best = Math.min(best, len);
            }
            minLeft[end] = best;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSumOfLengths(new int[]{2, 1, 3, 3, 2, 3, 1}, 6)); // 5
        System.out.println(s.minSumOfLengths(new int[]{2, 2, 2}, 4)); // -1（两段重叠）
    }
}
