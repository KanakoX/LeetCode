package com.kanako.WeeklyCompetition1;

/**
 * 暴力：枚举所有子数组 [L,R]，再枚举取反位置（或不取反）
 * O(n^3)，只适合对拍 / n 很小的版本
 */
public class Solution3Brute {
    public int longestValidSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                // 不取反
                if (mod(sum, k) == 0) {
                    ans = Math.max(ans, j - i + 1);
                    continue; // 已合法，不必再枚举取反
                }
                // 取反 [l,r] 里某一个
                for (int x = i; x <= j; x++) {
                    if (mod(sum - 2L * nums[x], k) == 0) {
                        ans = Math.max(ans, j - i + 1);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private int mod(long x, int k) {
        return (int) ((x % k + k) % k);
    }

    public static void main(String[] args) {
        Solution3Brute brute = new Solution3Brute();
        Solution3 fast = new Solution3();
        int[][] tests = {
                {4, 1, 2},
                {5, 3, 4},
                {1, 2, 3, 4, 5},
                {-2, 5, 3, -1}
        };
        int[] ks = {3, 7, 3, 4};
        for (int i = 0; i < tests.length; i++) {
            int a = brute.longestValidSubarray(tests[i], ks[i]);
            int b = fast.longestValidSubarray(tests[i], ks[i]);
            System.out.println(a + " vs " + b + (a == b ? " OK" : " FAIL"));
        }
    }
}
