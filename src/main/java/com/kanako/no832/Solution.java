package com.kanako.no832;

public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int n = row.length;
            if (n % 2 != 0) row[n / 2] ^= 1;
            for (int left = 0, right = n - 1; left < right; left++, right--) {
                int temp = row[left];
                row[left] = row[right] ^ 1;
                row[right] = temp ^ 1;
            }
        }
        return image;
    }
}
