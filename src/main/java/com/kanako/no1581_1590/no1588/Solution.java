package com.kanako.no1581_1590.no1588;

import java.util.Arrays;

public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sums = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sums[i + 1] = sums[i] + arr[i];
        }
        System.out.println(Arrays.toString(sums));
        int result = 0;
        int winSize = 1;
        for (int i = 0; i < arr.length; i++) {
            while (winSize + i <= arr.length) {
                result += calSum(sums, i, i + winSize - 1);
//                debugArray(arr, i, i + winSize, sums);
                winSize += 2;
            }
            winSize = 1;
        }
        return result;
    }

    private int calSum(int[] sums, int start, int end) {
        return sums[end + 1] - sums[start];
    }

    private void debugArray(int[] array, int start, int end, int[] sums) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, start, end)) + " " + calSum(sums, start, end - 1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }
}
