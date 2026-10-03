package com.kanako.no3643;

public class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int left = x, right = x + k - 1; left < right; left++, right--) {
            int[] temp = new int[k];
            System.arraycopy(grid[left], y, temp, 0, k);
            System.arraycopy(grid[right], y, grid[left], y, k);
            System.arraycopy(temp, 0, grid[right], y, k);
        }
        return grid;
    }
}
