package com.kanako.no2941_2950.no2946;

public class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        k %= n;
        for (int[] row : mat) {
            for (int j = 0; j < n; j++) {
                if (row[j] != row[(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
