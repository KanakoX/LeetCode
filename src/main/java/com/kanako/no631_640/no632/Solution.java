package com.kanako.no631_640.no632;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        List<int[]> beyond = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                beyond.add(new int[]{num, i});
            }
        }
        beyond.sort(Comparator.comparingInt(a -> a[0]));
        int[][] pairs = beyond.toArray(int[][]::new);

        int left = 0;
        int n = pairs.length;
        int[] rowRecord = new int[size];
        int correct = 0;
        int minLen = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            int row = pairs[i][1];
            if (++rowRecord[row] == 1) {
                correct++;
            }
            while (correct == size) {
                int diff = pairs[i][0] - pairs[left][0];
                if (diff < minLen) {
                    minLen = diff;
                    result[0] = pairs[left][0];
                    result[1] = pairs[i][0];
                }
                if (--rowRecord[pairs[left++][1]] == 0) correct--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.smallestRange(List.of(List.of(4,10,15,24,26), List.of(0,9,12,20), List.of(5,18,22,30)))));
    }
}
