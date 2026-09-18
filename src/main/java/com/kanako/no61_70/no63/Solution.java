package com.kanako.no61_70.no63;

import java.util.Arrays;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memory = new int[m][n];
        for (int[] row : memory) {
            Arrays.fill(row, -1);
        }
        return dfs(obstacleGrid, m - 1, n - 1, memory);
    }

    private int dfs(int[][] obstacleGrid, int x, int y, int[][] memory) {
        if (x < 0 || y < 0 || obstacleGrid[x][y] == 1) return 0;
        if (x == 0 && y == 0) return 1 - obstacleGrid[0][0];
        if (memory[x][y] != -1) return memory[x][y];
        return memory[x][y] = dfs(obstacleGrid, x - 1, y, memory) + dfs(obstacleGrid, x, y - 1, memory);
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = ((j - 1) < 0 ? 0 : dp[i][j - 1]) + ((i - 1) < 0 ? 0 : dp[i - 1][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles2(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
